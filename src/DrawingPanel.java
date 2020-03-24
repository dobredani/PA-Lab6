import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random random = new Random();
        int radius = ((int) frame.configPanel.getSizeField().getValue()); //random.nextInt(100); //generate a random number
        int sides = ((int) frame.configPanel.getSidesField().getValue()); //get the value from UI (in ConfigPanel)
        Color color = new Color(random.nextInt(0xFF),random.nextInt(0xFF),random.nextInt(0xFF),random.nextInt(0xFF)); //create a transparent random Color.
        graphics.setColor(color);

        if (frame.configPanel.getShapeCombo().getSelectedItem().toString().equals("Regular Polygon"))
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        if (frame.configPanel.getShapeCombo().getSelectedItem().toString().equals("Node Shape"))
            graphics.fill(new NodeShape(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g) {
        super.paint(g);
    } //Why did I do that? to update the canvas

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void loadImage(BufferedImage image){
        this.image = image;
        graphics = this.image.createGraphics();
        repaint();
    }

    public void reset()
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W, H);
        repaint();
    }
}