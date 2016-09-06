package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactModificationTests extends TestBase {
  @Test (enabled = false)
  public void testContactModification() {

    if (app.contact().list().size() ==0) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test").withGroup("group1"), true);
    }
    Contacts before = app.contact().all();
    ContactData modifiedContact =  before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Ivan").withLastName("Ivanov");
    app.contact().fillContactForm(contact, false);
    app.contact().submitContactUpdate();
    app.contact().returnToHomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));

    before.remove(modifiedContact);
    before.add(contact);
    assertThat(after, equalTo(before));
  }
}
