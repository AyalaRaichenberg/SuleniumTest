package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement button;

    public void loginAction(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.button.click();
    }
}
