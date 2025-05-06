import PageObjects.BaseClass;
import PageObjects.BooksStorePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

@Listeners({PageObjects.Listeners.class})
public class SeleniumTest extends BaseClass {

    LoginPage login;
    HomePage homePage;
    BooksStorePage booksStorePage;

    @BeforeClass
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        login = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        booksStorePage = PageFactory.initElements(driver, BooksStorePage.class);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test01() {
        login.loginAction("Ayala Raichenberg", "Ayalar@8648");
        homePage.gotoStore();
    }

    @Test
    public void test02() {
        booksStorePage.searchAction("git Pocket");
        assertTrue(booksStorePage.bookAmount() == 1);
    }

    @Test
    public void test03() {
        booksStorePage.removeSearch();
        booksStorePage.searchAction("VerySoft");
        assertTrue(booksStorePage.bookAmount() == 0);
        assertTrue(booksStorePage.noElementIsDisplayed());
    }

    @Test
    public void test04() {
        booksStorePage.removeSearch();
        booksStorePage.printBookList();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
