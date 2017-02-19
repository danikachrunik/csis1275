import java.util.Random;

/**
 * Sources:
 * 
 */

/**
 * The Die class represents a single die (the singular form of the
 * word "dice") that can be rolled to produce a random result.
 */
public class Die
{
	/**
	 * The number of sides on a single die.
	 */
	public static final int NUM_SIDES = 6;
	
	/**
	 * The pseudo-random number generator used to produce the rolls
	 * of the die.
	 */
	private Random prng;

	/**
	 * Constructs a new Die object, with the default pseudo-random
	 * seed value.
	 */
	public Die()
	{
		/*
		 * FIXME #3: Initialize the fields for this Die.
		 * 
		 * Hint: look to the Coin class as an example.
		 */
		this.prng = new Random();
	}
	
	/**
	 * Rolls the die once, returning a uniformly distributed value
	 * between 1 and the number of sides on the die (inclusive).
	 * 
	 * @return a value between 1 and Die.NUM_SIDES (inclusive).
	 */
	public int roll()
	{
		/*
		 * FIXME #4: Return a uniformly distributed value between
		 * 1 and NUM_SIDES. You will need to poll the pseudo-random
		 * number generator field.
		 */
		return prng.nextInt(NUM_SIDES) + 1;
	}
}
