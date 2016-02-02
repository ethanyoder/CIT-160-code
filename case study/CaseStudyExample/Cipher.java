import java.io.*;
import java.util.Scanner;

public class Cipher {
	private int shift;
	private String inputFile;
	private String outputFile;
	
	public int getShift() {
		return shift;
	}
	public void setShift(int shift) {
		this.shift = shift;
	}
	public String getInputFile() {
		return inputFile;
	}
	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}
	public String getOutputFile() {
		return outputFile;
	}
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
	
	public void encrypt() throws IOException{
		
		Scanner input = new Scanner(new File(inputFile)); //input obj
		PrintWriter output = new PrintWriter(outputFile); //output obj
		
		String message;
		
		while(input.hasNextLine()){
			message = input.nextLine();
			int counter = 0;
			while(counter < message.length()){
				// encrypt the character by applying the shift
				char letter = message.charAt(counter);
				if( letter != ' '){
					if (letter + shift > 122)
						output.print((char)(letter + shift - 26)); //loop back to the beginning
					else if(letter + shift < 97)
						output.print((char)(letter + shift + 26)); //loop back to the end
					else
						output.print((char)(letter + shift)); //no looping needed
				}
				counter++;
			}// end while
			output.println();
		}//end while
		
		input.close();
		output.close();
	}
	
}
