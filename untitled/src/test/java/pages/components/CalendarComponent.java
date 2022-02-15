package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement
            yearInput = $(".react-datepicker__year-select"),
            monthInput = $(".react-datepicker__month-select"),
            dayInput = $(".react-datepicker__month");

    public void setDate (String year, String month, String day){
        yearInput.selectOption(year);
        monthInput.selectOption(month);
        dayInput.$(byText(day)).click();
    }
}
