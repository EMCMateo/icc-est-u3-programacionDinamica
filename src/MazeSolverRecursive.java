import java.util.ArrayList;
import java.util.List;
public class MazeSolverRecursive implements MazeSolver{
    private List<Cell> path = new ArrayList<>();

    public MazeResult getPath(boolean [] [] grid, Cell start, Cell end){

       MazeResult result = new MazeResult(path, null);
        if (grid == null || grid.length == 0){
            return result;
        }
        if (findPath(grid, start, end, path)){
            return result;
        }
        return new MazeResult(new ArrayList<>(), null);
    }

    private boolean findPath (boolean [] [] grid, Cell star, Cell end, List<Cell> path){
        int row = star.row;
        int col = star.col;
        // Validar límites antes de acceder a grid[row][col]
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
        if (!grid[row][col]) return false;
        path.add(star);
        if (row == end.row && col == end.col) {
            return true;
        }
        // Orden: derecha, luego abajo
        if (findPath(grid, new Cell(row, col+1), end, path)) {
            return true;
        }
        if (findPath(grid, new Cell(row+1, col), end, path)) {
            return true;
        }
        // Backtracking
        path.remove(path.size() - 1);
        return false;




        
    }
    
}
