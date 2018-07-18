public class Board {
    final int N = 3;
    final char EMPTY = ' ';
    final char X = 'X';
    final char O = 'O';
   
    private char[][] grid;
    private char currentPlayer;

    public Board() {
        grid = new char[N][N]; 
        reset();
    }

    public void print() {
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (c > 0) {
                    System.out.print('|');
                }
                System.out.print(grid[r][c]);
            }
            System.out.println();
        }
    }

    public void reset() {
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                grid[r][c] = EMPTY;
            }
        }
        currentPlayer = X; // For now
    }

    private boolean didPlayerWin(char p) {
    	if (grid[0][0] == p && grid[0][1] == p && grid[0][2] == p) return true;
    	if (grid[1][0] == p && grid[1][1] == p && grid[1][2] == p) return true;
    	if (grid[2][0] == p && grid[2][1] == p && grid[2][2] == p) return true;
    	if (grid[0][0] == p && grid[1][0] == p && grid[2][0] == p) return true;
    	if (grid[0][1] == p && grid[1][1] == p && grid[2][1] == p) return true;
    	if (grid[0][2] == p && grid[1][2] == p && grid[2][2] == p) return true;
    	if (grid[0][0] == p && grid[1][1] == p && grid[2][2] == p) return true;
    	if (grid[2][0] == p && grid[1][1] == p && grid[0][2] == p) return true;
    	return false;
    }
    
    public char getCurrentPlayer() {
    	return currentPlayer;
    }
    
    private void switchPlayer() {
    	if (currentPlayer == 'X') {
    		currentPlayer = O;
    	} else {
    		currentPlayer = X;
    	}
    }
    
    public boolean didXWin() {
    	return didPlayerWin(X);
    }

    public boolean didOWin() {
    	return didPlayerWin(O);
    }

    public boolean isDraw() {
        return isBoardFull() && !didXWin() && !didOWin();
    }
    
    public boolean isGameOver() {
    	return didXWin() || didOWin() || isDraw();
    }

    public boolean isBoardFull() {
    	if (grid[0][0] == EMPTY) return false;
    	if (grid[0][1] == EMPTY) return false;
    	if (grid[0][2] == EMPTY) return false;
    	if (grid[1][0] == EMPTY) return false;
    	if (grid[1][1] == EMPTY) return false;
    	if (grid[1][2] == EMPTY) return false;
    	if (grid[2][0] == EMPTY) return false;
    	if (grid[2][1] == EMPTY) return false;
    	if (grid[2][2] == EMPTY) return false;
    	return true;
    }

    public boolean putMark(int r, int c) {
        if (grid[r][c] == EMPTY) {
            grid[r][c] = currentPlayer;
            switchPlayer();
            return true;
        }
        return false;
    }
}
