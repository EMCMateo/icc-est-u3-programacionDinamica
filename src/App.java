import java.util.List;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //runEjerciciosPD();
        runMaze();
    }
/* 
    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Ejercicio fibonacci recursivo");
        long start = System.nanoTime();
        long resultado= ejerciciosPD.getFibonaci(50);
        long end = System.nanoTime(); 
        long duration = end-start;
        double durationSegundos = duration / 1_000_000_000.0;
        System.out.println("Resultado: " + resultado + " en tiempo = " + duration + " ns (" + durationSegundos + " segundos)");


        
        System.out.println("Ejercicio fibonacci recursivo con Programacion Dinamica");
        start = System.nanoTime();
        resultado= ejerciciosPD.getFibonaciPD(50);
        end = System.nanoTime(); 
        duration = end-start;
        durationSegundos = duration / 1_000_000_000.0;
        System.out.println("Resultado: " + resultado + " en tiempo = " + duration + " ns (" + durationSegundos + " segundos)");

    }
        */

        private static void runMaze(){
            boolean[][] predefinedMaze = {
                {true, true, true, true},
                {false, true, false, true},
                {true, true, false, false},
                {true, true, true, true}
            };

            Maze maze = new Maze(predefinedMaze);
            System.out.println("Laberinto Cargado: ");
            maze.printMaze();


            Cell start = new Cell(0, 0);
            Cell end = new Cell(3, 3);
            
            MazeSolverRecursive solver = new MazeSolverRecursive();
            MazeResult result1 = solver.getPath(maze.predefinedMaze, start, end);
            System.out.println("Visitados (recorrido):");
            System.out.println(result1.getVisited());
            if (result1.getVisited() != null)
                maze.printMazeWithPath(new java.util.ArrayList<>(result1.getVisited()));
            java.util.Collections.reverse(result1.getPath());
            System.out.println("Camino óptimo:");
            System.out.println(result1.getPath());
            maze.printMazeWithPath(result1.getPath());

            MazeSolverRecursivoCuatro solver2 = new MazeSolverRecursivoCuatro();
            MazeResult result2 = solver2.getPath(maze.predefinedMaze, start, end);
            System.out.println("Visitados (recorrido 4 dirs):");
            System.out.println(result2.getVisited());
            if (result2.getVisited() != null)
                maze.printMazeWithPath(new java.util.ArrayList<>(result2.getVisited()));
            java.util.Collections.reverse(result2.getPath());
            System.out.println("Camino óptimo con 4 dirs:");
            System.out.println(result2.getPath());
            maze.printMazeWithPath(result2.getPath());

            MazeSolverRecursivoCompletoBT solver3 = new MazeSolverRecursivoCompletoBT();
            MazeResult result3 = solver3.getPath(maze.predefinedMaze, start, end);
            System.out.println("Visitados (BT):");
            System.out.println(result3.getVisited());
            if (result3.getVisited() != null)
                maze.printMazeWithPath(new java.util.ArrayList<>(result3.getVisited()));
            java.util.Collections.reverse(result3.getPath());
            System.out.println("Camino óptimo BT:");
            System.out.println(result3.getPath());
            maze.printMazeWithPath(result3.getPath());
            

        }


}