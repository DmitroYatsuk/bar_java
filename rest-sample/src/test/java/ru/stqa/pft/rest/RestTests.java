package ru.stqa.pft.rest;

import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created by Kiro on 16.11.16.
 */
public class RestTests {

  private Set<Issue> isuues;

  @Test
  public void testCreateIssue() {
    Set<Issue> oldIssues = getIsuues();
    Issue newIssue = new Issue();
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIsuues();
    oldIssues.add(newIssue.withId(issueId));
    Assert.assertEquals(newIssues, oldIssues);
  }

  public Set<Issue> getIsuues() {
   // Execute a GET with timeout settings and return response content as String.
    Request.Get("http://somehost/")
            .connectTimeout(1000)
            .socketTimeout(1000)
            .execute().returnContent().asString();
  }

  private int createIssue(Issue newIssue) {
    return 0;
  }



}
