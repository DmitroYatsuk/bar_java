package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kiro on 13.10.16.
 */
public class ContactAddingToGroups extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test")
              .withPhoto(new File("src/test/resources/test_photo.png")));
    }
  }

  @Test
  public void testContactAddingToGroups() {
    Contacts before = app.db().contacts();
//    Groups groups = app.db().groups();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("test").withLastName("testov")
            /*.inGroup(groups.iterator().next())*/.withPhoto(new File("src/test/resources/test_photo.png"));
    app.contact().returnToHomePage();
    app.contact().selectContactById(contact.getId());
    app.contact().selectGroupForContact(1); //from 1 to 3
    app.contact().submitAdditionToGroup();
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    System.out.println("Contact name is " + contact.getFirstName() + " " + contact.getLastName()
            + " in group(s):" + after.iterator().next().getGroups());
/*

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
    verifyContactListInUI();*/
  }
}
