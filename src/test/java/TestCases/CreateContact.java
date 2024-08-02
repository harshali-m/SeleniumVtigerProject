package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.Pom.Contacts;
import com.crm.Pom.HomePage;
import com.crm.fileUtility.ExcelUtility;
import com.crm.javaUtility.JavaUtil;

public class CreateContact extends BaseClass {
	ExcelUtility eUtil=new ExcelUtility();
	@Test
	public void createContact() throws EncryptedDocumentException, IOException
	{
		HomePage home=new HomePage(driver);
		home.contacts();
		Contacts con=new Contacts(driver);
		con.plus();
		int row=0;
		String conName= eUtil.getData("Sheet2", row++, 0);
		con.lastName(conName+JavaUtil.generateRandomNumber(1000));
		con.getLastName();
		con.endDate(JavaUtil.endDate());
		con.saveBtn();
		assertTrue((con.getContactInfo().getText()).contains(conName));
	}

}
