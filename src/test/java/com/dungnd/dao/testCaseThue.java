package com.dungnd.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCaseThue {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testRedirectToTaxConfig() {
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        // mở trình duyệt
        driver.get("http://localhost:8080/tax_manager/home");
        //chiều dài chiều rộng cửa rổ trình duyêt
        driver.manage().window().setSize(new Dimension(1050, 840));
        //click vào cái cấu hình
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        //kiểm tra có phải title là cấu hình thuế không
        assertThat(driver.getTitle(), is("Cấu hình thuế"));
        driver.quit();
        driver = null;
    }

    @Test
    public void testRedirectToTaxList(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        // mở trình duyệt
        driver.get("http://localhost:8080/tax_manager/home");
        //chiều dài chiều rộng cửa rổ trình duyêt
        driver.manage().window().setSize(new Dimension(1050, 840));
        //click vào cái cấu hình
        driver.findElement(By.linkText("Danh sách thuế")).click();
        //kiểm tra có phải title là cấu hình thuế không
        assertThat(driver.getTitle(), is("Danh sách thuế"));
        driver.quit();
        driver = null;
    }

    // demo test blank input gtbanthan
    @Test
    public void testBlankInputGTBanThan() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("3600000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtBanThan")).getText());
        //tắt trình duyệt
        //driver.quit();
        //driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testInputNumberGTBanThan() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("jsjakjdakdj");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("45600000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtBanThan")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testInputNumberGTPhuThuoc() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("9000000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("conchimnon");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtPhuThuoc")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testInputNumberGTTienAn() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("9000000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("760000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).sendKeys("conchimnon");
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtTienAn")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testInputNegativeNumberGTBanThan() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("-9000000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("45600000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtBanThan")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testInputNegativeNumberGTPhuThuoc() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("9000000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("-3600000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtPhuThuoc")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testInputNegativeNumberGTTienAn() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("9000000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("3600000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).sendKeys("-760000");
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtTienAn")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testNhapSoLeInputGTBanThan() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("123");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("3600000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtBanThan")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

    @Test
    public void testNhapSoLeInputGTPhuThuoc() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("7600000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("123");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).sendKeys("760000");
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtPhuThuoc")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }
    @Test
    public void testNhapSoLeInputGTTienAn() {
        //ok nhá
        System.setProperty("webdriver.chrome.driver","C:/Users/Dung/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/tax_manager/home");
        driver.manage().window().setSize(new Dimension(1050, 840));
        driver.findElement(By.linkText("Cấu hình thuế")).click();
        // click vào giảm trù bản thân
        // cái id này hình như của text mà ông chưa sửa
        driver.findElement(By.id("gtBanThan")).click();
        //clear cái text đấy
        driver.findElement(By.id("gtBanThan")).clear();
        // điền vào
        driver.findElement(By.id("gtBanThan")).sendKeys("7600000");
        //tương tự trên
        driver.findElement(By.id("gtPhuThuoc")).click();
        driver.findElement(By.id("gtPhuThuoc")).clear();
        driver.findElement(By.id("gtPhuThuoc")).sendKeys("900000");
        driver.findElement(By.id("gtTienAn")).click();
        driver.findElement(By.id("gtTienAn")).sendKeys("123");
        driver.findElement(By.id("gtTienAn")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        // kiểm tra xem cái Giảm trù bản thân có rỗng không
        assertEquals("", driver.findElement(By.id("gtTienAn")).getText());
        //tắt trình duyệt
        driver.quit();
        driver = null;
        //giờ tôi đang tìm hiểu cách để kiểm tra cái message khi nhập sai
        // hơi bị khó kiếm
    }

}
