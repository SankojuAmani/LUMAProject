package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Sign_in_page {
    WebDriver driver;

    public Sign_in_page(WebDriver driver) {
        this.driver = driver;

    }

    //Sign In Page
    By Sign_in_btn = By.linkText("Sign In");
    By Username = By.xpath(".//input[@name=\"login[username]\"]");
    By Pass = By.xpath(".//input[@id=\"pass\"]");
    By Sign_in = By.id("send2");
    //Sign Out Page
    By Drop_Down_Open = By.xpath(".//li[@class=\"customer-welcome\"]");
    By Drop_Down_Close = By.xpath(".//li[@class=\"customer-welcome active\"]");
    By Sign_Out_Btn = By.linkText("Sign Out");
    //I am Addtocart after signIn to the Application
    By Yoga_Frame = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/a/img");
    By Cart_Cross_mark = By.id("btn-minicart-close");


    //Sign_Into_Application
    public void SignintoLuma() throws InterruptedException {
        driver.findElement(Sign_in_btn).click();
        driver.findElement(Username).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(Pass).sendKeys("Luma@123");
        driver.findElement(Sign_in).click();
        Thread.sleep(2000);
    }

    //DataProviders
    public void DataProviders(String uname, String password) throws InterruptedException {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(5000);
        driver.findElement(Sign_in_btn).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Username")));
        driver.findElement(Username).sendKeys(uname);
        driver.findElement(Pass).sendKeys(password);
        driver.findElement(Sign_in).click();
        Thread.sleep(4000);
    }

    //Sign_Out_From_Application
    public void SignOut() throws InterruptedException {
        driver.findElement(Drop_Down_Open).click();
        Thread.sleep(2000);
        driver.findElement(Drop_Down_Close).isDisplayed();
        driver.findElement(Sign_Out_Btn).click();

    }

    //Selecting Women Option from Header
    public void MouseActions() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement Women = driver.findElement(By.xpath(".//nav//ul//li[2]"));
        action.moveToElement(Women).build().perform();
        Thread.sleep(7000);
        WebElement Women_Tops = driver.findElement(By.xpath(".//nav//ul//li[2]//ul//li[1]"));
        action.moveToElement(Women_Tops).build().perform();
        Thread.sleep(7000);
        WebElement Jacket = driver.findElement(By.xpath(".//nav//ul//li[2]//ul//li[1]//ul//li[1]"));
        action.moveToElement(Jacket).click().perform();
        Thread.sleep(7000);

    }

    //Selecting Men option from the Header
    public void MenInHeader() throws InterruptedException {
        Actions action1 = new Actions(driver);
        WebElement Men = driver.findElement(By.id("ui-id-5"));
        action1.moveToElement(Men).build().perform();
        Thread.sleep(6000);
        WebElement Men_Bottoms = driver.findElement(By.id("ui-id-18"));
        action1.moveToElement(Men_Bottoms).build().perform();
        Thread.sleep(6000);
        WebElement Shorts = driver.findElement(By.id("ui-id-24"));
        action1.moveToElement(Shorts).click().perform();
        Thread.sleep(6000);

    }

    //Add items to the cart
    public void SignInAddtoCart() throws InterruptedException {
        Thread.sleep(30000);
        driver.findElement(Sign_in_btn).click();
        driver.findElement(Username).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(Pass).sendKeys("Luma@123");
        driver.findElement(Sign_in).click();
        driver.findElement(Yoga_Frame).click();
        Actions act = new Actions(driver);
        WebElement Elisa_Ever_Cool = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[8]/div"));
        act.moveToElement(Elisa_Ever_Cool).click().perform();
        Thread.sleep(2000);
        WebElement Size_Medium = driver.findElement(By.id("option-label-size-143-item-168"));
        act.moveToElement(Size_Medium).click().perform();
        Thread.sleep(2000);
        WebElement Color_Elisa = driver.findElement(By.id("option-label-color-93-item-58"));
        act.moveToElement(Color_Elisa).click().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("8");
        Thread.sleep(6000);
        WebElement Add_Cart = driver.findElement(By.id("product-addtocart-button"));
        act.moveToElement(Add_Cart).click().perform();
        Thread.sleep(2000);
    }

    //Remove items from the Cart
    public void RemoveFromCart() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.className("minicart-wrapper")).click();
        driver.findElement(By.xpath(".//a[@class=\"action delete\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[1]/div[4]/aside[2]/div[2]/div[1]/div[1]")).isDisplayed();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[1]/div[4]/aside[2]/div[2]/footer[1]/button[2]")).click();
        driver.findElement(Cart_Cross_mark).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();

    }

    //Remove items from the Cart
    public void CancelRemoveFromCart() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(By.linkText("Breathe-Easy Tank")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("option-label-size-143-item-168")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("option-label-color-93-item-57")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//input[@name=\"qty\"]")).clear();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//input[@name=\"qty\"]")).sendKeys("5");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]/span")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("minicart-wrapper")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath(".//a[@class=\"action delete\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body[1]/div[4]/aside[2]/div[2]/div[1]/div[1]")).isDisplayed();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[1]")).click();
        driver.findElement(Cart_Cross_mark).click();
    }


    //Incorrect Page Title
    public void IncorrectPageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        String expectedTitle = "LUMA";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect. Actual title is: " + actualTitle);
        }
    }

    //Correct Page Title
    public void CorrectPageTitle() throws Exception {

        String actualTitle = driver.getTitle();
        String expectedTitle = "Elisa EverCool™ Tee";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is correct: " + actualTitle);
        } else {
            System.out.println("Page title is incorrect. Actual title is: " + actualTitle);
        }
    }

    // Broken links check
    public void BrokenLinks() throws Exception {
//Thread.sleep(50000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            System.out.println("-----------------");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                System.out.println("URL is empty.");
                continue;

            }
            HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
            huc.connect();
            if (huc.getResponseCode() >= 400) {
                System.out.println(url + " is broken");
            } else {
                System.out.println(url + "is vaild");
            }
        }
    }

    //Taking the screenshot of the Home page
    public void Home_ScreenShot() throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("C:\\Users\\amani\\Desktop\\Tester.Png");
        File directory = new File("C:\\Users\\amani\\Desktop");
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public void ForgotYourPassword() throws InterruptedException {
        Thread.sleep(30000);
        driver.findElement(Sign_in_btn).click();
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a/span")).click();
        driver.findElement(By.id("email_address")).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
    }

    public void MyAccountEdit() throws InterruptedException {
        driver.findElement(Drop_Down_Open).click();
        Thread.sleep(2000);
        driver.findElement(Drop_Down_Close).isDisplayed();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/div/div[2]/a[1]/span")).click();
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Sankoju");
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Amani");
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
    }

    public void ManageAddresses() throws InterruptedException {
        driver.findElement(Drop_Down_Open).click();
        Thread.sleep(2000);
        driver.findElement(Drop_Down_Close).isDisplayed();
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[5]/div[1]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[6]/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("company")).sendKeys("XYZ");
        Thread.sleep(4000);
        driver.findElement(By.id("telephone")).sendKeys("9999999999");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"street_1\"]")).sendKeys("SaiRamNagar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"street_2\"]")).sendKeys("ABCD");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"street_3\"]")).sendKeys("11-181");
        Thread.sleep(2000);
        driver.findElement(By.id("city")).sendKeys("Hyderabad");
        Thread.sleep(4000);
        WebElement dropdownElement1 = driver.findElement(By.id("country"));
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByVisibleText("India");
        Thread.sleep(4000);
        WebElement dropdownElement = driver.findElement(By.id("region_id"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Telangana");
        Thread.sleep(2000);
        driver.findElement(By.id("zip")).sendKeys("500098");
        //driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();

    }

    public void MyDownloadableProducts() throws InterruptedException {
        driver.findElement(By.linkText("My Downloadable Products")).click();

    }

    public void PaymentDetails() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(By.className("minicart-wrapper")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/ul/li[1]/button/span")).click();
        Thread.sleep(4000);
        //driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"co-payment-form\"]/fieldset/div[3]")).isDisplayed();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"co-payment-form\"]/fieldset/div[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"discount-code\"]")).sendKeys("DISCOUNT");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"discount-form\"]/div[2]/div/button/span/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div/div/a")).click();

    }

    public void AddToWishList() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.linkText("Argus All-Weather Tank")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]/span")).click();

    }

    public void MyOrders() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[1]/span")).click();

    }
}



