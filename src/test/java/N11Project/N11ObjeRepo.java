package N11Project;

import org.openqa.selenium.By;

/**
 * created by MehmetBesli on 02.2020
 */
public class N11ObjeRepo {
    public static final By girisYapText = By.cssSelector("a[class='btnSignIn']");
    public static final By email = By.id("email");
    public static final By password = By.id("password");
    public static final By girisYapBtn = By.id("loginButton");
    public static final By searchProduct = By.id("searchData");
    public static final By searchProductBtn = By.cssSelector("a[class='searchBtn']");
    public static final By nextPage = By.cssSelector("a[class='next navigation']");
    public static final By sepeteEkleBtn = By.cssSelector("a[class='btn btnGrey btnAddBasket']");
    public static final By fifthProduct = By.xpath("//div[@id=\"view\"]/ul/li[5] //div[@class=\"proDetail\"]/a[2]/ins");
    public static final By fifthProductTitle = By.xpath("//div[@id=\"view\"]/ul/li[5] //div[@class=\"proDetail\"]/a[2]");
    public static final By selectColor = By.xpath("//div[@id=\"skuArea\"]//select");
    public static final By HesabimTitle = By.cssSelector("a[class='menuTitle']");
    public static final By favorilerimIsteklerim = By.cssSelector("a[href='//www.n11.com/hesabim/istek-listelerim']");
    public static final By wishList = By.id("getWishList");
    public static final By addToFavouriteWishListBtn = By.id("addToFavouriteWishListBtn");
    public static final By selectBeforeAdded = By.cssSelector("a[href='https://www.n11.com/hesabim/favorilerim'] h4[class='listItemTitle']");
    public static final By deleteProduct = By.cssSelector("span[class='deleteProFromFavorites']");
    public static final By okBtnForDelete = By.cssSelector("span[class='btn btnBlack confirm']");
    public static final By logout = By.cssSelector("a[class='logoutBtn']");
    public static final By girisYapTextAlma = By.xpath("//div[@class=\"blockWrap\"]/h2");
    public static final By loginEkranGeldimiKontrol = By.cssSelector("div[class='leftBlock']");
    public static final By hesabimTitle2 = By.cssSelector("a[title='Hesabım']");
    public static final By productNameAfterSelected= By.cssSelector("h1[class='proName']");
    public static final By productInFavourite= By.xpath("//div[@class=\"proDetail\"]/a[2]");
    public static final By deletedProductMessage= By.cssSelector("span[class='message']");
    public static final By productNotExist= By.cssSelector("div[class='emptyWatchList hiddentext']");

}