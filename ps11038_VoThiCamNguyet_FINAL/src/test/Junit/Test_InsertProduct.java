package test.Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.SanPhamModel;
import entities.SanPham;

public class Test_InsertProduct {
	
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("Start test insert product.");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("Start TestCase 1");
		
		SanPhamModel spmd = new SanPhamModel();
		
		SanPham sp = new SanPham();		
		sp.setTenSP("ProductTest1");
		sp.setDonGia(100000);
		sp.setSoLuong(1);
		sp.setHinh("bibimbap.jpg");
		sp.setMaDM(1);
		
		spmd.insertSanPham(sp);
		
		String result = spmd.getSanPhamByTenSP(sp.getTenSP()).getTenSP();
		assertEquals(sp.getTenSP(), result);
		
		System.out.println("End TestCase 1.");
	}
	
	@Test
	public void TestCase2() {
		System.out.println("Start TestCase 2.");
		
		SanPhamModel spmd = new SanPhamModel();
		
		int length_before_insert = spmd.getList().size();
		
		SanPham sp = new SanPham();		
		sp.setTenSP(null);
		sp.setDonGia(0);
		sp.setSoLuong(0);
		sp.setHinh(null);
		sp.setMaDM(1);
				
		spmd.insertSanPham(sp);
				
		int length_after_insert = spmd.getList().size();
		assertEquals(length_before_insert, length_after_insert);
		
		System.out.println("End TestCase 2.");
	}
	
	@Test
	public void TestCase3() {
		System.out.println("Start TestCase 3.");
		
		SanPhamModel spmd = new SanPhamModel();
		
		int length_before_insert = spmd.getList().size();
		
		SanPham sp = new SanPham();		
		sp.setTenSP("ProductTest3");
		sp.setDonGia(0);
		sp.setSoLuong(0);
		sp.setHinh(null);
		sp.setMaDM(1);
		
		spmd.insertSanPham(sp);
		
		int length_after_insert = spmd.getList().size();
		assertEquals(length_before_insert, length_after_insert);
		
		System.out.println("End TestCase 3.");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("End test.");
	}
	
}
