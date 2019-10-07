package utils.suites;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class SuiteRunner {
    private final TestNG runner = new TestNG();
    private final List<String> suiteFiles=new ArrayList<String>();

    public void runSuite(String suiteFilePath) {
        suiteFiles.add(suiteFilePath);
        runner.setTestSuites(suiteFiles);
        runner.run();
    }
}
