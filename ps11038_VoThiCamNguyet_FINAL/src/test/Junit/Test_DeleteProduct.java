package test.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.SanPham;
import model.SanPhamModel;

public class Test_DeleteProduct {
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("Start test delete product.");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("Start TestCase 1");
		
		SanPhamModel spmd = new SanPhamModel();
		
		int length_before = spmd.getList().size();
		
		SanPham sp = new SanPham();
		sp.setMaSP(84);
		spmd.delete(sp);
		
		int length_after = spmd.getList().size();
		
		assertEquals(length_before - 1, length_after);
		
		System.out.println("End TestCase 1");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("End test.");
	}
}
