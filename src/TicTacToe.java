import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        char choice = '_';
        
        while (true) {
            System.out.println("--------------------------------------------------");
            board.print();
            if (board.didXWin()) {
                System.out.println("Player X wins!");
            } else if (board.didOWin()) {
                System.out.println("Player O wins!");
            } else if (board.isDraw()) {
                System.out.println("It's a DRAW!");
            } else {
                System.out.println("Current player is " + board.getCurrentPlayer());
            }
            
            System.out.println("n: new game");
            if (!board.isGameOver()) {
                System.out.println("m: make move");
            }
            System.out.println("q: quit");
            System.out.print("Enter a choice: ");
            String input = in.nextLine();
            if (input.length() == 0) {
                input = in.nextLine();
            }
            choice = input.charAt(0);
            if (choice == 'q') {
                System.out.println("Good-bye!");
                break;
            }
            else if (choice == 'm' && !board.isGameOver()) {
                do {
                    System.out.print("Where do you want to move? Enter row and column: ");
                    int row = in.nextInt();
                    int col = in.nextInt();
                    boolean done = board.putMark(row, col);
                    if (done) {
                        break;
                    } else {
                        System.out.println("Sorry, that square is already taken. Try again.");
                    }
                } while (true);
            }
            else if (choice == 'n') {
                board.reset();
            }
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        
        in.close();
    }
}
