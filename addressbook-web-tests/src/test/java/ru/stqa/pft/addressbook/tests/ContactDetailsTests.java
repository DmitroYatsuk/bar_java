package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactDetailsTests extends TestBase{

  @BeforeMethod
  public void insurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test").withLastName("testov")
              .withAddress("Test city, str. Test, bld. 20-160")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withEmail("test1@test.com").withEmail2("test.2@test.com").withEmail3("test_3@test.com")
              .withGroup("group1"), true);
    }
  }

  @Test
  public void testContactDetails() {
    app.contact().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    app.contact().showContactDetailsById(contact.getId());
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromDetailsForm.getAddress()));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromDetailsForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromDetailsForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactFieldsTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  }
