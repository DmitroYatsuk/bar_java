package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Kiro on 16.08.16.
 */
public class AllContactsDeletionTests extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion(){

    app.getContactHelper().selectAllContactsInList();
    app.getContactHelper().submitContactDeletion();
    app.getContactHelper().acceptContactDeletion();
    //app.getContactHelper().dismissContactDeletion();

  }
}
