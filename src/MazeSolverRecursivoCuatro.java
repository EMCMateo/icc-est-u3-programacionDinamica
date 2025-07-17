import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivoCuatro implements MazeSolver {

    @Override
    public MazeResult getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        java.util.LinkedHashSet<Cell> visitedSet = new java.util.LinkedHashSet<>();
        if (grid == null || grid.length == 0) {
            return new MazeResult(new ArrayList<>(), new java.util.LinkedHashSet<>());
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (findPath(grid, start, end, path, visited, visitedSet)) {
            return new MazeResult(path, visitedSet);
        }
        return new MazeResult(new ArrayList<>(), new java.util.LinkedHashSet<>());
    }

private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited, java.util.Set<Cell> visitedSet) {
        int row = current.row;
        int col = current.col;

    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || !grid[row][col] || visited[row][col]) {
        return false;
    }
    visited[row][col] = true;
    visitedSet.add(current);
    path.add(current);
    if (row == end.row && col == end.col) {
        return true;
    }
    // Orden: derecha, abajo, izquierda, arriba
    if (findPath(grid, new Cell(row, col+1), end, path, visited, visitedSet) ||
        findPath(grid, new Cell(row+1, col), end, path, visited, visitedSet) ||
        findPath(grid, new Cell(row, col-1), end, path, visited, visitedSet) ||
        findPath(grid, new Cell(row-1, col), end, path, visited, visitedSet)) {
        return true;
    }

    path.remove(path.size() - 1);
    return false;
    }
}