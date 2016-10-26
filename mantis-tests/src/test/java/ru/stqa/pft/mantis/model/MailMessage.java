package ru.stqa.pft.mantis.model;

/**
 * Created by Kiro on 26.10.16.
 */
public class MailMessage {

  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
