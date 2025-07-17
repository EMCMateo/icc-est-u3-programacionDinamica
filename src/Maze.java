
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


    public void printMazeVisited(java.util.List<Cell> path) {
  
        boolean[][] visited = new boolean[predefinedMaze.length][predefinedMaze[0].length];
        for (Cell c : path) {
            if (c.row >= 0 && c.row < visited.length && c.col >= 0 && c.col < visited[0].length) {
                visited[c.row][c.col] = true;
            }
        }
        for (int i = 0; i < predefinedMaze.length; i++) {
            for (int j = 0; j < predefinedMaze[i].length; j++) {
                if (visited[i][j]) {
                    System.out.print("> ");
                } else if (predefinedMaze[i][j]) {
                    System.out.print("- ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }


    public void printMazeWithPath(java.util.List<Cell> path) {
        boolean[][] visited = new boolean[predefinedMaze.length][predefinedMaze[0].length];
        for (Cell c : path) {
            if (c.row >= 0 && c.row < visited.length && c.col >= 0 && c.col < visited[0].length) {
                visited[c.row][c.col] = true;
            }
        }
        for (int i = 0; i < predefinedMaze.length; i++) {
            for (int j = 0; j < predefinedMaze[i].length; j++) {
                if (visited[i][j]) {
                    System.out.print("> ");
                } else if (predefinedMaze[i][j]) {
                    System.out.print("- ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }




    
}
