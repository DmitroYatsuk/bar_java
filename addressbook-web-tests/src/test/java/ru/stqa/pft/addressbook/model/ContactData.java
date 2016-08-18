package ru.stqa.pft.addressbook.model;

/**
 * Created by Kiro on 15.08.16.
 */
public class ContactData {

  private final String firstName;
  private final String middleName;
  private final String lastName;
  private String group;


  public ContactData(String firstName, String middleName, String lastName, String group) {

    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGroup() {
    return group;
  }
}
