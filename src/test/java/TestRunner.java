import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;
import devices.DeviceInformation;
import freemarker.template.*;
import org.testng.annotations.Test;
import utils.suites.SuiteGeneration;
import utils.suites.SuiteRunner;
import utils.suites.TemplateProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class TestRunner {
    @Test(description = "Wrap up test to execute template test suite with dynamic desired capabilities")
    public void generateTestSuiteXml() throws IOException, TemplateException, DeviceNotFoundException {
        SuiteGeneration suiteGeneration = new SuiteGeneration();
        SuiteRunner suiteRunner = new SuiteRunner();
        TemplateProcessor templateProcessor = new TemplateProcessor(new File(String.format("%s/%s",System.getProperty("user.dir"),"suites/")));
        templateProcessor.setUp();
        Template template = templateProcessor.getTemplate("template.ftl");
        Map<String, Object> templateData = new HashMap<String, Object>();
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ALL);
        List<DeviceInformation> devicesInformation = new ArrayList<>();
        /**
         * Add local devices and assign random systemPort capabilities
         * Random systemPort is required to achieve parallel executions
         */
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
        suiteGeneration.applyTemplateToSuite("./template.xml",template,templateData);
        suiteRunner.runSuite("./template.xml");
    }
}

