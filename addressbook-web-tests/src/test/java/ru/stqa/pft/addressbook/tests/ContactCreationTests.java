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
 * Created by Kiro on 15.08.16.
 */
public class ContactCreationTests extends TestBase {

  @Test (enabled = false)
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData()
            .withFirstName("fName").withMiddleName("mName").withLastName("lName").withGroup("group1");
    app.contact().createContact(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
   }
}
