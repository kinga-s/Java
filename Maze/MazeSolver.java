import java.util.*;

public class MazeSolver {


    static LinkedList<Integer> path = new LinkedList<>();

    public void easySolver(){

        int i = MazeGenerator.sizeTable-1;

        while(MazeGenerator.tableOfConnections[i] != -2){
            path.add(i);
            i = MazeGenerator.tableOfConnections[i];
        }

        path.add(0);
        Collections.reverse(path);
    }

    public void blindSolver(){

        boolean[] visitedPoints = new boolean[MazeGenerator.sizeTable];
        int i = 0;
        int last;
        path.add(0);

        while(!visitedPoints[MazeGenerator.sizeTable-1]){
            if(MazeGenerator.down[i] == true && visitedPoints[i+1] == false){
                //System.out.print("Jestem w punkcie " + i + " i odwiedzam punkt ");
                visitedPoints[i] = true;
                i = i + 1;
                path.add(i);
                //System.out.println(i);
            }
            else if(MazeGenerator.right[i] == true && visitedPoints[i+MazeGenerator.width] == false){
                //System.out.print("Jestem w punkcie " + i + " i odwiedzam punkt ");
                visitedPoints[i] = true;
                i = i + MazeGenerator.width;
                path.add(i);
                //System.out.println(i);
            }
            else if(MazeGenerator.left[i] == true && visitedPoints[i-MazeGenerator.width] == false){
                //System.out.print("Jestem w punkcie " + i + " i odwiedzam punkt ");
                visitedPoints[i] = true;
                i = i - MazeGenerator.width;
                path.add(i);
                //System.out.println(i);
            }
            else if(MazeGenerator.up[i] == true && visitedPoints[i-1] == false){
                //System.out.print("Jestem w punkcie " + i + " i odwiedzam punkt ");
                visitedPoints[i] = true;
                i = i - 1;
                path.add(i);
                //System.out.println(i);
            }
            else if(i != 0){
                visitedPoints[i] = true;
                last  = path.size();
                //System.out.println("Zostalo usuniete " + path.get(last-1));
                path.remove(path.size()-1);
                i = path.get(last - 2);

            }
        }
        int help = MazeGenerator.sizeTable-1;
        path.add(help);

    }


}
