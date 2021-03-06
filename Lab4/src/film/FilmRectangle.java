package Film;

import figure.Figure;
import figure.Rectangle;

public class FilmRectangle extends Rectangle implements Film.Film {

    public FilmRectangle(double width, double length) {
        super (width, length);
    }

    public FilmRectangle(Figure figure) {
        super (figure);
    }
    @Override
    public String toString() {
        return FilmRectangle.class.getSimpleName() + ": width = "
                + getWidth() + " length = " + getLength();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
