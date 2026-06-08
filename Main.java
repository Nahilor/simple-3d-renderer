// This is a simple viewer app
// it uses swing 
/*  The idea is to use swing for the application
    which will hava the image and two sliders
    to change the rotation of the 3d object.

    Resources used: https://www.geeksforgeeks.org/java/introduction-to-java-swing/
                    https://beginnersbook.com/2016/09/swing-borderlayout-in-java/
                    https://youtu.be/yRwQ7A6jVLk?si=By65dXSvtksMCxdx Matrices
                    https://youtu.be/vzt9c7iWPxs?si=TOQ86q2IAes74p_J Matrix multiplication
                    https://youtu.be/EZufiIwwqFA?si=_fYYpR8_IWPzAlHT Rotation
                    https://youtu.be/BKsZrkI6sro?si=hqzYkazhZAoiHXHJ 3d rotation

*/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.ArrayList;

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

        // Render logic will be here
        List<Triangle> tetrahedron = new ArrayList<>();
        tetrahedron.add(new Triangle(new Vertex(100, 100, 100),
                            new Vertex(-100, -100, 100),
                            new Vertex(-100, 100, -100),
                            Color.WHITE));
        tetrahedron.add(new Triangle(new Vertex(100, 100, 100),
                            new Vertex(-100, -100, 100),
                            new Vertex(100, -100, -100),
                            Color.RED));
        tetrahedron.add(new Triangle(new Vertex(-100, 100, -100),
                            new Vertex(100, -100, -100),
                            new Vertex(100, 100, 100),
                            Color.GREEN));
        tetrahedron.add(new Triangle(new Vertex(-100, 100, -100),
                            new Vertex(100, -100, -100),
                            new Vertex(-100, -100, 100),
                            Color.BLUE));

        // Panel to show the render
        JPanel renderViewPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g; // This allows methods in graphics2d to be used that are not in Graphics
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                


                // rotation
                double horizontalRotationRadian = Math.toRadians(horizontaSlider.getValue());
   

                Matrix3 rotationMatrix3Y = new Matrix3(new double[] {
                Math.cos(horizontalRotationRadian), 0, Math.sin(horizontalRotationRadian),
                0, 1, 0,
                -Math.sin(horizontalRotationRadian), 0, Math.cos(horizontalRotationRadian)
                });
                double verticalRotationRadian = Math.toRadians(verticalSlider.getValue());
                Matrix3 rotationMatrix3X = new Matrix3(new double[]{
                    1, 0, 0,
                    0, Math.cos(verticalRotationRadian), -Math.sin(verticalRotationRadian),
                    0, Math.sin(verticalRotationRadian), Math.cos(verticalRotationRadian)
                });

                Matrix3 transform = rotationMatrix3X.multiply(rotationMatrix3Y);
                // this is ignoring the z axis
                g2.translate(getWidth() / 2, getHeight() / 2); // Moves the origin (0,0) point to the center of the panel
                // This makes the 3D shape render from the middle of the window instead of the top-left corner
                g2.setColor(Color.WHITE);
                for (Triangle t : tetrahedron) {
                    Vertex v1 = transform.transform(t.v1);
                    Vertex v2 = transform.transform(t.v2);
                    Vertex v3 = transform.transform(t.v3);
                    // v1 = rotationMatrix3X.transform(t.v1);
                    // v2 = rotationMatrix3X.transform(t.v2);
                    // v3 = rotationMatrix3X.transform(t.v3);
                    Path2D path = new Path2D.Double();
                    path.moveTo(v1.x, v1.y); // moves the pen to the specified point
                    path.lineTo(v2.x, v2.y); // draws a line from vertex1(Point1) to vertex2(Point2)
                    path.lineTo(v3.x, v3.y); // same from the current location of the pen to the specified point
                    path.closePath(); // this automatically closes the path back the first vertex
                    g2.draw(path); // This renders the lines. Here there is no z axis it is just orthogonal view
                }
            }
        };
        pane.add(renderViewPanel, BorderLayout.CENTER);



        // Event handling
        horizontaSlider.addChangeListener(e -> renderViewPanel.repaint());
        verticalSlider.addChangeListener(e -> renderViewPanel.repaint());

        // Sets size and makes the window visible its called here because if it is put next to the declaration of JFrame window
        // It will displpay nothing because it doesn't get updated unless there is a change in the window
        // nothing you do after this two lines will appear first time it is run. so it must be moved to the bottom.
        frame.setSize(500, 500);
        frame.setVisible(true);
        
    }
}