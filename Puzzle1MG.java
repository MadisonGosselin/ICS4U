/****************************************************
**  Name: Madison Gosselin                         **
**  Class Name: Puzzle1MG.java                     **
**  Creation Date: 10-12-2021                      **
**  Description: This is a program that takes an   **
**               inputed line of text and reads    **
**               whether to add or get the average **
**               and prints the input and solution **
****************************************************/

import java.io.*;

public class Puzzle1MG {

	/*********************************************
	** Method Name: getData()					**
	** Inputs: an int position and string text  **
	** Returns: String called selectedData		**
	** Description: Reads in a comma delimited	** 
	** text file and prints the item selected	**
	*********************************************/
	
	public static String getData(int position, String text) {
		
		String selectedData = "";													//create variable to hold selectedData
		
		for(int x = 0; x <= position; x++) {
				
			if(text.indexOf(",") == -1) {
					
				selectedData = text; 												//set selectedData = to text
										
			}else {
					
				selectedData = text.substring(0, text.indexOf(","));				//make selectedData = to the data from the beginning to the first comma
				text = text.substring(text.indexOf(",") + 1, text.length());		//make text = to everything after the comma
					
			} //end else that runs when on any set of data before the last one
		} //end for loop that loops the amount of the chosen position
		
		return selectedData;														//return the selected data
		
	} //end of getData	
	
	/**************************************************
	** Method Name: countItems()				     **
	** Inputs: a char as the delimited character,    **
	**         and a string of inputed numbers       **
	** Returns: Int called amount of delimited items **
	** Description: Reads in a comma delimited	 	 ** 
	** text line and returns the amount of items	 **
	**************************************************/
	
	public static int countItems(char character, String numbers) {
		
		int amount = 0;									//create a variable to hold the amount of items
			
		for(int x = 0; x < numbers.length(); x++) {
				
			if(numbers.charAt(x) == character) {
					
				amount = amount + 1;					//add 1 to the amount 
					
			} //end if that checks if the char read in is the delimited char
		} //end for that loops the length of the line of text
			
		return amount;									//return the amount of delimited items
	}
		
	/**********************************************************
	**  Method Name: printReportTitle                        **
	**  Inputs: a String variable that will be printed       **
	**  Returns: Nothing                                     **
	**  Description: Takes in a title variable and prints it **
	**               if the title is 40 or less characters   ** 
	**********************************************************/

	public static boolean printReportTitle(String title) {

		int length = 40;                                        //create int variable that represents the number of dashes before and after the title
        boolean successful = false;                             //create boolean variable that represents if title was printed successfully
        
        if(title.length() <= 40){
        
            successful = true;                                  //sets successful to true
        
            for(int i = 0; i < length; i++){

                if((length - i) == 1){
            
                    System.out.println("-");                    //print 1 dash and add a line after the print
                    break;                                      //break from the for loop
                
                } //end if statement that adds extra line after print if on the last dash
            
                System.out.print("-");                          //print 1 dash with no line underneath
        
            } //end for loop that prints all 40 dashes
            int center = (length / 2) - (title.length() /2);    //create int variable that calculates the amount of space needed to center title
        
            for(int i = 0; i < center; i++){
            
            	System.out.print(" ");                      	//prints spaces 
                
            } //end for loop that prints the appropriate amount of spacing to make the title centered
            
            System.out.println(title);                     		//prints the title sent into the method 
     
            for(int i = 0; i < length; i++){
            	
	        	if((length - i) == 1){
	    	            
	        		System.out.println("-" + "\n");             //print 1 dash and add a line after the print
	        		break;                                      //break from the for loop
	                
	        	} //end if statement that adds extra line after print if on the last dash
	            	
	        	System.out.print("-");                          //prints 1 dash with no line underneath
	            
	        }//end for loop that prints all 40 dashes   
            
        //end if that sets successful to true if title is <= 40 characters
        }else{
        
            successful = false;                                 //sets successful to false

        } //end else that sets successful to false if title is over 40 characters long
        
        return successful;										//return if successful or not 
        
	}//end of printReportTitle
	
	public static void main(String[] args) throws IOException{
		
		printReportTitle("Puzzle 1");  	    												//send the title to the printReportTitle method
		
		try{
                    
            BufferedReader inputFile = new BufferedReader(new FileReader("H:\\math.txt")); //create BufferedReader to read file
            String inputData = "";                             							   //create string variable that will hold the inputed line of text
            
            while((inputData = inputFile.readLine()) != null) {
            	
            	char delimitedChar = ',';
            	final String FIND_OPERATION = getData(0, inputData);						//create final variable to hold the method call for the first pos of the line of data
            	double total = 0;															//create variable to hold the total of all the items
            	double avrg = 0;															//create variable to hold the average if the items
            	System.out.println("Input Line: " + inputData);								//print the read in line of data
            		
            	if(FIND_OPERATION.charAt(0) == 'A' || FIND_OPERATION.charAt(0) == 'S') {
            		
            		inputData = inputData.substring(inputData.indexOf(delimitedChar) + 1, inputData.length()); 	//chops up the inputed data into anything after the A or S
            		for(int x = 0; x < countItems(delimitedChar, inputData) + 1; x++) {		
            			
            			total = total + Integer.parseInt(getData(x, inputData));								//set total to its previous value + the next number in the line
            			
            		} //end for loop that loops the amount of items 
            		
            		if(FIND_OPERATION.charAt(0) == 'A') {
            			
            			avrg = total / (countItems(delimitedChar, inputData) + 1);								//set average = to the total divided by the amount of items
            			System.out.println("Average: " + avrg + "\n");											//print the average
            		
            		//end if that prints the average
            		}else {
            			System.out.println("Sum: " + total + "\n");												//print the sum
            		} //end else that prints the sum
            	}else {
            		
            		System.out.println("Sorry, you put in an invalid input!");									//print that there was an invalid input
            		
            	} //end else that catches if there is no A or S at the beginning of the line
            } //end while loop that reads in the file lines until empty
            
            inputFile.close();                                  												//close file
            
        //end of try     
        }catch(IOException e){
        
            System.out.println("Oh no! please fix error: " + e);                              					//print error
        
        } //end of catch that catches errors
	} //end of main method
} //end of class