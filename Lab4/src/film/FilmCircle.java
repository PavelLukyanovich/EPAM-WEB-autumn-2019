package Film;
import figure.Circle;
import figure.Figure;

public class FilmCircle extends Circle implements Film.Film {

    public FilmCircle(double radius) {
        super(radius);
    }
    public FilmCircle (Figure filmFigure){
        super(filmFigure);
    }

    @Override
    public String toString() {
        return FilmCircle.class.getSimpleName() + ": radius = " + getRadius();
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
