//@Kinga Syta
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class GrafiPlansza extends JPanel implements MouseListener{
    private static final int SZEROKOSC = 8;
    private static final int WYSOKOSC = 8;
    public static int gracz=2;

    public GrafiPlansza(){
        addMouseListener(this);
        setPreferredSize(new Dimension(420,420));
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
       Plansza.nrPola(e.getX(), e.getY());
        if(gracz==1)
            Plansza.gracz1(Plansza.wiersz, Plansza.kolumna);
        if(gracz==2)
            Plansza.gracz2(Plansza.wiersz, Plansza.kolumna);
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D kwadracik=(Graphics2D)g;
        Graphics2D kolko=(Graphics2D)g;




        for(int x=0; x<WYSOKOSC; x++){
            for(int y=0; y<SZEROKOSC; y++){

                kwadracik.setColor((x+y)%2==0 ? Color.white : Color.black);
                kwadracik.fillRect(10 + x * 50, 10 + y * 50, 50, 50);
                switch (Plansza.plan[y][x]){
                    case 2:
                        kolko.setColor(new java.awt.Color(255,20,147));
                        kolko.fillOval(15 + x * 50, 15 + y * 50, 40, 40);
                        break;
                    case 3:
                        kolko.setColor(Color.yellow);
                        kolko.fillOval(15 + x * 50, 15 + y * 50, 40, 40);
                        break;
                    case 4:
                        kolko.setColor(new java.awt.Color(133,30,133));
                        kolko.fillOval(15 + x * 50, 15 + y * 50, 40, 40);
                        break;
                    case 6:
                        kolko.setColor(new java.awt.Color(255,100,0));
                        kolko.fillOval(15 + x * 50, 15 + y * 50, 40, 40);
                        break;


                }

            }
        }

    }
}