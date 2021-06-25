package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ReadJson;

import java.lang.reflect.Method;

import static utils.extentreports.ExtentTestManager.startTest;

public class AmazonTest extends BaseTest {
    ReadJson readJson = new ReadJson();

    @Test(priority = 0, description = "Second Test Case")
    public void firstTestCase(Method method) throws InterruptedException {
        //ExtentReports Description
        startTest(method.getName(), "Amazon Scenario");
        //System.out.println(readJson.getDataFromJson(System.getProperty("user.dir") + "/src/test/java/tests/data/data.json"));



    }
}