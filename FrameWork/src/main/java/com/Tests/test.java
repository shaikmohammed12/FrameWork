package com.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void test1() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/TestData/Datasheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Data");
		XSSFCell cell = sh.getRow(0).getCell(0);
		for(int i=0;i<5;i++)
		{
		try
		{
			if(sh.getRow(0).getCell(0).getStringCellValue()==null)
					continue;
			else
			System.out.println(cell.getStringCellValue());
		}
		catch(Exception e)
		{
			System.out.println("null");
		}
		}
		
			
	}

}
