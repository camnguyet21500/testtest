package test.Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Test_InsertProduct.class, Test_UpdateProduct.class, Test_ShowProduct.class, Test_DeleteProduct.class, Test_Login.class})
public class Test_TestSuite {
	
}
