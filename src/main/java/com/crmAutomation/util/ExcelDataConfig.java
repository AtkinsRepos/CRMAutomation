package com.crmAutomation.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	FileInputStream fis; 
	XSSFWorkbook workbook; 
	XSSFSheet sheet;

	public ExcelDataConfig(String filePath)
	 {

	try 
	{
	File myFile=new File(filePath); 
	fis=new FileInputStream(myFile); 
	workbook=new XSSFWorkbook(fis);
	}

	catch (Exception e)
	
	{
	System.out.println("Something went wrong");

	}
	
	}
	public int getRowsCount (int sheetID)
	
	 {
		
	int rowsCount=workbook.getSheetAt(sheetID).getLastRowNum(); 
	
	System.out.println("rowsCount : + rowsCount"); 
			
	return rowsCount+1;
	}

	public String getRowColValue(int SheetID, int rowID, int colID) 
	{
	String valueAtRowCol=workbook.getSheetAt(SheetID).getRow(rowID).getCell(colID).getStringCellValue();
	return valueAtRowCol;
	}


}
