package film;

import figure.Circle;
import figure.Figure;
import paper.Paper;

public class FilmCircle extends Circle implements Film{

    public FilmCircle(double radius) {
        super(radius);
    }
    public FilmCircle (Figure filmFigure){
        super(filmFigure);
    }

    @Override
    public String toString() {
        return FilmCircle.class.getSimpleName() + ": radius = " + getRadius() + "color" + getColor();
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
