// A triangle is the best shape for drawing mesh on a computer
// Resources:   https://steemit.com/computergraphics/@jrkirby/the-fundamentals-of-computer-graphics-i-triangles-and-rendering
//              https://ericsink.com/wpf3d/5_Triangles.html
public class Triangle {
    Vertex v1;
    Vertex v2;
    Vertex v3;

    java.awt.Color color;


    Triangle(Vertex v1, Vertex v2, Vertex v3, java.awt.Color color) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
}
