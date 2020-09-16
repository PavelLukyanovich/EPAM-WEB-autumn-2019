package paper;

import figure.Figure;
import figure.Rectangle;

import java.util.Objects;

public class PaperRectangle extends Rectangle implements Paper {
    /** Link to object "Painting" class places in this field.
     *
     * */
    private Painting painting = new Painting();

    public PaperRectangle(double width, double length) {
        super(width, length);
    }

    public PaperRectangle(Paper paperFigure) {
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
        return PaperRectangle.class.getSimpleName() + ": width = "
                + getWidth() + " length = " + getLength() + " , " + '\n' + " : color = " + getColor();
    }

    @Override
    public boolean equals(Object o) {
        super.equals(o);
        if (this == o) return true;
        if (!(o instanceof PaperRectangle)) return false;
        if (!super.equals(o)) return false;
        PaperRectangle that = (PaperRectangle) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), painting);
    }
}
