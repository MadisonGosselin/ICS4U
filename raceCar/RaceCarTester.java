/****************************************************
**  Name: Madison Gosselin                         **
**  Class Name: RaceCarTester.java                 **
**  Creation Date: 11-22-2021                      **
**  Description: This is a program that calls a    **
**               class and sets/gets variables     **
**               within the class and uses methods **
**               in the called class to print info **
****************************************************/

public class RaceCarTester {

	public static void main(String[] args) {
		
		//create variable of type RaceCar
		RaceCar myFirstRaceCar = new RaceCar();
		
		//set variables that were defined in the RaceCar class
		myFirstRaceCar.setMake("Ferrari");
		myFirstRaceCar.setModel("GTO");
		myFirstRaceCar.setHorsePower(350);
		myFirstRaceCar.setMaxRPM(9000);
		myFirstRaceCar.setColour("RED");
		myFirstRaceCar.setWeight(2124);
		myFirstRaceCar.setCarNumber(19);
		myFirstRaceCar.setHpToWeightRatio(myFirstRaceCar.getHorsePower() / myFirstRaceCar.getWeight());
		
		//call methods in the RaceCar class
		myFirstRaceCar.getTheMake();
		myFirstRaceCar.getTheModel();
		myFirstRaceCar.getTheHorsePower();
		System.out.println(myFirstRaceCar.carTeam());
		myFirstRaceCar.startCar();
		
	} //end main method
} //end RaceCarTester
