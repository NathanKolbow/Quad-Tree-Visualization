import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JComponent implements ActionListener, MouseListener {

    private static final long serialVersionUID = 1L;

    public static int width = 1920;
    public static int height = 1080;
    public static ArrayList<Particle> particleList = new ArrayList<Particle>();
    public static QuadTree root;
    public static JFrame frame;
    public static boolean drawTrees = true;

    public static void main(String[] args) {
	frame = new JFrame("Quadtrees");
	Main main = new Main();
	frame.add(main);
	frame.addMouseListener(main);
	frame.pack();
	frame.setVisible(true);
	frame.setBackground(Color.WHITE);
	frame.setMinimumSize(new Dimension(width, height));
	frame.setMaximumSize(new Dimension(width, height));
	frame.setFocusable(true);

	Random r = new Random();
	for (int i = 0; i < 5; i++) {
	    int x = r.nextInt(width);
	    int y = r.nextInt(height);
	    particleList.add(new Particle(x, y, 20, 20));
	}

	Timer timer = new Timer(10, new Main());
	timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
	
	for (Particle p : particleList)
	    p.draw(g);

	if (root != null && drawTrees)
	    root.draw(g);
	
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	for (Particle p : particleList) {
	    p.move();
	}

	root = new QuadTree(particleList, new Rectangle(0, 0, width, height));
	frame.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	
    }

}
