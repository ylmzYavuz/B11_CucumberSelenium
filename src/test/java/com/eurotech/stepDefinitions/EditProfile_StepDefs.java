package com.eurotech.stepDefinitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EditProfile_StepDefs {
    EditProfilePage editProfilePage = new EditProfilePage();
    DashboardPage dashboardPage = new DashboardPage();

    @When("The user select status {string}")
    public void the_user_select_status(String status) {
        editProfilePage.selectMenu(editProfilePage.selectBox, status);
    }

    @When("The user slides the slider {int}")
    public void the_user_slides_the_slider(int num) {
        editProfilePage.slider(num);

    }

    @When("The user add {string} {string}")
    public void the_user_add(String inputBoxname, String userInfo) {
        editProfilePage.addInfo(inputBoxname, userInfo);
    }

    @When("The user clicks on the submit button")
    public void the_user_clicks_on_the_submit_button() {
        editProfilePage.editProfSubmitBtn.click();
    }

    @Then("The user verifies that {string} info in excel {string} {int}")
    public void the_user_verifies_that_info_in_excel(String infiTitle, String sheetName, Integer rowNumber) {
        String actualCompanyName = dashboardPage.getTextCommen(dashboardPage.getDataList(sheetName).get(rowNumber).get(infiTitle));
        System.out.println("actualCompanyName = " + actualCompanyName);
        Assert.assertEquals(dashboardPage.getDataList(sheetName).get(rowNumber).get(infiTitle), actualCompanyName);
    }

}

