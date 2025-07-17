public class Maze {

    public boolean [][] predefinedMaze;    
    
        

    public Maze(boolean [][] predefinedMaze ){
        this.predefinedMaze = predefinedMaze;
    }

    public void printMaze() {
        for (int i = 0; i < predefinedMaze.length; i++) {
            for (int j = 0; j < predefinedMaze[i].length; j++) {
                if (predefinedMaze[i][j]) {
                    System.out.print("-");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }




    
}
