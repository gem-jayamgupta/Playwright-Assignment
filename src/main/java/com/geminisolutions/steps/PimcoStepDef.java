package com.geminisolutions.steps;

import com.geminisolutions.implementation.PimcoImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PimcoStepDef {

    PimcoImpl pimcoImpl = new PimcoImpl();

    @Given("User navigates to {string}")
    public void userNavigatesToUrl(String url){
        pimcoImpl.launchUrl(url);
    }

    @When("User selects the first role")
    public void userSelectsTheFirstRole() {
        pimcoImpl.selectFirstRoleAndSubmitForm();
    }

    @Then("User fetches all the data points including date, name, and text")
    public void userFetchesAllTheDataPointsIncludingDateNameAndText() {
        pimcoImpl.fetchAllDataPointsAndValues();
    }

    @And("User stores the data in an Excel file")
    public void userStoresTheDataInAnExcelFile() {
        pimcoImpl.storeDataPointsAndValuesInExcel();
    }

    @And("User validates the data")
    public void userValidatesData() {
        Assert.assertTrue(pimcoImpl.validateData());
    }
}
