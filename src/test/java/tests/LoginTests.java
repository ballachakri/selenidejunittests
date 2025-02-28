package tests;

import hooks.Hooks;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTests extends Hooks {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("User login")
    public void userLogin() {

        loginPage.clickMyAccount().clickLoginTab()
                .enterEmail("email123@email.com").enterPassword("Auto123@").clickLoginButton();

        Assertions.assertThat(loginPage.returnAccountDetails()).isEqualTo("Account");

    }
}
