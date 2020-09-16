package figure;

import java.util.Objects;

public abstract class Triangle extends Figure {
    /** @value set by user
     */
    private double side;
    /** This is first constructor of "Triangle".
     *
     * @param side the sides of the triangle are equal
     */
    public Triangle(double side) {
        this.side = side;
    }
    /** This is second constructor of "Triangle".
     *
     * <p>
     *     This constructor is called when a shape is cut from another shape
     * </p>
     * @param figure any shape
     */
    public Triangle(Figure figure) {
        this.side = figure.getMinSize();
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getPerimeter() {
        return getSide() * 3;
    }

    @Override
    public double getArea() {
        return Math.sqrt((getPerimeter() / 2) * (getPerimeter() / 2 - getSide())
                * (getPerimeter() / 2 - getSide()) * (getPerimeter() / 2 - getSide()) );
    }

    @Override
    public double getMinSize() {
        return getSide() / 5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getSide(), getSide()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSide());
    }
}
