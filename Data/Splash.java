import java.awt.Graphics;
import java.awt.Color;

public class Splash {
	
	public int x;
	public int y;
	public int count = 0;
	public Color color = Color.BLACK;
	
	public Splash(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		count++;
		g.setColor(color);
		g.drawOval(x, y, count, count);
	}
	
	public int getTime() { return count; }
	
}