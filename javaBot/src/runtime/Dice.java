package runtime;

public class Dice {

	public Dice() {}
	
	public int rollDice(int sides) {
		return (int) (Math.random() * sides) + 1;
	}
}
