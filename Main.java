import javax.swing.JFrame;

/* @author unobatbayar
    Main class for the game
*/
public class Main{
    public static void main(String[] args){
        new Main();
    }

    public Main(){
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Controls controls = new Controls();
        frame.setTitle("Snake-AI");
        frame.add(controls);
      
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}