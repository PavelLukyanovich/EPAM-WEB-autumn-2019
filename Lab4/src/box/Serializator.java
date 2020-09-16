package box;

import java.io.*;

public class Serializator {
    public static void setFilePath(String filePath) {
        FILE_PATH = filePath;
    }

    public static String FILE_PATH;

    public static void saveToFile(Box box) throws MyException {

        try {
            File file = new File(FILE_PATH);
            FileOutputStream fos = new FileOutputStream("d:\\Pasha\\IT\\Cources" +
                    "\\EPAM\\Projects\\Lab4\\resources\\data.bin");
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(box);
            outputStream.close();
        } catch (NullPointerException ex) {
             throw new MyException (ex);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Box loadFromFile() {
        Box box = null;
        File file = new File(FILE_PATH);
        try {
            FileInputStream fis = new FileInputStream("d:\\Pasha\\IT\\Cources" +
                    "\\EPAM\\Projects\\Lab4\\resources\\data.bin");
            ObjectInputStream inputStream = new ObjectInputStream(fis);
            box = (Box) inputStream.readObject();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return box;
    }
}