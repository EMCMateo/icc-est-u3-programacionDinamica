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
                {false, true, true, true},
                {true, true, false, false},
                {true, true, true, true}
            };

            Maze maze = new Maze(predefinedMaze);
            System.out.println("Laberinto Cargado: ");
            maze.printMaze();


            Cell start = new Cell(0, 0);
            Cell end = new Cell(3, 3);
            
            MazeSolverRecursive solver = new MazeSolverRecursive();
            List<Cell> path = solver.getPath(maze.predefinedMaze, start, end);
            java.util.Collections.reverse(path);
            System.out.println("Camino: ");
            System.out.println(path);

            MazeSolverRecursivoCuatro solver2 = new MazeSolverRecursivoCuatro();
            List<Cell> path2 = solver2.getPath(maze.predefinedMaze, start, end);
            java.util.Collections.reverse(path2);
            System.out.println("Camino con 4 caminos posibles: ");
            System.out.println(path2);

        }


}