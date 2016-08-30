package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactModificationTests extends TestBase {
  @Test (enabled = false)
  public void testContactModification() {

    if (!app.getContactHelper().isThereAContact()) {
      app.goTo().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("test", null, null, "group1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().editContactEntryById(before.get(before.size() - 1).getId());
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Ivan", null, "Ivanov", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
