import box.Box;
import film.FilmCircle;
import film.FilmRectangle;
import film.FilmTriangle;
import paper.Paper;
import paper.PaperCircle;
import paper.PaperRectangle;
import paper.PaperTriangle;
import java.util.ArrayList;

/** Girl cut shapes, painting it an than put into the box.
 *
 * It is a test class
 * @author Pavel Lukyanovic
 * @version 1.0
 * */
public class Girl {
    public static void main(String[] args) {
        PaperCircle paperCircle = new PaperCircle(10.0);
        paperCircle.setColors(Paper.Colors.RED);
        PaperRectangle paperRectangle = new PaperRectangle(10, 20);
        paperRectangle.setColors(Paper.Colors.GREY);
        PaperTriangle paperTriangle = new PaperTriangle(15);
        paperTriangle.setColors(Paper.Colors.BLACK);
        FilmCircle filmCircle = new FilmCircle(100);
        FilmRectangle filmRectangle = new FilmRectangle(50, 200);
        FilmTriangle filmTriangle = new FilmTriangle(400);
        PaperCircle paperCircle1 = new PaperCircle(paperRectangle);
        PaperTriangle paperTriangle1 = new PaperTriangle(paperCircle);
        FilmTriangle filmTriangle1 = new FilmTriangle(filmCircle);
        FilmRectangle filmRectangle1 = new FilmRectangle(filmTriangle1);

        Box box = new Box();

        box.addFigure(paperCircle);
        box.addFigure(paperCircle);
        box.addFigure(paperRectangle);
        box.addFigure(paperTriangle);
        box.addFigure(filmCircle);
        box.addFigure(filmRectangle);
        box.addFigure(filmTriangle);
        box.addFigure(filmTriangle);
        box.addFigure(paperTriangle1);
        box.addFigure(paperCircle1);
        box.addFigure(filmRectangle1);
        box.addFigure(filmTriangle1);
        box.addFigure(filmRectangle1);
// Возможность динамического изменения размера коробки представлена методом addFigure().

//Сортировка коробки с фигурами по заданным параметрам. (форма, цвет, площадь)
       box.sortByShapes();
        System.out.println(box);

        box.sortByArea();
        System.out.println(box);

        Box.InnerComparator inComp = new Box.InnerComparator();

        Box.boxShapes.sort(inComp);
        System.out.println(Box.boxShapes);
// Получить все фигуры по одного цвета.
        System.out.println(box.getAllFigureByColor(Paper.Colors.RED));
// Получить все пленочные фигуры.
        System.out.println(box.getAllFilmFigure());
// Получить все заданные фигуры.
        System.out.println(box.getAllSpecifiedFigure("Rectangle"));
// Достать группу фигур начиная и заканчивая заданными индексами.
        System.out.println(box.getGroupOfFigure(1,3));
// Положить группу фигур (заранее объединенную в лист) в коробку.
        ArrayList groupList = new ArrayList();
        groupList.add(paperRectangle);
        groupList.add(paperRectangle);
        groupList.add(paperRectangle);
        groupList.add(paperRectangle);
        System.out.println(box.addGroupOfFigure(groupList));



    }
}
