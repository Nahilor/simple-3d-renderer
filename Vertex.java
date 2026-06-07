/*
    * X is for left and right directions
    * Y is for up and down directions
    * Z is for depth meaning it is perpendicular to the screen. 
    * x > 0 → right
    * x < 0 → left
    * y > 0 → up
    * y < 0 → down
    * z > 0 → toward the viewer
    * z < 0 → away from the viewer
*/
public class Vertex {
    double x;
    double y;
    double z;

    Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
