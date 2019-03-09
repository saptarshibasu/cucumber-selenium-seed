package com.sapbasu.cucumberseed.pageobjects;

import static com.sapbasu.cucumberseed.common.WebDriverUtils.getWebDriver;
import static com.sapbasu.cucumberseed.common.WebDriverUtils.getWebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class AbstractPageObject {
  
  public void goToUrl(String url) {
    getWebDriver().get(url);
  }
  
  public void waitForElement(String xpath) {
    getWebDriverWait()
        .until((webDriver) -> elementToBeClickable(By.xpath(xpath)));
  }
  
  public WebElement getElement(String xpath) {
    return getWebDriver().findElement(By.xpath(xpath));
  }
}
