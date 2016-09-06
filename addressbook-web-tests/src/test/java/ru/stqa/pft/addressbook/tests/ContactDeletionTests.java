package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void insurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test").withGroup("group1"), true);
    }
  }

  @Test(enabled = false)
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().submitContactDeletion();
    app.contact().acceptContactDeletion();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
   }
}
