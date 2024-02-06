package stepDefinitions.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;


import static driver.DriverFactory.cleanUpDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setUpDriver() {
        getDriver();
    }

    @After
    public void tearDownDriver() {
        cleanUpDriver();
    }
}
