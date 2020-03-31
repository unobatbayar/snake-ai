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
        Gameplay gameplay= new Gameplay();
        frame.setTitle("Snake-AI");
        frame.add(gameplay);
      
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // will call paint()
    }
}