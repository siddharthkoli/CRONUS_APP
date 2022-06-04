package com.cronus.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import com.cronus.app.PropertiesReader;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelAPI {
    private static int convertMonth(String month) {
        switch (month) {
            case "Jan":
                return Calendar.JANUARY;
            case "Feb":
                return Calendar.FEBRUARY;
            case "Mar":
                return Calendar.MARCH;
            case "Apr":
                return Calendar.APRIL;
            case "May":
                return Calendar.MARCH;
            case "Jun":
                return Calendar.JUNE;
            case "Jul":
                return Calendar.JULY;
            case "Aug":
                return Calendar.AUGUST;
            case "Sep":
                return Calendar.SEPTEMBER;
            case "Oct":
                return Calendar.OCTOBER;
            case "Nov":
                return Calendar.NOVEMBER;
            case "Dec":
                return Calendar.DECEMBER;
            default:
                return -1;
        }
    }

    public static ArrayList<ExcelRow> readExcel(int sheetNumber) throws java.text.ParseException {
        XSSFWorkbook wbook = null;
        try {
            Path filePath = Paths.get(ClassLoader.getSystemResource("ExcelFiles/jobs.xlsx").toURI());
            FileInputStream fis = new FileInputStream(new File(filePath.toString()));
            wbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        XSSFSheet sheet = wbook.getSheetAt(sheetNumber);
        Iterator<Row> rowIterator = sheet.iterator();

        ArrayList<ExcelRow> rows = new ArrayList<>();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getRowNum() > 0) {
                double accNo = row.getCell(PropertiesReader.getExcelProperty("COLUMN.ACCOUNT_NUMBER"))
                        .getNumericCellValue();
                String accNoString = String.valueOf((int) accNo);
                String maturityDateString = row.getCell(PropertiesReader.getExcelProperty("COLUMN.MATURITY_DATE"))
                        .toString();

                String medium = row.getCell(PropertiesReader.getExcelProperty("COLUMN.MEDIUM")).toString();
                Double interestDeposited = row.getCell(PropertiesReader.getExcelProperty("COLUMN.INTEREST"))
                        .getNumericCellValue();
                Double principal = row.getCell(PropertiesReader.getExcelProperty("COLUMN.PRINCIPAL"))
                        .getNumericCellValue();
                String[] names = row.getCell(PropertiesReader.getExcelProperty("COLUMN.NAMES")).toString().split(",");

                int maturityDay = Integer.parseInt(maturityDateString.substring(0, 2));
                int maturityMonth = ExcelAPI.convertMonth(maturityDateString.substring(3, 6));
                int maturityYear = Integer.parseInt(maturityDateString.substring(7, 11));

                rows.add(new ExcelRow(accNoString, names, interestDeposited, principal, medium, maturityDateString,
                        maturityDay, maturityMonth, maturityYear, "VASANT"));

            }

        }
        return rows;
    }
}
