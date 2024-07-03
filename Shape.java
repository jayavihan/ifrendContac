// Abstract class representing a Shape
public abstract class Shape {
	// Abstract method to calculate area (implementation depends on specific shape)
	public abstract double calculateArea();
  }
  
  // Interface representing Drawable objects (can be drawn on screen)
  public interface Drawable {
	// Method to draw the object on screen (implementation specific to the object)
	public void draw();
  }
  
  // Square class inheriting from Shape and implementing Drawable
  public class Square extends Shape implements Drawable {
	private double sideLength;
  
	public Square(double sideLength) {
	  this.sideLength = sideLength;
	}
  
	// Implementation for calculating area of a square
	@Override
	public double calculateArea() {
	  return sideLength * sideLength;
	}
  
	// Implementation for drawing a square (specific behavior for squares)
	@Override
	public void draw() {
	  System.out.println("Drawing a square with side length: " + sideLength);
	  // You could add code here to actually draw the square on the screen (e.g., using graphics libraries)
	}
  }
  
  // Circle class inheriting from Shape
  public class Circle extends Shape {
	private double radius;
  
	public Circle(double radius) {
	  this.radius = radius;
	}
  
	// Implementation for calculating area of a circle
	@Override
	public double calculateArea() {
	  return Math.PI * radius * radius;
	}
  }
  
  public class Demo {
	public static void main(String[] args) {
	  // Create an array of shapes (can hold both Square and Circle objects)
	  Shape[] shapes = {new Square(5), new Circle(3)};
  
	  // Loop through shapes and call calculateArea() (polymorphism)
	  for (Shape shape : shapes) {
		System.out.println("Area of " + shape.getClass().getSimpleName() + ": " + shape.calculateArea());
	  }
  
	  // Create a Square object and call draw()
	  Square square = new Square(4);
	  square.draw();
	}
  }
  