package com.crmAutomation.util;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class XLUtils 
//{
//	
//	public static FileInputStream fi;
//	public static FileOutputStream fo;
//	public static XSSFWorkbook wb;
//	public static XSSFSheet ws;
//	public static XSSFRow row;
//	public static XSSFCell cell;
//	public int size = 0;
//	List<XSSFCell> sheetHeader = null;
//	public static List<List<XSSFCell>> prodlist = new ArrayList<List<XSSFCell>>();
//	public static void setExcelFile(String xlfile,String xlsheet) throws Exception {
//		 
//			try {
//
//   			FileInputStream ExcelFile = new FileInputStream(xlfile);
//			wb = new XSSFWorkbook(ExcelFile);
//			ws = wb.getSheet(xlsheet);
//			} catch (Exception e){
//				throw (e);
//			}
//	}
//
//	public static int getRowCount(String xlfile,String xlsheet) throws IOException 
//	{
//		fi=new FileInputStream(xlfile);
//		wb=new XSSFWorkbook(fi);
//		ws=wb.getSheet(xlsheet);
//		int rowcount=ws.getLastRowNum();
//		wb.close();
//		fi.close();
//		return rowcount;		
//	}
//	
//	
//	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
//	{
//		fi=new FileInputStream(xlfile);
//		wb=new XSSFWorkbook(fi);
//		ws=wb.getSheet(xlsheet);
//		row=ws.getRow(rownum);
//		int cellcount=row.getLastCellNum();
//		wb.close();
//		fi.close();
//		return cellcount;
//	}
//	
//	
//	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
//	{
//		fi=new FileInputStream(xlfile);
//		wb=new XSSFWorkbook(fi);
//		ws=wb.getSheet(xlsheet);
//		row=ws.getRow(rownum);
//		cell=row.getCell(colnum);
//		String data;
//		try 
//		{
//			DataFormatter formatter = new DataFormatter();
//            String cellData = formatter.formatCellValue(cell);
//            return cellData;
//		}
//		catch (Exception e) 
//		{
//			data="";
//		}
//		wb.close();
//		fi.close();
//		return data;
//	}
//	
//	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
//	{
//		fi=new FileInputStream(xlfile);
//		wb=new XSSFWorkbook(fi);
//		ws=wb.getSheet(xlsheet);
//		row=ws.getRow(rownum);
//		cell=row.createCell(colnum);
//		cell.setCellValue(data);
//		fo=new FileOutputStream(xlfile);
//		wb.write(fo);		
//		wb.close();
//		fi.close();
//		fo.close();
//	}
//	public static List<List<XSSFCell>> getData(String workBook,String ssheetName) {
//		List<List<XSSFCell>> sheetData = null;
//		FileInputStream fis = null;
//		XSSFWorkbook wb = null;
//		XSSFSheet sheet = null;
//		try {
//			
//			String path=System.getProperty("user.dir");
//			String relativepath ="C:\\EclipseWorkSpace\\CRMAutomationLab\\src\\test\\resources\\TestData\\Test.xlsx";
//					//path+"\\CRMAutomationLab-master\\CRMAutomationLab-master\\CRMAutomationLab-master\\src\\test\\resources\\TestData\\"+workBook+".xlsx";
//			
//			String file= relativepath;
//			//String file =  System.getProperty("user.dir") + relativepath;
//			String sheetName = ssheetName;
//			System.out.println("The file is :: " + file + " and sheet is :: " + sheetName);
//			File fileName = new File(file);
//			if (fileName.exists()) {
//				fis = new FileInputStream(file);
//				wb = new XSSFWorkbook(fis);
//				sheet = wb.getSheet(sheetName);
//				System.out.println("Number of rows ::" + sheet.getPhysicalNumberOfRows());
//				System.out.println("Number of rows ::"+ sheet.getPhysicalNumberOfRows());
//				sheetData = new ArrayList<List<XSSFCell>>();
//				sheetData = getData_Template(sheet);
//			} else {
//				System.out.println("File not found");
//			}
//			fis.close();
//		} catch (Exception e) {
//			System.out.println("Exception in getData: " + e.getMessage());
//		}  finally {
//			if (fis != null) {
//				try {
//					fis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return sheetData;
//	}
//	public int getIndexFromSheetHeaderList(String hdrColName) {
//		Iterator<XSSFCell> hdrItr = sheetHeader.iterator();
//		XSSFCell hdrVal = null;
//		int indOfCol = 0;
//		while (hdrItr.hasNext()) {
//			hdrVal = hdrItr.next();
//			if (hdrVal.toString().trim().equals(hdrColName))
//				indOfCol = sheetHeader.indexOf((Object) hdrVal);
//		}
//		return indOfCol;
//	}
//	
//	public Object[][] getArray(List<List<XSSFCell>> sheetData, String isExcelYesNo) {
//
//		int indYN = getIndexFromSheetHeaderList("RunMode"); // "Yes/No");
//		prodlist.clear();
//		Iterator<List<XSSFCell>> checkData = sheetData.iterator();
//		List<XSSFCell> oneDList = null;
//		while (checkData.hasNext()) {
//			oneDList = (List<XSSFCell>) checkData.next();
//			if (isExcelYesNo.equalsIgnoreCase("Yes")) {
//				if ( oneDList.get(indYN).toString().equals("Yes"))
//					prodlist.add(oneDList);
//			} 
//		}
//
//		Object[][] result = new Object[prodlist.size()][];
//		try {
//			for (int i = 0; i < result.length; i++) {
//				result[i] = new Object[] { prodlist.get(i) };
//			}
//		} catch (Exception ex) {
//			System.out.println("Exception in getData_Template: " + ex.getMessage());
//		}
//		return result;
//	}
//	public static List<List<XSSFCell>> getData_Template(XSSFSheet sheet) {
//		List<List<XSSFCell>> sheetData = new ArrayList<List<XSSFCell>>();
//		FileInputStream fis = null;
//		try {
//			Iterator<Row> rows = sheet.rowIterator();
//			int iow = sheet.getPhysicalNumberOfRows();
//
//			for (int i = 0; i < iow; i++) {
//				if (rows != null) {
//					XSSFRow rown = (XSSFRow) rows.next();
//					Iterator<Cell> cells = rown.cellIterator();
//					List<XSSFCell> data = new ArrayList<XSSFCell>();
//					while (cells.hasNext()) {
//						XSSFCell celln = (XSSFCell) cells.next();
//						//celln = (XSSFCell) castCellType(celln);
//						data.add(celln);
//					}
//					if (data.isEmpty()) {
//						System.out.println("list is empty so not adding");
//					} else {
//						sheetData.add(data);
//					}
//				}
//			}
//		} catch (Exception e) {
//			System.out.println(
//					"Exception in getData_Template: " + e.getMessage());
//		} catch (OutOfMemoryError ex) {
//			System.out.println(
//					"Exception in getData_Template: " + ex.getMessage());
//	
//		} finally {
//			if (fis != null) {
//				try {
//					fis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return sheetData;
//	}
//
//	public Object[][] getTestData(String sSheetName,String sWorkbookName, String isExcelYesNo) throws Exception {
//
//		Object[][] array = null;
//		try {
//			System.out.println("Execution flag is - " +isExcelYesNo);
//
//			// To Do - Make constants for sheet name in Constants.java
//			List<List<XSSFCell>> listData = getData(sWorkbookName, sSheetName);
//			sheetHeader = listData.get(0);
//			listData.remove(0);
//
//			array = getArray(listData, isExcelYesNo);
//
//			size = array.length;
//			System.out.println(size); 
//		} catch (Exception e) {
//			System.out.println("Exception in getTestData_ExcelYes: " + e.getMessage());
//		} finally {
//			System.out.println("getTestData : End");
//		}
//		return array;
//	}
//
//	
//
//}
