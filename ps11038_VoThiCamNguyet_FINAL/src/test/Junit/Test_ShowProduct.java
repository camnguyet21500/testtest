package test.Junit;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.SanPhamModel;

public class Test_ShowProduct {
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("Start test show product.");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("Start TestCase1");
		
		SanPhamModel spmd = new SanPhamModel();
		
		assertTrue(spmd.getList() != null);
		
		System.out.println("End TestCase1");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("End test.");
	}
}
