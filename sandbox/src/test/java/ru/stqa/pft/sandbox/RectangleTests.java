package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Kiro on 03.08.16.
 */
public class RectangleTests {

  @Test
  public void testArea(){
    Rectangle r = new Rectangle(5);
    Assert.assertEquals(r.area(), 25.0);
  }

  @Test
  public void testAreaBad(){
    Rectangle r = new Rectangle(5);
    Assert.assertEquals(r.area(), 24.0);
  }
}
