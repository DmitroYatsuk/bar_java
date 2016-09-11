package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Kiro on 15.08.16.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void insurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("group1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("group1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    before.remove(modifiedGroup);
    before.add(group);
    assertThat(after, equalTo(before));
  }


}
