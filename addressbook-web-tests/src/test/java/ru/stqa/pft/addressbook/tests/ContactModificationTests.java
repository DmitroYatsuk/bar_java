package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactModificationTests extends TestBase {
  @Test
  public void testContactModification(){
    app.getContactHelper().editContactEntry(4);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().fillContactForm(new ContactData("1", "2", "3"));
    app.getContactHelper().submitContactUpdate();
  }
}
