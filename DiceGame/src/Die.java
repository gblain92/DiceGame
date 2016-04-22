import java.util.*;

public class Die {

	protected int numOfSides;
	public int roll;
	public Random rand = new Random();
	
	public Die() {
		
		this.numOfSides = 6;
		this.roll = 0;
		
	}
	
	//Generate random number to imitate rolling a die
	public int diceRoll() {
		
		roll = rand.nextInt(numOfSides) + 1; 
		return roll;
		
	}
	
	//Users can alter the amount of sides on the die
	public void setSide(int sides) {
		
		numOfSides = sides;
		
	}
	
}
