package org.example.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.MyBrowser;

public class BaseTest {
    @BeforeClass
    public void setup(){MyBrowser.open();}

    @AfterClass
    public void tearDown(){MyBrowser.quit();}
}
