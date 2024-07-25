package com.azmqalabs.uapitestautomation.apppages.masterpages;

import java.util.Map;
import java.util.NoSuchElementException;

import com.aventstack.extentreports.Status;
import com.azmqalabs.uapitestautomation.apppages.GlobalConstant;
import com.azmqalabs.uapitestautomation.common.Common;
import com.azmqalabs.uapitestautomation.common.Log;
import com.azmqalabs.uapitestautomation.common.ReadData;
import com.codoid.products.fillo.Recordset;

public class BasePage extends Common {
    public void launchApplication() {
        try {
            String MavenCmdLineAppUrl = "";
            MavenCmdLineAppUrl = System.getProperty("appurl");
            System.out.println("Maven externalized parameter: " + MavenCmdLineAppUrl);
            if (MavenCmdLineAppUrl != null)
                driver.get(MavenCmdLineAppUrl);
            else
                System.out.println(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
            driver.get(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
            test.log(Status.PASS, "Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
            System.out.println("Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
            new Log(driver, test).ReportEvent("PASS", "Application Launched Successfully");
            Thread.sleep(1000);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Test URL: " + GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
            driver.navigate().to(GlobalConstant.GLOBALTESTDATALOGINMAP.get("URL").toString());
            this.takeScreenShot();

        }

    }

    public void launchApplication(String sURL) {
        try {

            String MavenCmdLineTestType = "";
            MavenCmdLineTestType = System.getProperty("testtype");
            System.out.println("Maven externalized parameter: " + MavenCmdLineTestType);
            driver.get(sURL);
            test.log(Status.INFO, "Test URL: " + sURL);
            System.out.println("Test URL: " + sURL);
            this.takeScreenShot();
        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, ErrorFontColorPrefix
                    + "launchApplication Page - launchApplication failed - unable to Enter" + e + ErrorFontColorSuffix);
            test.log(Status.FAIL,
                    ErrorFontColorPrefix + "Error found at class: " + this.getClass().getName() + " Code line Number: "
                            + new Exception().getStackTrace()[0].getLineNumber() + "!" + ErrorFontColorSuffix);
            throw new NoSuchElementException("launchApplication - URL not launched");
        }
    }

    public void launchApplication(Map<Object,Object> testdatamap) throws Exception {
        Recordset launch= ReadData.readTestDataBySpecifiedValue("URL", "Portal", testdatamap.get("Portal").toString());
        launch.next();
        try{
            String MavenCmdLineAppUrl = "";
            MavenCmdLineAppUrl = System.getProperty("appurl");
            System.out.println("Maven externalized parameter: " + MavenCmdLineAppUrl);
            if (MavenCmdLineAppUrl != null)
                driver.get(MavenCmdLineAppUrl);
            else
                System.out.println(launch.getField("URL"));
            driver.get(launch.getField("URL"));
            test.log(Status.PASS, "Test URL: " + launch.getField("URL"));
            System.out.println("Test URL: " + launch.getField("URL"));
            new Log(driver, test).ReportEvent("PASS", "Application Launched Successfully");
            Thread.sleep(2000);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Test URL: " + launch.getField("URL"));
            driver.navigate().to(launch.getField("URL"));
            this.takeScreenShot();
        }
    }

}
