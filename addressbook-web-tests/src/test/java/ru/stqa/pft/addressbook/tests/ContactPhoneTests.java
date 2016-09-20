package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Димка on 20.09.16.
 */
public class ContactPhoneTests extends TestBase{
  // TODO: 20.09.16 add @BeforeMethod
  @Test
  public  void testContactPhones(){
    app.contact().returnToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
  }
}
