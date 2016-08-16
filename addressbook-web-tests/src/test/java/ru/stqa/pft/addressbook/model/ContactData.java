package ru.stqa.pft.addressbook.model;

/**
 * Created by Kiro on 15.08.16.
 */
public class ContactData {

  private final String firstName;
  private final String middleName;
  private final String lastName;


  public ContactData(String firstName, String middleName, String lastName) {

    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
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
}
