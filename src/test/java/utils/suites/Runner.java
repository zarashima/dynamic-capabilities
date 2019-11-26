package utils.suites;

import com.google.inject.Inject;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private final TestNG runner = new TestNG();
    private final List<String> suiteFiles = new ArrayList<>();

    @Inject
    public Runner() {
    }

    public void runSuite(String suiteFilePath) {
        suiteFiles.add(suiteFilePath);
        runner.setTestSuites(suiteFiles);
        runner.run();
    }
}
