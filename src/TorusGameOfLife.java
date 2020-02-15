public class TorusGameOfLife extends GameOfLife{

    public TorusGameOfLife(){
        super();
    }

    public TorusGameOfLife(int size){
        super(size);
    }

    public TorusGameOfLife(int[][] board){
        super(board);
    }


    @Override
    public int neighbors(int row, int col){
        int aliveCount = 0;
        int pRow = (row + size - 1) % size;
        int pCol = (col + size - 1) % size;
        int nRow = (row + size + 1) % size;
        int nCol = (col + size + 1) % size;

        if(previous[pRow][pCol] == 1){ //upper left
            aliveCount++;
        }
        if(previous[pRow][nCol] == 1){ //upper right
            aliveCount++;
        }
        if(previous[pRow][col] == 1){ //upper middle
            aliveCount++;
        }
        if(previous[nRow][col] == 1){ //lower middle
            aliveCount++;
        }
        if(previous[nRow][pCol] == 1){ //lower left
            aliveCount++;
        }
        if(previous[nRow][pCol] == 1){ //lower right
            aliveCount++;
        }
        if(previous[row][pCol] == 1){ //left middle
            aliveCount++;
        }
        if(previous[row][nCol] == 1){ //right middle
            aliveCount++;
        }
        return aliveCount;
    }
}
