import org.xml.sax.SAXException;
import parsing.DOMxmlEdit;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, SAXException, TransformerException {
        DOMxmlEdit doMxmlEdit = new DOMxmlEdit("d:/IT/Cources/EPAM/Projects/Lab7/resources/ADC/");
        doMxmlEdit.DOMParser();
    }
}
