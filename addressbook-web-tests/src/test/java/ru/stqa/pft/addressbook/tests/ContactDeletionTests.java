package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion(){

    app.getContactHelper().selectContactInList(1);
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    //app.getContactHelper().dismissContactDeletion();

  }
}
