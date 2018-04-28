package Tetris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tetris extends JFrame {
	int numLinesDestroyed = 0;
	JLabel statusbar;
	JPanel panel;
	Board board;
	Board board2;
	TAdapter input;

	public Tetris() {
		statusbar = new JLabel(" 0");
		board = new Board(this, 0);
		board.playSound("../Tetris/tetristheme (1).wav");
		setSize(400, 400);
		setTitle("Tetris");
		board.setPreferredSize(new Dimension(200, 400));
		add(board, BorderLayout.NORTH);
		add(statusbar, BorderLayout.SOUTH);
		board2 = new Board(this, 1);
		board2.setPreferredSize(new Dimension(200, 400));
		add(board2, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		pack();
		input = new TAdapter(board, board2);
		board.addKeyListener(input);
		board.start();
		board2.start();
	}

	public TAdapter getInput() {
		return input;
	}

	public void setInput(TAdapter input) {
		this.input = input;
	}

	public void increaseScore() {
		numLinesDestroyed++;
		statusbar.setText(numLinesDestroyed + "");
	}

	public void setBadScore() {
		statusbar.setText("BAD! Score: " + String.valueOf(numLinesDestroyed));
	}

	public JLabel getStatusBar() {
		return statusbar;
	}

	public void stopGame(Board b) {
		board.stopGame();
		board2.stopGame();
		if(b.getControls()==0) {
		JOptionPane.showMessageDialog(null, "The player on the Left side "
				+ "screwed you up\n Your score is: " + String.valueOf(numLinesDestroyed));
		System.exit(0);
		}
		else {
			JOptionPane.showMessageDialog(null, "The player on the Right  side "
					+ "screwed you up\n Your score is: " + String.valueOf(numLinesDestroyed));
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		Tetris game = new Tetris();
		game.setLocationRelativeTo(null);
		game.setVisible(true);

	}
}
