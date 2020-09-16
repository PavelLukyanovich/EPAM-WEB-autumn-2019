import Film.FilmCircle;
import Film.FilmRectangle;
import Film.FilmTriangle;
import box.Box;
import box.Serializator;
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
       /**
        * Serialization and deserialization boxShapes.
        */
       Box box2 = new Box();
       box2.addFigure(paperCircle);
       Serializator serializator = new Serializator();
       System.out.println(box2.toString());
       serializator.saveToFile(box2);
       System.out.println("-------------------------------------------");
       System.out.println(serializator.loadFromFile());


   }
}
