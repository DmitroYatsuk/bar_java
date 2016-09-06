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
public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() {
    if (!app.contact().isThereAContact()) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test").withGroup("group1"), true);
    }
    Contacts before = app.contact().all();
    app.contact().selectContactById(before.iterator().next());
    app.contact().submitContactDeletion();
    app.contact().acceptContactDeletion();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));

    before.remove(before.size() - 1);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
  }
}
