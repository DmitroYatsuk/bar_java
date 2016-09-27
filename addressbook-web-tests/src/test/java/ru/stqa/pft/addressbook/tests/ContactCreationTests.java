package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Kiro on 15.08.16.
 */
public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    File photo = new File("src/test/resources/test_photo.png");
    Contacts before = app.contact().all();
    app.goTo().gotoAddNewContactPage();
    ContactData contact = new ContactData()
            .withFirstName("fName").withMiddleName("mName").withLastName("lName").withPhoto(photo);
    app.contact().createContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
  }
}
