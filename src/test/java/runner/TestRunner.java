package runner;

import com.google.inject.Inject;
import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;
import devices.DeviceInformation;
import freemarker.template.*;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import utils.suites.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Guice(modules = {
        SuiteModule.class
})


public class TestRunner {

    @Inject private SuiteGeneration suiteGeneration;
    @Inject private Suite suite;
    @Inject private Runner runner;
    @Inject private Map<String,Object> templateData;

    @Test(description = "Wrap up test to execute template test suite with dynamic desired capabilities")
    public void generateTestSuiteXml() throws IOException, TemplateException, DeviceNotFoundException {
        TemplateProcessor templateProcessor = new TemplateProcessor(new File(String.format("%s/%s",System.getProperty("user.dir"),"suites/")));
        templateProcessor.setUp();
        Template template = templateProcessor.getTemplate("template.ftl");
        SuiteTemplate suiteTemplate = new SuiteTemplate(template, templateData);
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALL);
        List<DeviceInformation> devicesInformation = new ArrayList<>();
        String randomSystemPort;
        if (deviceInfo.anyDeviceConnected()) {
            int inBoundSystemPort = 8200;
            int outBoundSystemPort = 8299;
            for (Device device : deviceInfo.getDevices()) {
                randomSystemPort = String.valueOf(ThreadLocalRandom.current().nextInt(inBoundSystemPort, outBoundSystemPort));
                devicesInformation.add(new DeviceInformation(device.getDeviceProductName(),
                        device.getModelNumber(), randomSystemPort,
                        device.getUniqueDeviceID(), device.getProductVersion()));
            }
        }
        templateData.put("threadCount", deviceInfo.getDevices().size());
        templateData.put("devicesInformation", devicesInformation);
        suiteGeneration = new SuiteGeneration(suite);
        suiteGeneration.applyTemplate(suiteTemplate);
        runner.runSuite(".suites/template.xml");
    }
}

