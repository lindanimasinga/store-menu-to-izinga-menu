package co.za.izinga.menuupdater.izingamancare;

import co.za.izinga.menuupdater.model.Stock;
import co.za.izinga.menuupdater.model.StoreProfile;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShopriteMenToIzinga {

    public static void loadWWMenu(StoreProfile store) {
        System.setProperty("webdriver.chrome.driver", "store-menu-to-izinga-menu/src/main/resources/selenium/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);

        Set<Stock> stockList = new HashSet<>();
        var hasNextPage = false;
        var page = 0;
        do {
            hasNextPage = loadWWMenu(page++, driver, stockList);
        } while (hasNextPage && page <= 20);

        store.setStockList(stockList);
        driver.quit();
    }

    public static boolean loadWWMenu(int page, WebDriver driver, Set<Stock> stockList) {

        driver.get("https://www.shoprite.co.za/c-2256/All-Departments?q=%3Arelevance%3AallCategories%3Amens_shaving%3AallCategories%3Asports_nutrition_and_supplements%3AallCategories%3Amens_vitamins%3AallCategories%3Amens_haircare%3AallCategories%3Amale_roll_on_and_stick_deodorant%3AallCategories%3Amale_fragrances%3AbrowseAllStoresFacetOff%3AbrowseAllStoresFacetOff&page=" + page);

        List<WebElement> products = driver.findElements(By.cssSelector(".product-frame"));

        if (products == null || products.isEmpty()) return false;

        for (WebElement product : products) {
            String name = product.findElement(By.cssSelector(".item-product__name a"))
                    .getText()
                    .replaceAll("[^a-zA-Z0-9\\s]", " ");

            var priceString = product.findElement(By.cssSelector(".special-price__price"))
                    .getText()
                    .replaceFirst("R", "")
                    .replaceFirst("Per Kg", "");

            if (priceString.isEmpty()) continue;

            double price = Double.parseDouble(priceString);
            var discountPercentage = 0.0;
            //calculate discount if present
            try {
                var xtraSavingPrice = product.findElement(By.cssSelector(".special-price__extra__price"));
                if (xtraSavingPrice != null) {
                    var discountedAmount = Double.parseDouble(xtraSavingPrice
                            .getText()
                            .replaceFirst("R", "")
                            .replaceFirst("Per Kg", "")
                            .replaceFirst("WITH CARD", ""));
                    discountPercentage = 1 - discountedAmount / price;
                }
            } catch (NoSuchElementException e) {

            }

            String imageUrl = product.findElement(By.cssSelector(".item-product__image img")).getAttribute("src");
            String productUrl = product.findElement(By.cssSelector(".item-product__name a")).getAttribute("href");
            String category = productUrl.split("/")[5];
            Stock stock = new Stock(name, 1000, price, discountPercentage, List.of());
            stock.setGroup(category);
            stock.setImages(List.of(imageUrl));
            stockList.add(stock);
        }

        //has next page
        List<WebElement> hasNext = driver.findElements(By.cssSelector(".pagination-next"));
        return hasNext != null && !hasNext.isEmpty();
    }
}
