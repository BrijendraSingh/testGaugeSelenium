package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by shivalis on 11/19/16.
 */
public class SearchPage {

    @FindBy(id="keywords")
    WebElement searchField;

    @FindBy(xpath = "//*[@id='product_2']/a")
    WebElement railsBagElement;


    public void enterSearchKeys(String searchKey)
    {
        searchField.sendKeys(searchKey);
    }


    public void submitSearch()
    {
        searchField.submit();
    }


    public String getRailsBagElementDetails() {
        return railsBagElement.getText();

    }
}
