package figure;

import java.util.Objects;

public abstract class Rectangle extends Figure {
    /** @value set by user
     */
    private double width;
    private double length;
    /** This is first constructor of "Rectangle".
     *
     * @param length length of rectangle
     * @param width width of rectangle
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    /** This is second constructor of "Rectangle".
     *
     * <p>
     *     This constructor is called when a shape is cut from another shape
     * </p>
     * @param figure any shape
     */
    public Rectangle(Figure figure) {
        this.width = figure.getMinSize();
        this.length = figure.getMinSize();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return (getLength() + getWidth()) * 2;
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getMinSize() {
        return Math.min(getWidth(), getLength()) / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getWidth(), getWidth()) == 0 &&
                Double.compare(rectangle.getLength(), getLength()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getLength());
    }
}
