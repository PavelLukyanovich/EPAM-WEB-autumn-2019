package Film;

import figure.Figure;
import figure.Triangle;

public class FilmTriangle extends Triangle implements Film {

    public FilmTriangle(double side) {
        super(side);
    }

    public FilmTriangle(Figure figure) {
        super(figure);
    }

    @Override
    public String toString() {
        return FilmTriangle.class.getSimpleName() + ": side = " + getSide();
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
