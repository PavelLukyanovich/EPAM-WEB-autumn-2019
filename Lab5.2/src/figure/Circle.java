package figure;

import static java.util.Objects.hash;

public abstract class Circle extends Figure{
    /** @value set by user
     */
    private double radius;
    /** This is first constructor of "Circle".
     *
     * @param radius radius og circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }
    /** This is second constructor of "Circle".
     *
     * <p>
     *     This constructor is called when a shape is cut from another shape
     * </p>
     * @param figure any shape
     */
    public Circle (Figure figure) {
        this.radius = figure.getMinSize();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    /** Calculating perimeter of shape.
     *
     * @return perimeter of shape
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }
    /** Calculating area of shape.
     *
     * @return area shape
     */
    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double getMinSize() {
        return getRadius() / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return hash(getRadius());
    }
}
