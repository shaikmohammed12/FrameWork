package com.Resources;


import java.io.FileInputStream;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	
	public static String data=null;
	public static LinkedHashMap <String,String> data1 = new LinkedHashMap<String,String>();
	public static LinkedHashMap <Integer,String> data2 = new LinkedHashMap<Integer,String>();
	
	@SuppressWarnings("resource")
	public static XSSFSheet readExcel(String sheet) throws Throwable
	{
		/*
		 * String slash = "\\"; String escapedSlash = slash+slash; String
		 * twoEscapedSlashes = escapedSlash+escapedSlash; String temp =
		 * System.getProperty("user.dir")+"/src/test/TestData/Datasheet.xlsx"; String
		 * path = temp.replaceAll(escapedSlash, twoEscapedSlashes);
		 */
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/TestData/Datasheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheet);
		return sh;
	}
	
	public static String getData(String sheetName,String row,String column) throws Throwable
	{
		XSSFSheet sh = readExcel(sheetName);
		int i,j;
		for(i=0;i<=sh.getLastRowNum();i++)
		{
			if(row.equals(sh.getRow(i).getCell(0).getStringCellValue()))
			{	
				for(j=0;j<sh.getRow(i).getLastCellNum();j++)
				{
					if(column.equals(sh.getRow(0).getCell(j).getStringCellValue()))
					{
						data = sh.getRow(i).getCell(j).getStringCellValue();
						break;
					}
					else
						continue;
				}
				if(j>sh.getRow(0).getLastCellNum())
				{
					System.out.print("coloumn not found");
					return null;
				}
			}
			else
				continue;
		}
		if(1>sh.getLastRowNum())
		{
			System.out.print("row not found");
			return null;
		}
		return data;
	}
	
	
	
	@SuppressWarnings("resource")
	public static LinkedHashMap<Integer, String> getTestData(String sheetName,String column1,String column2) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/TestData/Datasheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		int i,j,x = 0,y = 0;
		if(sh.getLastRowNum()==0)
		{
			System.out.print("row not found");
			return null;
		}
		for(j=0;j<sh.getRow(0).getLastCellNum();j++)
		{
			if(column1.equals(sh.getRow(0).getCell(j).getStringCellValue()))
			{
					x=j;
					continue;
			}
			else if(column2.equals(sh.getRow(0).getCell(j).getStringCellValue()))
			{
					y=j;
					continue;
			}
			else
				continue;
		}
		for(i=1;i<=sh.getLastRowNum();i++)
		{
			if((sh.getRow(i).getCell(y).getStringCellValue().equalsIgnoreCase("Y")))
			{
				System.out.println(sh.getRow(i).getCell(x).getStringCellValue()+":"+sh.getRow(i).getCell(y).getStringCellValue());
				data2.put(i,sh.getRow(i).getCell(x).getStringCellValue());
				
			}
			else
				continue;
		}
		
		return data2;
	}
	
	
	@SuppressWarnings("resource")
	public static LinkedHashMap<String,String> getAllData(String filePath,String sheetName,String column1,String column2) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet(sheetName);
		int i,j,x = 0,y = 0;
		if(sh.getLastRowNum()==0)
		{
			System.out.print("row not found");
			return null;
		}
		for(j=0;j<sh.getRow(0).getLastCellNum();j++)
		{
			if(column1.equals(sh.getRow(0).getCell(j).getStringCellValue()))
			{
					x=j;
					continue;
			}
			else if(column2.equals(sh.getRow(0).getCell(j).getStringCellValue()))
			{
					y=j;
					continue;
			}
			else
				continue;
		}
		DataFormatter objDefaultFormat = new DataFormatter();
		FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);
		for(i=1;i<=sh.getLastRowNum();i++)
		{
			Cell cellvalue = sh.getRow(i).getCell(y);
			objFormulaEvaluator.evaluate(cellvalue); // This will evaluate the cell, And any type of cell will return string value
		    String cellValueStr = objDefaultFormat.formatCellValue(cellvalue,objFormulaEvaluator);
		    data1.put(sh.getRow(i).getCell(x).getStringCellValue(),cellValueStr);
		}
			
		return data1;
	}
	
	public static LinkedHashMap<Integer,String> getTestData(String sheetName,String column1) throws Throwable
	{
		XSSFSheet sh = readExcel(sheetName);
		int i,j,x = 0;
		if(sh.getLastRowNum()==0)
		{
			System.out.print("row not found");
			return null;
		}
		for(i=1;i<=sh.getLastRowNum();i++)
		{
			for(j=0;j<sh.getRow(0).getLastCellNum();j++)
			{
				if(column1.equals(sh.getRow(i).getCell(0).getStringCellValue()))
						x=j;
				else
					continue;
			}
			data2.put(i,sh.getRow(i).getCell(x).getStringCellValue());
				
		}
		
		return data2;
	}
	
	
}
