import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class QuadTree {

    public Rectangle rect;
    private ArrayList<Particle> pList;
    public QuadTree[] children = new QuadTree[] { null, null, null, null };

    public QuadTree(ArrayList<Particle> pList, Rectangle rect) {
	this.pList = pList;
	this.rect = rect;

	partitionAndPopulate();
    }

    public QuadTree(Rectangle rect) {
	this.rect = rect;
    }

    private void partitionAndPopulate() {
	Rectangle[] sectors = new Rectangle[4];
	int x = (int) rect.getX();
	int y = (int) rect.getY();
	int width = (int) rect.getWidth();
	int height = (int) rect.getHeight();

	sectors[0] = new Rectangle(x, y, width / 2, height / 2);
	sectors[1] = new Rectangle(x, y + (height / 2), width / 2, height / 2);
	sectors[2] = new Rectangle(x + (width / 2), y, width / 2, height / 2);
	sectors[3] = new Rectangle(x + (width / 2), y + (height / 2), width / 2, height / 2);

	for (int i = 0; i < 4; i++) {
	    Rectangle rect = sectors[i];
	    ArrayList<Particle> contains = new ArrayList<Particle>();
	    for (Particle p : pList) {

		if (rect.intersects(p.getHitbox()) && !p.getHitbox().contains(rect)) {
		    contains.add(p);
		}
	    }
	    if (contains.size() >= 2) {
		if((rect.width <= 10))
		    for(int j = 0; j < contains.size(); j++)
			contains.get(j).collide();
		children[i] = new QuadTree(contains, rect);
	    } else
		children[i] = new QuadTree(rect);
	}
    }

    public void draw(Graphics g) {
//	Graphics2D g2d = (Graphics2D) g;
//	g2d.setColor(new Color(255, 0, 0, 30));
//	g2d.fillRect(rect.x, rect.y, rect.width, rect.height);
	
	g.setColor(Color.BLACK);
	g.drawRect(rect.x, rect.y, rect.width, rect.height);
	
	for (QuadTree tree : children) {
	    if (tree != null)
		tree.draw(g);
	}
    }

}
