/************************************************************
**  Name: Madison Gosselin                        		   **
**  Class Name: TimeTest.java                     		   **
**  Creation Date: 10-25-2021                     		   **
**  Description: This is a program that takes an  		   **
**               inputed file of numbers and reads it into **
**               an int array then sends to a method that  **
**               finds a number and sends back the pos. It **
**				 also compares the time lapsed between     **
**               sequential and binary searches. 		   **
************************************************************/

import java.io.*;	 //import java libraries
import java.lang.*;	 //import time libraries

public class TimeTest{
	
	/*****************************************************************
	*  Method Name: binarySearch()					           		**
	*  Inputs: A int num, int[] array, and int length	       		**
	*  Returns: The position the number was found	 	       		**
	*  Description: Takes in parameters that are used 	       		**
	* 			    to find a designated number in an ordered array **
	* 				of data and return the pos it was found in		**
	*****************************************************************/
	
	public static int binarySearch(int num, int[] binArray, int len) {
		
		int mid = 0;										//create a variable that will hold the middle position
		int begin = 0;										//create a variable that will hold where the beginning is 
		int end = len - 1;									//create a variable that will hold where the end is 
		
		while(begin <= end) {
			
			mid = (begin + end) / 2;
			
			if(binArray[mid] == num) return mid; 			//if statement that runs if mid is = to the number and returns mid
			else if (binArray[mid] < num) begin = mid + 1;	//else if that runs if the mid is < the number and sets begin = to mid + 1 to ignore the left half
			else end = mid - 1;								//end else that runs if the mid is > the number and sets end = mid - 1 to ignore the right half
		
		} //end while that loops when the beginning is <= the end
       
        return -1;											//return -1 because the number was not found
		
	} //end binarySearch()
	
	/******************************************************************
	*  Method Name: sequentialSearch()					     		 **
	*  Inputs: A int num, int[] array, and int length	     		 **
	*  Returns: The position the number was found	 	      		 **
	*  Description: Takes in parameters that are used 	      		 **
	* 			    to find a designated number in an not ordered    **
	* 				array of data and return the pos it was found in **
	******************************************************************/
	
	public static int sequentialSearch(int num, int[] seqArray, int len) {
		
		int pos = 0;					//create a variable to hold the pos of the desired number
		
		for(int x = 0; x < len; x++) {
			
			if(seqArray[x] == num) {
				
				pos = x;				//set pos = to x which is where it is in the array
				x = len;				//set x = to length so it wont loop again
			
			//end if that checks if the pos in the array is = to the desired number
			}else if((len - x) == 1){
				
				pos = -1;				//set pos = to -1
				
			} //end else if that only runs if none were found and you are on the last loop
		} //end for loop that loops the length of the file
		
		return pos;						//return the pos of the num or -1 if none
		
	} //end sequentialSearch()
	
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
		
		BufferedReader inputUnsortedFile = new BufferedReader(new FileReader("H:\\number.txt")); 			//create BufferedReader to read unsorted file
		BufferedReader inputSortedFile = new BufferedReader(new FileReader("H:\\sortedNums.txt"));			//create BufferedReader to read sorted file
        String unsortedData = "";                             							   					//create string variable that will hold the inputed line of unsorted data
        String sortedData = "";
        int[] parsedUnsortedData = new int [9999];															//create an int array to hold the parsed unsorted data
        int[] parsedSortedData = new int [9999];															//create an int array to hold the parsed sorted data
        int num = 14;																						//create a variable to hold the wanted number
        int length = 0;																						//create a variable to count the length
        
        double startTime = 0.0; 																			//holds starting time
        double endTime = 0.0;   																			//holds ending time.
        	
        printReportTitle("Sequential Search");  	    													//send the title to the printReportTitle method
		
		try {
            
            while((unsortedData = inputUnsortedFile.readLine()) != null) {
            	
            	parsedUnsortedData[length] = Integer.parseInt(unsortedData);								//parse unsortedData and put it into an array
            	length = length + 1;																		//increase the length by 1
            	
            } //end while loop that reads in the unsorted file lines until empty
            
            startTime = System.nanoTime();																	//get starting time
            System.out.println("Item found at: \t" + sequentialSearch(num, parsedUnsortedData, length));	//print where the number was found at (seq)
            endTime = System.nanoTime();																	//get ending time after scanning the binary method 
                        
            System.out.println("Item value: \t" + num);														//print the number that was searched for (seq)
            System.out.println("Time elapsed: \t"+ (endTime - startTime) + "\n");							//print the time elapsed 
            
            printReportTitle("Binary Search");																//send the title to printreportTitle method
            length = 0;																						//reset length
            
            while((sortedData = inputSortedFile.readLine()) != null) {
            	
            	parsedSortedData[length] = Integer.parseInt(sortedData);									//parse sortedData and put it into an array
            	length = length +1;																			//increase the length by 1
            	
            } //end while that reads in the sorted file until empty
            
            startTime = System.nanoTime();																	//get starting time 
            System.out.println("Item found at: \t" + binarySearch(num, parsedSortedData, length));			//print where the number was found (bin)
            endTime = System.nanoTime();																	//get ending time after scanning the binary method
                        
            System.out.println("Item value: \t" + num);														//print the number that was searched for (bin)
            System.out.println("Time elapsed: \t"+ (endTime - startTime) + "\n");							//print the time elapsed
            
            inputUnsortedFile.close();                                  									//close unsorted file
            inputSortedFile.close();																		//close sorted file
            
        //end of try     
        }catch(IOException e){
        
            System.out.println("Oh no! please fix error: " + e);                              			//print error
        
        } //end of catch that catches errors
	} //end of main method
} //end of class