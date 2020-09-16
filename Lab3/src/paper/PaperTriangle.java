package paper;

import figure.Figure;
import figure.Triangle;

import java.util.Objects;

public class PaperTriangle extends Triangle implements Paper {
    /** Link to object "Painting" class places in this field.
     *
     * */
    private Painting painting = new Painting();

    public PaperTriangle(double side) {
        super(side);
    }

    public PaperTriangle(Paper paperFigure) {
        super((Figure) paperFigure);
        painting = paperFigure.getPainted();


    }
    @Override
    public Colors getColor() {
        return painting.getColorPainted();
    }

    @Override
    public void setColors(Colors color) {
        painting.setColorPainted(color);
    }

    @Override
    public Painting getPainted() {
        return painting;
    }

    @Override
    public String toString() {
        return PaperTriangle.class.getSimpleName() + ": side = " + getSide()
                + " , " + '\n' + " : color = " + getColor();
    }

    @Override
    public boolean equals(Object o) {
        super.equals(o);
        if (this == o) return true;
        if (!(o instanceof PaperRectangle)) return false;
        if (!super.equals(o)) return false;
        PaperTriangle that = (PaperTriangle) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), painting);
    }
}
