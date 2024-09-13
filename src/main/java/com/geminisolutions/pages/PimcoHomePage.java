package com.geminisolutions.pages;

import com.geminisolutions.locators.PimcoLocators;
import com.microsoft.playwright.Page;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class PimcoHomePage extends BasePage {

    String dailyNav;
    String dailyYtdReturn;
    String assetClass;
    String totalFundAssets;
    String fundInceptionDate;
    String morningStarRating;

    String dailyNavValue;
    String dailyYtdReturnValue;
    String assetClassValue;
    String totalFundAssetsValue;
    String fundInceptionDateValue;
    String morningStarRatingValue;

    public PimcoHomePage(Page page) {
        super(page);
    }

    public void selectFirstRole() {
        page.click(PimcoLocators.FIRST_ROLE_LOCATOR);
    }

    public void selectTermsAgreeCheckbox() {
        page.focus(PimcoLocators.TERMS_AGREE_CHECKBOX_LOCATOR);
        page.click(PimcoLocators.TERMS_AGREE_CHECKBOX_LOCATOR);
    }

    public void clickSubmitButton() {
        page.focus(PimcoLocators.SUBMIT_BUTTON_LOCATOR);
        page.click(PimcoLocators.SUBMIT_BUTTON_LOCATOR);
    }

    public void fetchAllDataPoints() {
        dailyNav = page.locator(PimcoLocators.DAILY_NAV_LOCATOR).textContent();
        dailyYtdReturn = page.locator(PimcoLocators.DAILY_YTD_RETURN_LOCATOR).textContent();
        assetClass = page.locator(PimcoLocators.ASSET_CLASS_LOCATOR).textContent();
        totalFundAssets = page.locator(PimcoLocators.TOTAL_FUND_ASSETS_LOCATOR).textContent();
        fundInceptionDate = page.locator(PimcoLocators.FUND_INCEPTION_DATE_LOCATOR).textContent();
        morningStarRating = page.locator(PimcoLocators.MORNING_STAR_RATING_LOCATOR).textContent();

    }

    public void fetchAllDataPointsValues() {
        dailyNavValue = page.locator(PimcoLocators.DAILY_NAV_VALUE_LOCATOR).innerText();
        dailyYtdReturnValue = page.locator(PimcoLocators.DAILY_YTD_RETURN_VALUE_LOCATOR).innerText();
        assetClassValue = page.locator(PimcoLocators.ASSET_CLASS_VALUE_LOCATOR).innerText();
        totalFundAssetsValue = page.locator(PimcoLocators.TOTAL_FUND_ASSETS_VALUE_LOCATOR).innerText();
        fundInceptionDateValue = page.locator(PimcoLocators.FUND_INCEPTION_DATE_VALUE_LOCATOR).innerText();
        morningStarRatingValue = page.locator(PimcoLocators.MORNING_STAR_RATING_VALUE_LOCATOR).innerText();

    }

    public void storeDataInExcel() {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet("Fund Data");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Nav Bar Field Name");
            header.createCell(1).setCellValue("Nav Bar Field Value");

            Object[][] data = {
                    {dailyNav, dailyNavValue},
                    {dailyYtdReturn, dailyYtdReturnValue},
                    {assetClass, assetClassValue},
                    {totalFundAssets, totalFundAssetsValue},
                    {fundInceptionDate, fundInceptionDateValue},
                    {morningStarRating, morningStarRatingValue}
            };

            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue((String) rowData[0]);
                row.createCell(1).setCellValue((String) rowData[1]);
            }

            String projectDir = System.getProperty("user.dir");
            String filePath = projectDir + "/FundData.xlsx";

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean validateData(){
        return dailyNavValue != null && dailyYtdReturnValue != null && assetClassValue != null &&
                totalFundAssetsValue != null && fundInceptionDateValue != null && morningStarRatingValue != null;
    }

}
