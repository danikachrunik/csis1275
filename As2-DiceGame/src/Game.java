/**
 * The Game class represents a single play-through of The Dice Game,
 * with one human player facing off against one computer-controlled
 * player.
 */
public class Game
{
	/**
	 * The message output if the initial coin flip indicates that
	 * the human player goes first.
	 */
	private static final String COIN_HUMAN =
			"The coin flip is heads; the human player starts";
	
	/**
	 * The message output if the initial coin flip indicates that
	 * the computer player goes first. 
	 */
	private static final String COIN_COMPUTER =
			"The coin flip is tails; the computer player starts";
	
	/**
	 * The format-String for the message output to the human player
	 * indicating the results of their roll.
	 */
	private static final String HUMAN_ROLL_FORMAT =
			"You roll a %d and a %d%n";
	
	/**
	 * The format-String for the message indicating the human player's
	 * final score at the end of the game.
	 */
	private static final String HUMAN_SCORE_FORMAT =
			"The human player scores: %d%n";
	
	/**
	 * The format-String for the message indicating the computer player's
	 * final score at the end of the game.
	 */
	private static final String COMPUTER_SCORE_FORMAT =
			"The computer player scores: %d%n";
	
	/**
	 * The final message output, indicating that the human player won
	 * the game.
	 */
	private static final String HUMAN_WINS = "The human wins!";
	
	/**
	 * The final message output, indicating that the computer player won
	 * the game. 
	 */
	private static final String COMPUTER_WINS = "The computer wins!";
	
	/**
	 * The final message output, indicating that the game ended in a
	 * draw.
	 */
	private static final String DRAW = "It's a draw";
	
	/**
	 * The maximal valid score that any player can have without being
	 * considered "over".
	 */
	private static final int MAX_SCORE = 21;
	
	/**
	 * The human player, playing on one side of The Dice Game.
	 */
	private HumanPlayer human;
	
	/**
	 * The computer player, playing on the other side of The Dice Game.
	 */
	private ComputerPlayer computer;
	
	/**
	 * One of the two dice that will be rolled by the players.
	 */
	private Die dieOne;
	
	/**
	 * The other of the two dice that will be rolled by the players.
	 */
	private Die dieTwo;
	
	private boolean show;
	
	/**
	 * Creates a new Game object, initializing the two players and the
	 * two dice objects.
	 */
	public Game()
	{
		this.human = new HumanPlayer();
		this.computer = new ComputerPlayer();
		
		this.dieOne = new Die();
		this.dieTwo = new Die();
	}
	
	/**
	 * Plays a single game of The Dice Game, with one human-controlled
	 * player playing against one computer-controlled player.
	 */
	public void play()
	{
		/*
		 * Create and flip a coin to determine which player goes first.
		 */
		boolean playerTurn;
		/*
		 * FIXME #8: Create a coin object and flip it. If the result is
		 * Coin.HEADS, then the human player goes first. Otherwise,
		 * the computer player goes first. Output who goes first, and
		 * set playerTurn accordingly.
		 */
		Coin coin = new Coin();
		String toss = coin.flip();
		if(toss == Coin.HEADS) {
			System.out.println(Game.COIN_HUMAN);
			playerTurn = true;
		} else {
			System.out.println(Game.COIN_COMPUTER);
			playerTurn = false;
		}
		
		/*
		 * The players alternate turns until someone elects to perform
		 * a "Show" on their turn instead of a "Roll".
		 */
		/*
		 * FIXME #9: Keep alternating turns until someone chooses to
		 * show on their turn.
		 * 
		 * Hint: the code provided below will have to be wrapped in a loop.
		 * But, how and when should you terminate that loop?
		 */
		do {
			if (playerTurn) {
				this.playHumanTurn();
			} else {
				this.playComputerTurn();
			}
			playerTurn = !playerTurn;
		} while(!show);
		
		/*
		 * Output the two players' scores.
		 */
		System.out.println(String.format(HUMAN_SCORE_FORMAT, human.getScore()));
		System.out.println(String.format(COMPUTER_SCORE_FORMAT, computer.getScore()));
		/*
		 * FIXME #10: Output the two players' scores, using
		 * HUMAN_SCORE_FORMAT and COMPUTER_SCORE_FORMAT as format
		 * Strings
		 */
		
		/*
		 * Output who the winner is.
		 */		
		if( (human.getScore() > MAX_SCORE && computer.getScore() > MAX_SCORE)
				|| (human.getScore() == computer.getScore()) ) {
			System.out.println(Game.DRAW);
		} else if (computer.getScore() > MAX_SCORE) {
			System.out.println(Game.HUMAN_WINS);
		} else if (human.getScore() > MAX_SCORE) {
			System.out.println(Game.COMPUTER_WINS);
		} else if (human.getScore() > computer.getScore()) {
			System.out.println(Game.HUMAN_WINS);
		} else {
			System.out.println(Game.COMPUTER_WINS);
		}
		
		/*
		 * FIXME #14: Output one of HUMAN_WINS, COMPUTER_WINS, or
		 * DRAW, based on the human player's final score and the
		 * computer player's final score.
		 * 
		 * Hint: you will need to use the MAX_SCORE constant.
		 */
	}
	
	/**
	 * Plays the human player's turn. First, the human player is asked if
	 * they want to roll the dice. If so, the two dice are rolled, and the
	 * sum of the two dice is added to the human player's score.
	 * 
	 * @return true if the human player rolled the dice, or false if the
	 * human player elected to "Show".
	 */
	private boolean playHumanTurn()
	{
		if (this.human.wantsToRoll()) {
			/*
			 * FIXME #11: Roll the two dice objects.
			 * 
			 * Prior to returning from this method, you *MUST* output the
			 * result of the dice rolls using HUMAN_ROLL_FORMAT as a format
			 * String.
			 * 
			 * You *MUST* also update the human's player's score by calling
			 * HumanPlayer.addToScore(int).
			 */
			int rollOne = this.dieOne.roll();
			int rollTwo = this.dieTwo.roll();
			System.out.print(String.format(HUMAN_ROLL_FORMAT, rollOne, rollTwo));
			this.human.addToScore(rollOne + rollTwo);
			return true;
		}
		else
			show = true;
			return false;
	}
	
	/**
	 * Plays the computer player's turn. The computer AI is called to
	 * determine whether the computer should roll the dice. If so, the
	 * two dice are rolled, and the sum of the two dice is added to the
	 * computer player's score.
	 * 
	 * @return true if the computer player rolled the dice, or false if the
	 * computer player elected to "Show".
	 */
	private boolean playComputerTurn()
	{
		if (this.computer.wantsToRoll()) {
			int add = this.dieOne.roll() + this.dieTwo.roll();
			this.computer.addToScore(add);
			return true;
		}
		else
			show = true;
			return false;
	}
}
