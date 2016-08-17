package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactEditionTests extends TestBase{
  @Test
  public void testContactEdition(){
    app.getContactHelper().selectGroupForContact(2);
    app.getContactHelper().submitAdditionToGroup();
  }
}
