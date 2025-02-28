package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {


    @Step("Search item '{0}'")
    public SearchPage searchItem(String item) {
        $(By.cssSelector("input[name='search']")).shouldBe(visible).setValue(item).pressEnter();
        return this;
    }

    @Step("Return search results list")
    public List<SelenideElement> getSearchResultsList() {
      return $$(By.cssSelector("div[class='product-thumb'] h4 a")).stream().toList();
    }
}
