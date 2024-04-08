package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LumaPage {
    WebDriver driver;

    public LumaPage(WebDriver driver) {
        this.driver = driver;
    }

    //SearchOption Test case
    By searchbox = By.id("search");
    By search_btn = By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
    //Create an Account Test case
    By Create_an_Account = By.linkText("Create an Account");
    By Firstname = By.id("firstname");
    By Lastname = By.id("lastname");
    By Email = By.name("email");
    By Password = By.id("password");
    By ConfirmationPassword = By.id("password-confirmation");
    By Create_btn = By.xpath(".//button[@class=\"action submit primary\"]");
    //Shopping add to cart not selected size & color
    By Tshirt = By.linkText("Radiant Tee");
    By Add_Cart_btn = By.xpath("//*[@id=\"product-addtocart-button\"]/span");
    //Shopping add to cart by selecting size & color
    By Inners = By.linkText("Breathe-Easy Tank");
    By Size = By.xpath(".//div[@id=\"option-label-size-143-item-166\"]");
    By Quantity = By.xpath(".//input[@name=\"qty\"]");
    By Color = By.id("option-label-color-93-item-57");


    //Search code
    public void searchingItems(String[] searchInputs) throws InterruptedException {
        for (String item : searchInputs) {
            WebElement searchBoxElement = driver.findElement(searchbox);
            searchBoxElement.clear();
            searchBoxElement.sendKeys(item);
            driver.findElement(search_btn).click();
            Thread.sleep(2000);
        }
    }
    public void WrongWordSearch(String[] searchInputs) throws InterruptedException {
        for (String item : searchInputs) {
            WebElement searchBoxElement = driver.findElement(searchbox);
            searchBoxElement.clear();
            searchBoxElement.sendKeys(item);
            driver.findElement(search_btn).click();
            Thread.sleep(2000);
        }
    }

    //Create an account code
    public void CreateAccountBtn() throws InterruptedException {
        driver.findElement(Create_an_Account).click();
        driver.findElement(Firstname).sendKeys("Amani");
        driver.findElement(Lastname).sendKeys("Sankoju");
        driver.findElement(Email).sendKeys("amani.sankoju13@gmail.com");
        driver.findElement(Password).sendKeys("Luma@123");
        driver.findElement(ConfirmationPassword).sendKeys("Luma@123");
        driver.findElement(Create_btn).click();
        Thread.sleep(2000);
    }

    //List of items on the page
    public void ListOfItems() throws InterruptedException {
        WebElement parentElement = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol"));
        List<WebElement> listItems = parentElement.findElements(By.tagName("a"));
        for (WebElement listItem : listItems) {
            String text = listItem.getText().trim();
            if (!text.isEmpty()) {
                System.out.println("List item text: " + text);
                System.out.println("List item text: " + text);
            }
        }
    }

    //Tshirts if not selected the size, colour and clicked on Add to cart option
    public void MyShoppinginLuma() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(Tshirt).click();
        driver.findElement(Add_Cart_btn).click();
        driver.navigate().back();
    }

    //Tshirts if selected the size, colour and clicked on Add to cart option
    public void ShopinLuma() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElement(Inners).click();
        driver.findElement(Size).click();
        driver.findElement(Color).click();
        driver.findElement(Quantity).clear();
        driver.findElement(Quantity).sendKeys("10");
        Thread.sleep(5000);
        driver.findElement(Add_Cart_btn).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).click();
    }

    public void SearchandClear() throws InterruptedException {
        WebElement searchBoxElement = driver.findElement(searchbox);
        driver.findElement(searchbox).sendKeys("Abcde");
        Thread.sleep(2000);
        searchBoxElement.clear();
    }
    public void FooterOptions() throws InterruptedException {
        driver.findElement(By.linkText("Search Terms")).click();
        driver.findElement(By.linkText("Privacy and Cookie Policy")).click();
        driver.findElement(By.linkText("Advanced Search")).click();
    }
    }