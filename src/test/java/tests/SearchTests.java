package tests;

import com.codeborne.selenide.SelenideElement;
import hooks.Hooks;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import java.util.List;

public class SearchTests extends Hooks {

    SearchPage searchPage = new SearchPage();

    @Test
    @DisplayName("User search for iphone")
    public void searchIphone() {

        searchPage.searchItem("Iphone");

        List<SelenideElement> list = searchPage.getSearchResultsList();

        for (SelenideElement selenideElement : list) {
            Assertions.assertThat(selenideElement.getText()).contains("iPhone");
        }
    }


    @Test
    @DisplayName("User search for mac")
    public void searchMac() {

        searchPage.searchItem("mac");

        List<SelenideElement> list = searchPage.getSearchResultsList();

        for (SelenideElement selenideElement : list) {
            Assertions.assertThat(selenideElement.getText()).contains("Mac");

        }
    }
}
