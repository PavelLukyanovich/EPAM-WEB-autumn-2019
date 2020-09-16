import Film.FilmCircle;
import Film.FilmRectangle;
import Film.FilmTriangle;
import box.Box;
import box.MyException;
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
   public static void main(String[] args) throws MyException {
       PaperCircle paperCircle = new PaperCircle(10.0);
       /**
        * No Exceptions.
        */
       Box box3 = new Box();
       box3.addFigure(paperCircle);
       Serializator serializator = new Serializator();
       serializator.setFilePath("data.bin");
       serializator.saveToFile(box3);
       serializator.loadFromFile();
       System.out.println("No Exceptions");
       System.out.println("--------------------------------------------");
       /**
        * My Exception.
        */
       Box box4 = new Box();
       box4.addFigure(paperCircle);
       Serializator serializator1 = new Serializator();
       serializator1.setFilePath(null);
       serializator.saveToFile(box4);
   }
}
