package com.sapbasu.cucumberseed.common;

import java.io.FileNotFoundException;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberHooks {
  
  @Before
  public void beforeEachTest() throws FileNotFoundException {
    WebDriverUtils.initDriver();
  }
  
  @After
  public void afterEachTest() {
    WebDriverUtils.quitDriver();
  }
}
