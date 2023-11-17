package com.eurotech.stepDefinitions;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.EditProfilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

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
        //editProfilePage.editProfSubmitBtn.click();
        editProfilePage.click(editProfilePage.editProfSubmitBtn);
    }

    @Then("The user verifies that {string} info in excel {string} {int}")
    public void the_user_verifies_that_info_in_excel(String infiTitle, String sheetName, Integer rowNumber) {
        String actualCompanyName = dashboardPage.getTextCommen(dashboardPage.getDataList(sheetName).get(rowNumber).get(infiTitle));
        System.out.println("actualCompanyName = " + actualCompanyName);
        Assert.assertEquals(dashboardPage.getDataList(sheetName).get(rowNumber).get(infiTitle), actualCompanyName);
    }

    @Then("The user verifies that profile info has been successfully updated")
    public void the_user_verifies_that_profile_info_has_been_successfully_updated() {
        Assert.assertTrue(editProfilePage.profileUpdateMessage.isDisplayed());
    }

    @When("The user add following information into related inputBox")
    public void the_user_add_following_information_into_related_input_box(List<Map<String, String>> dataTable) {
        System.out.println("dataTable.size() = " + dataTable.size());
        for (int i = 0; i < dataTable.size(); i++) {
            System.out.println("i = " + i);
            System.out.println("dataTable.get(i).values() = " + dataTable.get(i).values());
            String[] dataArray = dataTable.get(i).values().toArray(new String[i]);

            if (dataArray.length >= 2) {
                String firstElement = dataArray[0];
                String secondelement = dataArray[1];
                System.out.println("firstElement = " + firstElement);
                System.out.println("secondelement = " + secondelement);
                editProfilePage.addInfo(firstElement, secondelement);
            } else {
                System.out.println("There is not enuogh element value");
            }
        }
    }
}

