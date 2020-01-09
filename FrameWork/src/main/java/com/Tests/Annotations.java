package com.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	

		@BeforeSuite
		public void method_A() {
		System.out.println("before suite");
		}
		@BeforeTest
		public void method_B() {
		System.out.println("before test");
		}
		@BeforeClass
		public void method_C() {
		System.out.println("before class");
		}
		@BeforeMethod
		public void method_D() {
		System.out.println("before method");
		}

		@AfterSuite(alwaysRun = true)
		public void method_a() {
		System.out.println("After suite");
		}
		@AfterTest
		public void method_b() {
		System.out.println("After test");
		}
		@AfterClass
		public void method_c() {
		System.out.println("After class");
		}
		@AfterMethod
		public void method_d() {
		System.out.println("After method");
		}
		@Test
		public void method_1() {
		System.out.println("Test method");
		}

}
