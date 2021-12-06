/************************************************************
**  Name: Madison Gosselin                        		   **
**  Class Name: Fibonacci.java                     		   **
**  Creation Date: 12-06-2021                     		   **
**  Description: This is a program that uses a method  	   **
**               to find the fibonacci of a number		   **
**				 using recurssion 						   **
************************************************************/

public class Fibonacci {
	public static void main(String[] args) {

		printReportTitle("Fibonacci Sequence");  	    									//send the title to the printReportTitle method
		int num = 12;																		//create a variable to hold the num to fib
		System.out.println("The " + num + "th fibonacci number is: " + (fib(num)));			//print out the answer from the fib method
		
	} //end main method
	
	/**********************************************************
	**  Method Name: fib()                  			     **
	**  Inputs: an int (number for the fibonacci	         **
	**  Returns: ann int (the fib of the given num)          **
	**  Description: Takes in an int to find the fibonacci   **
	**               of using recursion					     ** 
	**********************************************************/
	public static int fib(int n) {
		
		if(n==0) return 0;						//if 0 return 0
		else if(n==1) return 1;					//if 1 return 1
		else return (fib(n - 2) + fib(n-1));	//anything greater than 1, take the fib of n-2 + n-1
		
	} //end fib()
	
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
} //end Fibonacci