package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Kiro on 12.08.16.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoAddNewContactPage (){
    //click(By.linkText("add new"));
    click(By.xpath(".//*[@id='nav']/ul/li[2]/a"));
  }

  public void gotoPageGroupN() {
    click(By.xpath(".//*[@id='content']/div/i/a"));
  }
}
