package com.geminisolutions.implementation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseImpl {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    public void teardown() {
        browser.close();
        playwright.close();
    }

}
