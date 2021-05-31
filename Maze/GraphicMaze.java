//@Kinga Syta
import javax.swing.JPanel;
import java.awt.*;
public class GraphicMaze extends JPanel {

    public GraphicMaze(){
        setPreferredSize(new Dimension(800,700));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(Color.white);
        gr.fillRect(0,0,MazeGenerator.length*15, MazeGenerator.width*15);

        /**
         * The size of the maze is 15 times larger
         */

        gr.setColor(Color.black);

        gr.drawLine(0,0,0, MazeGenerator.width*15);
        gr.drawLine(0, MazeGenerator.width*15, MazeGenerator.length*15, MazeGenerator.width*15);
        gr.drawLine(MazeGenerator.length*15, MazeGenerator.width*15, MazeGenerator.length*15, 0);
        gr.drawLine(0,0,MazeGenerator.length*15, 0);

        for(int i = 0; i < MazeGenerator.length; i++){
            for(int j = 0; j < MazeGenerator.width; j++){
                gr.drawLine((i+1)*15, j*15, (i+1)*15, (j+1)*15);
                gr.drawLine(i*15, (j+1)*15, (i+1)*15, (j+1)*15);
            }
        }

        gr.setColor(Color.white);

        for(int i = 1; i < MazeGenerator.tableOfConnections.length; i++){

            if(MazeGenerator.tableOfConnections[i] == (i + 1)){
                gr.drawLine((i/MazeGenerator.width)*15, (i%MazeGenerator.width+1)*15, (i/MazeGenerator.width+1)*15, (i%MazeGenerator.width+1)*15);
            }
            else if(MazeGenerator.tableOfConnections[i] == (i - 1)){
                gr.drawLine((i/MazeGenerator.width)*15, (i%MazeGenerator.width)*15, (i/MazeGenerator.width+1)*15, (i%MazeGenerator.width)*15);
            }
            else if(MazeGenerator.tableOfConnections[i] == (i + MazeGenerator.width)){
                gr.drawLine((i/MazeGenerator.width+1)*15, (i%MazeGenerator.width)*15, (i/MazeGenerator.width+1)*15, (i%MazeGenerator.width+1)*15);
            }
            else if(MazeGenerator.tableOfConnections[i] == (i - MazeGenerator.width)){
                gr.drawLine((i/MazeGenerator.width)*15, (i%MazeGenerator.width)*15, (i/MazeGenerator.width)*15, (i%MazeGenerator.width+1)*15);
            }

        }
        gr.setColor(Color.orange);
        for(Integer j: MazeSolver.path){
            gr.fillRect(j/MazeGenerator.width*15+5, j%MazeGenerator.width*15+5, 5, 5);
        }

    }
}