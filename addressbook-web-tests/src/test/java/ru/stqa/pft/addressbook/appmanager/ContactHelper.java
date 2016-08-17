package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Kiro on 15.08.16.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }


  public void selectContactInList(int i) {
    click(By.xpath(".//*[@id='" + i + "']"));
  }

  public void selectAllContactsInList() {
    click(By.xpath(".//*[@id='MassCB']"));
  }

  public void submitContactDeletion() {
    click(By.xpath(".//*[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void dismissContactDeletion() {
    wd.switchTo().alert().dismiss();
  }

  public void showContactDetails(int i) {
    click(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[7]/a/img"));
  }

  public void submitContactModification() {
    click(By.id("modifiy"));
  }

  public void submitContactUpdate() {
    click(By.id("update"));
  }
}
