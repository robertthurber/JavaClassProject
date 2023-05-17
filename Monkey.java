

// declaring the monkey class
public class Monkey extends RescueAnimal{
	
	//creating variables
	private String tailLength; 
	private String height;
	private String bodyLength;
	private String species;
	
	// create constructor and set each variable 
	public Monkey() {
		tailLength = "";
		height = "";
		bodyLength = "";
		species = "";
	}
	
	public Monkey(String name, String tailLength, String height, String bodyLength, String species, String gender, String age, String weight, String acquisitionDate, String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setTailLength(tailLength);
		setHeight(height);
		setBodyLength(bodyLength);
		setSpecies(species);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);
		
		
		
		
	}
	// Mutator Method for tail length
	public void setTailLength(String monkeyTailLength) {
		tailLength = monkeyTailLength;
	}
	
	// Accessor Method for tail length
	public String getTailLength() {
		return tailLength;
	}
	
	// Mutator Method for height
	public void setHeight(String monekyHeight) {
		height = monekyHeight;
	}
	
	// Accessor Method for height
	public String getHeight() {
		return height;
	}
	
	// Mutator Method for body length 
	public void setBodyLength(String monkeyBodyLength) {
		bodyLength = monkeyBodyLength;
	}
	
	// Accessor Method for body length
	public String getBodyLength() {
		return bodyLength;
	}
	
	// Mutator Method for species
	public void setSpecies(String monkeySpecies) {
		species = monkeySpecies;
	}
	
	// Accessor Method for body length
	public String getSpecies() {
		return species; 
	}
	
}
