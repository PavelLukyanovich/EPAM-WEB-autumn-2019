package box;

import comparators.ComparatorFigure;
import figure.Circle;
import figure.Figure;
import film.Film;
import paper.Paper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Object of "Box" class is a box for our shapes.
 *
 * To store the shapes we use the List.
 *
 */

public class Box {
    /**
     * Creating box for the shapes.
     * <p>
     * Use ArrayList
     */
    public static List<Figure> boxShapes = new ArrayList<>();

    /**
     * Add figure to the box.
     *
     * @param figure any shape
     * @return false if shape wasn't added
     */
    public boolean addFigure(Figure figure) {
        if (!(figure == null) && !(boxShapes.contains(figure))) {
            boxShapes.add(figure);
            return true;
        }
        return false;
    }

    /**
     * Check which shape is on this index.
     *
     * @param x number of index
     * @return false if shape isn't in a box
     */
    public boolean checkByNumber(int x) {
        if (x >= 0 && x < boxShapes.size()) {
            System.out.println(boxShapes.get(x));
            return true;
        }
        return false;
    }

    /**
     * Removing shape with called index.
     *
     * @param x number of index
     * @return false if shape wasn't removed
     */
    public boolean removeByNumber(int x) {
        if (x >= 0 && x < boxShapes.size()) {
            boxShapes.remove(x);
            return true;
        }
        return false;
    }

    /**
     * To change shape by called index.
     *
     * @param x      number of index
     * @param figure any shape
     * @return false if shape wasn't changed
     */
    public boolean changeByNumber(int x, Figure figure) {
        if (x >= 0 && x < boxShapes.size()) {
            boxShapes.set(x, figure);
            return true;
        }
        return false;
    }

    /**
     * Searching identical shape in box.
     *
     * @param figure any shape
     * @return false if shape isn't in a box
     */
    public boolean finedEquivalent(Figure figure) {
        for (Figure fi : boxShapes) {
            if (figure.equals(fi)) {
                System.out.println(boxShapes.indexOf(fi));
                return true;
            }
        }
        return false;
    }
    /**
     * How many shapes in the box.
     *
     * @return int "size" - number of shapes are in the box
     */
        public int numberOfFigure () {
            return boxShapes.size();
        }
    /**
     * @return double "sum" - sum of perimeters all shapes
     */
        public double sumOfArea () {
            double sumArea = 0;
            for (Figure sa : boxShapes) {
                sumArea += sa.getArea();
            }
            return sumArea;
        }
    /**
     * @return double "sum" - sum of areas all shapes
     */
        public double sumOfPerimeter () {
            double sumPerim = 0;
            for (Figure sa : boxShapes) {
                sumPerim += sa.getPerimeter();
            }
            return sumPerim;
        }
    /**
     * Get out of the box all circle.
     */
        public void getCircle () {
            int count = 0;
            for (Figure figure : boxShapes) {
                if (figure instanceof Circle) {
                    System.out.println("Positions of circle: " + boxShapes.indexOf(figure) + "; ");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("There is no this shape in this list");

            } else {
                System.out.println(count + " circles in this list");
            }
        }
    /**
     * Get out of the box all film shapes.
     */
        public void getFilmFigure () {
            int count = 0;
            for (Figure figure : boxShapes) {
                if (figure instanceof Film) {
                    System.out.println("Positions of film figure: " + boxShapes.indexOf(figure) + "; ");
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("There is no this shape in this list");

            } else {
                System.out.println(count + " film figure in this list");
            }
        }

public void sortByShapes() {
    ComparatorFigure cf = new ComparatorFigure();
    boxShapes.sort(cf);
}
    public void sortByArea(){
        boxShapes.sort(new Comparator<Figure>() {
            @Override
            public int compare(Figure o1, Figure o2) {
                return (int) (Math.round(o1.getArea()) - Math.round(o2.getArea()));
            }
        });
    }
    public static class InnerComparator implements Comparator<Figure>{

        @Override
        public int compare(Figure o1, Figure o2) {
            return o1.getColor().compareTo(o2.getColor()) ;
        }
    }

public List getAllFigureByColor(Paper.Colors color) {
    List list = new ArrayList();
            for(Figure f : boxShapes ) {
                if(f.getColor().compareTo(color) == 0)
                    list.add(f);
            }return list;
}

    public List getAllFilmFigure() {
        List list = new ArrayList();
        for (Figure f : boxShapes) {
            if (f instanceof Film)
                list.add(f);
        }
        return list;
    }

    public List getAllSpecifiedFigure(String name ) {
        List list = new ArrayList();
        for (Figure f : boxShapes)
            if (f.getClass().getSimpleName().contains(name))
                list.add(f);
        return list;
    }

    public List addGroupOfFigure(ArrayList list) {
            boxShapes.addAll(list);
            return boxShapes;
    }
public List getGroupOfFigure(int startIndex, int endIndex) {
        List list = new ArrayList();
        list = boxShapes.subList(startIndex, endIndex);
 return list;
}
            @Override
            public String toString() {
                return boxShapes.toString();
            }
        }
