package org.example.core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.MyBrowser;

public class BaseTest {
    @BeforeMethod
    public void setup(){MyBrowser.open();}

    @AfterMethod
    public void tearDown(){MyBrowser.quit();}
}
