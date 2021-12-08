import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/************************************************************
**  Name: Madison Gosselin                        		   **
**  Class Name: Recursion2.java                     	   **
**  Creation Date: 12-08-2021                     		   **
**  Description: This is a program that uses a method  	   **
**               to remove the same chars that are next to **
**				 eachother using recursion 					**
************************************************************/

public class Recursion2 {
	public static void main(String[] args) throws IOException{

		printReportTitle("Recursion #2");  	    																//send the title to the printReportTitle method
		
		try{
			
			BufferedReader inputFile = new BufferedReader (new FileReader ("H:\\RECUR2.txt")); 					//create BufferedReader to read file
			String inputData = "";																				//create a string to hold the inputed variable
			int amount = 0;																						//create a variable to hold the amount of strings read in 
			
		    while((inputData = inputFile.readLine())!= null) {
		    		
		    	System.out.println("Input:  "+ inputData + "\tOutput: "+ findDupes(inputData));					//print the inputed and outputted string from the method
		    	amount++;																						//increase the amount of strings read by 1
		    	
		    } //end while that reads in the string to be checked
		    System.out.println("\nTotal String Count: " + amount);												//print the amount of strings read in with a blank line inbetween
		    
		    inputFile.close();																					//close file
		    	
		//end try
		}catch (IOException e){

		    System.out.println ("Oh no! Please fix error: " + e);                           					//print error

		} //end of catch that catches errors
	} //end main method
	
	/*********************************************************************
	**  Method Name: findDupes()                  		    			**
	**  Inputs: a String of inputed data	        		 			**
	**  Returns: an organized String				         			**
	**  Description: Takes in an String and deletes duplicate   		**
	**               chars that are next to eachother using recursion	** 
	*********************************************************************/
	public static String findDupes(String input) {
		
		if(input.length() <= 1) return input;												//if the length is 0, return the string it is done
		else if(input.charAt(0) == input.charAt(1)) return findDupes(input.substring(1));	//if the chars at 0 and 1 are equal return the string after those values back to the method
		else return input.charAt(0) + findDupes(input.substring(1));						//else return the first char and send everything after back to the method
		
	} //end findDupes()
	
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
} //end Recursion2