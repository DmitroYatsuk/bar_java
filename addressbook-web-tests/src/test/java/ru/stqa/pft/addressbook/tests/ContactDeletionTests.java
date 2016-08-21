package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Kiro on 16.08.16.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddNewContactPage();
            app.getContactHelper().createContact(new ContactData("test", "2", "3", "group1"), true);
        }
        app.getContactHelper().selectContact(0);
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().acceptContactDeletion();
    }
}
