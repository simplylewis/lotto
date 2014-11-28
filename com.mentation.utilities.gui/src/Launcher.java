import javax.swing.JFrame;

public class Launcher {	
	
	private JFrame _app = null;
	
	public Launcher(JFrame app) {
		_app = app;
	}

	public void launch() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				// Display the application
				_app.pack();
				_app.setVisible(true);
				
				// Make sure we have nice window decorations.
				JFrame.setDefaultLookAndFeelDecorated(true);

				// And good behaviour if the window is closed 
				_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}
