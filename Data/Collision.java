import java.awt.Graphics;
import java.awt.Color;

public class Collision {

    private Color color = Color.BLACK;
    private int x;
    private int y;
    private int maxRadius = 25;
    private int speed = 1;
    private int radius = 0;

    public Collision(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public void draw(Graphics g) {
	g.setColor(color);
	radius += speed;
	g.drawOval(x, y, radius, radius);
    }

    public boolean remove() {
	return radius >= maxRadius;
    }

}
