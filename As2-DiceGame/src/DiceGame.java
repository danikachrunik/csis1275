/**
 * The DiceGame class represents the application that can be executed
 * to play a single round of The Dice Game.
 */
public class DiceGame
{
	/**
	 * Plays a single round of The Dice Game.
	 * 
	 * @param args the command-line arguments passed to the JVM.
	 * Ignored by this application.
	 */
	public static void main(String[] args)
	{
		/*
		 * FIXME #1: Call a publicly accessible method on the
		 * newly created Game object to start a single game of
		 * The Dice Game.
		 */
		Game game = new Game();
		game.play();
	}
}
