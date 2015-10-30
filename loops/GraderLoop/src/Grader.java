// Simple grader program with a loop!
// October 21st, 2015
// Author: Alicia McNett

import static java.lang.Math.*;

import java.util.Scanner;


public class Grader {
  public static void main(String[] args){

    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter a grade or -1 to quit");
    int grade = keyboard.nextInt();
    int count = 0;
    int sum = 0;
    double average = 0;

    while(grade != -1){
      sum += grade;
      count++;
      System.out.println("Please enter a grade or -1 to quit");
      grade = keyboard.nextInt();
    }

    average = ((double)sum)/count;
    int roundedAverage = (int)round(average);
    System.out.println("The average is " + roundedAverage);
  }
}
