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
	
    double average = 0;
    int roundedAverage = (int)round(average);
    System.out.println("The average is " + roundedAverage);
  }
}
