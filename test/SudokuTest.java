import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SudokuTest {


    int[][] correctBoard1;

    int[][] incorrectBoardHorizontal;
    int[][] incorrectBoardVertical;
    int[][] incorrectBoardBox;

    @Before
    public void setUp() {

        correctBoard1 = new int[][]{
                {6, 0, 0, 2, 0, 5, 0, 4, 1},
                {0, 0, 0, 1, 7, 0, 8, 9, 6},
                {1, 0, 4, 0, 0, 0, 5, 0, 7},

                {7, 0, 5, 0, 8, 0, 0, 6, 0},
                {0, 0, 6, 0, 5, 0, 2, 0, 0,},
                {0, 4, 0, 0, 6, 0, 7, 0, 3},

                {2, 0, 9, 0, 0, 0, 4, 0, 8},
                {3, 5, 1, 0, 4, 8, 0, 0, 0},
                {4, 8, 0, 3, 0, 9, 0, 0, 5}
        };

        incorrectBoardHorizontal = new int[][]{
                {6, 0, 6, 2, 0, 5, 0, 4, 1},
                {0, 0, 0, 1, 7, 0, 8, 9, 6},
                {1, 0, 4, 0, 0, 0, 5, 0, 7},

                {7, 0, 5, 0, 8, 0, 0, 6, 0},
                {0, 0, 6, 0, 5, 0, 2, 0, 0,},
                {0, 4, 0, 0, 6, 0, 7, 0, 3},

                {2, 0, 9, 0, 0, 0, 4, 0, 8},
                {3, 5, 1, 0, 4, 8, 0, 0, 0},
                {4, 8, 0, 3, 0, 9, 0, 0, 5}
        };

        incorrectBoardVertical = new int[][]{
                {6, 0, 0, 2, 0, 5, 0, 4, 1},
                {0, 0, 0, 1, 7, 0, 8, 9, 6},
                {1, 0, 4, 0, 0, 0, 5, 0, 7},

                {7, 0, 5, 0, 8, 0, 0, 6, 0},
                {0, 0, 6, 0, 5, 0, 2, 0, 0,},
                {7, 4, 0, 0, 6, 0, 7, 0, 3},

                {2, 0, 9, 0, 0, 0, 4, 0, 8},
                {3, 5, 1, 0, 4, 8, 0, 0, 0},
                {4, 8, 0, 3, 0, 9, 0, 0, 5}
        };

        incorrectBoardBox = new int[][]{
                {6, 0, 0, 2, 0, 5, 0, 4, 1},
                {0, 0, 0, 1, 7, 0, 8, 9, 6},
                {1, 0, 4, 0, 0, 0, 5, 0, 7},

                {7, 0, 5, 0, 8, 0, 0, 6, 0},
                {0, 0, 6, 0, 5, 0, 2, 0, 0,},
                {0, 4, 0, 0, 6, 0, 7, 0, 3},

                {2, 0, 9, 0, 0, 0, 4, 5, 8},
                {3, 5, 1, 0, 4, 8, 0, 0, 0},
                {4, 8, 0, 3, 0, 9, 0, 0, 5}
        };
    }

    @Test
    public void checkSequence_correct() {
        assertTrue(SudokuBoardChecker.checkSequence(new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertTrue(SudokuBoardChecker.checkSequence(new Integer[]{1, 2, 3, 0, 0, 0, 0, 0, 0}));
        assertTrue(SudokuBoardChecker.checkSequence(new Integer[]{1, 2, 3, 0, 0, 9, 7, 0, 0}));
        assertTrue(SudokuBoardChecker.checkSequence(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    @Test
    public void checkSequence_incorrect() {
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{}));
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{-8, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{2, 0, 0, 0, 0, 0, 2, 0, 0, 0}));
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{1, 2, 3, 4, 5, 6, 2, 7, 8, 9}));
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{1, 2, 3, 4, 0, 0, 0, 5, 6, 2}));
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{1, 2}));
        assertFalse(SudokuBoardChecker.checkSequence(new Integer[]{4, 5, 8, 0, 0, 0, 0, 0, 5}));

    }

    @Test
    public void makeSequqnces() {
        List<List<Integer>> sequqnces = SudokuBoardChecker.makeSequqnces(correctBoard1);
        assertEquals(sequqnces.size(), 9 * 3);

        //first two rows
        assertArrayEquals(sequqnces.get(0).toArray(new Integer[9]), new Integer[]{6, 0, 0, 2, 0, 5, 0, 4, 1});
        assertArrayEquals(sequqnces.get(2).toArray(new Integer[9]), new Integer[]{0, 0, 0, 1, 7, 0, 8, 9, 6});

        //first two columns
        assertArrayEquals(sequqnces.get(1).toArray(new Integer[9]), new Integer[]{6, 0, 1, 7, 0, 0, 2, 3, 4});
        assertArrayEquals(sequqnces.get(3).toArray(new Integer[9]), new Integer[]{0, 0, 0, 0, 0, 4, 0, 5, 8});

        //upper left box
        assertArrayEquals(sequqnces.get(18).toArray(new Integer[9]), new Integer[]{6, 0, 0, 0, 0, 0, 1, 0, 4});

        //lower right box
        assertArrayEquals(sequqnces.get(26).toArray(new Integer[9]), new Integer[]{4, 0, 8, 0, 0, 0, 0, 0, 5});


    }

    @Test
    public void checkBoard_correct() {
        assertTrue(SudokuBoardChecker.checkBoard(correctBoard1));
    }

    @Test
    public void checkBoard_incorrectHorizontal() {
        assertFalse(SudokuBoardChecker.checkBoard(incorrectBoardHorizontal));
    }

    @Test
    public void checkBoard_incorrectVertical() {
        assertFalse(SudokuBoardChecker.checkBoard(incorrectBoardVertical));
    }

    @Test
    public void checkBoard_incorrectBox() {
        assertFalse(SudokuBoardChecker.checkBoard(incorrectBoardBox));
    }

}
