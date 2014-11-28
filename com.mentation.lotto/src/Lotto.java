public class Lotto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String playGame = args[0];
		Launcher launcher = null;
		
		if (playGame.equals("Lotto")) {
			launcher = new Launcher(new Lottery("Lotto"));
		}

		if (playGame.equals("EuroMillions")) {
			launcher = new Launcher(new EuroMillions("EuroMillions"));
		}
		
		launcher.launch();
	}

} // Lotto
