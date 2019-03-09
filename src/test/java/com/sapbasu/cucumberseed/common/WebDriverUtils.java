package com.sapbasu.cucumberseed.common;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.sapbasu.cucumberseed.constants.Constants;

public class WebDriverUtils {
  
  final static Logger logger = LoggerFactory.getLogger(WebDriverUtils.class);
  
  private static WebDriver webDriver;
  
  private static WebDriverWait wait;
  
  public static void initDriver() throws FileNotFoundException {
    logger.info("Initializing driver");
    System.setProperty("webdriver.chrome.driver",
        findFile("chromedriver.exe"));
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--user-data-dir=target/chrome/profile");
    options.addArguments("--window-size=1200x600");
    options.addArguments("--disable-default-apps");
    options.addArguments("--disable-extensions-file-access-check");
    options.addArguments("--disable-prompt-on-repost");
    options.addArguments("--enable-automation");
    
    webDriver = new ChromeDriver(options);
    webDriver.manage().deleteAllCookies();
    wait = new WebDriverWait(webDriver, Constants.WAIT_FOR_ELEMENT_IN_SEC);
  }
  
  public static void quitDriver() {
    logger.info("Closing driver");
    webDriver.quit();
  }
  
  private static String findFile(String filename) throws FileNotFoundException {
    return ResourceUtils.getFile("classpath:webdriver/chromedriver.exe").getAbsolutePath();
  }
  
  public static WebDriver getWebDriver() {
    return webDriver;
  }
  
  public static WebDriverWait getWebDriverWait() {
    return wait;
  }
}
