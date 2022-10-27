package Fidexio.stepdefinition;

import Fidexio.utilities.Driver;
import io.cucumber.java.After;

public class Hook {
    @After
    public void teardownScenario(){
        Driver.closeDriver();
    }
}

