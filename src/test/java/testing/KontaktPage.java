package testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class KontaktPage extends Base {

    public KontaktPage() {

        PageFactory.initElements(driver,this);
    }
    public @FindBy(xpath = "//*[@id=\"main_navigation_wrap\"]/div[2]/div/div/div/nav/ul/li[3]/a")
    WebElement kontaktDugme;

    public @FindBy(className = "logo")
    WebElement logo;

    public void clickContact(){
        kontaktDugme.click();
    }

    public boolean displayedLogo(){
        return logo.isDisplayed();

    }
public String displayedKontakt(){
       return kontaktDugme.getText();
    }

}
