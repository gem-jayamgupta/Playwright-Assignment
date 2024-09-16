package com.geminisolutions.pages;

import com.geminisolutions.locators.PimcoLocators;
import com.microsoft.playwright.Page;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
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

    String dailyNavAsOfDateValue;
    String dailyYtdReturnValue;

    String dailyYtdReturnAsOfDateValue;
    String assetClassValue;
    String totalFundAssetsValue;

    String totalFundAssetsAsOfDateValue;
    String fundInceptionDateValue;
    String morningStarRatingValue;

    String morningStarRatingAsOfDateValue;

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
        dailyNavValue = dailyNavValue.split("As")[0].trim();
        dailyNavAsOfDateValue = page.locator(PimcoLocators.DAILY_NAV_AS_OF_DATE_VALUE).innerText();
        dailyNavAsOfDateValue = dailyNavAsOfDateValue.replace("As of ", "").trim();
        dailyYtdReturnValue = page.locator(PimcoLocators.DAILY_YTD_RETURN_VALUE_LOCATOR).innerText();
        dailyYtdReturnAsOfDateValue = page.locator(PimcoLocators.DAILY_YTD_RETURN_AS_OF_DATE_VALUE).innerText();
        dailyYtdReturnAsOfDateValue = dailyYtdReturnAsOfDateValue.replace("As of ","").trim();
        assetClassValue = page.locator(PimcoLocators.ASSET_CLASS_VALUE_LOCATOR).innerText();
        totalFundAssetsValue = page.locator(PimcoLocators.TOTAL_FUND_ASSETS_VALUE_LOCATOR).innerText();
        totalFundAssetsValue = totalFundAssetsValue.split("As")[0].trim();
        totalFundAssetsAsOfDateValue = page.locator(PimcoLocators.TOTAL_FUND_ASSETS_AS_OF_DATE_VALUE).innerText();
        totalFundAssetsAsOfDateValue = totalFundAssetsAsOfDateValue.replace("As of ", "").trim();
        fundInceptionDateValue = page.locator(PimcoLocators.FUND_INCEPTION_DATE_VALUE_LOCATOR).innerText();
        morningStarRatingValue = page.locator(PimcoLocators.MORNING_STAR_RATING_VALUE_LOCATOR).innerText();
        morningStarRatingAsOfDateValue = page.locator(PimcoLocators.MORNING_STAR_RATING_AS_OF_DATE_VALUE).innerText();
        morningStarRatingAsOfDateValue = morningStarRatingAsOfDateValue.replace("As of ", "").trim();
    }

    public void storeDataInExcel(String excelName) {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = workbook.createSheet(excelName);

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Nav Bar Field Name");
            header.createCell(1).setCellValue("Nav Bar Field Value");

            Object[][] data = {
                    {dailyNav, dailyNavValue},
                    {"Daily Nav Dated", dailyNavAsOfDateValue},
                    {dailyYtdReturn, dailyYtdReturnValue},
                    {"Daily YTD Return Dated", dailyYtdReturnAsOfDateValue},
                    {assetClass, assetClassValue},
                    {totalFundAssets, totalFundAssetsValue},
                    {"Total Fund Assets Dated", totalFundAssetsAsOfDateValue},
                    {fundInceptionDate, fundInceptionDateValue},
                    {morningStarRating, morningStarRatingValue},
                    {"Morning Star Rating Dated", morningStarRatingAsOfDateValue}
            };

            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue((String) rowData[0]);
                row.createCell(1).setCellValue((String) rowData[1]);
            }

            String projectDir = System.getProperty("user.dir");
            String filePath = projectDir + "/"+excelName+".xlsx";

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void storeFollowingDayDataInExcel(String excelName){
        try (FileInputStream fileInputStream = new FileInputStream(excelName+".xlsx");
             HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream)) {

            HSSFSheet sheet = workbook.getSheet(excelName);

            Row header = sheet.getRow(0);
            if (header != null) {
                Cell headerCell = header.createCell(2);
                headerCell.setCellValue("Following Day Data");
            }

            Object[][] data = {
                    {dailyNavValue},
                    {dailyNavAsOfDateValue},
                    {dailyYtdReturnValue},
                    {dailyYtdReturnAsOfDateValue},
                    {assetClassValue},
                    {totalFundAssetsValue},
                    {totalFundAssetsAsOfDateValue},
                    {fundInceptionDateValue},
                    {morningStarRatingValue},
                    {morningStarRatingAsOfDateValue}
            };

            int rowNum = 1;
            for (Object[] rowData : data) {
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    row = sheet.createRow(rowNum);
                }
                row.createCell(2).setCellValue((String) rowData[0]);
                rowNum++;
            }

            try (FileOutputStream fileOut = new FileOutputStream(excelName+".xlsx")) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateData(String excelName){

        try (FileInputStream fileInputStream = new FileInputStream(excelName+".xlsx");
             HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream)) {

            HSSFSheet sheet = workbook.getSheet(excelName);

            Row header = sheet.getRow(0);
            if (header != null) {
                Cell resultHeaderCell = header.createCell(3);
                resultHeaderCell.setCellValue("Result");
            }

            int rowNum = 1;
            while (true) {
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    break;
                }

                Cell cell2 = row.getCell(1);
                Cell cell3 = row.getCell(2);

                if (cell2 == null || cell3 == null) {
                    break;
                }

                String value2 = cell2.getStringCellValue().trim();
                String value3 = cell3.getStringCellValue().trim();

                Cell resultCell = row.createCell(3);

                if (value2.equals(value3)) {
                    resultCell.setCellValue("Match");
                } else {
                    resultCell.setCellValue("Mismatch");
                }

                rowNum++;
            }

            try (FileOutputStream fileOut = new FileOutputStream(excelName+".xlsx")) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
