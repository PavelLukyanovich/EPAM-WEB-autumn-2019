package parsing;
import java.io.File;

public class Rename {
    String ourPath;
    public Rename (String path) {
        ourPath = path;
    }
    // Метод  переименовывает каждый каталог ..\[posCode] в ..\ADC_[posCode]
public void renameDir () {
    String StartPath = ourPath;
    File path = new File(StartPath);
    if (path.exists() && path.isDirectory())
    List1(StartPath);
}
    static void List1(String root){
        try{
            File f = new File(root);
            String[] fDirList = f.list();
            if (fDirList != null){
                for (int i = 0; i < fDirList.length; i++){
                    File f1 = new File(root + File.separator + fDirList[i]);
                    if (f1.isDirectory()){
                        f1.renameTo(new File(root + File.separator + "ADC_" + fDirList[i]));
                    }
                    else
                    {
                        List1(root + File.separator + "ADC_" + fDirList[0]);
                    }
                }
            }
        }
        catch (NullPointerException s){
            System.out.println(s);
        }
    }


    //Метод переименовывающий каждый файл.
public void renameXML() {
    String StartPath = ourPath;
    File path = new File(StartPath);
    if (path.exists() && path.isDirectory())
          List(StartPath);
}
    static void List(String root){
        try{
            File f = new File(root);
            String[] fDirList = f.list();
            if (fDirList != null){
                for (int i = 0; i < fDirList.length; i++){
                    File f1 = new File(root + File.separator + fDirList[i]);
                    if (f1.isFile()){
                        f1.renameTo(new File(root + File.separator + "ADC_" + fDirList[i]));
                    }
                    else
                    {
                        List(root + File.separator + fDirList[i]);
                    }
                }
            }
        }
        catch (NullPointerException s){
            System.out.println(s);
        }
    }
}


