package testGaugeSpree;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.LoginPage;
import util.Hooks;

import static org.assertj.core.api.Assertions.assertThat;

public class Login {

    HomePage homePage;
    LoginPage loginPage;
    WebDriver driver;

    public Login() {

        driver = Hooks.driver;
        //driver.get("http://localhost:3000");
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);

    }

    @Step("login with <xt@xt.com> and <xtxtxt>")
    public void validLogin(String userName, String password) {
        homePage.clickOnLoginLink();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();


    }

    @Step("validate <MY ACCOUNT> link")
    public void validateLink(String name) {
        System.out.println(homePage.getMyAccountText());
        assertThat(homePage.getMyAccountText()).isEqualTo(name);

    }
    @Step("open url <http://localhost:3000>")
    public void openURL(String url) {
        driver.get(url);
    }

    @Step("in-valid login with <xt@xt.com> and <xtxtxt>")
    public void invalidLogin(String userName, String password) {
        homePage.clickOnLoginLink();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

    }



    @Step("validate error message <Invalid email or password.>")
    public void validateInvalidLoginMessage(String message) {
        Assert.assertEquals(loginPage.getInvalidLoginText(), message);
    }

    @Step("logout user")
    public void logoutUser() {
        homePage.clickLogOut();

    }
}
