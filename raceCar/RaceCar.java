/****************************************************
**  Name: Madison Gosselin                         **
**  Class Name: RaceCar.java                 	   **
**  Creation Date: 11-22-2021                      **
**  Description: This is a class that creates      **
**               variables to hold racecar info,   **
**				 uses getters and setters to       **
**				 manipulate the variables, and has ** 
**				 methods to manipulate the racecar **
**               info.  						   **
****************************************************/

public class RaceCar {
	
	//create variables that hold information about the racecar
	String make = "";
	String model = "";
	int horsePower = 0;
	int maxRPM = 0;
	String colour = "";
	int weight = 0;
	int carNumber = 0;
	double hpToWeightRatio = 0;
	
	//create all getters and setters below
	public String getMake() {
		return make;
	} //end getMake()
	public void setMake(String make) {
		this.make = make;
	} //end setMake()
	public String getModel() {
		return model;
	} //end getModel()
	public void setModel(String model) {
		this.model = model;
	} //end setModel()
	public int getHorsePower() {
		return horsePower;
	} //end getHorsePower()
	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	} //end setHorsePower()
	public int getMaxRPM() {
		return maxRPM;
	} //end getMaxRPM()
	public void setMaxRPM(int maxRPM) {
		this.maxRPM = maxRPM;
	} //end setMaxRPM()
	public String getColour() {
		return colour;
	} //end getColour()
	public void setColour(String colour) {
		this.colour = colour;
	} //end setColour()
	public int getWeight() {
		return weight;
	} //end getWeight()
	public void setWeight(int weight) {
		this.weight = weight;
	} //end setWeight()
	public int getCarNumber() {
		return carNumber;
	} //end getCarNumber()
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	} //end setCarNumber()
	public double getHpToWeightRatio() {
		return hpToWeightRatio;
	} //end getHpToWeightRatio()
	public void setHpToWeightRatio(double hpToWeightRatio) {
		this.hpToWeightRatio = hpToWeightRatio;
	} //end getHpToWeightRatio()
	
	/**********************************
	*  Method Name: getTheMake()	 **
	*  Inputs: N/A    				 **
	*  Returns: N/A					 **
	*  Description: Prints the Make	 **
	**********************************/
	public void getTheMake() {
		
		System.out.println("The make of the car is: " + getMake());		//print the make
		
	} //end getTheMake()
	
	/**********************************
	*  Method Name: getTheModel()	 **
	*  Inputs: N/A    				 **
	*  Returns: N/A					 **
	*  Description: Prints the Model **
	**********************************/
	public void getTheModel() {
			
		System.out.println("The model of the car is: " + getModel());	//print the model
			
	} //end getTheModel
	
	/************************************
	*  Method Name: getTheHorsePower() **
	*  Inputs: N/A    				   **
	*  Returns: N/A					   **
	*  Description: Prints the HP      **
	************************************/
	public void getTheHorsePower() {
			
		System.out.println("The horse power is: " + getHorsePower());	//print the hp
			
	} //end getTheHp()
	
	/******************************************
	*  Method Name: startCar()	             **
	*  Inputs: N/A    				         **
	*  Returns: N/A					         **
	*  Description: Prints the car starting	 **
	******************************************/
	public void startCar() {
		
		System.out.println("vroom vroom");	//print vroom vroom
		
	} //end startCar()
	
	/*************************************
	*  Method Name: carTeam()	        **
	*  Inputs: N/A    				    **
	*  Returns: String (team)		    **
	*  Description: Returns the team    **
	*  				based on the colour **
	*************************************/ 
	public String carTeam() {
		
		switch(getColour()) {
		
			case "RED":							//return team ferrari if the colour is red
				return "TEAM FERRARI";
			case "BLUE":						//return team ford if the colour is blue
				return "TEAM FORD";
			case "GREEN":						//return team porshe if the colour is green
				return "TEAM PORSHE";
			case "BLACK":						//return team lamborghini if colour is black
				return "TEAM LAMBORGHINI";
			default:							//set default to return unknown team if not a set input
				return "UNKNOWN TEAM";
				
		} //end switch that returns the team based on colour
	} //end carTeam()
} //end RaceCar class
