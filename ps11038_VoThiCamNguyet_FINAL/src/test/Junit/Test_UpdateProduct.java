package test.Junit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.SanPham;
import model.SanPhamModel;

public class Test_UpdateProduct {
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("Start test update product");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("Start TestCase 1");
		
		SanPhamModel spmd = new SanPhamModel();
		
		SanPham sp = new SanPham();		
		sp.setTenSP("aaa");
		sp.setDonGia(10000);
		sp.setSoLuong(1);
		sp.setHinh("bibimbap.jpg");
		sp.setMaDM(1);
		sp.setMaSP(84);
		
		spmd.updateSanPham(sp);
		
		int actual = spmd.getSanPhamByTenSP(sp.getTenSP()).getDonGia();
		
		assertEquals(sp.getDonGia(), actual);		
		
		System.out.println("End TestCase 1.");
	}
	
	@Test
	public void TestCase2() {
		System.out.println("Start TestCase 2");
		
		SanPhamModel spmd = new SanPhamModel();
		
		SanPham sp = new SanPham();		
		sp.setTenSP("aaa");
		sp.setDonGia(0);
		sp.setSoLuong(1);
		sp.setHinh("bibimbap.jpg");
		sp.setMaDM(1);
		sp.setMaSP(84);
		
		spmd.updateSanPham(sp);
		
		int actual = spmd.getSanPhamByTenSP(sp.getTenSP()).getDonGia();
		
		assertNotEquals(sp.getDonGia(), actual);
		
		System.out.println("End TestCase 2.");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("End test.");
	}
}
