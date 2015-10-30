import java.util.Scanner;
/* The Caesar cipher is one of the earliest known and simplest ciphers. 
 * It is a type of substitution cipher in which each letter in the plaintext is 'shifted' a 
 * certain number of places down the alphabet.
 */
public class Caesar {

	public static void main(String[] args) {

		// Declaring data needed at top... this is good housekeeping!
		String message, encryptedMessage = "";
		int shift; //how many numbers to shift by 
		int counter = 0; //lcv
		
		// Get info needed from the user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter a word to encrypt: ");
		message = keyboard.nextLine().toLowerCase(); // there is no getChar() method... so we improvise!
		System.out.println("You entered " + message);
		
		System.out.print("Enter shift number (-25 to 25, no zeros): ");
		shift = keyboard.nextInt();
		
		while(shift == 0 || shift >= 26 || shift <= -26){
			System.out.print("Invalid Entry: Enter shift number (-25 to 25, no zeros): ");
			shift = keyboard.nextInt();
		}
		
		while(counter < message.length()){
			// encrypt the character by applying the shift
			char letter = message.charAt(counter);
			if( letter != ' '){
				if (letter + shift > 122)
					encryptedMessage += (char)(letter + shift - 26); //loop back to the beginning
				else if(letter + shift < 97)
					encryptedMessage += (char)(letter + shift + 26); //loop back to the end
				else
					encryptedMessage += (char)(letter + shift); //no looping needed
			}
			counter++;
		}//while
		
		System.out.println("Your encrypted message is: " + encryptedMessage);
		keyboard.close();

	}//main

}
