package parsing;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

import static javax.xml.transform.TransformerFactory.newInstance;

public class DOMxmlEdit {

    public Document doc;
    static File file;
    static String filePath;
    //public File filePathNew = new File(new File("d:/IT/Cources/EPAM/Projects/Lab7/renameFiles/").getAbsolutePath()
          //  + File.separator + file.getName());
    public DOMxmlEdit(String path) {
        filePath = path;
    }
     void BuildFactory (File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();;
        Document document = docBuilder.parse(file);
        this.doc = document;
    }



    public void DOMParser() {
        String StartPath = filePath;
        File path = new File(StartPath);
        if (path.exists() && path.isDirectory())
            List(StartPath);
    }
    void List(String root){
        try{
            File f = new File(root);
            String[] fDirList = f.list();
            if (fDirList != null){
                for (int i = 0; i < fDirList.length; i++){
                    File f1 = new File(root + File.separator + fDirList[i]);
                    if (f1.isFile()){
                        file = f1;
                        BuildFactory(file);
                        setPointOfSale(doc);
                        setPointOfSaleDescription(doc);
                        transform(doc, new File(new File("d:/IT/Cources/EPAM/Projects/Lab7/renameFiles/").getAbsolutePath()
                                + File.separator + file.getName()));
                    }
                    else
                    {
                        List(root + File.separator + fDirList[i]);
                    }
                }
            }
        }
        catch (NullPointerException | ParserConfigurationException | IOException | SAXException | TransformerException s){
            System.out.println(s);
        }
    }

    public void setPointOfSale(Document document) {
        Node node = document.getDocumentElement().getElementsByTagName("PointOfSale").item(0);
        NamedNodeMap attributes = node.getAttributes();
        for (int j = 0; j < attributes.getLength(); j++) {
            String key = attributes.item(j).getNodeName();
            String value = attributes.item(j).getNodeValue();
            if ("ParentPointOfSale".equals(key)) {
                attributes.item(j).setNodeValue("ADC_" + value);
            } else if ("PointOfSaleCode".equals(key)) {
                attributes.item(j).setNodeValue("ADC_" + value);
            }
        }
    }

   public void setPointOfSaleDescription(Document document) {
        Node node = document.getDocumentElement().getElementsByTagName("PointOfSaleDescription").item(0);
        NamedNodeMap attributes = node.getAttributes();
        for (int j = 0; j < attributes.getLength(); j++) {
            String key = attributes.item(j).getNodeName();
            String value = attributes.item(j).getNodeValue();
            if ("Description".equals(key)) {
                attributes.item(j).setNodeValue("ADC_" + value);
            }
        }
    }

    public void transform(Node document, File filepath) throws TransformerException {
        TransformerFactory transformerFactory = newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(filepath);
        transformer.transform(source, result);
    }

}
