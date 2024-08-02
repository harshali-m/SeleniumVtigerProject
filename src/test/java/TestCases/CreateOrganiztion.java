package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.Pom.HomePage;
import com.crm.Pom.Organization;
import com.crm.fileUtility.ExcelUtility;
import com.crm.javaUtility.JavaUtil;
@Listeners(com.crm.Listners.BasicListner.class)
public class CreateOrganiztion extends BaseClass {
	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		HomePage home = new HomePage(driver);
		home.organizations();
		
		int row = 0;
		Organization org = new Organization(driver);
		org.plusIcon();
		String orgName= eUtil.getData("Sheet1", row++, 0);
		org.organizationName(orgName+JavaUtil.generateRandomNumber(1000));
		org.group();
		org.assignedto(eUtil.getData("Sheet1", row++, 0));
		org.saveBtn();
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
	}

}
