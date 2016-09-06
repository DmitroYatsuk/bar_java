package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kiro on 05.09.16.
 */
public class Contacts extends ForwardingSet<ContactData>{

  private final Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate());
  }

  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate();
  }

  public Contacts withAdded(ContactData contact) {
    Contacts contacts = new Contacts();
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(ContactData contact) {
    Contacts contacts = new Contacts();
    contacts.remove(contact);
    return contacts;
  }
}
