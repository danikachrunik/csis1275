import java.util.Scanner;

/**
 * The HumanPlayer class represents the human-controlled player
 * in The Dice Game.
 */
public class HumanPlayer
{
	/**
	 * The format-String for the message displaying the player's
	 * current score.
	 */
	private static final String CURRENT_SCORE_FORMAT =
			"Your current score is %d%n";
	
	/**
	 * The prompt to be output asking whether the user would like
	 * roll the dice (instead of showing).
	 */
	private static final String ROLL_AGAIN_QUESTION =
			"Do you want to roll the dice: ";
	
	/**
	 * If the first character of the response input by the user
	 * is this character, interpret the response as "Yes".
	 */
	private static final char YES_INPUT_1 = 'Y';

	/**
	 * If the first character of the response input by the user
	 * is this character, interpret the response as "Yes".
	 */
	private static final char YES_INPUT_2 = 'y';
	
	/**
	 * If the first character of the response input by the user
	 * is this character, interpret the response as "No".
	 */
	private static final char NO_INPUT_1 = 'N';
	
	/**
	 * If the first character of the response input by the user
	 * is this character, interpret the response as "No".
	 */
	private static final char NO_INPUT_2 = 'n';
	
	/**
	 * The human player's current score.
	 */
	private int score;
	
	/**
	 * A Scanner on standard input, which is where the human player
	 * provides their input on whether or not to roll the dice (as
	 * opposed to showing).
	 */
	private Scanner kb;
	
	/**
	 * Creates a new human player, initializing the user's score to
	 * zero and opening a Scanner on standard input.
	 */
	public HumanPlayer()
	{
		/*
		 * FIXME #5: Initialize the human player's score to zero, and
		 * open a Scanner on standard input from which we can read all
		 * of the user's keyboard input (no need to open a new Scanner
		 * every time it's the player's turn).
		 * 
		 * Hint: look to the ComputerPlayer constructor.
		 */
		this.score = 0;
		this.kb = new Scanner(System.in);		
	}
	
	/**
	 * Returns the human player's current score.
	 * 
	 * @return the human player's current score.
	 */
	public int getScore()
	{
		/*
		 * FIXME #6: Write the getter method for returning the human
		 * player's current score.
		 */
		return this.score;
	}
	
	/**
	 * Adds the given value to the human player's current score.
	 * 
	 * @param value the amount to add to the human player's current
	 * score.
	 */
	public void addToScore(int value)
	{
		/*
		 * FIXME #7: Write the mutator method for increasing the
		 * human player's current score.
		 */
		this.score += value;
	}


	/**
	 * Asks the human player whether or not to roll, as opposed to
	 * showing. First, output the player's current score. Then,
	 * repeatedly ask the user whether or not they want to roll,
	 * until they input a line starting with YES_INPUT_1,
	 * YES_INPUT_2, NO_INPUT_1, or NO_INPUT_2.
	 * 
	 * @return true if the human player elects to roll, false
	 * otherwise.
	 */
	public boolean wantsToRoll()
	{
		System.out.format(HumanPlayer.CURRENT_SCORE_FORMAT, this.score);
		
		while (true) {
			System.out.print(HumanPlayer.ROLL_AGAIN_QUESTION);
			String input = this.kb.nextLine();
			
			/*
			 * FIXME #12: Keep asking the user for input until the first character
			 * of their input matches one of YES_INPUT_1, YES_INPUT_2, NO_INPUT_1,
			 * or NO_INPUT_2.
			 * 
			 * You *MUST* use a switch statement to receive full marks.
			 * 
			 * Hint: do not forget to consider all possible inputs that the user
			 * could provide. Depending on how you choose to address certain user
			 * inputs, you may find the "continue" command helpful, to return to
			 * the top of the loop under a certain condition.
			 * 
			 * Hint: You can execute a return command anywhere, even inside
			 * of a case in a switch.
			 */
			if(input.length() <= 0) {
				continue;
			} else {
				switch(input.charAt(0)) {
				case YES_INPUT_1:
					return true;
				case YES_INPUT_2:
					return true;
				case NO_INPUT_1:
					return false;
				case NO_INPUT_2:
					return false;
				default:
					continue;
				}
			}
		}
	}
}