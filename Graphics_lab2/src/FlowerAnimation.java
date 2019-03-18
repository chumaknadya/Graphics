import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class FlowerAnimation extends JPanel implements ActionListener {
    private static int maxWidth;
    private static int maxHeight;
    private double angle = 0;
    private double tx = 100;
    private double ty = 100;


    Timer timer;

    public FlowerAnimation(){
        timer = new Timer(10, this);
        timer.start();
    }


    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        setAnimation(g);
    }

    public void setAnimation(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setBackground(new Color(0,255,128));
        g2d.clearRect(0,0 ,maxWidth, maxHeight);

        BasicStroke basicStroke = new BasicStroke(6,BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(basicStroke);
        g2d.drawRect(15, 15, 760, 740);

        double[][] firstLeafPoints = {{109, 150}, {115, 100}, {160, 132}};
        GeneralPath firstLeaf = new GeneralPath();
        firstLeaf.moveTo(firstLeafPoints[0][0], firstLeafPoints[0][1]);
        for (int k = 1; k < firstLeafPoints.length; k++)
            firstLeaf.lineTo(firstLeafPoints[k][0], firstLeafPoints[k][1]);
        firstLeaf.closePath();


        double[][] secondLeafPoints = {{123, 87}, {165, 58}, {170, 115}};
        GeneralPath secondLeaf = new GeneralPath();
        secondLeaf.moveTo(secondLeafPoints[0][0], secondLeafPoints[0][1]);
        for (int k = 1; k < secondLeafPoints.length; k++)
            secondLeaf.lineTo(secondLeafPoints[k][0], secondLeafPoints[k][1]);
        secondLeaf.closePath();

        double[][] thirdLeafPoints = {{185, 59}, {235, 85}, {190, 112}};
        GeneralPath thirdLeaf = new GeneralPath();
        thirdLeaf.moveTo(thirdLeafPoints[0][0], thirdLeafPoints[0][1]);
        for (int k = 1; k < thirdLeafPoints.length; k++)
            thirdLeaf.lineTo(thirdLeafPoints[k][0], thirdLeafPoints[k][1]);
        thirdLeaf.closePath();

        double[][] fourthLeafPoints = {{242, 97}, {241, 160}, {203, 131}};
        GeneralPath fourthLeaf = new GeneralPath();
        fourthLeaf.moveTo(fourthLeafPoints[0][0], fourthLeafPoints[0][1]);
        for (int k = 1; k < fourthLeafPoints.length; k++)
            fourthLeaf.lineTo(fourthLeafPoints[k][0], fourthLeafPoints[k][1]);
        fourthLeaf.closePath();

        double[][] fifthLeafPoints = {{236, 166}, {192, 195}, {195, 148}};
        GeneralPath fifthLeaf = new GeneralPath();
        fifthLeaf.moveTo(fifthLeafPoints[0][0], fifthLeafPoints[0][1]);
        for (int k = 1; k < fifthLeafPoints.length; k++)
            fifthLeaf.lineTo(fifthLeafPoints[k][0], fifthLeafPoints[k][1]);
        fifthLeaf.closePath();

        double[][] sixthLeafPoints = {{165, 194}, {115, 160}, {165, 148}};
        GeneralPath sixthLeaf = new GeneralPath();
        sixthLeaf.moveTo(sixthLeafPoints[0][0], sixthLeafPoints[0][1]);
        for (int k = 1; k < sixthLeafPoints.length; k++)
            sixthLeaf.lineTo(sixthLeafPoints[k][0], sixthLeafPoints[k][1]);
        sixthLeaf.closePath();

        GradientPaint gp = new GradientPaint(
                70, 100,
                Color.GRAY,
                200, 180,
                Color.PINK,
                true
        );
        g2d.setPaint(gp);
        g2d.translate(tx,ty);
        //g2d.rotate(angle, 115,100);
        //g2d.rotate(angle, 190,130);

        g2d.fill(firstLeaf);
        g2d.fill(secondLeaf);
        g2d.fill(thirdLeaf);
        g2d.fill(fourthLeaf);
        g2d.fill(fifthLeaf);
        g2d.fill(sixthLeaf);

        g2d.setColor(new Color(0, 128, 0));
        g2d.drawLine(180,160,180,260);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(150, 100, 60, 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(tx == 100 && ty <= 350){
            ty += 1;
        } else if (tx < 350 && ty > 350 ){
            tx +=1;
        }else if(tx >= 350 && ty >= 100) {
            ty -= 1;
        } else if (tx > 100 && ty < 140 ){
            tx -=1;
        }

        angle -= 0.01;

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics_lab#2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();


        frame.add(new FlowerAnimation());

        frame.setVisible(true);
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
}