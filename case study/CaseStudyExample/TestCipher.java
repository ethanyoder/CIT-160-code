import java.io.*;
import java.util.Scanner;

public class TestCipher {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/* let Eclipse fix indenting: highlight & go to Source > Correct Indentation */

		Scanner keyboard = new Scanner(System.in);

		String inputString;
		int choice;
		int shift;
		Cipher myCipher = new Cipher(); //default constructor

		do {
			System.out.println("Choose from a menu item below:");
			System.out.println("1 - Specify input file");
			System.out.println("2 - Specify output file");
			System.out.println("3 - Specify shift");
			System.out.println("4 - Encrypt");
			System.out.println("5 - Decrypt");
			System.out.println("6 - Exit");
			choice = keyboard.nextInt();
	
			switch(choice){
				case 1: 
					System.out.println("Enter input file name");
					inputString = keyboard.next();
					File file = new File(inputString);
					if(file.exists())
						myCipher.setInputFile(inputString);
					else
						System.out.println("file does not exist");
					break;
				case 2: 
					System.out.println("Enter output file name");
					inputString = keyboard.next();
					myCipher.setOutputFile(inputString);
					break;
				case 3: 
					System.out.println("Enter shift value (-25 to 25, not zero");
					shift = keyboard.nextInt();
					myCipher.setShift(shift);
					break;
				case 4: 
					myCipher.encrypt();
					break;
				case 5: 
					break;
				case 6: 
					System.out.println("Bye!");
					System.exit(0);
					break;
				default: 
					System.out.println("Invalid input");
			}//end switch
		}while(choice != 6);
	}//end main

}//end class
