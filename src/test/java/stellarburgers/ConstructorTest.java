package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.api.User;
import stellarburgers.api.UserStep;
import stellarburgers.paga.LoginPage;
import stellarburgers.paga.MainPage;

import static org.junit.Assert.assertTrue;
import static stellarburgers.constants.UserData.*;

public class ConstructorTest extends BaseSetBrowsers{
    public ConstructorTest(String browserType, String binaryPath) {
        super(browserType, binaryPath);
    }
    private final String fluorescentBuns = "Флюоресцентная булка R2-D3";
    //Булка

    private final String craterBuns = "Краторная булка N-200i";
    //Булка

    private final String spicy_X = "Соус Spicy-X";
    //Соусы
    private final String spaceSous = "Соус фирменный Space Sauce";
    //Соусы

    private final String meatShellfish = "Мясо бессмертных моллюсков Protostomia";
    //Начинки
    private final String beefMeteorite = "Говяжий метеорит (отбивная)";
    //Начинки



    @DisplayName("Конструктор")
    @Description("Пользователь авторизован. Проверка работают переходы к разделам Булки.")
    @Test
    public void transitionsSectionsBunsAuthorizationTest() {
        UserStep userStep = new UserStep();
        User user = new User(USER_NAME, USER_EMAIL, USER_PASSWORD);
        userStep.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickBtnPersonAccount(); //MaimPage
        loginPage.userInputAccount(USER_EMAIL, USER_PASSWORD); //LoginPage
        mainPage.clickBtnPersonAccount();
        mainPage.clickConstructor();

        mainPage.clickBtnFillings();
        mainPage.clickBtnBuns();
        assertTrue(mainPage.chooseBuns(fluorescentBuns, craterBuns));
    }

    @DisplayName("Конструктор")
    @Description("Пользователь авторизован. Проверка работают переходы к разделам Соусы.")
    @Test
    public void transitionsSectionsSaucesAuthorizationTest() {
        UserStep userStep = new UserStep();
        User user = new User(USER_NAME, USER_EMAIL, USER_PASSWORD);
        userStep.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickBtnPersonAccount(); //MaimPage
        loginPage.userInputAccount(USER_EMAIL, USER_PASSWORD); //LoginPage
        mainPage.clickBtnPersonAccount();
        mainPage.clickConstructor();

        mainPage.clickBtnSauces();
        assertTrue(mainPage.chooseSauces(spicy_X, spaceSous));
    }

    @DisplayName("Конструктор")
    @Description("Пользователь авторизован. Проверка работают переходы к разделам Начинки.")
    @Test
    public void transitionsSectionsFillingsAuthorizationTest() {
        UserStep userStep = new UserStep();
        User user = new User(USER_NAME, USER_EMAIL, USER_PASSWORD);
        userStep.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickBtnPersonAccount(); //MaimPage
        loginPage.userInputAccount(USER_EMAIL, USER_PASSWORD); //LoginPage
        mainPage.clickBtnPersonAccount();
        mainPage.clickConstructor();

        mainPage.clickBtnFillings();
        assertTrue(mainPage.chooseFillings(meatShellfish, beefMeteorite));
    }

    @DisplayName("Конструктор")
    @Description("Пользователь не авторизован. Проверка работают переходы к разделам Булки.")
    @Test
    public void transitionsSectionsBunsNotAuthorizationTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickBtnPersonAccount(); //MaimPage
        mainPage.clickConstructor();
        mainPage.clickBtnFillings();
        mainPage.clickBtnBuns();
        assertTrue(mainPage.chooseBuns(fluorescentBuns, craterBuns));
    }

    @DisplayName("Конструктор")
    @Description("Пользователь не авторизован. Проверка работают переходы к разделам Соусы.")
    @Test
    public void transitionsSectionsSaucesNotAuthorizationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnPersonAccount(); //MaimPage
        mainPage.clickConstructor();
        mainPage.clickBtnSauces();
        assertTrue(mainPage.chooseSauces(spicy_X, spaceSous));
    }

    @DisplayName("Конструктор")
    @Description("Пользователь не авторизован. Проверка работают переходы к разделам Начинки.")
    @Test
    public void transitionsSectionsFillingsNotAuthorizationTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBtnPersonAccount(); //MaimPage
        mainPage.clickConstructor();
        mainPage.clickBtnFillings();
        assertTrue(mainPage.chooseFillings(meatShellfish, beefMeteorite));
    }
}
