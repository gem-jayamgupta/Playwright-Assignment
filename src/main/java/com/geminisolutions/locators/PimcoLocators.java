package com.geminisolutions.locators;

public class PimcoLocators {

    public static final String FIRST_ROLE_LOCATOR = "//label[@for='946d02f3-85b6-495c-b8cf-8621ba0d98f0']";
    public static final String TERMS_AGREE_CHECKBOX_LOCATOR = "//label[@for='termsAgree']";
    public static final String SUBMIT_BUTTON_LOCATOR = "//button[@type='submit']";

    public static final String DAILY_NAV_LOCATOR = "//div[contains(text(), 'Daily Nav (USD)')]";
    public static final String DAILY_YTD_RETURN_LOCATOR = "//div[contains(text(),'Daily YTD RETURN')]";
    public static final String ASSET_CLASS_LOCATOR = "//div[contains(text(), 'Asset Class')]";
    public static final String TOTAL_FUND_ASSETS_LOCATOR = "//div[contains(text(), 'Total ')]";
    public static final String FUND_INCEPTION_DATE_LOCATOR = "//div[contains(text(), ' Inception Date ')]";
    public static final String MORNING_STAR_RATING_LOCATOR = "//div[contains(text(), 'Overall Morningstar Rating')]";

    public static final String DAILY_NAV_VALUE_LOCATOR = "(//div[@class='fund-summary__value'])[1]";
    public static final String DAILY_YTD_RETURN_VALUE_LOCATOR = "(//div[@class='fund-summary__value ng-star-inserted'])[1]/*[1]";
    public static final String ASSET_CLASS_VALUE_LOCATOR = "//div[@class='fund-summary__value fund-summary__fund-class']";
    public static final String TOTAL_FUND_ASSETS_VALUE_LOCATOR = "(//div[@class='fund-summary__value'])[2]";
    public static final String FUND_INCEPTION_DATE_VALUE_LOCATOR = "(//div[@class='fund-summary__value'])[3]";
    public static final String MORNING_STAR_RATING_VALUE_LOCATOR = "//div[@class='fund-summary__value ng-star-inserted']//span[@class='visually-hidden']";

}
