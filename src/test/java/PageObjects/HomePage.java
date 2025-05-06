package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(id = "gotoStore")
    private WebElement storeButton;

    public void gotoStore() {
        storeButton.click();
    }
}
