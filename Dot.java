import java.awt.Color;
import java.awt.Graphics;

public class Dot{

    private int x_c;
    private int y_c;
    private int height;
    private int width;

    public Dot(int x_c, int y_c, int size){
        this.x_c = x_c;
        this.y_c = y_c;
        this.height = size;
        this.width = size;
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
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