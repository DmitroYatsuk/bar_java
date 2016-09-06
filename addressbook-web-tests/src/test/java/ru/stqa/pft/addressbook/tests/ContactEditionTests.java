package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactEditionTests extends TestBase{
  @Test (enabled = false)
  public void testContactEdition(){
    app.contact().selectGroupForContact(2);
    app.contact().submitAdditionToGroup();
  }
}
