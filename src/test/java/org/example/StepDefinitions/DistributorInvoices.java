package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Page_Options;

public class DistributorInvoices extends Page_Options {
    @Given("Login to Search Invoice")
    public void login_to_search_invoice() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(19) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @When("search for Invoice")
    public void search_for_invoice() {
        xpath = "//*[@id=\"inv_tableData_filter\"]/label/input";
        waitByxpath(xpath);
        inputbyxpath(xpath, DistributorInvoiceSearchInfo);
    }

    @And("description of an Invoice")
    public void description_of_an_invoice() {
        id = "btn_view";
        waitById(id);
        clickbyId(id);
    }

    @Then("close Invoice for search")
    public void close_invoice_for_search() throws InterruptedException {
        Thread.sleep(1500);
        closedriver();
    }


    @Given("login for Invoice")
    public void login_for_invoice() {
        Login(user_Fahim);

        cssSelector = ".menues-bar:nth-child(19) .active";
        waitByCssSelector(cssSelector);
        clickbycssselector(cssSelector);
    }

    @And("create new Invoice")
    public void create_new_invoice() throws InterruptedException {
        //click the create new button
        xpath = "//*[@id=\"inv_tableData_wrapper\"]/div[1]/button[4]";
        waitByxpath(xpath);
        clickbyxpath(xpath);

        //set date
        xpath = "//*[@id=\"c_actual_inv_date\"]";
        waitByxpath(xpath);
        inputbyxpath(xpath, getToday());

        //order list
        xpath = "//*[@id=\"select2-order_list-container\"]";
        waitByxpath(xpath);
        clickbyxpath(xpath);
        //search for bhai bhai and hit enter
        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, DistributorInvoiceDistributorSearch);
        cssSelectorPressEnter(cssSelector);

        //select the store
        id = "select2-c_store_id-container";
        waitById(id);
        clickbyId(id);

        cssSelector = "body > span > span > span.select2-search.select2-search--dropdown > input";
        waitByCssSelector(cssSelector);
        inputbycssselector(cssSelector, DistributorInvoiceStore);
        cssSelectorPressEnter(cssSelector);

        //notes
        id = "c_notes";
        inputbyid(id, DistributorInvoiceNote);

        //partial cancel or full cancel
        Boolean fullCancel = false; //Default is Full Cancel

        for (int i = 0; i < getTotalRowCountByXpath("//*[@id=\"c_inv_items_list\"]"); i++) {
            if (fullCancel == false && i%2 ==0 ) {
                //CTN
                Thread.sleep(200);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[5]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, DistributorInvoiceItemQuantity); //here the number is the quantity that will be deleted

                //PCS
                Thread.sleep(200);
                xpath = "//*[@id=\"c_inv_items_list\"]/tr["+(i+1)+"]/td[6]/input";
                waitByxpath(xpath);
                clearByXpath(xpath);
                inputbyxpath(xpath, DistributorInvoiceItemQuantity); //here the number is the quantity that will be deleted
            }
        }

        //save
        xpath = "//*[@id=\"add_region\"]";
        clickbyxpath(xpath);

        AlertAccept();
    }

    @Then("close the Invoice window")
    public void close_the_invoice_window() throws InterruptedException {
        Thread.sleep(2000);
        closedriver();
    }
}
