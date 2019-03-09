package com.sapbasu.cucumberseed.steps;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.sapbasu.cucumberseed.config.SpringConfig;
import com.sapbasu.cucumberseed.dto.UserDto;
import com.sapbasu.cucumberseed.pageobjects.AddUserPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = SpringConfig.class)
public class AddUser {
  
  final static Logger logger = LoggerFactory.getLogger(AddUser.class);
  
  private final Map<String,String> context = new HashMap<String,String>();
  
  @Autowired
  private AddUserPage addUserPage;
  
  private static final String USERNAME = "USERNAME";
  private static final String PASSWORD = "PASSWORD";
  
  @Given("^User goes to add user page \"(.*)\"$")
  public void userGoesToAddUserPage(String url) {
    addUserPage.goToUrl(url);
  }
  
  @When("^User enters user details$")
  public void userEntersUserDetails(List<UserDto> userDto) {
    // Without clicking on button, entering multiple user details is meaningless
    // functionality-wise. But this is just to test the cucumber data table
    // feature
    userDto.stream().forEach(this::enterUserDetails);
  }
  
  @When("^User clicks on Save button$")
  public void userClicksOnAddUserButton() {
    addUserPage.clickOnAddUserButton();
  }
  
  @Then("^The page displays username$")
  public void usernameIsDisplayed() {
    Optional<String> displayedUserNamePassword = addUserPage
        .getDisplayedUserNamePassword();
    assertTrue("Correct username is not displayed",
        displayedUserNamePassword.map(input -> input.split("\n")[0])
            .filter(
                input -> input.equals("The username: " + context.get(USERNAME)))
            .isPresent());
  }
  
  @Then("^The page displays password$")
  public void passwordIsDisplayed() {
    Optional<String> displayedUserNamePassword = addUserPage
        .getDisplayedUserNamePassword();
    assertTrue("Correct password is not displayed",
        displayedUserNamePassword.map(input -> input.split("\n")[1])
            .filter(
                input -> input.equals("The password: " + context.get(PASSWORD)))
            .isPresent());
  }
  
  public void enterUserDetails(UserDto userDto) {
    context.clear();
    addUserPage.enterUserDetails(userDto);
    context.put(USERNAME, userDto.getUsername());
    context.put(PASSWORD, userDto.getPassword());
  }
}
