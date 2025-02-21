package org.example.test.VWOLogin;
import io.qameta.allure.Description;
import org.example.baseTest.CommonToAllTest;
import org.example.driver.DriverManager;
import org.example.listners.RetryAnalyser;
import org.example.listners.TestListener;
import org.example.pages.DashBoardPage;
import org.example.pages.VWOLoginPage;
import org.example.utils.EnvironmentExcelPath;
import org.example.utils.PropertyReader;
import org.example.utils.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(TestListener.class)
public class VWOLoginTest extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(VWOLoginTest.class);


    @Description("Verify that the user shold be looged in with valid creds")
    @Test(dataProvider = "environmentData",retryAnalyzer = RetryAnalyser.class)
    public void testVWOLoginPositive(String username, String password) {

        logger.info("Starting the test case");

        VWOLoginPage loginPage = new VWOLoginPage(DriverManager.getDriver());
        loginPage.logToVWOInvalidCred(username, password);

        DashBoardPage dashBoardPage = new DashBoardPage(DriverManager.getDriver());
        String loggedInUsername = dashBoardPage.loggedInUserName();
        assertThat(loggedInUsername).isEqualTo(PropertyReader.readKey("expected_username"));

        logger.info("End of the test case");

    }
    @DataProvider(name = "environmentData")
    public Object[][] getEnvironmentData() throws IOException {
        String filePath = EnvironmentExcelPath.getExcelFilePath(); // Get the file path based on the environment
        String sheetName = "Login";
        return ExcelReader.getTestData(filePath, sheetName);
    }
















//    @Description("Verify that the user shold not login with invalid creds")
//    @Test
//    public void testVWOLoginNegative() {
//
//        VWOLoginPage loginPage = new VWOLoginPage(DriverManager.getDriver());
//        String error_message = loginPage.logToVWOInvalidCred(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
//
//        assertThat(error_message).isEqualTo(PropertyReader.readKey("error_message"));
//
//    }

}
