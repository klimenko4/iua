import PageObjects.LoginPage;
import PageObjects.LoginPopupPage;
import PageObjects.MailPage;
import PageObjects.MainPage;
import org.testng.annotations.Test;


public class MainTest extends BaseTest {


    String login1 = "logintest1@i.ua";
    String login2 = "logintest2@i.ua";
    String pass1 = "123456A";
    String pass2 = "123456A";

    @Test(dataProvider = "getRegisteredUsersData", dataProviderClass = IUADataProvider.RegisteredUsersDataProvider.class)
    public void userLoginFromPopup(String login, String password) {
        MainPage mainPage = new MainPage(driver, wait);

        mainPage.open().openLoginPopup().login(login, password);
    }

    @Test(dataProvider = "getRegisteredUsersData", dataProviderClass = IUADataProvider.RegisteredUsersDataProvider.class)
    public void userLoginFromLoginPage(String login, String password) {
        LoginPage loginPage = new LoginPage(driver,wait);

        loginPage.open().login(login,password).openMailPage();
    }

    @Test
    public void sendMessageBetweenUsers(){
        MainPage mainPage = new MainPage(driver, wait);

        mainPage.open().openLoginPopup().login();
    }
}
