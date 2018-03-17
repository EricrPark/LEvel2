package Tetris;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {

	JLabel statusbar;
	static JLabel label;

	public Tetris() {

		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);
		Board board = new Board(this);
		board.playSound("../Tetris/tetristheme (1).wav");
		setSize(200, 400);
		setTitle("Tetris");
		add(board);
		label = new JLabel();
		add(label, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		board.start();
	}

	public JLabel getStatusBar() {
		return statusbar;
	}

	public static void main(String[] args) {

		Tetris game = new Tetris();
		game.setLocationRelativeTo(null);
		game.setVisible(true);

	}
}
