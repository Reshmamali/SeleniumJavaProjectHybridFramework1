package org.example.baseTest;

import org.example.driver.DriverManager;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.example.driver.DriverManager.driver;


public class CommonToAllTest {

    @BeforeMethod
    public void setUp(ITestContext context){
        DriverManager.init();
        context.setAttribute("WebDriver", driver);
    }
    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
