//@Kinga Syta
import java.awt.EventQueue;
import javax.swing.JFrame;
public class Main extends JFrame {
    public Main(){
        super("WARCABY");

        add(new GrafiPlansza());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public static void main(String[] args){
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new Main();
                    }
                });
    }
}
