import java.awt.Color;
import java.awt.Graphics;

public class BodyBlock{

    private int x_c;
    private int y_c;
    private int height;
    private int width;

    public BodyBlock(int x_c, int y_c, int size){
        this.x_c = x_c;
        this.y_c = y_c;
        this.height = size;
        this.width = size;
    }


    public void tick(){

    }

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
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

}