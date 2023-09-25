import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @Test
    public void testFormSubmission() {
        // Открыть страницу
        open("ваш_адрес_страницы");

        // Заполнить поля формы
        $("[data-test-id='city']").setValue("Москва");
        $("[data-test-id='date']").setValue("31.12.2023");
        $("[data-test-id='name']").setValue("Иван Иванов");
        $("[data-test-id='phone']").setValue("+79123456789");
        $("[data-test-id='agreement']").click();

        // Отправить форму
        $(".button_theme_alfa-on-white").click();

        // Проверить состояние загрузки
        $("[data-test-id='loading']").should(Condition.appear);

        // Проверить появление всплывающего окна об успешном завершении
        $("[data-test-id='success-popup']").should(Condition.appear);
    }
}
