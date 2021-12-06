/**************************************************************
**  Name: Madison Gosselin                        		     **
**  Class Name: LabTest1.java                     		     **
**  Creation Date: 10-29-2021                     		     **
**  Description: This is a program that takes an  		     **
**               inputed file of points and reads it into    **
**               an int array then processes it to find      **
**               every combination of points that will give  **
**				 less then the total points (last array pos) **
**               and prints all combos. 				     **
**************************************************************/

import java.io.*;
import java.lang.reflect.Array;

public class LabTest1 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader inputFile = new BufferedReader(new FileReader("H:\\labInput.txt")); 					//create BufferedReader to read unsorted file
		String inputData = "";																				//create string to hold the inputed line of data
		int[] points = new int[4];																			//create array to hold amount of points
		int counter = 0;																					//create a counter
		
		 printReportTitle("Lab Test Solution");  	    													//send the title to the printReportTitle method
		
		try {
			
            while((inputData = inputFile.readLine()) != null) {
            	
            	points[counter] = Integer.parseInt(inputData);												//parse inputData into an array											
            	counter++;																					//increase the length by 1
            	
            } //end while loop that reads in the unsorted file lines until empty
            
            int bears = points[0];																			//variable to hold num of bears read in the array
            int moose = points[1];																			//variable to hold num of moose read in the array
            int wolves = points[2];																			//variable to hold num of wolves read in the array
            int total = points[3];																			//variable to hold the total points
            
            int totalBears = 0;																				//variable to hold total bear points
            int numOfBears = 0;																				//variable to hold number of bears
            int totalMoose = 0;																				//variable to hold total moose points
            int numOfMoose = 0;																				//variable to hold number of moose
            int totalWolves = 0;																			//variable to hold total wolf points
            int numOfWolves = 0;																			//variable to hold number of wolves
            int totalBM = 0;																				//variable to hold total bears and moose													
            int numOfBM = 0;																				//variable to hold amount of bears and moose
            int totalMW = 0;																				//variable to hold num of moose and wolves
            int numOfMW = 0;																				//variable to hold the amount of moose ad wolves
            int totalBW = 0;																				//variable to hold total bears and wolves
            int numOfBW = 0;																				//variable to hold amount of bears and wolves
            int numOfWays = 0;																				//total num of ways
            
            while((total - totalBears) >= bears) {
            	
            	totalBears = totalBears + bears;															//set totalBears = to itself + bears
            	if(totalBears < total) numOfBears++;														//if toalBears is < total increase the amount of bears allowed inside the points
            } //end while that checks how many bears fit in the total
            if(numOfBears > 0) System.out.println(numOfBears + " Brown Bear, 0 Northern Moose, 0 Gray Wolves");	numOfWays ++;		//print num of bears that you can have if its not 0
            
            while((total - totalMoose) >= moose) {
            	
            	totalMoose = totalMoose + moose;															//set totalMoose = to itself + moose
            	if(totalMoose < total) numOfMoose++;														//if toalMoose is < total increase the amount of moose allowed inside the points
            } //end while that checks how many moose fit in the total
            if(numOfMoose > 0) System.out.println("0 Brown Bear, " + numOfMoose + " Northern Moose, 0 Gray Wolves"); numOfWays++;	//print num of moose you can have if its not 0
            
            while((total - totalWolves) >= wolves) {
            		
            	totalWolves = totalWolves + wolves;															//set totalWolves = to itself + wolves
            	if(totalWolves < total) numOfWolves++;														//if toalWolves is < total increase the amount of wolves allowed inside the points
            } //end while that checks how many wolves fit in the total
            if(numOfWolves > 0) System.out.println("0 Brown Bear 0 Northern Moose, " + numOfWolves + " Gray Wolves"); numOfWays++;	//print num of wolves you can have if its not 0
            
            numOfBears = 0;																					//reset num of bears
            numOfMoose = 0;																					//reset num of wolves
            boolean first = true;;																			//create a variable to say if its the first loop or not
            while((total - totalBM) >= numOfBears) {	
            	
            	if(first == true) {
            		
            		totalBM = bears + moose;																//make total bears and moose = to one of each as a base
            		if(totalBM < total) numOfBears++; numOfMoose++;											//make an if that if its less than the total increase each by 1
            		first = false;																			//set first false
            	
            	//end if that runs if its the first loop
            	}else {
            		
            		totalBM = totalBM + bears;																//increase total by 1 bear
            		if(totalBM < total) numOfBears++;														//if less than total increase amount by 1
            	} //end else that runs for all loops except the first
            } //end while 
            if(numOfBears > 0) System.out.println(numOfBears + " Brown Bear, " + numOfMoose + " Northern Moose, 0 Gray Wolves"); numOfWays++;	//print the number of bears AND moose
            
            numOfWolves = 0;																				//reset num of wolves
            numOfMoose = 0;																					//reset num of moose
            first = true;																					//reset first
            while((total - totalMW) >= numOfMoose) {
           
            	if(first == true) {													
            		
            		totalMW = wolves + moose;																//set total to a base of 1 of each
            		if(totalMW < total) numOfWolves++; numOfMoose++;										//if less than total increase counter
            		first = false;																			//set first false
            		
            	}else {
            				
            		totalMW = totalMW + moose;																//increase by 1 moose
            		if(totalMW < total) numOfMoose++;														//increase amount of moose by 1
            	}	
            } //end while 
            if(numOfMoose > 0) System.out.println("0 Brown Bear, " + numOfMoose + " Northern Moose, " + numOfWolves + " Gray Wolves"); numOfWays++;	//print the number of Moose and Wolves
            
            numOfBears = 0;																					//reset num of bears
            numOfWolves = 0;																				//reset num of wolves
            first = true;																			//create a variable to say if its the first loop or not
            while((total - totalBW) >= numOfBears) {	
            	
            	if(first == true) {
            		
            		totalBW = bears + wolves;																//make total bears and moose = to one of each as a base
            		if(totalBW < total) numOfBears++; numOfWolves++;										//make an if that if its less than the total increase each by 1
            		first = false;																			//set first false
            	
            	//end if that runs if its the first loop
            	}else {
            		
            		totalBW = totalBW + bears;																//increase total by 1 bear
            		if(totalBW < total) numOfBears++;														//if less than total increase amount by 1
            		else if((totalBW - bears) > wolves) numOfWolves++;
            	} //end else that runs for all loops except the first
            } //end while 
            if(numOfBears > 0) System.out.println(numOfBears + " Brown Bear, 0 Northern Moose, " + numOfWolves + " Gray Wolves"); numOfWays++;	//print the number of bears AND wolves
            
            System.out.println("Total Number of Ways: " + numOfWays);
            
            inputFile.close();																				//close input file
            
        //end of try     
        }catch(IOException e){
        
            System.out.println("Oh no! please fix error: " + e);                              				//print error
        
        } //end of catch that catches errors
	} //end main method
	
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
} //end class