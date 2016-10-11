package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactModificationTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test")
              .withPhoto(new File("src/test/resources/test_photo.png")));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact =  before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("test").withLastName("test")
            .withPhoto(new File("src/test/resources/test_photo.png"));
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    before.remove(modifiedContact);
    before.add(contact);
    assertThat(after, equalTo(before));
  }
}
