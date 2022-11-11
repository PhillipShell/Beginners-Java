import java.util.Scanner; // Needed to use the scanner object

public class AssignmentISBN {
	  public static void main(String[] args) {
		  // Create Scanner object
		  Scanner input = new Scanner(System.in);
		  
		  double booksReturned = 0, checkedOut = 0, booksProcessed = 0;
		  
		  //Welcome user and ask for input
		  System.out.println(" Welcome to Daily Book Inventory! ");
		  System.out.println("***********************************");
		  while (true) {
		  System.out.print("Enter the first 12 digits of an ISBN: ");
		  String isbn = input.next();
		  
		  // Check for valid input
		  if (isbn.length() != 12) {
			  // Loop until input from user is valid
			  while(isbn.length()!= 12) {
			   System.out.println(" Invalid Input: Please input first 12 digits of ISBN: ");
			  isbn = input.next();
		  }
		  }
			  
			
			// Loop for calculating the checkSum
			 int checkSum = 0; 
		  for (int i = 0; i < isbn.length(); i++){
			  char digitCharacter = isbn.charAt(i);
			  int digit = Character.getNumericValue(digitCharacter);
			  
			  if((i+1) % 2 == 0) {
				checkSum += (digit)*3;
			  }
			  else {
				  checkSum += (digit);
			  }
		  }
		  	// Calculate the checkSum
			  checkSum = 10 - checkSum % 10;
			  if (checkSum == 10) {
				  checkSum = 0;
			  }	  
			  // Display the concatenated ISBN number
			  System.out.println("The ISBN number is " + isbn+checkSum);
			  
			  System.out.println("Enter 'r' for return or 'c' for check out ");
			  String bookStatus = input.next();
			  	if(bookStatus.equals ("r")) {
			  		booksReturned++;
			  		booksProcessed++;
			  	}
			  	else if(bookStatus.equals("c")) {
			  		checkedOut++;
			  		booksProcessed++;
			  	}
			  	System.out.println("**************************");
			  	System.out.println("*  Daily Book Inventory  *");
			  	System.out.println("**************************");
			  	System.out.println("Books Returned: " + booksReturned);
			  	System.out.println("Books Checked out: " + checkedOut);
			  	System.out.println("Books Processed: " + booksProcessed);
			  	
			  	
			  System.out.println("Would you like to continue? y/n: ");
			  String reply = input.next();
			  	if(!reply.equals("y")) {
			  		System.out.println("Thank You! Please come again!");
			  		break;
			  	}
			  		
		  }
	  }
}