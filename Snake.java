import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Snake{

    private int x_c;
    private int y_c;
    private int height;
    private int width;

    public Snake(int x_c, int y_c, int size){
        this.x_c = x_c;
        this.y_c = y_c;
        this.height = size;
        this.width = size;
    }


    public void tick(){

    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x_c*width, y_c*height, width, height);
    }

    public int getX_c() {
		return this.x_c;
	}

	public void setX_c(int x_c) {
		this.x_c = x_c;
	}

	public int getY_c() {
		return this.y_c;
	}

	public void setY_c(int y_c) {
		this.y_c = y_c;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}


}