package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //locators
    SelenideElement pageLoadCheck = $(".main-header");
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement userGenderInput = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement yearOfBirthInput = $(".react-datepicker__year-select");
    SelenideElement monthOfBirthInput = $(".react-datepicker__month-select");
    SelenideElement dayOfBirthInput = $(".react-datepicker__month");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbyInput = $("#hobbiesWrapper");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateCityInput = $("#stateCity-wrapper");
    SelenideElement stateInput = $("#state");
    SelenideElement cityInput = $("#city");
    SelenideElement submitButton = $("#submit");
    SelenideElement checkResponsForm = $(".table-responsive");

    //actions

    public void setPageLoadCheck (String headerText){
        pageLoadCheck.shouldHave(text(headerText));
    };

    public void setFirstName (String firstName){
        firstNameInput.setValue(firstName);
    };

    public void setLastName (String lastName){
        lastNameInput.setValue(lastName);
    };

    public void setUserEmail (String userEmail){
        userEmailInput.setValue(userEmail);
    };

    public void setUserGender (String userGender){
        userGenderInput.$(byText(userGender)).click();
    };

    public void setUserNumber (String userNumber){
        userNumberInput.setValue(userNumber);
    };

    public void setDateOfBirth (String yearOfBirth, String monthOfBirth, String dayOfBirth){
        dateOfBirthInput.click();
        yearOfBirthInput.selectOption(yearOfBirth);
        monthOfBirthInput.selectOption(monthOfBirth);
        dayOfBirthInput.$(byText(dayOfBirth)).click();
    };

    public void setSubject (String subjectShort, String subject){
        subjectInput.setValue(subjectShort);
        $(byText(subject)).click();
    };

    public void setHobby (String hobby){
        hobbyInput.$(byText(hobby)).click();
    };

    public void uploadPicture (String pathName){
        uploadPictureInput.uploadFile(new File(pathName));
    };

    public void setCurrentAddress (String currentAddress){
        currentAddressInput.setValue(currentAddress);
    };

    public void setStateCity (String state, String city){
        stateCityInput.scrollTo();
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();
    };

    public void clickSubmit (){
        submitButton.click();
    };

}
