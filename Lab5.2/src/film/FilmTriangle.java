package film;

import figure.Figure;
import figure.Triangle;
import paper.Paper;

public class FilmTriangle extends Triangle implements Film {

    public FilmTriangle(double side) {
        super(side);
    }

    public FilmTriangle(Figure figure) {
        super(figure);
    }

    @Override
    public String toString() {
        return FilmTriangle.class.getSimpleName() + ": side = " + getSide() + "color" + getColor();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public Paper.Colors getColor() {
        return Paper.Colors.TRANSPARENT;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
