package Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Multiplayer.ClientPlayer;
import Multiplayer.CreateServer;
import Singleplayer.SinglePlayer;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	int screenWidth = 275;
	int screenHeight = 250;

	int buttonWidth = 100;
	int buttonHeight = 40;

	JButton Play, Host, Connect, Quit;

	public MainMenu() {
		getContentPane().setLayout(null);

		// Calling methods
		addButtons();
		addActions();

		// Setting Bounds and Placing Buttons
		Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight);
		Host.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight);
		Connect.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth, buttonHeight);
		Quit.setBounds((screenWidth - buttonWidth) / 2, 140, buttonWidth, buttonHeight);

		// Placing Buttons
		getContentPane().add(Play);
		getContentPane().add(Quit);
		getContentPane().add(Host);
		getContentPane().add(Connect);

		// JFrame Stuff
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Pong Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	} // End constructor

	// Add buttons to the JFrame
	private void addButtons() {
		Play = new JButton("Play SP");
		Host = new JButton("Host MP");
		Connect = new JButton("Connect");
		Quit = new JButton("Quit");
	} // End addButtons

	// Add actions to the buttons
	private void addActions() {

		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				SinglePlayer sp = new SinglePlayer();

				sp.start();
			}
		});// Play button

		Host.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				new CreateServer();
			}
		}); // Host a server button

		Connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				new ClientPlayer();
			}
		}); // Connect to a server button

		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});// Quit program button

	} // End addActions
} // End the class