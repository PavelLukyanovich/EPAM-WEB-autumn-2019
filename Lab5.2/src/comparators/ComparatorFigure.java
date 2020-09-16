package comparators;

import figure.Figure;
import java.util.Comparator;

public class ComparatorFigure implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
    }

}
