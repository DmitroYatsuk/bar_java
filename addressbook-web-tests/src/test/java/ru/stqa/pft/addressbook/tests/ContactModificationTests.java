package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification(){

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test", null, null, "group1"), true);
    }
    app.getContactHelper().editContactEntry(2);
//    app.getContactHelper().submitContactModification();
    app.getContactHelper().fillContactForm(new ContactData("1", "2", "3", null), false);
    app.getContactHelper().submitContactUpdate();
  }
}
