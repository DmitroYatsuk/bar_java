package ru.stqa.pft.addressbook.model;

/**
 * Created by Kiro on 15.08.16.
 */
public class ContactData {


  private static String firstName;
  private static String middleName;
  private static String lastName;


  public ContactData(String firstName, String middleName, String lastName) {

    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  public static String getFirstName() {
    return firstName;
  }

  public static String getMiddleName() {
    return middleName;
  }

  public static String getLastName() {
    return lastName;
  }
}
