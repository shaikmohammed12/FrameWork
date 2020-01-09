package com.Resources;

import java.util.*;


import org.testng.*;
import org.testng.xml.*;


public class DynamicTestng {
	
	@SuppressWarnings("deprecation")
	public  void createXML(ArrayList<String> tc_id,ArrayList<String> ClassName,ArrayList<String> browser,ArrayList<String> url)
	{
		try
		{
			TestNG myTestNG = new TestNG();
	    
		//Create an instance of XML Suite and assign a name for it.
			
			XmlSuite mySuite = new XmlSuite();
			mySuite.setName("MySuite");
			System.out.println("Suite is created");
	    
	    //Create a Test, assign a name and hook it to the suite 
			
			for(int i=0;i<ClassName.size();i++)
				createXMLTest(mySuite,i,tc_id.get(i),ClassName.get(i),browser.get(i),url.get(i));
			
		//Add the suite to the list of suites.
		     List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		     mySuites.add(mySuite);
		     
		    //Set the list of Suites to the testNG object you created earlier.
		     myTestNG.setXmlSuites(mySuites);
		     System.out.println("Suite is hooked to TestNG instance");
		     TestListenerAdapter tla = new TestListenerAdapter();
		     myTestNG.addListener(tla);
		     System.out.println("Creating XML File");
		     myTestNG.run();
		     System.out.println("runnning XML File");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

		public void createXMLTest(XmlSuite mySuite,int i,String tc_id,String ClassName,String browser,String url) throws Exception
		{
			try
			{
				//Create an instance of XmlTest and assign a name for it.
				
			     	XmlTest myTest = new XmlTest(mySuite);
			     	myTest.setName("MyTest"+i);
			     	myTest.addParameter("tc_id", tc_id);
			     	myTest.addParameter("browser", browser);
			     	myTest.addParameter("url", url);
			     	System.out.println("Test is created and hooked to suite"+mySuite.getName());
			     	
			   //Create a list which can contain the classes that you want to run.
					
					List<XmlClass> myClasses = new ArrayList<XmlClass>();
					XmlClass myClass = new XmlClass("com.Tests."+ClassName);
					//XmlClass myClass = new XmlClass(Setup.class);
					System.out.println("Class is created is created");
					myClasses.add(myClass);
					
				//Assign that to the XmlTest Object created earlier.
					
				     myTest.setXmlClasses(myClasses);
				     System.out.println("classes are hooked to test");
				    
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
}
