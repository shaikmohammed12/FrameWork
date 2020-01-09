package com.Resources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Testng {

	public static LinkedHashMap<String,String> configdata = new LinkedHashMap<String,String>();
	public static LinkedHashMap<Integer,String> tc_id = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> Classes = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> browsers = new LinkedHashMap<Integer,String>();
	public static LinkedHashMap<Integer,String> urls = new LinkedHashMap<Integer,String>();
	ArrayList<String> tc_id1 = new ArrayList<String>();
	ArrayList<String> Classes1 = new ArrayList<String>();
	ArrayList<String> browsers1 = new ArrayList<String>();
	ArrayList<String> urls1 = new ArrayList<String>();
	
	DynamicTestng dt = new DynamicTestng();
	
	public ArrayList<String> getTestCase(String SheetName) throws Throwable
	{
		tc_id = Excel.getTestData(SheetName, "TC_ID","EXECUTE");
		Collection<String> values = tc_id.values();
		ArrayList<String> tc_id2 = new ArrayList<String>(values);
		return tc_id2;
	}
	
	@Test
	public void getInputData() throws Throwable
	{
		String path = "/src/test/TestData/Config.xlsx";
		configdata = Excel.getAllData(path, "config", "NAME", "VALUE");
		System.out.println(configdata);
		String SheetName = configdata.get("DataSheetName");
		System.out.println(SheetName);
		tc_id = Excel.getTestData(SheetName, "TC_ID","EXECUTE");
		Collection<String> values = tc_id.values();
		ArrayList<String> tc_id1 = new ArrayList<String>(values);
		//System.out.println(tc_id1+":"+Classes1+":"+browsers1+":"+urls1);
		Classes = Excel.getTestData(SheetName, "CLASS","EXECUTE");
		Collection<String> values1 = tc_id.values();
		ArrayList<String> Classes1 = new ArrayList<String>(values1);
		//System.out.println(tc_id1+":"+Classes1+":"+browsers1+":"+urls1);
		browsers = Excel.getTestData(SheetName, "BROWSER","EXECUTE");
		Collection<String> values2 = tc_id.values();
		ArrayList<String> browsers1 = new ArrayList<String>(values2);
		//System.out.println(tc_id1+":"+Classes1+":"+browsers1+":"+urls1);
		urls = Excel.getTestData(SheetName, "URL","EXECUTE");
		Collection<String> values3 = tc_id.values();
		ArrayList<String> urls1 = new ArrayList<String>(values3);
		dt.createXML(tc_id1, Classes1, browsers1, urls1);
		
	}
	
	@BeforeTest
	public void sample()
	{
		System.out.print("TestNG class is invoked");
	}
}
