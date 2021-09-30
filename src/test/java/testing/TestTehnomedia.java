package testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;



public class TestTehnomedia extends Base {

    KontaktPage pocetnaKlasa;
    PorukaPage radnaKlasa;

    @Before

    public void setUpPage() {
        pocetnaKlasa = new KontaktPage();
        radnaKlasa = new PorukaPage();
    }

    @Test

    public void slanjePoruke(){
//uspeno je poslata poruka sa svim popunjenim obaveznim poljima
        pocetnaKlasa.clickContact();
        //komanda za skrolovanje na tacno odredjeni element
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", radnaKlasa.skrolovanje);
        radnaKlasa.insertName("Petar Petrovic");
        radnaKlasa.insertEmail("petar.p@gmail.com");
        radnaKlasa.typeMessage("Hteo bih da porucim televizor marke Samsung.");
        radnaKlasa.pressPosalji();

    }
@Test

public void slanjePorukeBezImena(){
//sajt ne radi ispravno, prihvata prazno polje za ime i prezime i slaje poruku uspesno iako je Ime obavezno polje
    pocetnaKlasa.clickContact();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", radnaKlasa.skrolovanje);
    radnaKlasa.insertName("");
    radnaKlasa.insertEmail("petar.p@gmail.com");
    radnaKlasa.typeMessage("Hteo bih da porucim televizor marke Samsung.");
    radnaKlasa.pressPosalji();
}

@Test

public void slanjePorukeBezEmaila() {
//salje se poruka bez popunjene email adrese koja je obavezno polje, test je pao jer je ocekivano da se ne posalje poruka
        pocetnaKlasa.clickContact();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", radnaKlasa.skrolovanje);
        radnaKlasa.insertName("Petar Petrovic");
        radnaKlasa.insertEmail("");
        radnaKlasa.typeMessage("Hteo bih da porucim televizor marke Samsung.");
        radnaKlasa.pressPosalji();
    }

    @Test
    public void slanjePorukeBezTekstaPoruke() {
//salje se poruka bez ispunjenog obaveznog polja za unos poruke, test prolazi iako ne bi trebalo da prolazi
        pocetnaKlasa.clickContact();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", radnaKlasa.skrolovanje);
        radnaKlasa.insertName("Petar Petrovic");
        radnaKlasa.insertEmail("petar.p@gmail.com");
        radnaKlasa.typeMessage("");
        radnaKlasa.pressPosalji();
    }
@Test
public void slanjePorukeBezPopunjenihObaveznihPolja() {
//poruka je poslata iako nije popunjeno nijedno obavezno polje, test je prosao iako ne bi trebalo da prodje
    pocetnaKlasa.clickContact();
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", radnaKlasa.skrolovanje);
    radnaKlasa.insertName("");
    radnaKlasa.insertEmail("");
    radnaKlasa.typeMessage("");
    radnaKlasa.pressPosalji();

}
@Test

    public void proveraPrikazaLogoa(){

    Assert.assertTrue(pocetnaKlasa.displayedLogo());

}

@Test

    public void proveraPrikazaLinkaKontakt(){

        Assert.assertEquals("Kontakt", pocetnaKlasa.displayedKontakt());

}


}