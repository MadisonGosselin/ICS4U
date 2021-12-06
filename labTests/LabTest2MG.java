/*************************************************************
**  Name: Madison Gosselin                                  **
**  Class Name: LabTest2MG.java                             **
**  Creation Date: 11-25-2021                                **
**  Description: This is a program that will take in an int **
**               and uses a method that checks the num of   **
**               times it need to be * 2 before it is / 10  **
*************************************************************/

import java.io.*;   //import java libraries

public class LabTest2MG{

    public static void main (String[] args) throws IOException{

	printReportTitle ("Lab Test #2");                                                  //print the title to the screen
	BufferedReader inputFile = new BufferedReader (new FileReader ("H:\\indata.txt")); //create BufferedReader to read file
	String inputData = "";                                                             //create a variable to hold the inputed data
	int length = 0;                                                                    //create a variable to hold the length
	int counter = 0;                                                                   //create a counter
    
	try{

	    length = Integer.parseInt (inputFile.readLine ());                             //read in the first line
	    int[] numbers = new int [length];                                              //create an array that will rad in all the x's

	    while ((inputData = inputFile.readLine ()) != null){

		numbers[counter] = Integer.parseInt (inputData);                           //read in the numbers into an array
		System.out.println (numOfTurns(length, numbers[counter]));                 //print the method output                                                                 //decrease temp length by 1 
		counter++;                                                                 //increase counter by 1

	    } //end while that reads in the data after the first line
	//end try
	}catch (IOException e){

	    System.out.println ("Oh no! Please fix error: " + e);                           //print error

	} //end of catch that catches errors
    } //end of main method
    
    /**********************************************************
    **  Method Name: numOfTurns()                            **
    **  Inputs: int length and int num                       **
    **  Returns: the num of turns needed                     **
    **  Description: Takes in a number and decides how many  **
    **               times you need to mulitply by 2 before  **
    **               it is divisible by 2                    **
    **********************************************************/

    public static int numOfTurns (int length, int num){
	
	if(num%10 == 0) return 0;           //check if it divible by 10 if so return 0 turns
	else if(num*2%10 ==0) return 1;     //multiply by 2 and check if it is divisible by 10, if so return 1 turn 
	else return -1;                     //else return -1

    } //end numOfTurns()

    /**********************************************************
    **  Method Name: printReportTitle()                      **
    **  Inputs: a String variable that will be printed       **
    **  Returns: a boolean that tells if it was successful   **
    **  Description: Takes in a title variable and prints it **
    **               if the title is 40 or less characters   **
    **********************************************************/


    public static boolean printReportTitle (String title)
    {

	int length = 35;                                        //create int variable that represents the number of dashes before and after the title
	boolean successful = false;                             //create boolean variable that represents if title was printed successfully

	if (title.length () <= 40)
	{

	    successful = true;                                  //sets successful to true

	    for (int i = 0 ; i < length ; i++)
	    {

		if ((length - i) == 1)
		{

		    System.out.println ("*");                   //print 1 star and add a line after the print
		    break;                                      //break from the for loop

		} //end if statement that adds extra line after print if on the last dash

		System.out.print ("*");                         //print 1 star with no line underneath

	    } //end for loop that prints all 40 dashes
	    int center = (length / 2) - (title.length () / 2);  //create int variable that calculates the amount of space needed to center title

	    for (int i = 0 ; i < center ; i++)
	    {

		System.out.print (" ");                         //prints spaces

	    } //end for loop that prints the appropriate amount of spacing to make the title centered

	    System.out.println (title);                         //prints the title sent into the method

	    for (int i = 0 ; i < length ; i++)
	    {

		if ((length - i) == 1)
		{

		    System.out.println ("*" + "\n");            //print 1 dash and add a line after the print
		    break;                                      //break from the for loop

		} //end if statement that adds extra line after print if on the last dash

		System.out.print ("*");                         //prints 1 dash with no line underneath

	    } //end for loop that prints all 40 dashes

	    //end if that sets successful to true if title is <= 40 characters
	}
	else
	{

	    successful = false;                                 //sets successful to false

	} //end else that sets successful to false if title is over 40 characters long

	return successful;                                                                              //return if successful or not

    } //end of printReportTitle
} // LabTest2MG class
