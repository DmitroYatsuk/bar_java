package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiro on 28.10.16.
 */
public class PasswordChangeHelper extends BaseHelper {

  public PasswordChangeHelper(ApplicationManager app) {
    super(app);
  }

  public void loginAsAdmin(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector(".button"));
  }

  public String manageUsers() {
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
    List<WebElement> accounts = new ArrayList<>(wd.findElements(By.cssSelector("#manage-user-div>table>tbody>tr>td>a")));
    String text ="";
    for (WebElement account : accounts) {
      text = account.getText();
      if (!account.getText().equals(app.getProperty("web.adminLogin"))) {
        click(By.xpath(String.format("//a[contains(text(),'%s')]", text)));
        break;
      }
    }
    return text;
  }

  public void resetPassword() {
    click(By.cssSelector("[value='Reset Password']"));
  }
}
