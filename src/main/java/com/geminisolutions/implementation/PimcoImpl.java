package com.geminisolutions.implementation;

import com.geminisolutions.pages.PimcoHomePage;

public class PimcoImpl extends BaseImpl{

    PimcoHomePage pimcoHomePage;

    public void launchUrl(String url) {
        super.setup();
        pimcoHomePage = new PimcoHomePage(page);
        page.navigate(url);
    }

    public void selectFirstRoleAndSubmitForm(){
        pimcoHomePage.selectFirstRole();
        pimcoHomePage.selectTermsAgreeCheckbox();
        pimcoHomePage.clickSubmitButton();
    }

    public void fetchAllDataPointsAndValues(){
        pimcoHomePage.fetchAllDataPoints();
        pimcoHomePage.fetchAllDataPointsValues();
    }

    public void storeDataPointsAndValuesInExcel(){
        pimcoHomePage.storeDataInExcel();
    }

    public boolean validateData(){
        return pimcoHomePage.validateData();
    }

}
