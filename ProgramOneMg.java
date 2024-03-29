/***************************************************
**  Name: Madison Gosselin                        **
**  Class Name: ProgramOneMG.java                 **
**  Creation Date: 09-15-2021                     **
**  Description: This is a program that sends     **
**               a title to a seperate method     **
**               "printReportTitle" and prints    **
**               the title                        **
***************************************************/

public class ProgramOneMg
{

    /**********************************************************
    **  Method Name: printReportTitle                        **
    **  Inputs: a String variable that will be printed       **
    **  Returns: Nothing                                     **
    **  Description: Takes in a title variable and prints it **
    **               if the title is 40 or less characters   **
    **********************************************************/

    public static void printReportTitle(String title) {

	int length = 40;                                        //create int variable that represents teh number of dashes before and after the title
	boolean successful = false;                             //create bool variable that represents if title was printed successfully
	
	if(title.length() <= 40){
	
	    successful = true;                                  //sets successful to true
	
	    for(int i = 0; i < length; i++){

		if((length - i) == 1){
	    
		    System.out.println("-");                    //print 1 dash and add a line after the print
		    break;                                      //break from the for loop
		
		} //end if statement that adds extra line after print if on the last dash
	    
		System.out.print("-");                          //print 1 dash with no line underneath
	
	    } //end for loop that prints all 40 dashes
	    int center = (length / 2) - (title.length() /2);    //create int variable that calculates the amout of space needed to center title
	
	    for(int i = 0; i < center; i++){
	    
		    System.out.print(" ");                      //prints spaces 
		
	    } //end for loop that prints the approriate amout of spacing to make the title centered
	    
	    System.out.println(title);                      //prints the title sent into the method 
     
	    for(int i = 0; i < length; i++){
	
		System.out.print("-");                          //prints 1 dash with no line underneath
	    
	    }//end for loop that prints all 40 dashes  
	    
	//end if that sets successful to true if title is <= 40 characters
	}else{
	
	    successful = false;                                 //sets successful to false

	} //end else that sets successful to false if title is over 40 characters long
    }//end of printReportTitle

    public static void main (String[] args){
	
	printReportTitle("This is the title");                  //send the title to the printReportTitle method
    
    }//end of main method
} // ProgramOneMg class
