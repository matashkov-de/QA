package firstTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ElementDragAndDropTest {
    @Test
    void dragAndDropElementSwapPlaces() {
        //Открыть страницу с элементами
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));


        //check: Элементы  поменялись местами
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));

        //Вывод результата
        System.out.println("Элементы поменялись местами");
    }
}
