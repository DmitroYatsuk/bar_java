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
public class ContactDetailsTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    if (app.contact().list().size() == 0) {
      app.goTo().gotoAddNewContactPage();
      app.contact().createContact(new ContactData().withFirstName("test").withLastName("testov")
              .withAddress("Test city, str. Test, bld. 20-160")
              .withHomePhone("111").withMobilePhone("222").withWorkPhone("333")
              .withEmail("test1@test.com").withEmail2("test.2@test.com").withEmail3("test_3@test.com"));
    }
  }

  // TODO: 22.09.16 to fix
  @Test
  public void testContactDetails() {
    app.contact().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contactInfoFromDetailsForm.getAllContactDetails(), equalTo(mergeAllContactData(contactInfoFromEditForm)));
  }

  private String mergeAllContactData(ContactData contact) {
    if (!contact.getHomePhone().equals("")) contact.withHomePhone("H: "+contact.getHomePhone());
    if (!contact.getMobilePhone().equals("")) contact.withMobilePhone("M: "+contact.getMobilePhone());
    if (!contact.getWorkPhone().equals("")) contact.withWorkPhone("W: "+contact.getWorkPhone());
    if (!contact.getEmail().equals("")) contact.withEmail(contact.getEmail() + " (www.test.com)");
    if (!contact.getEmail2().equals("")) contact.withEmail2(contact.getEmail2() + " (www.test.com)");
    if (!contact.getEmail3().equals("")) contact.withEmail3(contact.getEmail3() + " (www.test.com)");
    return Arrays.asList(contact.getFirstName() + " " + contact.getLastName() + "\n" + contact.getAddress() + "\n",
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            "\n" +  contact.getEmail()  + "\n" + contact.getEmail2()  + "\n" +contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}
