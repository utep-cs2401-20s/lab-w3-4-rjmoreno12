public class GameOfLife {
    int size;
    int[][] board;
    int[][] previous;

    public GameOfLife(){
        this(0);
    }

    public GameOfLife(int size){
        this.size = size;
        board = new int[size][size];
        previous = new int[size][size];
    }

    public GameOfLife(int[][] board){
        this.size = board.length;

        this.board = new int[size][size];
        previous = new int[size][size];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                this.board [i][j] = board[i][j];
                this.previous[i][j] = board[i][j];
            }
        }
    }

    public void setBoard(int[][] board){
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setPreviousBoard(int[][] previousBoard){
        this.previous = previousBoard;
    }

    public int[][] getPreviousBoard(){
        return this.previous;
    }

    public void oneStep() {
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board[i].length; j++){
                previous[i][j] = this.board[i][j];
            }
        }

        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board[i].length; j++){
                int neighbors = neighbors(i,j);
                int alive = previous[i][j];
                if(alive == 1) {

                    if (neighbors == 1 || neighbors == 2) {
                        this.board[i][j] = 1;
                    }
                    else{
                        this.board[i][j] = 0;
                    }
                }
                else{
                    if(neighbors == 3){
                        this.board[i][j] = 1;
                    }
                }
            }
        }
    }

    public int neighbors(int row, int col){
        int aliveCount = 0;

        if(col+1 < board.length && previous[row][col+1] == 1){ //middle right
            aliveCount++;
        }

        if(row+1 < board.length && previous[row+1][col] == 1){ // lower middle
            aliveCount++;
        }

        if(col-1 >= 0 && col > 0 && previous[row][col-1] == 1){ //middle left
            aliveCount++;
        }

        if(row-1 >= 0 && previous[row-1][col] == 1){ //upper middle
            aliveCount++;
        }

        if(row-1 >= 0 && col + 1 < board.length && previous[row-1][col+1] == 1){  //upper right
            aliveCount++;
        }

        if(row+1 < board.length && col+1 < board.length && previous[row+1][col+1] == 1){ //lower right
            aliveCount++;
        }

        if(row+1 < board.length && col-1 >= 0 && previous[row+1][col-1] == 1){ //lower left
            aliveCount++;
        }

        if(row-1 >= 0 && col-1 >=0 && previous[row-1][col-1] ==1){ //upper left
            aliveCount++;
        }

        return aliveCount;
    }

    public void Evolution(int n) {
        int i = 0;
        while(i < n){
            oneStep();
            i++;

        }

    }

}