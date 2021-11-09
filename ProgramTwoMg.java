/***************************************************
**  Name: Madison Gosselin                        **
**  Class Name: ProgramTwoMG.java                 **
**  Creation Date: 09-17-2021                     **
**  Description: This is a program that sends     **
**               a title to a seperate method     **
**               "printReportTitle" and prints    **
**               the title                        **
***************************************************/

import java.io.*;

public class ProgramTwoMg
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

    public static void main (String[] args) throws IOException {
    
	try{
	    
	    String inputTitle = "";                             //create string variable that will hold the inputted title
	
	    BufferedReader inputFile = new BufferedReader(new FileReader("H:\\textdata.txt")); //create BufferedReader to read file
	    inputTitle = inputFile.readLine();                  //put info from file into inputTitle
	   
	    System.out.println("Program 2: File Handling");     //Print out what the program is
	    printReportTitle(inputTitle);                       //send the title to the printReportTitle method
	    
	    inputFile.close();                                  //close file
	//end of try     
	}catch(IOException e){
	
	    System.out.println(e);                              //print error
	
	}//end of catch that catches errors     
    }//end of main method
} // ProgramOneMg class
