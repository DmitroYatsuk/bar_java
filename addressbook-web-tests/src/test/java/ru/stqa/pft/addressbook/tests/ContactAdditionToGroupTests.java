package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactAdditionToGroupTests extends TestBase{
  @Test
  public void testContactAdditionToGroup (){
    app.getContactHelper().selectContactById(12);
    app.getContactHelper().selectGroupForContact(2);
    app.getContactHelper().submitAdditionToGroup();
    app.getNavigationHelper().gotoPageGroupN();
  }
}
