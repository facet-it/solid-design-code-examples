package be.course.design.inheritance.shape;

/**
 * An implementation / abstraction of a Rectangle. It is not wrong, it is just an implementation.
 * What if we decide to use this class as a base class for another class, like Square?
 *
 * In this case, it would not be a good idea. Because the way we modelled the Rectangle class, isn't correct
 * according to the mathematical rules. We have just given the properties widht and lenght to our Rectangle
 * class as these are the properties that are important in our abstraction. But from a math perspective,
 * a rectangle needs to have 4 angles of 90 degrees. That is what makes a shape with a lenght and a width
 * a rectangle.
 *
 * A square is a rectangle because it also has 4 angles of 90 degrees. But since we have not included these, our
 * base class is not correct. And that is not the only problem: a square also does not have a lenght and a width,
 * it has 4 sided of an equal length.
 */
public class Rectangle {

    private int width;
    private int lenght;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int calculateArea() {
        return this.width * this.lenght;
    }
}
