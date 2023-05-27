package ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI  {
    private static final int BOARD_SIZE = 3;

    private JFrame frame;
    private JButton[][] buttons;
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGUI () {
        frame = new JFrame("Tic Tac Toe");
        buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = 'X';

        initializeBoard();
        initializeFrame();
    }

    private void initializeBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void initializeFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                JButton button = new JButton();
                button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
                button.addActionListener(new ButtonClickListener(row, col));
                buttons[row][col] = button;
                frame.add(button);
            }
        }

        frame.setSize(300, 300);
        frame.setLocation(500,200);
        frame.setVisible(true);
    }

    private void makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            buttons[row][col].setText(Character.toString(currentPlayer));

            if (haveWon(currentPlayer)) {
                JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " has won!");
                restartGame();
            } else if (isFull()) {
                JOptionPane.showMessageDialog(frame, "It's a draw!");
                restartGame();
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean haveWon(char player) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < BOARD_SIZE; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private boolean isFull() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void restartGame() {
        // Clear the board and reset the current player
        initializeBoard();

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                buttons[row][col].setText(""); // Reset button text
            }
        }

        currentPlayer = 'X';
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            makeMove(row, col);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}
