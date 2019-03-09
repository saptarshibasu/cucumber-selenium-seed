package com.sapbasu.cucumberseed.pageobjects;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sapbasu.cucumberseed.constants.XpathConstants;
import com.sapbasu.cucumberseed.dto.UserDto;

@Component
public class AddUserPage extends AbstractPageObject {
  
  public void enterUserDetails(UserDto user) {
    waitForElement(XpathConstants.USERNAME_TEXT);
    getElement(XpathConstants.USERNAME_TEXT).clear();
    getElement(XpathConstants.USERNAME_TEXT).sendKeys(user.getUsername());
    waitForElement(XpathConstants.PASSWORD_TEXT);
    getElement(XpathConstants.PASSWORD_TEXT).clear();
    getElement(XpathConstants.PASSWORD_TEXT).sendKeys(user.getPassword());
  }
  
  public void clickOnAddUserButton() {
    getElement(XpathConstants.ADD_USER_BUTTON).click();
  }
  
  public Optional<String> getDisplayedUserNamePassword() {
    waitForElement(XpathConstants.DISPLAY_USERNAME_PASSWORD);
    return Optional.ofNullable(getElement(XpathConstants.DISPLAY_USERNAME_PASSWORD).getText());
  }
}
