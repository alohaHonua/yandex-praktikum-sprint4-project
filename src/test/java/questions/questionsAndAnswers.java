package questions;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;

public class questionsAndAnswers {

    private WebDriver driver;

    @Test
    public void checkAnswersTest() {

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Закрыть поп-ап с куками
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.clickAcceptCookiesButton();

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.clickQuestionByText("Сколько это стоит? И как оплатить?");
        mainPage.checkAnswer("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
