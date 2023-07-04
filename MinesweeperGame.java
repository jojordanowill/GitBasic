import java.io.FileNotFoundException;
import java.util.Scanner;

//Jordan Williams

public class MinesweeperGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldCount = 1;

        while (scanner.hasNext()) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            // Check if the input signals the end of the game
            if (rows == 0 && columns == 0) {
                break;
            }

            char[][] field = new char[rows][columns];

            // Read the field data from the file
            for (int i = 0; i < rows; i++) {
                String row = scanner.next();
                field[i] = row.toCharArray();
            }

            System.out.println("Field #" + fieldCount + ":");
            char[][] result = calculateMinesweeperField(field); // Calculate the result
            printField(result); // Print the result

            fieldCount++;

            System.out.println();
        }

        scanner.close();
    }

    // Calculates the minesweeper field based on the input field
    static char[][] calculateMinesweeperField(char[][] field) {
        int rows = field.length;
        int columns = field[0].length;
        char[][] result = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field[i][j] == '*') {
                    result[i][j] = '*';
                } else {
                    int count = 0;
                    // Count the adjacent mines
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < rows && y >= 0 && y < columns && field[x][y] == '*') {
                                count++;
                            }
                        }
                    }
                    result[i][j] = (char) (count + '0'); // Convert the count to a character
                }
            }
        }

        return result;
    }

    // Prints the minesweeper field
    static void printField(char[][] field) {
        int rows = field.length;
        int columns = field[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();  // Add newline character after each row
        }
    }
}
