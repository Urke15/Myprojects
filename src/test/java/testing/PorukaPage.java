package testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PorukaPage extends Base {

    public PorukaPage (){
        PageFactory.initElements(driver, this);
    }

    public @FindBy(id = "cf_name")
    WebElement unosImePrezime;

    public @FindBy(id = "cf_email")
    WebElement unosEmail;

    public @FindBy(name = "cf_message")
    WebElement tekstPoruke;

    public @FindBy(css = ".button_blue.middle_btn.kontaktsalji")
    WebElement dugmePosalji;

    public @FindBy(className = "page_title")
    WebElement skrolovanje;

    public void insertName(String ime){
        unosImePrezime.clear();
        unosImePrezime.sendKeys(ime);
    }
    public void insertEmail(String email){
        unosEmail.clear();
        unosEmail.sendKeys(email);
    }
    public void typeMessage(String message){
        tekstPoruke.clear();
        tekstPoruke.sendKeys(message);
    }
    public void pressPosalji(){
        dugmePosalji.click();

    }

}


