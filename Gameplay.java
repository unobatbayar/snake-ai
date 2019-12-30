import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; 

import javax.swing.JPanel;
/* @author unobatbayar
    Controls class for the game;
    Paints the canvas, and runs/stops the game. 
    Calls methods from other classes.
*/
public class Gameplay extends JPanel implements Runnable, KeyListener{

    private static final long serialVersionUID = 1L;
    
    private int height = 600;
    private int width = 600; 
    private int x_c = 10;
    private int y_c = 10;
    private int size = 10;
    private int ticks = 0;
    private int score = 0;

    private Thread thread;

    private boolean running;
    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;


    private BodyBlock b;
    private ArrayList<BodyBlock> snake; 

    private Dot d;
    private ArrayList<Dot> dots; 

    private Random r;

    public Gameplay(){
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        addKeyListener(this);
        snake = new ArrayList<BodyBlock>(); 
        dots = new ArrayList<Dot>();

        r = new Random();
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
    
        g.fillRect(0, 0, width, width);
    
        for(int i = 0; i<width/6; i++){
            g.drawLine(i*10, 0, i*10, height);
            g.drawLine(0, i*10, height, i*10);
        }

        for(int i = 0; i <snake.size(); i++){
            snake.get(i).draw(g);
        }

        for(int i = 0; i<dots.size(); i++){
            dots.get(i).draw(g);
        }

        g.drawString("Score: " + score, 20, 20);
        g.drawString("Player: human", 20, 40);

    }

    public void tick(){
        if(snake.size() == 0 ){
            b = new BodyBlock(x_c, y_c, 10);
            snake.add(b);
        }

        ticks++;
        if(ticks > 250000){
            if(right) x_c++;
            if(left) x_c--;
            if(up) y_c--;
            if(down) y_c++;

            ticks = 0;

            b = new BodyBlock(x_c, y_c, 10);
            snake.add(b);

            if(snake.size() > size){
                snake.remove(0);
            }
        }

        if(dots.size() == 0 ){
            int x_c = r.nextInt(59);
            int y_c = r.nextInt(59);

            d = new Dot(x_c, y_c, 10);
            dots.add(d);
        }

        for(int i = 0; i<dots.size(); i++){
            if(x_c == dots.get(i).getX_c() && y_c == dots.get(i).getY_c()){
                size++;
                score++;
                dots.remove(i);
                i++;
            }
        }

        //wall collision
        if(x_c < 0 || x_c > 59 || y_c < 0 || y_c > 59){
            System.out.println("Game Over. Your score: " + score);
            stop();
        }

         //collosion on snake border body part 
        for(int i = 0 ; i < snake.size(); i++) {
            if(x_c == snake.get(i).getX_c() && y_c == snake.get(i).getY_c()) {
                if(i !=snake.size()- 1) {
                    System.out.println("Game Over. Your score: " + score);
                    stop();
                }   
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        //For general users
        if(key == KeyEvent.VK_RIGHT && !left){
            right = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_LEFT && !right){
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_UP && !down){
            up = true;
            left = false;
            right = false;
        }
        if(key == KeyEvent.VK_DOWN && !up){
            down = true;
            left = false;
            right = false;
        }
        
        //For gamers
        if(key == KeyEvent.VK_D && !left){
            right = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_A && !right){
            left = true;
            up = false;
            down = false;
        }
        if(key == KeyEvent.VK_W && !down){
            up = true;
            left = false;
            right = false;
        }
        if(key == KeyEvent.VK_S && !up){
            down = true;
            left = false;
            right = false;
        }    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}