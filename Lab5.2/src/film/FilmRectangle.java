package film;

import figure.Figure;
import figure.Rectangle;
import paper.Paper;

public class FilmRectangle extends Rectangle implements Film {

    public FilmRectangle(double width, double length) {
        super (width, length);
    }

    public FilmRectangle(Figure figure) {
        super (figure);
    }
    @Override
    public String toString() {
        return FilmRectangle.class.getSimpleName() + ": width = "
                + getWidth() + " length = " + getLength() + "color" + getColor();
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
