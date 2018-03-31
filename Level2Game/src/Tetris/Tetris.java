package Tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tetris extends JFrame {

	JLabel statusbar;
	JPanel panel;

	public Tetris() {
		Board board = new Board(this);
		board.playSound("../Tetris/tetristheme (1).wav");
		setSize(400, 400);
		setTitle("Tetris");
		board.setPreferredSize(new Dimension(200, 400));
		add(board, BorderLayout.NORTH);
		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);
		Board board2 = new Board(this);
		board2.setPreferredSize(new Dimension(200, 400));
		add(board2, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		pack();
		board.start();
		board2.start();
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
