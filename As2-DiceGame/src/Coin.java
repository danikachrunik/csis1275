import java.util.Random;

/**
 * Sources:
 * http://www.java2s.com/Tutorials/Java/java.util/Random/Java_Random_nextBoolean_.htm
 */

/**
 * The Coin class represents a single coin which can be flipped to
 * produce a heads or tails result.
 */
public class Coin
{
	/**
	 * The output of a coin flip if the result is heads.
	 */
	public static final String HEADS = "Heads";
	
	/**
	 * The output of a coin flip if the result is tails.
	 */
	public static final String TAILS = "Tails";
	
	/**
	 * The pseudo-random number generator used to produce the flips
	 * of the coin.
	 */
	private Random prng;
	
	/**
	 * Constructs a new Coin object, with the default pseudo-random
	 * seed value.
	 */
	public Coin()
	{
		this.prng = new Random();
	}
	
	/**
	 * Flips the coin, producing a heads or tails result.
	 * 
	 * @return Coin.HEADS if the result of the flip is a heads, or
	 * Coin.TAILS otherwise.
	 */
	public String flip()
	{
		/*
		 * FIXME #2: Poll the pseudo-random number generator field
		 * of this Coin for a boolean value. Use it to decide whether
		 * to return HEADS or TAILS.
		 * 
		 * Hint: look to the Oracle documentation on the Java Standard
		 * API for the Random class. How might you get a random boolean
		 * (true or false) value?
		 */
		boolean randomBool = prng.nextBoolean();
		
		if(randomBool) {
			return HEADS;
		} else {
			return TAILS;
		}

	}
}
