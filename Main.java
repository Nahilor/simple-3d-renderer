// This is a simple viewer app
// it uses swing 
/*  The idea is to use swing for the application
    which will hava the image and two sliders
    to change the rotation of the 3d object.

    Resources used: https://www.geeksforgeeks.org/java/introduction-to-java-swing/
                    https://beginnersbook.com/2016/09/swing-borderlayout-in-java/

*/

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3D viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        Container pane = frame.getContentPane();
 
        // Layout type
        pane.setLayout(new BorderLayout());

        // sliders (Control rotations of 3d objects)
        // JSlider constructor takes 3 arguments orientation(Vertical or Horizontal), min, max and value
        JSlider horizontaSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 360, 180);
        pane.add(horizontaSlider, BorderLayout.SOUTH);

        JSlider verticalSlider = new JSlider(SwingConstants.VERTICAL,0, 360, 180);
        pane.add(verticalSlider, BorderLayout.EAST);

        // Panel to show the render
        JPanel renderViewPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g; // This allows methods in graphics2d to be used that are not in Graphics
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Render logic will be here


            }
        };
        pane.add(renderViewPanel, BorderLayout.CENTER);

        // Sets size and makes the window visible its called here because if it is put next to the declaration of JFrame window
        // It will displpay nothing because it doesn't get updated unless there is a change in the window
        // nothing you do after this two lines will appear first time it is run. so it must be moved to the bottom.
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}