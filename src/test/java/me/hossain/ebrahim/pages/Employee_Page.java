package me.hossain.ebrahim.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import me.hossain.ebrahim.basedrivers.PageDriver;
import me.hossain.ebrahim.utilities.ExcelUtils;
import me.hossain.ebrahim.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Employee_Page {

    ExtentTest test;
    ExcelUtils excelUtils = new ExcelUtils();
    public Employee_Page(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBys({
            @FindBy(xpath = "//ul[@class='oxd-main-menu']/li[2]/a")
    })
    WebElement pim_option;

    @FindBys({
            @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
    })
    WebElement add;

    @FindBys({
            @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
    })
    WebElement first_name;

    @FindBys({
            @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/input[1]")
    })
    WebElement middle_name;

    @FindBys({
            @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")
    })
    WebElement last_name;

    @FindBys({
            @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")
    })
    WebElement save;


    public void passCase(String message) {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
    }

    public void passCaseWithSC(String message, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName); // Capture screenshot
        test.info("Screenshot saved at: " + screenShotPath); // Add file path info to the report
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build()); // Attach screenshot
    }

    // Fail
    @SuppressWarnings("unused")
    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), "" + scName + "");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }

    public void add_employee() throws IOException, InterruptedException {
        test.info("Add Employee");
        pim_option.click();
        Thread.sleep(5000);
        passCase("Clicked on PIM option");
        add.click();
        Thread.sleep(5000);
        passCase("Clicked on Add option");
        first_name.sendKeys("John");
        Thread.sleep(3000);
        middle_name.sendKeys("Smith");
        Thread.sleep(3000);
        last_name.sendKeys("Doe");
        Thread.sleep(3000);
        passCaseWithSC("Information provided", "pass");
        save.click();
        Thread.sleep(5000);

    }


}
