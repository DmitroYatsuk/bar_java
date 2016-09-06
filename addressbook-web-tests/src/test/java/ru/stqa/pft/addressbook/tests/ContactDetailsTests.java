package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactDetailsTests extends TestBase{

  @Test (enabled = false)
  public void testContactDetails(){
    app.contact().showContactDetails(4);
  }
}
