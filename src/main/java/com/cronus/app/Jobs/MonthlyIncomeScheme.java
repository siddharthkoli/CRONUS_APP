package com.cronus.app.Jobs;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.util.SystemPropertyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.lang.Enum;

import com.cronus.app.Jobs.Base.BaseInvestmentJob;

public class MonthlyIncomeScheme extends BaseInvestmentJob {
    public MonthlyIncomeScheme() {
        super();
    }

//    public static void ReadExcel(){
//     Path currpath = Paths.get(System.getProperty("user.dir"));
//     Path filePath = Paths.get(currpath.toString(),"/ExcelFiles/jobs.xlsx");
//     try
//     {
//         FileInputStream file = new FileInputStream(new File(filePath.toString()));

//         //Create Workbook instance holding reference to .xlsx file
//         HSSFWorkbook workbook = new HSSFWorkbook(file);
//         HSSFSheet sheet = workbook.getSheetAt(2);
//         int rows;
//         rows = sheet.getPhysicalNumberOfRows();
//         int cols=0;
//         int tmp =0;

//         Iterator<Row> rowIterator;
//         while (rowIterator.hasNext()) 
//         {
//             Row row = rowIterator.next();
//             //For each row, iterate through all the columns
//             Iterator<Cell> cellIterator = row.cellIterator();
             
//             while (cellIterator.hasNext()) 
//             {
//                 Cell cell = cellIterator.next();
//                 //Check the cell type and format accordingly
//                 switch (cell.getCellType()) 
//                 {
//                     case NUMERIC:
//                         System.out.print(cell.getNumericCellValue() + "t");
//                         break;
//                     case STRING:
//                         System.out.print(cell.getStringCellValue() + "t");
//                         break;
                    

//                 }
//             }
//             System.out.println("");
//         }






        // Skip intial few rows 
    
    
   //}
}
