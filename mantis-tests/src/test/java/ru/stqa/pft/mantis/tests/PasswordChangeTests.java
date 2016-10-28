package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Kiro on 28.10.16.
 */
public class PasswordChangeTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testPasswordChange() {
    String user = app.getProperty("web.adminLogin");
    String password = app.getProperty("web.adminPassword");

    app.passwordChange().loginAsAdmin(user, password);
    app.passwordChange().manageUsers();
    app.passwordChange().resetPassword();
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = findConfirmationLink(mailMessages);
/*    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));*/
  }

  private String findConfirmationLink(List<MailMessage> mailMessages) {
    MailMessage mailMessage = mailMessages.get(0);
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod
  public void stopMailServer() {
    app.mail().stop();
  }
}
