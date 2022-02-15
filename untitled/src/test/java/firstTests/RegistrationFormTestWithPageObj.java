package firstTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTestWithPageObj {
    RegistrationPage registrationPage = new RegistrationPage();

    //задаем переменные
    String headerText = "Practice Form";
    String firstName = "My";
    String lastName = "Name";
    String userEmail = "myEmail@gmail.com";
    String userGender = "Male";
    String userNumber = "1234567890";
    String year = "1999";
    String month = "December";
    String day = "31";
    String subjectShort = "Ma";
    String subject = "Maths";
    String hobby = "Sports";
    String pathName = "src/test/resources/swef.png";
    String fileName = "swef.png";
    String currentAddress = "MyAdress 14-88";
    String state = "NCR";
    String city = "Delhi";
    String tableHeader = "Thanks for submitting the form";




    @Test
    void successFillTest () {

        // Заполнение формы

        registrationPage
                .openPage(headerText)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(year, month, day)
                .setSubject(subjectShort, subject)
                .setHobby(hobby)
                .uploadPicture(pathName)
                .setCurrentAddress(currentAddress)
                .setStateCity(state, city)
                .clickSubmit();

        //Проверка отправленной формы

        registrationPage
                .tableCheck(tableHeader)
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", userGender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subject)
                .checkForm("Hobbies", hobby)
                .checkForm("Picture", fileName)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);
    }
}