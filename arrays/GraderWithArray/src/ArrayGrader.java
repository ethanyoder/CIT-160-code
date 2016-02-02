import java.util.Scanner;

// Accepts grades from user to populate an array of grades

public class ArrayGrader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//get array size from user
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the number of grades: ");
		int numOfGrades = keyboard.nextInt();
		
		//create array
		double[] grades = new double[numOfGrades];
		
		for(int g = 0; g < grades.length; g++){
			System.out.print("Enter grade: ");
			grades[g] = keyboard.nextDouble();
		}		
		
		for(int g = 0; g < grades.length; g++){
			System.out.println(grades[g]);
		}
		
	}

}
