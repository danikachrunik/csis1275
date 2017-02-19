/**
 * The ComputerPlayer class represents a computer opponent to the
 * human player in The Dice Game.
 */
public class ComputerPlayer
{	
	/**
	 * The message informing the user that the computer player has
	 * elected to roll the dice.
	 */
	private static final String PLAY_ROLL =
			"The computer player chooses to roll the dice";
	
	/**
	 * The message informing the user that the computer player has
	 * elected to show.
	 */
	private static final String PLAY_SHOW =
			"The computer player chooses to show";
	
	/**
	 * The minimal current number of points the computer player must
	 * have before it elects to show.
	 */
	private static int MIN_SHOW = 15;
	
	/**
	 * The maximal current number of points the computer player may
	 * have and still show. Beyond this number of points, the computer
	 * player will always elect to roll, subject to MAX_ROLLS below.
	 */
	private static int MAX_SHOW = 21;
	
	/**
	 * The maximum number of times that the computer player will roll
	 * before showing. If the computer player has already rolled
	 * MAX_ROLLS times, the human player is guaranteed to have more
	 * than the maximum number of points allowed, so showing will
	 * end the game at a guaranteed draw.
	 */
	private static int MAX_ROLLS = 11;
	
	/**
	 * The computer player's current score.
	 */
	private int score;
	
	/**
	 * The number of times that the computer player has rolled.
	 */
	private int rolls;
	
	/**
	 * Constructs a new computer player with a current score of zero.
	 */
	public ComputerPlayer()
	{
		this.score = 0;
		this.rolls = 0;
	}
	
	/**
	 * Returns the computer player's current score.
	 * 
	 * @return the computer player's current score.
	 */
	public int getScore()
	{
		return this.score;
	}
	
	/**
	 * Adds the given value to the computer player's current score.
	 * 
	 * @param value the amount to add to the computer player's current
	 * score.
	 */
	public void addToScore(int value)
	{
		this.score += value;
	}
	
	/**
	 * Makes the computer player decide whether or not to roll.
	 * Outputs a message to the user indicating whether the computer
	 * player elected to roll or to show.
	 * 
	 * @return true if the computer player elects to roll, false
	 * otherwise.
	 */
	public boolean wantsToRoll()
	{
		/*
		 * FIXME #13: Implement the computer AI.
		 * 
		 * If the computer has already executed MAX_ROLLS rolls, it must
		 * show.
		 * 
		 * Otherwise, the computer will show if and only if its score is
		 * between MIN_SHOW and MAX_SHOW, inclusive.
		 * 
		 * You must output either PLAY_SHOW or PLAY_ROLL, to indicate which
		 * action the computer player is taking.
		 */
		if (rolls >= MAX_ROLLS) {
			System.out.println(ComputerPlayer.PLAY_SHOW);
			return false;
		} else if (this.score >= MIN_SHOW && this.score <= MAX_SHOW) {
			System.out.println(ComputerPlayer.PLAY_SHOW);
			return false;
		}
		System.out.println(ComputerPlayer.PLAY_ROLL);
		return true;
	}
}