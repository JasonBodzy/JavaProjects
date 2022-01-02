public class GameManager {
    private char[][] board;
    private int currentMove = 1;

    GameManager() {
        this.board = new char[][]{{'-', '-', '-'},
                                  {'-', '-', '-'},
                                  {'-', '-', '-'}};
    }

    public char[][] getBoard() {
        return this.board;
    }

    public int getCurrentMove() {
        return this.currentMove;
    }

    public synchronized void updateBoard(String moveString) {
        int row = Integer.parseInt(moveString.substring(0,1));
        int column = Integer.parseInt(moveString.substring(1,2));
        char c = (moveString.charAt(2));

        this.board[row][column] = c;

        if (this.currentMove == 1) {
            this.currentMove = 2;
        } else if (this.currentMove == 2) {
            this.currentMove = 1;
        }


    }

    public int determineWinner() {
        // Horizontal Wins
        if (this.getBoard()[0][0] != '-') {
            if (this.getBoard()[0][0] == this.getBoard()[0][1] && this.getBoard()[0][0] == this.getBoard()[0][2]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }
        if (this.getBoard()[1][0] != '-') {
            if (this.getBoard()[1][0] == this.getBoard()[1][1] && this.getBoard()[1][0] == this.getBoard()[1][2]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        if (this.getBoard()[2][0] != '-') {
            if (this.getBoard()[2][0] == this.getBoard()[2][1] && this.getBoard()[2][0] == this.getBoard()[2][2]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        // Vertical Wins

        if (this.getBoard()[0][0] != '-') {
            if (this.getBoard()[0][0] == this.getBoard()[1][0] && this.getBoard()[0][0] == this.getBoard()[2][0]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        if (this.getBoard()[0][1] != '-') {
            if (this.getBoard()[0][1] == this.getBoard()[1][1] && this.getBoard()[0][1] == this.getBoard()[2][1]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        if (this.getBoard()[0][2] != '-') {
            if (this.getBoard()[0][2] == this.getBoard()[1][2] && this.getBoard()[0][2] == this.getBoard()[2][2]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        // Diagonal Wins
        if (this.getBoard()[0][0] != '-') {
            if (this.getBoard()[0][0] == this.getBoard()[1][1] && this.getBoard()[0][0] == this.getBoard()[2][2]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        if (this.getBoard()[0][2] != '-') {
            if (this.getBoard()[0][2] == this.getBoard()[1][1] && this.getBoard()[0][2] == this.getBoard()[2][0]) {
                if (this.currentMove == 2) {
                    return 1;
                } else if (this.currentMove == 1) {
                    return 2;
                }
            }
        }

        return 0;

    }
}
