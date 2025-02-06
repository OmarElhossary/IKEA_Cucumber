package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions

        (
                features = "src/main/resources/Features",
                glue = "org.example.StepDefs",
                tags = "" ,
                plugin = {
                        "pretty",
                        "html:Report/report.html"
                }

        )


public class runner extends AbstractTestNGCucumberTests {


}
