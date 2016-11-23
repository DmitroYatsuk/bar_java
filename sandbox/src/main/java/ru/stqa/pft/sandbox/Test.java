package ru.stqa.pft.sandbox;

/**
 * Created by Kiro on 14-Sep-16.
 */
public class Test{
    public void setAge(){
        int age = 0;
        age = age + 7;
        System.out.println("New age is : " + age);
    }
    public static void main(String args[]){
        Test test = new Test();
        test.setAge();
    }
}