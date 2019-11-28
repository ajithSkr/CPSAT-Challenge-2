package CPSAT_PageObject.Question6.PageObject.Pages;

import CPSAT_Utilities.CPSAT_UtilityFunctions;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * This class contains all the steps for Live market page
 */
public class Question6_LiveMarketPage extends CPSAT_UtilityFunctions {

    WebDriver webDriver;

    XSSFWorkbook workbook = new XSSFWorkbook();

    public Question6_LiveMarketPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void storeTheTopGainersValueInExcelSheet(By gainersTable, By topGainersTableHeader, By topGainersTableData) {
        waitUntilTheElementIsVisible(webDriver, gainersTable);
        clickElementByXpath(webDriver, gainersTable);
        List<WebElement> tableHeader = new LinkedList<WebElement>();
        List<WebElement> tableElements = new LinkedList<WebElement>();
        tableHeader.addAll(searchElementsByXpath(webDriver, topGainersTableHeader));
        tableElements.addAll(searchElementsByXpath(webDriver, topGainersTableData));
        XSSFSheet sheet = workbook.createSheet("GainersData");
        int rownum = 0;
        XSSFRow row = sheet.createRow(rownum);
        int cellnum = 0;

        for (int i = 0; i < tableElements.size() - 1; i++) {
            sheet.setColumnWidth((short) i, (short) 5000);
            XSSFCell cell = row.createCell((short) cellnum++);
            if (rownum == 0) {
                XSSFCellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(cellStyle);

            }
            cell.setCellValue(tableElements.get(i).getText());

            if ((i + 1) % tableHeader.size() == 0) {
                rownum = rownum + 1;
                row = sheet.createRow(rownum);
                cellnum = 0;
            }
            try {
                FileOutputStream out = new FileOutputStream(new File("src/test/resources/ExcelSheets/TopGainers" +
                        "&LosersData.xlsx"));
                workbook.write(out);

                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void storeTheTopLosersValueInExcelSheet(By losersTable, By topLosersTableHeader, By topLosersTableData) {
        waitUntilTheElementIsVisible(webDriver, losersTable);
        clickElementByXpath(webDriver, losersTable);
        List<WebElement> tableHeader = new LinkedList<WebElement>();
        List<WebElement> tableElements = new LinkedList<WebElement>();
        tableHeader.addAll(searchElementsByXpath(webDriver, topLosersTableHeader));
        tableElements.addAll(searchElementsByXpath(webDriver, topLosersTableData));
        XSSFSheet sheet = workbook.createSheet("LosersData");
        int rownum = 0;
        XSSFRow row = sheet.createRow(rownum);
        int cellnum = 0;

        for (int i = 0; i < tableElements.size() - 1; i++) {
            sheet.setColumnWidth((short) i, (short) 5000);
            XSSFCell cell = row.createCell((short) cellnum++);
            if (rownum == 0) {
                XSSFCellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setFillForegroundColor(IndexedColors.SEA_GREEN.getIndex());
                cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cell.setCellStyle(cellStyle);

            }
            cell.setCellValue(tableElements.get(i).getText());
            if ((i + 1) % tableHeader.size() == 0) {
                rownum = rownum + 1;
                row = sheet.createRow(rownum);
                cellnum = 0;
            }
            try {
                FileOutputStream out = new FileOutputStream(new File("src/test/resources/ExcelSheets/TopGainers" +
                        "&LosersData.xlsx"));
                workbook.write(out);
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Assert the top gainers And losers percentage change are from high to low or not
     *
     * @param filePath
     * @throws IOException
     */
    public void assertTopGainersAndLosersPercentage(String filePath) throws IOException {

        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            int noOfSheets = 2;
            for (int i = 0; i < noOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                XSSFRow row = null;
                Iterator iterator = sheet.rowIterator();
                int rownum = 0;
                int columnNumber = 0;
                List<Float> actualData = new LinkedList<>();
                List<Float> dataForSort = new LinkedList<>();
                while (iterator.hasNext()) {
                    row = (XSSFRow) iterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (cell.getStringCellValue().replace("\n", " ").contains("% Change")) {
                            columnNumber = cell.getColumnIndex();
                        }
                    }
                }
                iterator = sheet.rowIterator();
                while (iterator.hasNext()) {
                    row = (XSSFRow) iterator.next();
                    if (rownum > 0) {
                        if (!row.getCell(columnNumber).toString().equals("-")) {
                            if (row.getCell(columnNumber).toString().contains("-")) {
                                String percentage = row.getCell(columnNumber).toString().replace("-", "");
                                actualData.add(Float.parseFloat(percentage));
                                dataForSort.add(Float.parseFloat(percentage));
                            } else {
                                String percentage = row.getCell(columnNumber).toString();
                                actualData.add(Float.parseFloat(percentage));
                                dataForSort.add(Float.parseFloat(percentage));
                            }
                        }

                    }
                    rownum++;

                }

                Collections.sort(dataForSort, Collections.reverseOrder());
                Assert.assertEquals(actualData, dataForSort);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    /**
     * Extract the date and time and compare with the system date and time
     *
     * @param refreshButton
     * @param dateAndTime
     */
    public void extractDateAndTimeAndCompareWithTheSystemResult(By refreshButton, By dateAndTime) throws ParseException {
        waitUntilTheElementIsVisible(webDriver, refreshButton);
        String dateAndTimeFromLiveMarketPag = searchElementByXpath(webDriver, dateAndTime).getText().replace("As on "
                , "");

        DateFormat format = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss", Locale.ENGLISH);
        Date fetchedDateAndTime = format.parse(dateAndTimeFromLiveMarketPag);
        Date currentDateAndTime = new Date();
        Long df = currentDateAndTime.getTime() - fetchedDateAndTime.getTime();
        System.out.println(" The Top Gainers and Losers data was Updated before " + TimeUnit.DAYS.convert(df,
                TimeUnit.MILLISECONDS) + " days ");


    }

}

