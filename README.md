# Simple 3D Renderer

A Java-based 3D graphics renderer that demonstrates fundamental computer graphics concepts including matrix transformations, 3D rotations, and rasterization.

## Overview

This project renders 3D shapes (currently a tetrahedron) using Java Swing for the GUI and implements custom matrix math for 3D transformations. The renderer allows interactive rotation of objects using sliders.

## Features

- **3D Shape Rendering**: Renders triangular mesh objects in 3D space
- **Interactive Rotation**: Horizontal and vertical sliders to control object rotation in real-time
- **Matrix Transformations**: Custom 3x3 matrix implementation for 3D rotations
- **Barycentric Coordinates**: Implements triangle rasterization using barycentric coordinates
- **Java Swing GUI**: Simple and intuitive graphical interface

## Technical Details

### Core Components

- **Main.java**: Entry point with GUI setup and rendering loop
- **Vertex.java**: Represents a 3D point with (x, y, z) coordinates
  - x: left/right direction
  - y: up/down direction
  - z: depth (toward/away from viewer)
- **Matrix3.java**: 3x3 matrix for 3D transformations and rotations
- **Triangle.java**: Triangle mesh primitive with color
  - Used for efficient 3D mesh representation

### How It Works

1. **3D Object Definition**: Objects are defined as collections of triangles
2. **Transformation**: Objects are rotated using rotation matrices (X, Y, Z axes)
3. **Projection**: 3D coordinates are projected onto 2D screen space
4. **Rasterization**: Triangles are filled using barycentric coordinates
5. **Rendering**: Results are displayed on screen with interactive controls

## Usage

### Prerequisites
- Java Development Kit (JDK)
- No external dependencies required

### Compilation & Execution

```bash
javac *.java
java Main
```

### Controls

- **Horizontal Slider**: Rotate the object left/right (Y-axis rotation)
- **Vertical Slider**: Rotate the object up/down (X-axis rotation)

## Learning Resources

This project incorporates concepts from the following resources:

- [Java Swing Introduction](https://www.geeksforgeeks.org/java/introduction-to-java-swing/)
- [Swing BorderLayout](https://beginnersbook.com/2016/09/swing-borderlayout-in-java/)
- [Matrices](https://youtu.be/yRwQ7A6jVLk?si=By65dXSvtksMCxdx)
- [Matrix Multiplication](https://youtu.be/vzt9c7iWPxs?si=TOQ86q2IAes74p_J)
- [3D Rotation Mathematics](https://youtu.be/BKsZrkI6sro?si=hqzYkazhZAoiHXHJ)
- [Barycentric Coordinate System](https://en.wikipedia.org/wiki/Barycentric_coordinate_system)
- [Triangle-Based Graphics](https://ericsink.com/wpf3d/5_Triangles.html)

## Future Enhancements

Potential improvements for this project:

- Support for multiple 3D models
- Depth sorting/Z-buffering for proper occlusion
- Lighting and shading
- Perspective projection improvements
- Model loading from file formats (OBJ, etc.)
- Performance optimization

## License

This project is provided as-is for educational purposes.

## Author

Nahilor

---

**Note**: This is a learning project designed to understand the fundamentals of 3D graphics rendering without relying on external graphics libraries.
