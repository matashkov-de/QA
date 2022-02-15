package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    private SelenideElement
            pageLoadCheck = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            yearOfBirthInput = $(".react-datepicker__year-select"),
            monthOfBirthInput = $(".react-datepicker__month-select"),
            dayOfBirthInput = $(".react-datepicker__month"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateCityInput = $("#stateCity-wrapper"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            checkLoadTable = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive");

    //actions


    public RegistrationPage openPage (String headerText){
        Configuration.browserSize = "1920x1580";
        open("https://demoqa.com/automation-practice-form");
        pageLoadCheck.shouldHave(text(headerText));

        return this;
    }

    public RegistrationPage setFirstName (String firstName){
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName (String lastName){
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail (String userEmail){
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setUserGender (String userGender){
        userGenderInput.$(byText(userGender)).click();

        return this;
    }

    public RegistrationPage setUserNumber (String userNumber){
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage setDateOfBirth (String year, String month, String day){
        dateOfBirthInput.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }

    public RegistrationPage setSubject (String subjectShort, String subject){
        subjectInput.setValue(subjectShort);
        $(byText(subject)).click();

        return this;
    }

    public RegistrationPage setHobby (String hobby){
        hobbyInput.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage uploadPicture (String pathName){
        uploadPictureInput.uploadFile(new File(pathName));

        return this;
    }

    public RegistrationPage setCurrentAddress (String currentAddress){
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public RegistrationPage setStateCity (String state, String city){
        stateCityInput.scrollTo();
        stateInput.click();
        $(byText(state)).click();
        cityInput.click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationPage clickSubmit (){
        submitButton.click();

        return this;
    }


    public RegistrationPage tableCheck (String tableHeader){
        checkLoadTable.shouldHave(text(tableHeader));

        return this;
    }

    public RegistrationPage checkForm (String fieldName, String value) {
        resultTable.$(byText(fieldName))
            .parent().shouldHave(text(value));

        return this;
    }
}


