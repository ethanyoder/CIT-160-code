/* Video store application
 * Uses arrays to store serial numbers. 
 * Update: reads initial serial numbers from a files and saves changes to the file
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.*;

public class VideoStore {
	
	// this method will write our changes to the array out to the output file
	public static void save(int[] numbers) throws IOException {
		
		// open output file
		PrintWriter outputFile = new PrintWriter("data.csv");
		// write array out to output file
		for(int i = 0; i < numbers.length; i++)
			outputFile.print(numbers[i]+",");
		System.out.println("Changes saved");
		outputFile.close(); // don't forget to close!
	}

	public static void main(String[] args) throws IOException{

		int option = 0; //will store user option
		int searchItem; //item to find and delete
		int loc; //loop control variable
		int foundLoc; //will hold the location of the serial number if found
		int i =0; //another loop control variable

		//declaring and initializing the array
		int[] serialNum = new int[10];

		//set up file for reading
		File f = new File("data.csv");
		Scanner inputFile = new Scanner(f);

		//read each line and parse the input
		while(inputFile.hasNextLine()){
			String data = inputFile.nextLine();
			//slits up input and stores as an array based on comma
			String[] values = data.split(",");
			for(i = 0; i < values.length; i++)
				serialNum[i] = Integer.parseInt(values[i]); 
		}
		inputFile.close(); //don't forget this!
		
		//insert while loop after the numbers have been inserted into the array
		do
		{
			option = Integer.parseInt(JOptionPane.showInputDialog("Options:\n0 – Quit\n1 – Print Serial Numbers"
					+"\n2 – Delete Serial Number\n3 - Add Serial Number"));
			/************ OPTION 1 ************/
			if (option == 1) //if print option
			{
				//print the contents of the array
				for(int j = 0; j < serialNum.length; j++)
				{
					System.out.println(serialNum[j]);

				}
				System.out.println();
			}//end if
			/*********** OPTION 2 *************/
			else if(option == 2) //notice that I used an “else if”
			{

				foundLoc = -1; // we will first set this to -1 (means not found)
				searchItem = Integer.parseInt(JOptionPane.showInputDialog("Enter number to be deleted:"));

				//first we will search for the item
				for (loc = 0; loc < serialNum.length; loc++)
				{
					if (serialNum[loc] == searchItem) // if the items match – store this location
					{
						foundLoc = loc;
					}//end if
				}//end for
				//now we can delete the item if it was found
				if (foundLoc != -1 )
				{
					//move items up on the array list, copying over the deleted value
					for(i = foundLoc; i < serialNum.length-1; i++)
					{
						serialNum[i] = serialNum[i+1];
					} //end for
					serialNum[serialNum.length-1] = 0;
					save(serialNum); //write out to output file
				}//end if
				else
					System.out.println("Serial number was not found!");

			}//end else if
			/**************** OPTION 3 **************/
			else if(option == 3){
				int addItem = Integer.parseInt(JOptionPane.showInputDialog("enter sn to add"));
				for(i = 0; i < serialNum.length; i++){
					if(serialNum[i] == 0){
						serialNum[i] = addItem;
						save(serialNum); //write out to output file
						break;
					}
				}
				if(i == serialNum.length)
					System.out.println("Sorry - no room in the list!");
				
			}
		} while(option != 0); //Keep looping while options is not equal to “0”
		System.exit(0);
	}//end main
}//end class
