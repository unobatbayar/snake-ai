import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
/* @author unobatbayar
    Controls class for the game;
    Paints the canvas, and runs/stops the game. 
    Calls methods from other classes.
*/
public class Gameplay extends JPanel implements Runnable{

    private static final long serialVersionUID = 1L;
    
    private int height = 600;
    private int width = 600; 
    private int x_c = 10;
    private int y_c = 10;
    private int size = 5;
    private int ticks = 0;

    private Thread thread;

    private boolean running;
    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;


    private BodyBlock b;

    private ArrayList<BodyBlock> snake; 


    public Gameplay(){
        setPreferredSize(new Dimension(width, height));
        snake = new ArrayList<BodyBlock>(); 
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
        for(int i = 0; i<width/6; i++){
            g.drawLine(i*10, 0, i*10, height);
            g.drawLine(0, i*10, height, i*10);
        }

        for(int i = 0; i <snake.size(); i++){
            snake.get(i).draw(g);
        }
        //g.fillRect(0, 0, width, height);
    }

    public void tick(){
        if(snake.size() == 0 ){
            b = new BodyBlock(x_c, y_c, 10);
            snake.add(b);
        }

        ticks++;
        if(ticks > 500000 ticks){
            if(right) x_c++;
            if(left) x_c--;
            if(up) y_c++ ;
            if(down) y_c--;

            ticks = 0;

            b = new BodyBlock(x_c, y_c, 10);
            snake.add(b);

            if(snake.size() > size){
                snake.remove(0);
            }
        }
    }

	@Override
	public void run() {
        while(running){
            tick();
            repaint();
        }

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