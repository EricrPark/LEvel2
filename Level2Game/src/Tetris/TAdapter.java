package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import Tetris.Shape.Tetrominoes;

class TAdapter extends KeyAdapter{
	Board board;
	Board board2;

	public TAdapter(Board board, Board board2) {
		super();
		this.board = board;
		this.board2 = board2;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (!board.isStarted || board.getCurPiece().getShape() == Tetrominoes.NoShape) {
			return;
		}

		int keycode = e.getKeyCode();
		System.out.println(board.getControls());
		if (keycode == 'p' || keycode == 'P') {
			board.pause();
			return;
		}

		if (board.isPaused)
			return;
		if (board.getControls() == 0) {
			switch (keycode) {
			case KeyEvent.VK_LEFT:
				board.tryMove(board.getCurPiece(), board.getCurX() - 1, board.getCurY());
				break;
			case KeyEvent.VK_RIGHT:
				board.tryMove(board.getCurPiece(), board.getCurX() + 1, board.getCurY());
				break;
			case KeyEvent.VK_DOWN:
				board.tryMove(board.getCurPiece().rotateRight(), board.getCurX(), board.getCurY());
				break;
			case KeyEvent.VK_UP:
				board.tryMove(board.getCurPiece().rotateLeft(), board.getCurX(), board.getCurY());
				break;
			case KeyEvent.VK_SPACE:
				board.dropDown();
				break;
			case 'm':
				board.oneLineDown();
				break;
			case 'M':
				board.oneLineDown();
				break;
			}
		}
		if (board.getControls() == 1) {
			switch (keycode) {
			case KeyEvent.VK_A:
				board.tryMove(board.getCurPiece(), board.getCurX() - 1, board.getCurY());
				break;
			case KeyEvent.VK_D:
				board.tryMove(board.getCurPiece(), board.getCurX() + 1, board.getCurY());
				break;
			case KeyEvent.VK_S:
				board.tryMove(board.getCurPiece().rotateRight(), board.getCurX(), board.getCurY());
				break;
			case KeyEvent.VK_W:
				board.tryMove(board.getCurPiece().rotateLeft(), board.getCurX(), board.getCurY());
				break;
			case KeyEvent.VK_Q:
				board.dropDown();
				break;
			case 'r':
				board.oneLineDown();
				break;
			case 'R':
				board.oneLineDown();
				break;
			}
		}

	}
}