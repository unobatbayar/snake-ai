import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Controls extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private int height = 600;
    private int width = 600; 
    private Thread thread;
    private boolean running;

    public Controls(){
        setPreferredSize(new Dimension(width, height));
        start();
    }

    public void start(){
        running = true;
        System.out.println("Started running...");
        thread = new Thread(this);
        thread.start();
        System.out.println("Starting thread...");
    }

    public void stop(){
        running = false;
        try{
            thread.join();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    /*
    The paint method is automatically called after the constructor. Also called when we setVisible(true);
    https://stackoverflow.com/questions/30786744/is-the-paint-method-called-when-a-jframe-is-created/30786885
    */
    public void paint(Graphics g){
        System.out.println("painting...");

        for(int i = 0; i<width/6; i++){
            g.drawLine(i*10, 0, i*10, height);
            g.drawLine(0, i*10, height, i*10);
        }

        g.fillRect(0, 0, width, height);
    }

    public void tick(){

    }

	@Override
	public void run() {
        // TODO Auto-generated method stub

    }

    public int getHeight(){
        return this.height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWidth(){
        return this.width;
    }
    
    public void setWidth(int width){
        this.width = width;
    }
}