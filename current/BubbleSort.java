/************************************************************
**  Name: Madison Gosselin                        		   **
**  Class Name: BubbleSort.java                     	   **
**  Creation Date: 11-08-2021                     		   **
**  Description: This is a program that takes an  		   **
**               inputed file of numbers and reads it into **
**               an int array then sends to methods that   **
**               sort the numbers and returns them into    **
**				 a text file							   **
************************************************************/

import java.io.*;	 //import java libraries
import java.lang.*;	 //import time libraries

public class BubbleSort{
	
	/*****************************************************************
	*  Method Name: bubbleSort()					           		**
	*  Inputs: An int[] array, int length and int direction    		**
	*  Returns: The ordered int[] array					 	       	**
	*  Description: Takes in parameters that are used to organize	**
	* 			    the inputed array in the designated order		**
	*****************************************************************/
	
	public static int[] bubbleSort(int array[], int len, int direction) {
		
		int temp = 0;								//create a temporary variable 
		boolean switched;							//create a boolean to track if the array was switched or not
		
		for(int x = 0; x < len - 1; x++) {
			
			switched = false; 						//set switched = false at the beginning of every run
			
			for(int i = 0; i < len - x - 1; i++) {
				
				if(array[i] > array[i + 1] && direction == 0 || array[i] < array[i + 1] && direction == 1) {
						
					temp = array[i];				//set temp = to the current position in the array
					array[i] = array[i + 1];		//set the current pos in the array = to the next pos value
					array[i + 1] = temp;			//set the next pos value = to the temp variable (what the current pos was)
					switched = true;				//set switched = to true
					
				} //end if that checks if the current pos is greater than the next pos or less than the next pos
			} //end for loop that trims the already sorted numbers
			
			if(switched == false) x = len; 			//makes so for loop will not run again
			
		} //end for loop that runs while x is < length - 1
		return array;								//return the sorted array
	} //end bubbleSort()
	
	/*****************************************************************
	*  Method Name: insertionSort()					        		**
	*  Inputs: An int[] array, int length and int direction    		**
	*  Returns: The ordered int[] array					 	       	**
	*  Description: Takes in parameters that are used to organize	**
	* 			    the inputed array in the designated order by    **
	* 				taking out the value being assessed and putting **
	* 			 	it in the right position						**
	*****************************************************************/
	
	public static int[] insertionSort(int array[], int len, int direction) { 
		
		for(int x = 1; x < len; x++) {
			
			int current = array[x];				//create a variable that puts the value being checked into a variable
			int y = x-1;						//create a variable that is = to 1 less then x
			
			while(direction == 0 && ( y >= 0 && current < array[y]) || direction == 1 && ( y >= 0 && current > array[y])) {
				
				array[y+1] = array[y];			//move everything over 
				y--;							//decrease y by 1 to check the next value against the current value
		
			} //end while that loops while y >= 0 and orders them in ascending or descending order depending on the direction
			array[y+1] = current;				//insert number into correct position
		} //end for loop that loops from the second element til the end of the array
		
		return array;							//return sorted array
		
	} //end insertionSort()
	
	public static int[] shellSort(int array[], int len, int direction) {
		
		int interval = 0;								//create a variable to hold the interval at which you want to search between
		
		for(interval = len/2; interval > 0; interval = interval/2) {
			for(int x = interval; x < len; x++) {
				
				int temp = array[x];					//create a temp variable that holds the current value of then position in the array being scanned
				int j = 0;								//create a variable that loops the for loop and tracks what pos in the array you are at
				
				for(j = x; j >= interval && array[j-interval] > temp; j -= interval) {
					
					array[j] = array[j-interval];		//swap them 
					
				} //end for loop that loops to find the correct pos to put the low number
				array[j] = temp;						//put it in the correct spot
			} //?? https://www.programiz.com/dsa/shell-sort
		} //??
		
		return array;
		
	} //end shellSort()
	
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
		
		BufferedReader inputFile = new BufferedReader(new FileReader("H:\\unsortedData.dat")); 				//create BufferedReader to read unsorted file
		PrintWriter outputFile = new PrintWriter("H:\\out.dat");											//create a PrintWriter to write to a file
		String inputData = "";																				//create variable to hold data
		int[] bubArray = new int[99999];																	//create array to hold bubble sort output
		int[] insArray = new int[99999];																	//create array to hold insertion sort output
		int length = 0;																						//create a variable to hold the length
		int order = 0;																						//create a variable to hold the order (0 - ascending, 1 - descending)
        	
		double startTime = 0.0; 																			//holds starting time
        double endTime = 0.0;   																			//holds ending time.
		
        printReportTitle("Bubble Sort and Insertion Sort");  	    										//send the title to the printReportTitle method
		
		try {
            
			System.out.println("Reading in the data...");													//print current step
			
            while((inputData = inputFile.readLine()) != null) {
            	
            	bubArray[length] = Integer.parseInt(inputData);												//parse inputData into bubble array
            	insArray[length] = Integer.parseInt(inputData);												//parse inputData into insertion array
            	length = length + 1;																		//increase the length by 1
            	
            } //end while loop that reads in the unsorted file lines until empty
            
            System.out.println("Processing data...\n");            											//print current step
            startTime = System.nanoTime();																	//get starting time
            bubArray = bubbleSort(bubArray, length, order);													//set array = to bubble sorted data            
            endTime = System.nanoTime();																	//get ending time after running the bubble sort 
            System.out.println("Bubble Sort - Time elapsed: \t"+ (endTime - startTime) + "\n");				//print the time elapsed 
            
            startTime = System.nanoTime();																	//get starting time 
            insArray = insertionSort(insArray, length, order);												//set array = to insertion sorted data
            endTime = System.nanoTime();																	//get ending time after running the insertion sort 
            System.out.println("Insertion Sort - Time elapsed: \t"+ (endTime - startTime) + "\n");			//print the time elapsed 
            
            outputFile.println("\tBubble Sort Output\t");													//output to file that the output is bubble sorted
            for(int x = 0; x < length; x++) {
            	
				outputFile.println(bubArray[x]);															//output bubble sort to file
				
			} //end for that unloads the array onto a file 
            
            System.out.println("Processed bubble sort data into file");										//print current step 
            
            outputFile.println("\tInsertion Sort Output\t");												//output to file that the output is insertion sorted
            for(int x = 0; x < length; x++) {
            	
				outputFile.println(insArray[x]);															//output insertion sort to file
				
			} //end for that unloads the array onto a file 
            
            System.out.println("Processed insertion sort data into file");									//print current step
            
            inputFile.close();																				//close input file
            outputFile.close();																				//close output file
            
        //end of try     
        }catch(IOException e){
        
            System.out.println("Oh no! please fix error: " + e);                              				//print error
        
        } //end of catch that catches errors
	} //end of main method
} //end of class
