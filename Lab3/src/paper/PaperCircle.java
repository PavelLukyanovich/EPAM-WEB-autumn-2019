package paper;

import figure.Circle;
import figure.Figure;
import java.util.Objects;

public class PaperCircle extends Circle implements Paper {

    /** Link to object "Painting" class places in this field.
     *
     * */
    private String name = "Paper Circle";
    private static int count = 1;
    transient int size = 20;


    private Painting painting = new Painting();


    public PaperCircle(double radius) {
        super(radius);
    }

    public PaperCircle(Paper paperFigure) {
        super((Figure) paperFigure);
        painting = paperFigure.getPainted();
    }
    @Override
    public Colors getColor(){
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
            return PaperCircle.class.getSimpleName() + " : radius = " + getRadius()
                    + " , " + '\n' + " : color = " + getColor() + " : name = " + name +
                    " : count = " + count + " size: " + size;
        }

        @Override
        public boolean equals(Object o) {
        super.equals(o);
            if (this == o) return true;
            if (!(o instanceof PaperCircle)) return false;
            if (!super.equals(o)) return false;
            PaperCircle that = (PaperCircle) o;
            return getColor() == that.getColor();
        }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), painting);
    }
}
