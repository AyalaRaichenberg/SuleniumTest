package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.fail;

public class BooksStorePage extends BaseClass {

    @FindBy(id = "searchBox")
    private WebElement searchBox;

    @FindBy(className = "rt-noData")
    private WebElement noElement;


    public void searchAction(String bookName) {
        searchBox.sendKeys(bookName);
    }

    public int bookAmount() {
        return driver.findElements(By.xpath("//div[@class=\"rt-td\"]/img")).size();
    }

    public boolean noElementIsDisplayed() {
        return noElement.isDisplayed();
    }

    public void removeSearch() {
        searchBox.click();
        String search = searchBox.getAttribute("value");
        for (int i = 0; i < search.length(); i++) {
            searchBox.sendKeys(Keys.BACK_SPACE);
        }
    }

    public List<WebElement> bookWebElementList()
    {
        return driver.findElements(By.className("rt-tr-group"));
    }

    public List<Book> bookList(List<WebElement> books) {
        List<Book> bookList = new ArrayList<>();
        WebElement book;
        try{
        for (int i = 0; i < books.size() - 2; i++) {
            book = books.get(i);
            bookList.add(new Book(driver.findElements(By.className("mr-2")).get(i).getText(),
                    driver.findElements(By.className("rt-td")).get(2 * i + 1).getText(),
                    driver.findElements(By.className("rt-td")).get(2 * i + 2).getText()));
        }}
        catch (Exception e){
            System.out.println("ERROR: "+e);
            fail("ERROR: "+e);
        }
        return bookList;
    }

    public void printBookList() {
        List<Book> bookList = bookList(bookWebElementList());

        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i).toString());
        }
    }
}
