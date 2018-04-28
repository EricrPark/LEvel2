package Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Tetris.Shape.Tetrominoes;

class TAdapter implements KeyListener {
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
			//board.pause();
			board2.pause();
			return;
		}

		if (board.isPaused) {
			return;
		}
		switch (keycode) {
		case KeyEvent.VK_LEFT:
			board2.tryMove(board2.getCurPiece(), board2.getCurX() - 1, board2.getCurY());
			break;
		case KeyEvent.VK_RIGHT:
			board2.tryMove(board2.getCurPiece(), board2.getCurX() + 1, board2.getCurY());
			break;
		case KeyEvent.VK_DOWN:
			board2.tryMove(board2.getCurPiece().rotateRight(), board2.getCurX(), board2.getCurY());
			break;
		case KeyEvent.VK_UP:
			board2.tryMove(board2.getCurPiece().rotateLeft(), board2.getCurX(), board2.getCurY());
			break;
		case KeyEvent.VK_SPACE:
			board2.dropDown();
			break;
		case 'm':
			board2.oneLineDown();
			break;
		case 'M':
			board2.oneLineDown();
			break;
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
		board.requestFocus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}