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

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
      click(By.linkText("groups"));
  }

  public void gotoAddNewContactPage() {
    //click(By.linkText("add new"));
    click(By.xpath(".//*[@id='nav']/ul/li[2]/a"));
  }

  public void gotoPageGroupN() {
    click(By.xpath(".//*[@id='content']/div/i/a"));
  }

}
