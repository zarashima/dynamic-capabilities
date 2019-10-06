package utils.suites;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class SuiteRunner {
    TestNG runner = new TestNG();
    List<String> suiteFiles=new ArrayList<String>();

    public void runSuite(String suiteFilePath) {
        suiteFiles.add(suiteFilePath);
        runner.setTestSuites(suiteFiles);
        runner.run();
    }
}
