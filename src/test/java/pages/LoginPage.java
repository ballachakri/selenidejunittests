package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {




    @Step("Click my account tab")
    public LoginPage clickMyAccount() {
        $(By.cssSelector("a[title='My Account']")).click();
        return this;
    }

    @Step("Click my login tab")
    public LoginPage clickLoginTab() {
        $(By.linkText("Login")).click();
        return this;
    }

    @Step("Enter user email '{0}'")
    public LoginPage enterEmail(String email) {
        $(By.cssSelector("input[name='email']")).setValue(email);
        return this;
    }

    @Step("Enter user password '{0}'")
    public LoginPage enterPassword(String password) {
        $(By.cssSelector("input[name='password']")).setValue(password);
        return this;
    }

    @Step("Click my login button")
    public void clickLoginButton() {
        $(By.cssSelector("input[value='Login']")).click();
    }

    @Step("Return account details")
    public String returnAccountDetails() {
        return $(By.cssSelector("#account-account > ul > li:nth-child(2) > a")).getText();
    }
}
