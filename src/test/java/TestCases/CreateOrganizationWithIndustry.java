package TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.Pom.HomePage;
import com.crm.Pom.Organization;
import com.crm.fileUtility.ExcelUtility;
import com.crm.javaUtility.JavaUtil;

public class CreateOrganizationWithIndustry extends BaseClass {
	ExcelUtility eUtil = new ExcelUtility();
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		HomePage home = new HomePage(driver);
		home.organizations();
		
		int row = 0;
		Organization org = new Organization(driver);
		org.plusIcon();
		String orgName= eUtil.getData("Sheet1", row++, 1);
		org.organizationName(orgName+JavaUtil.generateRandomNumber(1000));
		org.group();
		org.assignedto(eUtil.getData("Sheet1", row++, 1));
		String industry = eUtil.getData("Sheet1", row++, 1);
		org.selectIndustry(industry);
		assertTrue((org.getIndustry().getText()).contains(industry));
		org.saveBtn();
		assertTrue((org.getCreatedOrgText().getText()).contains(orgName));
	}

}
