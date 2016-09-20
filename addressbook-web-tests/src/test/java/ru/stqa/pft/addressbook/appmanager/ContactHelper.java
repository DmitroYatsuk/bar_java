package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiro on 15.08.16.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void submitContactCreation() {
        click(By.name("submit"));
    }


    public void selectContactById(int i) {
        //click(By.xpath(".//*[@id='" + i + "']"));
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            click(By.name("selected[]"));
        }
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
        click(By.name("modifiy"));
    }

    public void submitContactUpdate() {
        click(By.name("update"));
    }

    public void editContactEntryById(int id) {
        //click(By.xpath(".//*[@id='maintable']/tbody/tr[" + i + "]/td[8]/a/img"));
        click(By.cssSelector("a[href =\"edit.php?id=" + id + "\"]"));
    }

    public void selectGroupForContact(int i) {
        if (!wd.findElement(By.xpath("//div[@class='right']//select[normalize-space(.)='test1 test1 test1']//option[" + i + "]")).isSelected()) {
            click(By.xpath("//div[@class='right']//select[normalize-space(.)='test1 test1 test1 test1']//option[" + i + "]"));
        }
    }

    public void submitAdditionToGroup() {
        click(By.name("add"));
    }

    public void createContact(ContactData contact, boolean creation) {
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        submitContactDeletion();
        acceptContactDeletion();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        editContactEntryById(contact.getId());
        fillContactForm(contact, false);
        submitContactUpdate();
        returnToHomePage();
    }

  public int count() {
      return wd.findElements(By.name("selected[]")).size();
  }
}
