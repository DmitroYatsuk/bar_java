package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Kiro on 16.08.16.
 */
public class AllContactsDeletionTests extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion(){

    app.contact().selectAllContactsInList();
    app.contact().submitContactDeletion();
    app.contact().acceptContactDeletion();
    //app.contact().dismissContactDeletion();

  }
}
