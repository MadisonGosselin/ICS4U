/***********************************************************
**  Name: Madison Gosselin                        		  **
**  Class Name: Puzzle2MG.java                    		  **
**  Creation Date: 10-14-2021                     		  **
**  Description: This is a program that takes an  		  **
**               inputed line of text and reads if there  **
**               is a substring with an inputed start and **
**               end char that is a designated length     **
***********************************************************/

import java.io.*; //import libraries

public class Puzzle2MG {
	
	/******************************************************
	*  Method Name: findText()							 **
	*  Inputs: A char start, char end, int length		 **
	* 		   and string input							 **
	*  Returns: The number of substrings			 	 **
	*  Description: Takes in parameters that are used 	 **
	* 			    to find a substring in a line of	 **
	* 				data and return the amount found  	 **
	******************************************************/
	
	public static int findText(char start, char end, int len, String input) {
		
		int numOfSubs = 0;						//create variable to hold the number of substrings
		
		if(len <= input.length()) {
			for(int x = 0; x < input.length(); x++) {
				if(input.charAt(x) == start && (x <= input.length()-len) && input.charAt(x+len-1) == end ) {
						
					numOfSubs ++;				//add 1 to the number of subs
						
				} //end if that checks if there is a the start char at the x pos and the end char at the end of the designated length
			} //end for that loops through the input length 
		//end if that checks if the length specified is less than or equal to the length of the input	
		}else{
			
			numOfSubs = -1;						//make numOfSubs = -1 to show that there were none 
			
		} //end else that prints if the start and end char isn't found
		return numOfSubs;						//return the number of substrings
	} //end findText()
	
	/**********************************************************
	**  Method Name: printReportTitle()                      **
	**  Inputs: a String variable that will be printed       **
	**  Returns: a boolean that tells if it was successful   **
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
		
		printReportTitle("Find a String Puzzle");  	    										//send the title to the printReportTitle method
		
		try{
                    
            BufferedReader inputFile = new BufferedReader(new FileReader("H:\\inputText.txt")); //create BufferedReader to read file
            String inputData = "";                             							   		//create string variable that will hold the inputed line of text
            char begChar = 'P';																	//create a variable to hold the beginning char
            char endChar = 'X';																	//create a variable to hold the end char
            int length = 3;																		//create a variable to hold the length
            
            while((inputData = inputFile.readLine()) != null) {
            	
            	System.out.println("Input String to Test: \t" + inputData);												//print the line of data
            	System.out.println("Number of Occurrences: \t" + findText(begChar, endChar, length, inputData)+ "\n");	//print the amount of substrings
            	

            } //end while loop that reads in the file lines until empty
            
            inputFile.close();                                  								//close file
            
        //end of try     
        }catch(IOException e){
        
            System.out.println("Oh no! please fix error: " + e);                              	//print error
        
        } //end of catch that catches errors
	} //end of main method
} //end of class