/*****************************************************************
**  Name: Madison Gosselin                        		        **
**  Class Name: TowersOfHanoiMG.java              		        **
**  Creation Date: 01-19-2022                     		        **
**  Description: This is a program that plays towers of hanoi   **
**               by sending the amount of rings in play to a    **
**				 method that calculates the necessary moves     **
**				 to successfully complete the game 			    **
*****************************************************************/ 

//import needed java libraries
import java.io.*;
import java.util.*;

public class TowersOfHanoiMG {
	public static void main(String[] args) throws IOException {
		
		printReportTitle("Towers Of Hanoi");  	    							//send the title to the printReportTitle method
		
		Scanner scannerObj = new Scanner(System.in);							//scannerObj to take in the number of disk
		
		System.out.println("Please enter the height of the first tower: ");		//ask the user to enter the number of disk
		int numOfDisks = scannerObj.nextInt();									//makes numOfDisks equal to what the user entered
		
		movingDisks(numOfDisks, '1', '3', '2');									//calls movingDisks to play the game
		scannerObj.close();														//closes scannerObj  
		
	} //end main method
	
	/***********************************************************
	**  Method Name: movingDisks()                            **
	**  Inputs: an int number of disks, 3 chars representing  **
	**			each of the 3 rungs						      **
	**  Returns: nothing								      **
	**  Description: Takes in the number of disks and         **
	**               calculates the movement between the      ** 
	**			     designated rung names and prints results **
	***********************************************************/ 
	
	public static void movingDisks(int numOfDisks, char from, char to, char helper) {
		
		if (numOfDisks == 1){	
			
			System.out.println("move disk 1 to rung " + to);	//print where disk 1 moves
			return;												//return to main method		
		
		} //end if statement that checks if there is only 1 disk (base case)
		
		movingDisks(numOfDisks - 1, from, helper, to);							//calls movingDisks to make the next move starting at the from rung (1)
		
		System.out.println("move disk " + numOfDisks + " to rung " + to);		//prints the move it just made
		
		movingDisks(numOfDisks - 1, helper, to, from);							//calls movingDisks to make the next move starting at the helper rung (2)
		
	} //end movingTheDisk()
	
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
} //end TowersOfHanoiMG
