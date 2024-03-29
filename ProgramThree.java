/***************************************************
**  Name: Madison Gosselin                        **
**  Class Name: ProgramThree.java                 **
**  Creation Date: 09-30-2021                     **
**  Description: This is a program that finds     **
**               the chosen word position from a  **
**               comma delimited text file and    **
**               prints it						  **
***************************************************/

import java.io.*;

public class ProgramThree {

	/*********************************************
	** Method Name: getData()					**
	** Inputs: an int position and string text  **
	** Returns: String calledselectedData		**
	** Description: Reads in a comma delimited	** 
	** text file and prints the word selected	**
	*********************************************/
	
	public static String getData(int position, String text) {
		
		String selectedData = "";													//create variable to hold selectedData
		
		for(int x = 0; x <= position; x++) {
				
				if(text.indexOf(",") == -1) {
					
					selectedData = text; 											//set selectedData = to text
					
				//end if that runs if on the last set of data	
				}else {
					
					selectedData = text.substring(0, text.indexOf(","));			//make selectedData = to the data from the beginning to the first comma
					text = text.substring(text.indexOf(",") + 1, text.length());	//make text = to everything after the comma
					
				} //end else that runs when on any set of data before the last one
		} //end for loop that loops the amount of the chosen position
		
		return selectedData;														//return the selected data
		
	} //end of getData	
		
		/**********************************************************
	    **  Method Name: printReportTitle                        **
	    **  Inputs: a String variable that will be printed       **
	    **  Returns: Nothing                                     **
	    **  Description: Takes in a title variable and prints it **
	    **               if the title is 40 or less characters   **
	    **********************************************************/

	public static void printReportTitle(String title) {

		int length = 40;                                        	//create int variable that represents the number of dashes before and after the title
	        
		if(title.length() <= 40){
	        
			for(int i = 0; i < length; i++){

				if((length - i) == 1){
	            
					System.out.println("-");                    	//print 1 dash and add a line after the print
	             	break;                                      	//break from the for loop
	                
				} //end if statement that adds extra line after print if on the last dash
	            
				System.out.print("-");                          	//print 1 dash with no line underneath
	        
			} //end for loop that prints all 40 dashes
			int center = (length / 2) - (title.length() /2);    	//create int variable that calculates the amount of space needed to center title
		        
		    	for(int i = 0; i < center; i++){
		            
		    		System.out.print(" ");                     	 	//prints spaces 
		                
		    	} //end for loop that prints the appropriate amount of spacing to make the title centered
		            
		        System.out.println(title);                      	//prints the title sent into the method 
		     
		        for(int i = 0; i < length; i++){
		            	
		        	if((length - i) == 1){
		    	            
		        		System.out.println("-");                    //print 1 dash and add a line after the print
		        		break;                                      //break from the for loop
		                
		        	} //end if statement that adds extra line after print if on the last dash
		            	
		        	System.out.print("-");                          //prints 1 dash with no line underneath
		            
		        }//end for loop that prints all 40 dashes  
		}//end if that prints the title of the length is less then 40
	}//end of printReportTitle
	
	public static void main(String[] args) throws IOException{
		
		try{
            
            String inputData = "";                             				//create string variable that will hold the inputed line of text
        
            BufferedReader inputFile = new BufferedReader(new FileReader("H:\\A3.txt")); //create BufferedReader to read file
            inputData = inputFile.readLine();                 				//put info from file into inputData
            int pos = 0;
            String methodCall = getData(pos, inputData);					//create variable to hold method call
           
            printReportTitle("Assignment #3");  	    					//send the title to the printReportTitle method
            System.out.println("Data in the text file: " + inputData );		//print all the data in the text file
            System.out.println("The position of the data wanted: " + pos);	//print the position of data wanted
            System.out.println("The data chosen is: " + methodCall);		//print the returned data from getData() 
            
            inputFile.close();                                  			//close file
            
        //end of try     
        }catch(IOException e){
        
            System.out.println(e);                              			//print error
        
        } //end of catch that catches errors
	} //end of main method
} //end of class

