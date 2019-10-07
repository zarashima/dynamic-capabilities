package utils.suites;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SuiteGeneration {
    public void applyTemplateToSuite(String suiteFilePath, Template template, Object templateData) throws IOException, TemplateException {
        Writer suiteFile = new FileWriter(suiteFilePath);
        template.process(templateData, suiteFile);
        suiteFile.flush();
        suiteFile.close();
    }
}
