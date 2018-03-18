import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Particle {

    public Color color = Color.RED;
    public int x;
    public int y;
    public int width;
    public int height;
    public double dx;
    public double dy;
	private int count = 0;

    public Particle(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	
	Random r = new Random();
	this.dx = r.nextInt(4) + 1;
	this.dy = r.nextInt(4) + 1;
	dx *= (r.nextInt(2) == 0) ? -1 : 1;
	dy *= (r.nextInt(2) == 0) ? -1 : 1;
    }

    public void move() {
		if(count != 0) count--;
	x += dx;
	y += dy;

	if (x < 0)
	    x = Main.width;
	if (y < 0)
	    y = Main.height;
	if (x > Main.width)
	    x = 0;
	if (y > Main.height)
	    y = 0;
    }

    public Rectangle getHitbox() {
	return new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
	g.setColor(color);
	g.fillRect(x, y, width, height);
    }
    
    public void collide() {
		if(count <= 0) {
			Main.splash(x, y);
			count = 50;
		}
    }
}
