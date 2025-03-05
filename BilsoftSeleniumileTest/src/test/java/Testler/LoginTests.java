package Testler;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;


public class LoginTests {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Faker faker = new Faker();






    @BeforeEach
    void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://app.bilsoft.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtVergiNo"))).sendKeys("0533614****");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtKullaniciAdi"))).sendKeys("bozkurtbora74@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtSifre"))).sendKeys("****");
        driver.findElement(By.id("btnLogin")).click();


    }


    @Test
    void BilsoftLoginTest(){
        driver.get("https://app.bilsoft.com/");
        driver.findElement(By.id("txtVergiNo")).sendKeys("0533614****");
        driver.findElement(By.id("txtKullaniciAdi")).sendKeys("bozkurtbora74@gmail.com");
        driver.findElement(By.id("txtSifre")).sendKeys("****");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test
    void YeniCariHesapOlusturma() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Cari Hesaplar(F1)')]")));
        driver.findElement(By.xpath("//a[contains(.,'Cari Hesaplar(F1)')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".yenicari"))).click();

        for (int i = 0; i < 3; i++) {
            String secilenSirket = faker.company().name();
            String secilenYetkili = faker.name().fullName();

            WebElement sirketInput = driver.findElement(By.xpath("//div[@class='col-md-4']/div[@class='col-md-12 margin-bottom-3 form-floating-label']/input[@class='form-control cariMb']"));
            WebElement yetkiliInput = driver.findElement(By.xpath("//div[@class='col-md-4']/div[4]/input[@class='form-control cariMb']"));
            WebElement kaydetButton = driver.findElement(By.xpath("//a[@href=\"javascript:__doPostBack('ctl00$ContentPlaceHolderBody$btnKaydet','')\"]"));

            sirketInput.clear();
            sirketInput.sendKeys(secilenSirket);
            yetkiliInput.clear();
            yetkiliInput.sendKeys(secilenYetkili);
            kaydetButton.click();

            driver.navigate().back();
            


        }
    }


    @Test
    void CariGruplar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(.,'Cari Hesaplar(F1)')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Gruplar')]")).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.cssSelector("[placeholder='Grup Adı Giriniz']")).sendKeys("Malzeme");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#txtAra")).sendKeys("Malzeme", Keys.ENTER);
        Thread.sleep(2000);
    }
    @Test
    void StokGruplari(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(".dashboard-stat[href='stok_kartlari.aspx'] .mobilres")).click();
        driver.findElement(By.cssSelector("[href='stok_gruplari.aspx']")).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.cssSelector("[placeholder='Grup Adı Giriniz']")).sendKeys("Teknoloji");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtAra")));
        searchBox.sendKeys("Teknoloji", Keys.ENTER);
    }
    @Test
    void StokMarkalari(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(".dashboard-stat[href='stok_kartlari.aspx'] .mobilres")).click();
        driver.findElement(By.cssSelector("[href='stok_markalari.aspx']")).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.cssSelector("[placeholder='Marka Adı Giriniz...']")).sendKeys("Ülker");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtAra")));
        searchBox.sendKeys("Ülker", Keys.ENTER);
    }
    @Test
    void StokBirimleri(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(".dashboard-stat[href='stok_kartlari.aspx'] .mobilres")).click();
        driver.findElement(By.cssSelector("[href='stok_birimleri.aspx']")).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.cssSelector("[placeholder='Birim Adı Giriniz...']")).sendKeys("Metre");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtAra")));
        searchBox.sendKeys("Metre", Keys.ENTER);
    }
    @Test
    void StokDepolari(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(".dashboard-stat[href='stok_kartlari.aspx'] .mobilres")).click();
        driver.findElement(By.cssSelector("[href='stok_depolari.aspx']")).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.cssSelector("[placeholder='Depo adı giriniz...']")).sendKeys("KAYNAŞLI");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtAra")));
        searchBox.sendKeys("KAYNAŞLI", Keys.ENTER);
    }
    @Test
    void YeniStokOlusturma() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector(".dashboard-stat[href='stok_kartlari.aspx'] .mobilres")).click();
        driver.findElement(By.cssSelector("[href='stok_yeni.aspx']")).click();
        driver.findElement(By.cssSelector("#txtStokAdi")).sendKeys("Islak Mendil");
        driver.findElement(By.cssSelector("#txtGirisBakiyesi")).sendKeys("500");
        driver.findElement(By.cssSelector("#alisbilgiler [placeholder='0']")).sendKeys("1");
        driver.findElement(By.cssSelector("#satisbilgiler [placeholder='0']")).sendKeys("8");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement kaydetButonu = driver.findElement(By.xpath("//a[contains(@href, 'ctl00$ContentPlaceHolderBody$btnKaydet')]"));
        js.executeScript("arguments[0].click();", kaydetButonu);
    }
    @Test
    void YeniKasaOlusturma() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[href='/Kasalar/kasalar.aspx'] b")).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("kasaAd")).sendKeys("Kaynaşlı Kasa");
        Thread.sleep(1000);
        driver.findElement(By.id("kasaAciklama")).sendKeys("TL");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='ekleModal']//button[@class='btn blue-dark']")).click();
    }
    @Test
    void KasaParaGirisi() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[href='/Kasalar/kasalar.aspx'] > .details")).click();
        driver.findElement(By.cssSelector(".btnbilsoftgray")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("girisYap")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnCariModal")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody[@id='cariListesi']/tr[1]//div[@class='btn btnbilsoftgray']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("girisAciklama")).sendKeys("giriş");
        Thread.sleep(1000);
        driver.findElement(By.id("girisTutar")).sendKeys("1000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='girisEkle']//div[@class='modal-footer']/button[@class='btn blue-dark']")).click();
    }
    @Test
    void KasadanParaCikisi() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[href='/Kasalar/kasalar.aspx'] > .details")).click();
        driver.findElement(By.cssSelector(".btnbilsoftgray")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cikisYap")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("btnCariModalCikis")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tbody[@id='cariListesi']/tr[1]//div[@class='btn btnbilsoftgray']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("cikisAciklama")).sendKeys("Çıkış");
        Thread.sleep(1000);
        driver.findElement(By.id("cikisTutar")).sendKeys("100");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='cikisEkle']//div[@class='modal-footer']/button[@class='btn blue-dark']")).click();
    }
    @Test
    void YeniBankaOlusturma(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='(F7)']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.='Yeni Banka Hesabı']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtBankaAdi"))).sendKeys("TEB");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtsubeAdi"))).sendKeys("MERKEZ");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnKaydet"))).click();
    }
    @Test
    void BankayaParaYatirma() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='(F7)']"))).click();
        driver.findElement(By.xpath("//tr[2]//i[@class='fa fa-fw fa-search']")).click();
        driver.findElement(By.xpath("//a[.='Para Yatırma']")).click();
        driver.findElement(By.id("txtUnvan")).sendKeys("Bilsoft");
        driver.findElement(By.cssSelector("textarea")).sendKeys("Havale");
        driver.findElement(By.id("txtTutar")).clear();
        Thread.sleep(200);
        driver.findElement(By.id("txtTutar")).sendKeys("1000");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
    }
    @Test
    void BankadanParaCekme() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[.='(F7)']"))).click();
        driver.findElement(By.xpath("//tr[2]//i[@class='fa fa-fw fa-search']")).click();
        driver.findElement(By.xpath("//a[.='Para Çekme']")).click();
        driver.findElement(By.id("txtUnvan")).sendKeys("Bilsoft");
        driver.findElement(By.cssSelector("textarea")).sendKeys("para çıkışı");
        driver.findElement(By.id("txtTutar")).clear();
        Thread.sleep(200);
        driver.findElement(By.id("txtTutar")).sendKeys("500");
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
    }
    @Test
    void GelirGiderEkle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='gelir_gider.aspx']/span[@class='title']"))).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.id("giderAd")).sendKeys("Bora");
        driver.findElement(By.id("giderAboneHesapNo")).sendKeys("7401");
        driver.findElement(By.id("giderAciklama")).sendKeys("Bilsoft");
        driver.findElement(By.xpath("//button[.='Ekle']")).click();
    }
    @Test
    void Gelirİsleme() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='gelir_gider.aspx']/span[@class='title']"))).click();
        driver.findElement(By.cssSelector(".btnbilsoftgray")).click();
        driver.findElement(By.xpath("//a[.='(+) Gelir İşle']")).click();
        WebElement odemeSekliDropdown = driver.findElement(By.xpath("//div[@id='gelirIsle']//div[3]/select[@class='form-control']"));
        odemeSekliDropdown.click();
        odemeSekliDropdown.sendKeys(Keys.ARROW_DOWN);
        odemeSekliDropdown.sendKeys(Keys.ARROW_DOWN);
        odemeSekliDropdown.sendKeys(Keys.ENTER);
        Thread.sleep(300);
        driver.findElement(By.id("gelirIsleAciklama")).sendKeys("Gelir İşleme");
        driver.findElement(By.id("gelirIsleTutar")).sendKeys("400");
        driver.findElement(By.xpath("//div[@id='gelirIsle']//button[@class='btn blue-dark']")).click();
    }
    @Test
    void Giderİsleme(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='gelir_gider.aspx']/span[@class='title']"))).click();
        driver.findElement(By.cssSelector(".btnbilsoftgray")).click();
        driver.findElement(By.xpath("//a[.='(-) Gider İşle']")).click();
        WebElement odemeSekliDropdown = driver.findElement(By.xpath("//div[@id='giderIsle']//div[3]/select[@class='form-control']"));
        odemeSekliDropdown.click();
        odemeSekliDropdown.sendKeys(Keys.ARROW_DOWN);
        odemeSekliDropdown.sendKeys(Keys.ARROW_DOWN);
        odemeSekliDropdown.sendKeys(Keys.ENTER);
        driver.findElement(By.id("giderIsleAciklama")).sendKeys("Gider İşleme");
        driver.findElement(By.id("giderIsleTutar")).sendKeys("200");
        driver.findElement(By.xpath("//div[@id='giderIsle']//button[@class='btn blue-dark']")).click();
    }
    @Test
    void TaksitTakip() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Taksit Takip']"))).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        driver.findElement(By.id("txtUnvan")).sendKeys("Bilsoft");
        driver.findElement(By.id("txtToplamTutar")).clear();
        Thread.sleep(200);
        driver.findElement(By.id("txtToplamTutar")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@class='form-control ']")).clear();
        driver.findElement(By.xpath("//input[@class='form-control ']")).sendKeys("1000");
        driver.findElement(By.xpath("//tr[22]//input[@class='form-control']")).sendKeys("İlk Taksit Ödeme");
        driver.findElement(By.id("btnKaydet")).click();
    }
    @Test
    void DovizAyarlari() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Döviz Ayarları']"))).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        Thread.sleep(600);
        driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12']/div[7]//span[@class='slider round']")).click();
        Thread.sleep(600);
        driver.findElement(By.xpath("//div[10]//span[@class='slider round']")).click();
        Thread.sleep(600);
        driver.findElement(By.id("btnSave")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Döviz Ayarları']"))).click();
        driver.findElement(By.cssSelector(".btnbilsoftdarkblue")).click();
        Thread.sleep(600);
        driver.findElement(By.xpath("//div[@class='col-lg-12 col-md-12']/div[7]//span[@class='slider round']")).click();
        Thread.sleep(600);
        driver.findElement(By.xpath("//div[10]//span[@class='slider round'")).click();
        Thread.sleep(600);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Döviz Ayarları']"))).click();
    }
    }



