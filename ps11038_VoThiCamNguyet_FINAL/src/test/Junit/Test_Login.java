package test.Junit;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import entities.Account;
import model.AccountModel;

public class Test_Login {
	@BeforeClass
	public static void BeforeClass() {
		System.out.println("Start test login class.");
	}
	
	@Test
	public void TestCase1() {
		System.out.println("Start TestCase 1");
		
		AccountModel acmd = new AccountModel();
		
		Account acc = new Account();
		acc.setUsername("admin");
		acc.setPassword("123");
		
		int actual = acmd.checkLogin(acc);
		
		assertEquals(1, actual);
		
		
		System.out.println("End TestCase 1");
	}
	
	@Test
	public void TestCase2() {
		System.out.println("Start TestCase 2");
		
		AccountModel acmd = new AccountModel();
		
		Account acc = new Account();
		acc.setUsername("admin");
		acc.setPassword(null);
				
		int actual = acmd.checkLogin(acc);
		
		assertEquals(0, actual);
		
		System.out.println("End TestCase 2");
	}
	
	@Test
	public void TestCase3() {
		System.out.println("Start TestCase 3");
		
		AccountModel acmd = new AccountModel();
		
		Account acc = new Account();
		acc.setUsername(null);
		acc.setPassword("123");
		
		int actual = acmd.checkLogin(acc);
		
		assertEquals(0, actual);
	}
	
	@Test
	public void TestCase4() {
		System.out.println("Start TestCase 4");
		
		AccountModel acmd = new AccountModel();
		
		Account acc = new Account();
		acc.setUsername(null);
		acc.setPassword(null);
		
		int actual = acmd.checkLogin(acc);
		
		assertEquals(0, actual);
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("End test.");
	}
}
