package testGaugeSpree;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.SearchPage;
import util.Hooks;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Search {

    SearchPage searchPage;
    WebDriver driver;

    public Search() {
        driver = Hooks.driver;
        searchPage = PageFactory.initElements(driver, SearchPage.class);

    }

    @Step("Enter <bag> in search field and click Search")
    public void simpleSearch(String searchKey) {
        searchPage.enterSearchKeys(searchKey);
        searchPage.submitSearch();

    }

    @Step("Verify element <Ruby on Rails Bag> in the results")
    public void validateSearchResult(String itemName) {
        assertThat(itemName).isEqualTo(searchPage.getRailsBagElementDetails());


    }

    @Step("Verify below elements in the results <table>")
    public void validateMultipleSearchResults(Table items) {

        Gauge.writeMessage("Need to Implement validation");
        List<WebElement> products = driver.findElements(By.id("products"));
        for (WebElement product : products) {

        }

        for (TableRow row : items.getTableRows()) {
            String word = row.getCell("ItemName");


            for (WebElement product : products) {

            }

        }

    }

    @Step("reset Search")
    public void resetSearch() {


    }
}
