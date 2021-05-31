//@Kinga Syta
import java.awt.EventQueue;
import javax.swing.JFrame;
public class Main extends JFrame {
    public Main(){
        super("MAZE");
        add(new GraphicMaze());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args){

        MazeGenerator mg = new MazeGenerator();
        mg.startSettings();
        mg.fillingLists();
        mg.loop();
        mg.transcribePoints();
        MazeSolver ms = new MazeSolver();
        //ms.easySolver();
        ms.blindSolver();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}