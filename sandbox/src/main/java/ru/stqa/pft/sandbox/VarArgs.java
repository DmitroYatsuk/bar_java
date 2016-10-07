package ru.stqa.pft.sandbox;

/**
 * Created by Kiro on 20.09.16.
 */
public class VarArgs {
  public static void vaTest(int ... x){
    System.out.println("Quantity of  args:" + x.length);

    for (int y: x) {
      System.out.println(y);
    }
  }

  public static void main(String[] args) {
    vaTest(10);
    vaTest(1, 2, 3);
  }
}
