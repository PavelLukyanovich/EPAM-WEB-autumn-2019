import Film.FilmCircle;
import Film.FilmRectangle;
import Film.FilmTriangle;
import box.Box;
import paper.Paper;
import paper.PaperCircle;
import paper.PaperRectangle;
import paper.PaperTriangle;
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
       System.out.println(paperCircle.getColor());
       paperCircle.setColors(Paper.Colors.GREY);
       System.out.println(paperCircle.getColor());// Girl can't to paint a figure second time.
       System.out.println(paperCircle.getArea());
       System.out.println(paperCircle.getPerimeter());
       System.out.println(paperCircle.toString());
       System.out.println(paperCircle.equals(paperCircle));
       System.out.println(paperCircle.hashCode());
       System.out.println("------------------");

       PaperRectangle paperRectangle = new PaperRectangle(10, 20);
       paperRectangle.setColors(Paper.Colors.GREY);
       System.out.println(paperRectangle.getColor());
       paperRectangle.setColors(Paper.Colors.BLACK);
       System.out.println(paperRectangle.getColor()); // Girl can't to paint a figure second time.
       System.out.println(paperRectangle.getArea());
       System.out.println(paperRectangle.getPerimeter());
       System.out.println(paperRectangle.toString());
       System.out.println(paperRectangle.equals(paperCircle));
       System.out.println(paperRectangle.hashCode());
       System.out.println("------------------");

       PaperTriangle paperTriangle = new PaperTriangle(15);
       paperTriangle.setColors(Paper.Colors.BLACK);
       System.out.println(paperTriangle.getColor());
       paperTriangle.setColors(Paper.Colors.GREY);
       System.out.println(paperTriangle.getColor());// Girl can't to paint a figure second time.
       System.out.println(paperTriangle.getArea());
       System.out.println(paperTriangle.getPerimeter());
       System.out.println(paperTriangle.toString());
       System.out.println(paperTriangle.equals(paperTriangle));
       System.out.println(paperTriangle.hashCode());
       System.out.println("------------------");

       FilmCircle filmCircle = new FilmCircle(100);
       System.out.println(filmCircle.getArea());
       System.out.println(filmCircle.getPerimeter());
       System.out.println(filmCircle.toString());
       System.out.println("------------------");

       FilmRectangle filmRectangle = new FilmRectangle(50, 200);
       System.out.println(filmRectangle.getArea());
       System.out.println(filmRectangle.getPerimeter());
       System.out.println(filmRectangle.toString());
       System.out.println("------------------");

       FilmTriangle filmTriangle = new FilmTriangle(400);
       System.out.println(filmTriangle.getArea());
       System.out.println(filmTriangle.getPerimeter());
       System.out.println(filmTriangle.toString());
       System.out.println("------------------");

       System.out.println("Girl want to cut figure from other figure... ");

       PaperCircle paperCircle1 = new PaperCircle(paperRectangle);
       System.out.println(paperCircle1.toString());
       System.out.println("------------------");
       PaperTriangle paperTriangle1 = new PaperTriangle(paperCircle);
       System.out.println(paperTriangle1.toString());
       FilmTriangle filmTriangle1 = new FilmTriangle(filmCircle);
       System.out.println(filmTriangle1.toString());
       FilmRectangle filmRectangle1 = new FilmRectangle(filmTriangle1);
       System.out.println(filmRectangle1.toString());
       System.out.println("------------------------------------------------");
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
       box.checkByNumber(4);
       box.checkByNumber(456);
       box.checkByNumber(1);
       box.removeByNumber(1);
       box.checkByNumber(1);
       box.changeByNumber(4, paperRectangle);
       box.finedEquivalent(paperCircle1);
       System.out.println(box.numberOfFigure());
       System.out.println(box.sumOfArea());
       System.out.println(box.sumOfPerimeter());
       System.out.println("----------------");
       Box box1 = new Box();
       box1.addFigure(paperRectangle);
       box1.addFigure(paperTriangle);
       box1.addFigure(filmCircle);
       box1.addFigure(filmRectangle);
       box1.addFigure(filmTriangle);
       box1.addFigure(paperTriangle1);
       box1.addFigure(paperCircle1);
       box1.addFigure(filmRectangle1);
       box1.getCircle();
       box1.getFilmFigure();
       box1.finedEquivalent(filmRectangle);

   }
}
