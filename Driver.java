import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	//created a scanner object
	private static Scanner scnr = new Scanner(System.in);
	
	
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    // Instance variables (if needed)
    
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {

    	String menuChoice = "";
    	
    	
        initializeDogList();
        initializeMonkeyList();
       
        // this is the logic  that will let you select the item menu and return the right method   
        while( !menuChoice.equalsIgnoreCase("q") ) {
        	displayMenu();
        	menuChoice = scnr.nextLine();
        	switch(menuChoice) {
        	case "1":
        		intakeNewDog(scnr);
        			System.out.println();
        			break;
        	case "2":
        		intakeNewMonkey(scnr);
        			System.out.println();
        			break;
        	case "3":
        		reserveAnimal(scnr);
        			break;
        	case "4":
        		printAnimals("4");
        			System.out.println();
        			break;
        	case "5":
        		printAnimals("5");
        			break;
        	case "6":
        		printAnimals("6");
        			break;
      
        	default:
        		if(!menuChoice.equalsIgnoreCase("q")){
        			System.out.print("Please enter a valid selection. ");
        			System.out.print("Press enter to continue");
        		}
        		break;
        			
        	}
        }

   
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing (I updated for testing)
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in progress", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Fred", "5.3in", "3 foot", "10", "Capuchin", "male", "3", "15", "12/17/22", "United States", "in service", false, "usa");
    	Monkey monkey2 = new Monkey("Sirion", "4.5in", "2 foot", "12", "Guenon", "female", "5", "10", "12/15/21", "Canada", "in progress", true, "Canada");
    	Monkey monkey3 = new Monkey("Bob", "6.5in", "24 foot", "15", "Macaque", "male", "5", "10", "08/15/22", "China", "in service", false, "China");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }


    // Complete the intakeNewDog method
    public static void intakeNewDog(Scanner scanner) {
       // asks for dog name and checks to make sure it is not already in the system
    	System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        //asking for dog breed
        System.out.println("What is the dog's breed?");
        String breed = scnr.nextLine();
        //asking for dog gender 
        System.out.println("what is the dog's gender?");
        String gender = scnr.nextLine();
        //asking for dog age
        System.out.println("What is the dog's age?");
        String age = scnr.nextLine();
        //asking for dog weight
        System.out.println("What is the dog's weight?");
        String weight = scnr.nextLine();
        // asking for dog Acquisition date
        System.out.println("What is the dog's acquisition date");
        String acquisitionDate = scnr.nextLine();
        //asking for dog acquisition location
        System.out.println("What is the dog's acquisition location?");
        String acquisitionLocation = scnr.nextLine();
        //asking for dog training status and checking if a valid response because this impact other reports 
        String trainingStatus = "";
        var traningStatusEntered = false;
        while(!traningStatusEntered) {
        	System.out.println("What is the dog's training status");
        	System.out.println("Please enter the following with no space before or after:  (in progress) or (in service)");
        	String dogStatus = scnr.nextLine();
        	if(dogStatus.equalsIgnoreCase("in progress")) {
        		trainingStatus = dogStatus;
        		traningStatusEntered = true;
        	}
        	else if (dogStatus.equalsIgnoreCase("in service")) {
        		trainingStatus = dogStatus;
        		traningStatusEntered = true;
        	}
        	else {
        		System.out.println("please enter a valid response, press enter to continue");
        		scnr.nextLine();
        	}
        }
        //asking for dog reserved checking if a valid response only allowing true or false as valid answers because this impacts other reports 
        boolean reserved = true;
        var isReserved = false;
        while(!isReserved) {
        	System.out.println("Is the dog reserved? Please enter true or false with no space before or after");
        	String dogReserveStatus = scnr.nextLine();
        	if (dogReserveStatus.equalsIgnoreCase("true")) {
        		reserved = true; 
        		isReserved = true;
        	}
        	else if (dogReserveStatus.equalsIgnoreCase("false")) {
        		reserved = false;
        		isReserved = true;
        	}
        	else {
        		System.out.println("please input a valid answer of true or false, press enter to continue");
        		scnr.nextLine();
        	}   
        }
        // asking for dog service country 
        System.out.println("What is the dog's service country");
        String inServiceCountry = scnr.nextLine();
        
        //creates a new dog  from what the user entered and set it to the dog list
       Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceCountry);
       dogList.add(dog);

       //my print statements to let the user know dog has been add and how to get back to the menu
       System.out.println("");
       System.out.println("Dog has been added");
       System.out.println("Please press enter to return to the menu.");
       scnr.nextLine();  
    }


        // Where we in take a new monkey instance the user adds 
        public static void intakeNewMonkey(Scanner scanner) {
            
        	//checking to see if the monkey name entered is already in our system
        	System.out.println("What is the Monkeys name?");
            String name = scnr.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis Moneky is already in our system\n\n");
                    return; //returns to menu
                }
            }
            
            //asking for monkey tail length
            System.out.println("What is the monkey's tail Length?");
            String tailLength = scnr.nextLine();
            //asking for monkey height
            System.out.println("What is the monkey's height?");
            String height = scnr.nextLine();
            //asking for monkey body length 
            System.out.println("What is the monkey's body length?");
            String bodyLength = scnr.nextLine();
            //asking for monkey species 
            String species = "";
            // used a while loop with if else if to check to see if user entered a correct species
            var monkeySpeciesName = false;
            while(!monkeySpeciesName) {
            	
            	System.out.println("What is the monkey's species? Please enter the following species below with no space before or after.");
            	System.out.println("Species List: Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin");
            	String userSpecies = scnr.nextLine();
   
            	if (userSpecies.equalsIgnoreCase("Capuchin")) {
            		species = userSpecies; 
            		monkeySpeciesName = true;          		
            	}
            	else if (userSpecies.equalsIgnoreCase("Guenon")) {
            		species = userSpecies;
            		monkeySpeciesName = true;          		
            	}
            	else if (userSpecies.equalsIgnoreCase("Macaque") ) {
            		species = userSpecies;
            		monkeySpeciesName = true;       		
            	}
            	else if (userSpecies.equalsIgnoreCase("Marmoset")) {
            		species = userSpecies;
            		monkeySpeciesName = true;          		
            	}
            	else if (userSpecies.equalsIgnoreCase("Squirrel monkey")) {
            		species = userSpecies;
            		monkeySpeciesName = true;	
            	}
            	else if (userSpecies.equalsIgnoreCase("Tamarin")) {
            		species = userSpecies;
            		monkeySpeciesName = true;
            	}
            	else {
            		System.out.println("you did not select a vaild monkey species, please hit enter and select a valid species");
            		scnr.nextLine();
            	}
            }
        
            //asking for monkey gender 
            System.out.println("What is the monkey's gender?");
            String gender = scnr.nextLine();
            //asking for monkey age
            System.out.println("What is the monkey's age?");
            String age = scnr.nextLine();
            //asking for monkey weight
            System.out.println("What is the monkey's weight?");
            String weight = scnr.nextLine();
            // asking for monkey acquisition date 
            System.out.println("What is the monkey's acquisition date?");
            String acquisitionDate = scnr.nextLine();
            //asking for monkey acquisition location
            System.out.println("What is the monkey's acquisition location?");
            String acquisitionLocation = scnr.nextLine();
            //asking for monkey training status making sure user answer is valid because it impacts other reports
            
            String trainingStatus = "";
            var monkeyTrainingStatus = false;
            while(!monkeyTrainingStatus) {
            	System.out.println("What is the monkey's training status?");
            	System.out.println("Please enter the following with no space before or after: (in progress) or (in service)");
            	String mkTrainingStatus = scnr.nextLine();
            	if (mkTrainingStatus.equalsIgnoreCase("in progress")) {
            		trainingStatus = mkTrainingStatus;
            		monkeyTrainingStatus = true;
            	}
            	else if(mkTrainingStatus.equalsIgnoreCase("in service")) {
            		trainingStatus = mkTrainingStatus;
            		monkeyTrainingStatus = true;
            		
            	} 
            	else {
            		System.out.println("please enter a valid response, press enter to continue");
            		scnr.nextLine();
            	}
            }
            //asking for monkey reserved making sure user answer is valid because this impacts other reports 
            boolean reserved = true;
            var isReserved = false;
            while(!isReserved) {
            	System.out.println("Is the monkey reserved?");
            	System.out.println("Enter true or false with no space before or after");
            	String mkReserved = scnr.nextLine();
            	if (mkReserved.equalsIgnoreCase("true")) {
            		reserved = true;
            		isReserved = true;
            	}
            	else if (mkReserved.equalsIgnoreCase("false")) {
            		reserved = false;
            		isReserved = true;
            	}
            	else {
            		System.out.println("please input a valid answer of true or false, press enter to continue");
            		scnr.nextLine();
            	}
            	
            }
            
            //asking what county the monkey is in service at 
            System.out.println("What is the monkey's service country?");
            String inServiceCountry = scnr.nextLine();
            
            //this is creating a new monkey instance from what the user entered and adds to the monkey list
            Monkey monkey = new Monkey(name, tailLength, height, bodyLength, species, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceCountry);
            monkeyList.add(monkey);
            
            // print statement out that monkey has been added 
            System.out.println("");
            System.out.println("Monkey has been added");
            System.out.println("Please press enter to return to the menu.");
            scnr.nextLine();
            
        }

        
        // Finds animal by type and service country 
        public static void reserveAnimal(Scanner scnr) {
    
            System.out.println("Please enter animal type: ");
            String animalType = scnr.nextLine();
            //checks on if monkey and what country it is in service in and set reserve to true if it is in our list
            if (animalType.equalsIgnoreCase("Monkey")) {
            	System.out.println("Please enter the monkey's service country: ");
            	String inServiceCountry = scnr.nextLine();
            	for (Monkey monkey: monkeyList) {
            		if(monkey.getInServiceLocation().equalsIgnoreCase(inServiceCountry)){
            			monkey.setReserved(true);
            			System.out.println();
            			System.out.println("The monkey you have entered is now reserved! ");
            			System.out.println("Please press enter to return to the menu.");
            			scnr.nextLine();
            			return;
            		}
            	}    	
            //Checks on if dog and what country it is in service in and set reserve to true if it is in our list
            }
            else if (animalType.equalsIgnoreCase("Dog")) {
            	System.out.println("Please enter the dog's service country: ");
            	String inServiceCountry = scnr.nextLine();
            	for(Dog dog: dogList) {
            		if (dog.getInServiceLocation().equalsIgnoreCase(inServiceCountry)) {
            			dog.setReserved(true);
            			System.out.println("");
            			System.out.println("The dog you have entered is now reserved! "); 
            			System.out.println("Please press enter to return to the menu");
            			scnr.nextLine();
            			return;
            		}
            	}
  
            	scnr.nextLine();
          
            	//if animal type or service county can not be found return error message 
            }
            else {
            	System.out.println("Sorry the animal type you have entered can not be found");
            	System.out.println("Please press enter to return to the menu");
            	scnr.nextLine();
            }
        }

       // will print all the dogs, monkey, and also all animals not reserved and in service
        public static void printAnimals(String menuChoice) {
        	
    		//search through dog list array and get the dog items for name, status, acquisition country and reserve status  
        	if (menuChoice == "4") {
            	for(int i = 0; i<dogList.size(); ++i) {
            		System.out.println("Name: " + dogList.get(i).getName() + " | Training Status: " + dogList.get(i).getTrainingStatus() + " | Acquisition Country: " + dogList.get(i).getAcquisitionLocation() + "| Reservation Status: " + dogList.get(i).getReserved());
            	}
            	System.out.println("Please press enter to return to the menu");
            	scnr.nextLine();
        	}
        	
        	//Search through monkey list array and get the monkey item for name, status, acquisition country and reserve status 
        	if (menuChoice == "5") {
        		for (int i = 0; i<monkeyList.size(); ++i) {
        			System.out.println("Name: " + monkeyList.get(i).getName() + " | Training Status: " + monkeyList.get(i).getTrainingStatus() + " | Acquisition Country: " + monkeyList.get(i).getAcquisitionLocation() + " | Reservation Status: " + monkeyList.get(i).getReserved());
        		}
        		System.out.println("Please press enter to return to the menu");
        		scnr.nextLine();
        	}
        	
        	// prints both dogs and monkeys that training status is "in service" and not reserved 
        	if(menuChoice == "6") {
        		// checks to make sure dog is in service and and reserved is false 
                for (int i = 0; i<dogList.size(); ++i) {
                	if(dogList.get(i).getTrainingStatus() == "in service" && dogList.get(i).getReserved() == false ) {
                		System.out.println("Name: " + dogList.get(i).getName() + " | Training Status: " + dogList.get(i).getTrainingStatus() + " | Reservation Status: " + dogList.get(i).getReserved() + " | Country Location: " + dogList.get(i).getInServiceLocation());
                	}
                	
                	
                }
                // checks to make sure monkey is in service and reserved is false
                for(int i = 0; i<monkeyList.size(); ++i) {
                	if(monkeyList.get(i).getTrainingStatus() == "in service" && monkeyList.get(i).getReserved() == false) {
                		System.out.println("Name: " + monkeyList.get(i).getName() + " | Training Status: " + monkeyList.get(i).getTrainingStatus() + " | Reservation Status: " + monkeyList.get(i).getReserved() + " | Country Location: " + monkeyList.get(i).getInServiceLocation());
                          
                		}	
                }
                System.out.println("please press enter to return to the menu");
               scnr.nextLine();
        	}
        	
        	
        }
        
}


