/************************************************************
**  Name: Madison Gosselin                        		   **
**  Class Name: LuckyMoney.java                     	   **
**  Creation Date: 12-06-2021                     		   **
**  Description: This is a program that takes an  		   **
**               inputed file of serial numbers and        **
**               sends it to a method that checks if the   **
**               day is lucky or not aka the digits are 3  **
**				 letters repeating over and over in the    **
**               same order						 		   **
************************************************************/

import java.io.*;		//import java libraries

public class LuckyMoney {
	public static void main(String[] args) throws IOException {
		
		printReportTitle("Lucky Money Problem");  	    																		//send the title to the printReportTitle method
	    
		try{
			
			BufferedReader inputFile = new BufferedReader (new FileReader ("H:\\yen.txt")); 									//create BufferedReader to read file
			int length = Integer.parseInt (inputFile.readLine());                         										//read in the first line
			String inputData = "";																								//create a variable to hold the inputed data once read in
			
		    for (int x = 0 ; x < length ; x++) {
		    		
		    	inputData = inputFile.readLine();																				//read file into inputData
		    	if(inputData.length() == 3) System.out.println(inputData + " is lucky");										//check if it is 3 long, if so print lucky
		    	else if((inputData.length() % 3) == 0) System.out.println(inputData + " is " + checkSerialNums(inputData));     //if it is divisible by 3 evenly, run the method                                                 
		    	else System.out.println(inputData + " is not lucky");															//else print not lucky
		    	
		    } //end for that reads in the serial numbers
		    
		    inputFile.close();																									//close file
		    	
		//end try
		}catch (IOException e){

		    System.out.println ("Oh no! Please fix error: " + e);                           									//print error

		} //end of catch that catches errors
	} //end main method	
	
	/*****************************************************************
	**  Method Name: checkSerialNums()					           	**
	**  Inputs: A string of the inputed serial number	       		**
	**  Returns: A string (if lucky of not)	 	       				**
	**  Description: Takes in the serial number and checks if  	    **
	** 			   	the first 3 digits repeat themselves all		**
	** 				throughout the line, then return the status		**
	*****************************************************************/
	
	public static String checkSerialNums(String line) {
		
		String testLine = line.substring(0, 3); 								//create a variable to hold a substring for the test line
		String status = "not lucky";											//create a variable to hold the status of lucky or not lucky
		
		for(int x = 3; x < line.length(); x += 3) {
			
			if(testLine.equals(line.substring(x, x + 3))) status = "lucky";		//check if the substring equals the next 3 characters, if so set status to lucky
			else status = "not lucky";											//else put the status to not lucky
			
		} //end for that loops that checks if each 3 digits equal
		return status;															//return status
	} //end checkSerialNums()
	
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
	
} //end LuckyMoney
