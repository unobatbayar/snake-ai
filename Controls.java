import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Controls extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	private int height = 475;
    private int width = 475; 

    public Controls(){
        setPreferredSize(new Dimension(width, height));
    }

    public void start(){

    }

    public void stop(){
        
    }

    public void draw(Graphics graphics){

        graphics.clearRect(0, 0, width, height);
        graphics.setColor(Color.BLACK); 
        graphics.fillRect(0, 0, width, height);

        for(int i = 0; i<width/10; i++){
            graphics.drawLine(i*10, 0, i*10, height);
            graphics.drawLine(0, i*10, height, i*10);
        }
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