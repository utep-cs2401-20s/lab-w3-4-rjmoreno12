import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

    public class GameOfLifeTest {

        @Test
        public void neighbors1() {
            int[][] a = {
                    {1,0,0},
                    {1,0,1},
                    {1,1,1}};
            GameOfLife GAME1 = new GameOfLife(a);
            assertEquals(6, GAME1.neighbors(1,1));
        }


        @Test
        public void neighbors2() {
            int[][] a = {
                    {1,0,0},
                    {1,0,1},
                    {1,1,1}};
            GameOfLife GAME2 = new GameOfLife(a);
            assertEquals(3, GAME2.neighbors(0,1));
        }


        @Test
        public void neighbors3() {
            int[][] a = {
                    {1,0,0,1},
                    {1,0,1,0},
                    {1,1,1,0},
                    {0,1,1,0}};
            GameOfLife GAME3 = new GameOfLife(a);
            assertEquals(1, GAME3.neighbors(0,3));
        }


        @Test
        public void neighbors4() {
            int[][] a = {
                    {1,0,0,1},
                    {1,1,1,1},
                    {1,1,1,1},
                    {0,1,1,1}};
            GameOfLife GAME4 = new GameOfLife(a);
            assertEquals(8, GAME4.neighbors(2,2));
        }


        @Test
        public void neighbors5() {
            int[][] a = {
                    {1,0,0,1},
                    {0,0,0,1},
                    {0,0,0,1},
                    {0,0,0,1}};
            GameOfLife GAME5 = new GameOfLife(a);
            assertEquals(0, GAME5.neighbors(2,1));
        }


        @Test
        public void neighborsTorus1() {
            int[][] a = {
                    {1,0,0},
                    {1,0,1},
                    {1,1,1}};
            TorusGameOfLife GAME1 = new TorusGameOfLife(a);
            assertEquals(6, GAME1.neighbors(1,1));
        }


        @Test
        public void neighborsTorus2() {
            int[][] a = {
                    {1,0,0},
                    {1,0,1},
                    {1,1,1}};
            TorusGameOfLife GAME2 = new TorusGameOfLife(a);
            assertEquals(6, GAME2.neighbors(0,1));
        }

        @Test
        public void neighborsTorus3() {
            int[][] a = {
                    {1,0,0,1},
                    {1,0,1,0},
                    {1,1,1,0},
                    {1,1,1,0}};
            TorusGameOfLife GAME3 = new TorusGameOfLife(a);
            assertEquals(5, GAME3.neighbors(0,3));
        }


        @Test
        public void neighborsTorus4() {
            int[][] a = {
                    {1,0,0,1},
                    {1,1,1,1},
                    {1,1,1,1},
                    {0,1,1,1}};
            TorusGameOfLife GAME4 = new TorusGameOfLife(a);
            assertEquals(7, GAME4.neighbors(2,0));
        }


        @Test
        public void neighborsTorus5() {
            int[][] a = {
                    {1,0,0,1},
                    {0,0,0,1},
                    {0,0,0,1},
                    {0,0,0,1}};
            TorusGameOfLife GAME5 = new TorusGameOfLife(a);
            assertEquals(0, GAME5.neighbors(2,1));
        }

        @Test
        public void oneStepTest1() {

            int[][] a = {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,1,1,1,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}};

            GameOfLife game1 = new GameOfLife(a);
            game1.oneStep();
            int[][] board = game1.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 1, 1, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 1, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
        }

        @Test
        public void oneStepTest2(){
            int[][] b = {
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0},
                    {0,0,1,1,1,0},
                    {0,1,1,1,0,0},
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0}};

            GameOfLife game2 = new GameOfLife(b);
            game2.oneStep();
            int[][] board = game2.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 0, 1, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 1, 0});
            assertArrayEquals(board[3], new int[] {0, 1, 0, 0, 1, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void oneStepTest3(){
            int[][] c = {
                    {0,0,0,0,0,0},
                    {0,1,1,0,0,0},
                    {0,1,1,0,0,0},
                    {0,0,0,1,1,0},
                    {0,0,0,1,1,0},
                    {0,0,0,0,0,0}};

            GameOfLife game3 = new GameOfLife(c);
            game3.oneStep();
            int[][] board = game3.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 1, 1, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 1, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 1, 1, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void oneStepTest4(){
            int[][] d = {
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};



            TorusGameOfLife game4 = new TorusGameOfLife(d);
            game4.oneStep();
            int[][] board = game4.getBoard();
            assertArrayEquals(board[0], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[1], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[2], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[3], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[4], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[5], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[6], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[7], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[8], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[9], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[10], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[11], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[12], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[13], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[14], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[15], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[16], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[17], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[18], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        }

        @Test
        public void oneStepTest5(){
            int[][] e = {
                    {0,0,0,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,0,0,0,0}};

            GameOfLife game5 = new GameOfLife(e);
            game5.oneStep();
            int[][] board = game5.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 1, 1, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 1, 1, 1, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void oneStepTorus1() {

            int[][] a = {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {1,1,0,0,1},
                    {0,0,0,0,0},
                    {0,0,0,0,0}};

            TorusGameOfLife game1 = new TorusGameOfLife(a);
            game1.oneStep();
            int[][] board = game1.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {1, 1, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {1, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {1, 0, 0, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
        }

        @Test
        public void oneStepTorus2(){
            int[][] b = {
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0},
                    {1,0,0,0,1,1},
                    {0,0,0,1,1,1},
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0}};

            TorusGameOfLife game2 = new TorusGameOfLife(b);
            game2.oneStep();
            int[][] board = game2.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {1, 0, 0, 0, 0, 1});
            assertArrayEquals(board[2], new int[] {1, 0, 0, 1, 0, 0});
            assertArrayEquals(board[3], new int[] {1, 0, 0, 1, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 1, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void oneStepTorus3(){
            int[][] c = {
                    {1,1,0,0,0,0},
                    {1,1,0,0,0,0},
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0},
                    {0,0,0,0,1,1},
                    {0,0,0,0,1,1}};

            TorusGameOfLife game3 = new TorusGameOfLife(c);
            game3.oneStep();
            int[][] board = game3.getBoard();
            assertArrayEquals(board[0], new int[] {0, 1, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {1, 1, 0, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 1, 1});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 1, 0});
        }

        @Test
        public void oneStepTorus4(){
            int[][] d = {
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},};

            TorusGameOfLife game4 = new TorusGameOfLife(d);
            game4.oneStep();
            int[][] board = game4.getBoard();
            assertArrayEquals(board[0], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[1], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[2], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[3], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[4], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[5], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[6], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[7], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[8], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[9], new int[] {0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[10], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[11], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[12], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[13], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[14], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[15], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[16], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[17], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[18], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        }

        @Test
        public void oneStepTorus5(){
            int[][] e = {
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,1},
                    {0,0,0,0,0,1},
                    {0,0,0,0,0,1},
                    {0,0,0,0,0,1},
                    {0,0,0,0,0,0}};

            TorusGameOfLife game5 = new TorusGameOfLife(e);
            game5.oneStep();
            int[][] board = game5.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {1, 0, 0, 0, 1, 1});
            assertArrayEquals(board[3], new int[] {1, 0, 0, 0, 1, 1});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTest1() {

            int[][] a = {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {0,1,1,1,0},
                    {0,0,0,0,0},
                    {0,0,0,0,0}};

            GameOfLife game1 = new GameOfLife(a);
            game1.Evolution(5);
            int[][] board = game1.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 0, 1, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 1, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTest2(){
            int[][] b = {
                    {0,0,0,0,0,0},
                    {0,1,0,0,0,0},
                    {0,0,1,1,1,0},
                    {0,1,1,1,0,0},
                    {0,0,0,0,1,0},
                    {0,0,0,0,0,0}};

            GameOfLife game2 = new GameOfLife(b);
            game2.Evolution(5);
            int[][] board = game2.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 0, 1, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 1, 0});
            assertArrayEquals(board[3], new int[] {0, 1, 0, 0, 1, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTest3(){
            int[][] c = {
                    {0,0,0,0,0,0},
                    {0,1,1,0,1,0},
                    {0,1,1,0,0,0},
                    {0,0,0,1,1,0},
                    {0,1,0,1,1,0},
                    {0,0,0,0,0,0}};

            GameOfLife game3 = new GameOfLife(c);
            game3.Evolution(5);
            int[][] board = game3.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 1, 1, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 1, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 1, 1, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTest4(){
            int[][] d = {
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};



            TorusGameOfLife game4 = new TorusGameOfLife(d);
            game4.Evolution(15);
            int[][] board = game4.getBoard();
            assertArrayEquals(board[0], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[1], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[2], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[3], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[4], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[5], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[6], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[7], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[8], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[9], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[10], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[11], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[12], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[13], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[14], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[15], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[16], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[17], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[18], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        }

        @Test
        public void evolutionTest5(){
            int[][] e = {
                    {0,0,0,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,0,0,0,0}};

            GameOfLife game5 = new GameOfLife(e);
            game5.Evolution(5);
            int[][] board = game5.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 0, 1, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 1, 0, 1, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTorus1() {

            int[][] a = {
                    {0,0,0,0,0},
                    {0,0,0,0,0},
                    {1,0,0,1,1},
                    {0,0,0,0,0},
                    {0,0,0,0,0}};

            TorusGameOfLife game1 = new TorusGameOfLife(a);
            game1.Evolution(5);
            int[][] board = game1.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 0, 0, 1});
            assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 1});
            assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 1});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTorus2(){
            int[][] n = {
                    {0,0,0,0,0,0},
                    {0,0,0,1,0,0},
                    {1,1,0,0,0,1},
                    {1,0,0,0,1,1},
                    {0,0,1,0,0,0},
                    {0,0,0,0,0,0}};

            TorusGameOfLife game2 = new TorusGameOfLife(n);
            game2.Evolution(5);
            int[][] board = game2.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {1, 0, 0, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 1, 0, 0, 1, 0});
            assertArrayEquals(board[3], new int[] {0, 1, 0, 0, 1, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 0, 1});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0});
        }

        @Test
        public void evolutionTorus3(){
            int[][] n = {
                    {1,1,0,0,0,0},
                    {1,1,0,0,0,0},
                    {0,0,0,1,0,0},
                    {0,0,0,0,0,0},
                    {0,1,0,0,1,1},
                    {0,0,0,0,1,1}};

            TorusGameOfLife game3 = new TorusGameOfLife(n);
            game3.Evolution(5);
            int[][] board = game3.getBoard();
            assertArrayEquals(board[0], new int[] {0, 1, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {1, 1, 0, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 0, 0, 1, 1});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 1, 0});
        }

        @Test
        public void evolutionTorus4(){
            int[][] n = {

                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,0,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},
                    {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},};

            TorusGameOfLife game4 = new TorusGameOfLife(n);
            game4.Evolution(15);
            int[][] board = game4.getBoard();
            assertArrayEquals(board[0], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[1], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[2], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[3], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[4], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[5], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[6], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[7], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[8], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[9], new int[] {0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[10], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[11], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[12], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[13], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[14], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[15], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[16], new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[17], new int[] {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0});
            assertArrayEquals(board[18], new int[] {0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0});
        }

        @Test
        public void evolutionTorus5(){
            int[][] n = {
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,0,0,0,0},
                    {0,0,0,0,0,0},
                    {0,0,1,0,0,0},
                    {0,0,1,0,0,0}};

            TorusGameOfLife game5 = new TorusGameOfLife(n);
            game5.Evolution(5);
            int[][] board = game5.getBoard();
            assertArrayEquals(board[0], new int[] {0, 1, 0, 1, 0, 0});
            assertArrayEquals(board[1], new int[] {0, 0, 1, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 0, 1, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 1, 0, 1, 0, 0});
        }

        @Test
        public void evolutionTorus6(){
            int[][] n = {
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,1,1,1,1,0,0,0,0},
                    {0,1,0,0,0,1,0,0,0,0},
                    {0,0,0,0,0,1,0,0,0,0},
                    {0,1,0,0,1,0,0,0,1,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0}};

            TorusGameOfLife game6 = new TorusGameOfLife(n);
            game6.Evolution(18);
            int[][] board = game6.getBoard();
            assertArrayEquals(board[0], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[1], new int[] {1, 0, 0, 1, 0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[2], new int[] {0, 0, 0, 0, 1, 0, 0, 0, 0, 0});
            assertArrayEquals(board[3], new int[] {1, 0, 0, 0, 1, 0, 0, 0, 0, 0});
            assertArrayEquals(board[4], new int[] {0, 1, 1, 1, 1, 0, 0, 0, 0, 0});
            assertArrayEquals(board[5], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[6], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[7], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[8], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
            assertArrayEquals(board[9], new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        }
    }