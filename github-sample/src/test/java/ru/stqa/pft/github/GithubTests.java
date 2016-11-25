package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Kiro on 23-Nov-16.
 */
public class GithubTests {

  @Test

  public void testCommits() throws IOException {
    Github github = new RtGithub("xxxx");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("DmitroYatsuk", "bar_java")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
