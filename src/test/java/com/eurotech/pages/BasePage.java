package com.eurotech.pages;

import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public abstract class BasePage {//abstract olmasinin sebebi bu clastan obje olusturmayacagiz
    //OOP konsept.
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    WebDriverWait wait=new WebDriverWait(Driver.get(),10);
    @FindBy(className = "nav__menu-item")
    public List<WebElement> menuList;
    @FindBy(id = "navbar-menu-list2-item2")//burasi daha genel oldugu icin basepage icine koyduk
    public WebElement allPosts;
    @FindBy(id = "navbar-menu-list2-item1")
    public WebElement developers;
    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    public void navigateToMenu(String menuName){//interwiev de cok etkileyici olabilir
        Driver.get().findElement(By.xpath("//*[text()='"+menuName+"']")).click();
    }
    public void navigateTSubMenu(String subMenuName){
        BrowserUtils.hover(myAccount);
        Driver.get().findElement(By.xpath("//span[text()='"+subMenuName+"']")).click();
    }
    public String getHeaderText(String headerName){
        //return Driver.get().findElement(By.xpath("//*[text()='"+headerName+"']")).getText();
        return Driver.get().findElement(By.xpath("//section[@class='container']/*[text()='"+headerName+"']")).getText();
    }
    public List<Map<String, String>> getDataList(String sheetName){
        ExcelUtil excelUtil=new ExcelUtil("src/test/resources/Batch11_DevEx.xlsx", sheetName);
        List<Map<String, String>> dataList = excelUtil.getDataList();
        return dataList;
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    } public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
