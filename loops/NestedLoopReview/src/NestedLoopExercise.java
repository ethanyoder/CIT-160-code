import java.util.Scanner;

public class NestedLoopExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter number: ");
		int max = keyboard.nextInt();
		
		int col = 1; //init lcv
		int row = 1;
		
		while(row <= max){
			while(col <= row){
				if (row % 2 != 0)
					System.out.print("$");
				else {
					System.out.print("&#");
					col++;
				}
				col++;
			}
			row++;
			col = 1;
			System.out.println();
		}
		
	
	}

}
