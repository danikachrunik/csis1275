import javax.swing.JOptionPane;

/**
 * Sources:
 * https://www.daniweb.com/programming/software-development/threads/176939/catching-cancel-in-joptionpane
 * http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
 * http://stackoverflow.com/questions/9625663/calculating-and-printing-the-nth-prime-number
 */


/**
 * The Prime class represents an application that can be executed to determine
 * the nth prime number (where 2 is the first prime number, 3 is the second,
 * and so forth).
 */
public class Prime
{
	/**
	 * The first prime number.
	 */
	private static final int FIRST_PRIME = 2;
	
	/**
	 * The question to pose to the user, when the user is to input a value n
	 * (in order to see the nth prime).
	 */
	private static final String QUESTION = "Enter n to see the nth prime:";
	
	/**
	 * The format String, representing an error to be displayed to the user
	 * if they input a value less than or equal to zero for n (when asking
	 * to see the nth prime).
	 */
	private static final String ERROR_FORMAT =
			"There is no such thing as the %dth prime.";
	
	/**
	 * The format String, representing how the answer is to be formatted to
	 * the user: e.g., "The 5th prime is 11".
	 */
	private static final String ANSWER_FORMAT = "The %d%s prime is %d";
	
	/**
	 * The letters to put after the number 1, in "1st".
	 */
	private static final String POSTFIX_ONE = "st";
	
	/**
	 * The letters to put after the number 2, in "2nd".
	 */
	private static final String POSTFIX_TWO = "nd";
	
	/**
	 * The letters to put after the number 3, in "3rd".
	 */
	private static final String POSTFIX_THREE = "rd";
	
	/**
	 * The letters to put after any number other than 1, 2, or 3, as in "9th".
	 */
	private static final String POSTFIX_OTHER = "th";
	
	/**
	 * Executes an application which repeatedly asks the user to input n into
	 * a dialog box, and replies with another dialog box containing the nth
	 * prime number. The program exits when the user cancels.
	 * 
	 * @param args the command-line arguments passed to the JVM, which are
	 * ignored by this application.
	 */
	public static void main(String[] args)
	{
		/*
		 * FIXME #6: We should ask the user repeatedly for a value n, and
		 * display the nth prime, instead of just asking once.
		 */
		
		/*
		 * FIXME #7: If the user clicks cancel in this dialog box, it seems
		 * to crash the application.
		 */
		boolean cancelled = false;
		do {
			try {
				String input = JOptionPane.showInputDialog(Prime.QUESTION);
				int value = Integer.parseInt(input);
				if (value > 0)
					Prime.displayPrime(value);
		
				/*
				 * FIXME #5: Display an error message, using ERROR_FORMAT as a format
				 * String, if the user asks for the 0th prime, the -1th prime, the
				 * -2th prime, etc.
				 */
				if (value < 0) {
					JOptionPane.showMessageDialog(null, String.format(ERROR_FORMAT, value), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e) {
				cancelled = true;
			}
		} while (!cancelled);

		System.exit(0);
	}
	
	/**
	 * Displays a dialog box describing the the nth prime number.
	 * 
	 * @param nth which prime number to display. Note that this parameter
	 * refers to which prime number to display, not the value to display. So,
	 * if nth is equal to 4, the 4th prime number (with the value of 7) should
	 * be displayed.
	 */
	private static void displayPrime(int nth)
	{
		String postfix;
		int primeValue;
		
		/*
		 * FIXME #3: Something seems to be going wrong with this switch
		 * statement, but I can't figure out what. Can someone pass this
		 * problem off to one of those bright CSIS 1275 students to figure
		 * out?
		 */
		switch (nth) {
		case 1:
			postfix = Prime.POSTFIX_ONE;
			break;
		case 2:
			postfix = Prime.POSTFIX_TWO;
			break;
		case 3:
			postfix = Prime.POSTFIX_THREE;
			break;
		default:
			postfix = Prime.POSTFIX_OTHER;
			break;
		}
		
		primeValue = Prime.getPrime(nth);
		
		/*
		 * FIXME #4: Use ANSWER_FORMAT as a format String to create the output
		 * that will be displayed in a dialog box, instead of using this terrible
		 * output.
		 */
		String output = String.format(ANSWER_FORMAT, nth, postfix, primeValue);
		JOptionPane.showMessageDialog(null, output);
	}

	/**
	 * Returns the nth prime number.
	 * 
	 * @param nth which prime number should be returned. Note that this
	 * parameter refers to which prime number to return, not the value to
	 * return. So, if nth is equal to 4, the 4th prime number (with the value
	 * of 7) should be returned.
	 * @return the nth prime number, where the 1st prime number is
	 * Prime.FIRST_PRIME.
	 */
	private static int getPrime(int nth)
	{
		int valueToTest = Prime.FIRST_PRIME;
		
		while(true) {
			/*
			 * FIXME #2: Starting with FIRST_PRIME, test every integer (in
			 * ascending order) to see if it is prime by calling isPrime(int).
			 * Once you find the nth number that is prime, return it.  
			 */
			for(int primesFound = 0; primesFound < nth; ++valueToTest)
			if(isPrime(valueToTest)) {
				++primesFound;
			}			
	        return valueToTest-1;
		}	
	}
	
	/**
	 * Tests whether the given number is a prime number. It is assumed that
	 * the given parameter is greater than or equal to Prime.FIRST_PRIME.
	 * 
	 * @param num the number to test, regarding whether or not it is prime.
	 * This value is assumed to be greater than or equal to Prime.FIRST_PRIME.
	 * @return true if the given value if prime, or false if the given value
	 * is composite (non-prime). 
	 */
	private static boolean isPrime(int num)
	{
		/*
		 * FIXME #8: Compute maxTest, the maximal value we must test for whether
		 * it divides num, in order to tell if num is prime. On the assignment sheet,
		 * maxTest is defined as m(n), i.e., the floor of the square root of num.
		 * 
		 * Hint: look to Oracle's documentation on the Standard Java API class
		 * called Math for methods to compute floors and/or square roots.
		 * 
		 * Hint: what types do the Math class' methods that computes floors and
		 * square roots return? We'll need to do something to the return of at least
		 * one of those methods to store the value we want in the maxTest variable.
		 */
		int maxTest = (int) Math.floor(Math.sqrt(num));
		
		/*
		 * FIXME #1: Test every value, v, between FIRST_PRIME and maxTest to see if
		 * v divides num. If any value v between FIRST_PRIME and maxTest does divide
		 * num, return that num is not prime.
		 * 
		 * Hint: recall that (x % y) computes the remainder when x is divided by y.  
		 */
		for (int v = FIRST_PRIME; v <= maxTest; v++) {
			if (num % v == 0) {
				return false;
			} 
		}
		return true;
	}
}