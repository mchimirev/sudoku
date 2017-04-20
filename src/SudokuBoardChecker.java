import java.util.ArrayList;
import java.util.List;

public class SudokuBoardChecker {


    public static boolean checkBoard(int[][] board) {
        List<List<Integer>> sequnces = makeSequqnces(board);
        for (List<Integer> sequence : sequnces) {
            if (!checkSequence(sequence.toArray(new Integer[9]))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> makeSequqnces(int[][] board) {

        List<List<Integer>> sequences = new ArrayList<>();

        if (board.length > 9) {
            throw new RuntimeException("board too large");
        }

        for (int i = 0; i < 9; i++) {
            if (board[i].length > 9) {
                throw new RuntimeException("board too large");
            }
        }

        for (int i = 0; i < 9; i++) {
            List<Integer> horizontal = new ArrayList<>();
            List<Integer> vertical = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                horizontal.add(board[i][j]);
                vertical.add(board[j][i]);
            }
            sequences.add(horizontal);
            sequences.add(vertical);

            //System.out.println(horizontal);
            //System.out.println(vertical);
        }


        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                List<Integer> box = new ArrayList<>();
                for (int ii = i; ii < i + 3; ii++) {
                    for (int jj = j; jj < j + 3; jj++) {
                        box.add(board[ii][jj]);
                    }
                }
                sequences.add(box);
                //System.out.println(box);
            }
        }
        //System.out.println();

        return sequences;


    }


    public static boolean checkSequence(Integer[] sequence) {

        if (sequence.length != 9) {
            return false;
        }

        List<Integer> sequenceTracker = new ArrayList<>();

        for (int numberInSequence : sequence) {
            if (numberInSequence < 0 || numberInSequence > 9) {
                return false;
            }

            if (numberInSequence > 0) {
                if (sequenceTracker.contains(numberInSequence)) {
                    //number twice in sequence
                    return false;
                }
                sequenceTracker.add(numberInSequence);
            }

        }

        return true;
    }
}
