package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Products extends Page_Options {
    String productname = PROD_Name + randomnumber();
    String productcode = PROD_Code + randomnumber();


    /*
    Creation of a product
    */
    @Given("login for creating new  Product")
    public void login_for_creating_new_product() {
        Login_AIR2_AIR(user_Haseeb);
        Click_from_leftSideBar("Products");
    }

    @When("create new  Product")
    public void create_new_product() throws InterruptedException {
        Thread.sleep(2000);
        //click the create new button
        xpath = "/html/body/div[2]/div[2]/a";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //product code
        xpath = "//*[@id=\"product_code\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, productcode);

        //product name
        xpath = "//*[@id=\"product_name\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, productname);

        //product category
        xpath = "//*[@id=\"select2-product_category-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        xpath = "/html/body/span/span/span[1]/input";
        inputbyxpath(xpath, PROD_Category);
        pressEnterbyXpath(xpath);

        //product flavor
        xpath = "//*[@id=\"select2-product_flavor-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        xpath = "/html/body/span/span/span[1]/input";
        clickbyxpath(xpath);
        inputbyxpath(xpath, PROD_flavor);
        pressEnterbyXpath(xpath);

        //size in ml
        xpath = "//*[@id=\"product_quantity_size\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        clearByXpath(xpath);
        inputbyxpath(xpath, PROD_sizeML);

        //ctn size in Pcs
        xpath = "//*[@id=\"product_quantity_ctn\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        clearByXpath(xpath);
        inputbyxpath(xpath, PROD_CtnPCS);

        //retail price
        id = "retail_price";
        waitById(id);
        inputbyid(id, PROD_RetailPrice);

        //trade price
        id = "trade_price";
        waitById(id);
        inputbyid(id, PROD_TradePrice);

        //distributor price
        id = "dist_price";
        waitById(id);
        inputbyid(id, PROD_DistributorPrice);

        //effective from
        id = "effect_date";
        waitById(id);
        inputbyid(id, getFutureDatenTime());
        Thread.sleep(1000);

        //save
        xpath = "//*[@id=\"product_data\"]/div[2]/button";
        clickbyxpath(xpath);
    }


    @And("verify that the Product is created and listed in the Products list")
    public void verify_that_the_product_is_created_and_listed_in_the_products_list() throws InterruptedException {
        Thread.sleep(2000);

        //search for the product
        id = "myInput";
        waitById(id);
        inputbyid(id, productname);
        Thread.sleep(2000);

        // verify the created product
        WebElement table = driver.findElement(By.id("productData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                Assert.assertEquals(productname, row.findElement(By.xpath(".//td[2]")).getText());
            }
        }
    }

    @Then("close driver for creating Product")
    public void close_driver_for_creating_product() throws InterruptedException {
        closedriver();
    }

    /*
    Edit a product
    */


    @When("edit the Product")
    public void edit_the_product() throws InterruptedException {
        Thread.sleep(2000);

        //search for product
        id = "myInput";
        waitById(id);
        inputbyid(id, productname);

        // click the edit button of the displayed product
        WebElement table = driver.findElement(By.id("productData"));
        java.util.List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through rows
        for (WebElement row : rows) {
            // Check if the row is displayed
            if (!row.getAttribute("style").contains("display: none;")) {
                // Find and click the "Add App Permissions" button for the visible row
                WebElement editButton = row.findElement(By.id("btn_edit"));
                editButton.click();
            }
        }

        Thread.sleep(200);
        //product code
        id = "edit_product_code";
        waitById(id);
        clearById(id);
        inputbyid(id, E_PROD_Code);
        //product code
        id = "edit_product_name";
        waitById(id);
        clearById(id);
        inputbyid(id, E_PROD_Name);

        //product category
        xpath = "//*[@id=\"select2-edit_product_category-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        xpath = "/html/body/span/span/span[1]/input";
        clickbyxpath(xpath);
        inputbyxpath(xpath, E_PROD_Category);
        pressEnterbyXpath(xpath);

        //product flavor
        xpath = "//*[@id=\"select2-edit_product_flavor-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        xpath = "/html/body/span/span/span[1]/input";
        clickbyxpath(xpath);
        inputbyxpath(xpath, E_PROD_flavor);
        pressEnterbyXpath(xpath);

        //size in ml
        xpath = "//*[@id=\"edit_product_quantity_size\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        clearByXpath(xpath);
        inputbyxpath(xpath, E_PROD_sizeML);

        //ctn size in Pcs
        xpath = "//*[@id=\"edit_product_quantity_ctn\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        clearByXpath(xpath);
        inputbyxpath(xpath, E_PROD_CtnPCS);

        //price toggle button
        xpath = "//*[@id=\"flush-headingOne\"]/button";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        Thread.sleep(200);

        //retail price
        id = "new_reatail_price";
        waitById(id);
        inputbyid(id, E_PROD_RetailPrice);

        //trade price
        id = "new_trade_price";
        waitById(id);
        inputbyid(id, E_PROD_TradePrice);

        //distributor price
        id = "new_dist_price";
        waitById(id);
        inputbyid(id, E_PROD_DistributorPrice);

        //effective from
        id = "new_eff_from";
        waitById(id);
        inputbyid(id, getlastMonthAndTime());

        //update
        xpath = "//*[@id=\"update_product\"]/div[5]/button";
        clickbyxpath(xpath);
    }

    @Then("close driver for editing Product")
    public void close_driver_for_editing_product() throws InterruptedException {
        closedriver();
    }

    /*
    check if the Product is found while ordering
    */


    @When("check if the product is available for order")
    public void check_if_the_product_is_available_for_order() throws InterruptedException {

        Thread.sleep(2000);
        Click_from_leftSideBar("Pre Invoices");
        Thread.sleep(2000);

        //click the create new pre invoice
        xpath = "//*[@id=\"tableData_wrapper\"]/div[1]/button[4]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //pre Invoice date
        xpath = "//*[@id=\"c_ord_date\"]";
        clickbyxpath(xpath);
        inputbyxpath(xpath, getToday());

        //wait and click distributors
        Thread.sleep(200);
        id = "select2-distributor_list-container";
        waitById(id);
        clickbyId(id);
        //search for bhai bhai and hit enter
        cssSelector = ".select2-search--dropdown > .select2-search__field";
        inputbycssselector(cssSelector, "bhai bhai");
        cssSelectorPressEnter(cssSelector);

        //add product
        xpath = "//*[@id=\"add_pre_invoice_form\"]/div/div[4]/div[6]/span/span[1]/span";
        Thread.sleep(0500);
        waitByxpath(xpath);
        inputbyxpath(xpath, productname);
        pressEnterbyXpath(xpath);

        //plus button
        id = "c_add_inv_prod";
        waitById(id);
        clickbyId(id);

        Thread.sleep(500);

        //get the text from the item list
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[1]";
        String iteminfo = getTextbyXpath(xpath);

        Assert.assertTrue(iteminfo.contains(productname));

        //get the price from the item list
        xpath = "//*[@id=\"c_inv_items_list\"]/tr/td[4]";
        String itemprice = getTextbyXpath(xpath);
        Assert.assertEquals(itemprice, PROD_DistributorPrice);

    }

    @Then("Close the driver for checking if the Product is found while ordering")
    public void close_the_driver_for_checking_if_the_product_is_found_while_ordering() throws InterruptedException {
        closedriver();
    }


}
