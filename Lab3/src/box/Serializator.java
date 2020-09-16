package box;

import java.io.*;

public class Serializator {
    public static final String FILE_PATH = "data.bin";

    public static void saveToFile(Box box) {
        File file = new File(FILE_PATH);
        try {
            FileOutputStream fos = new FileOutputStream("d:\\Pasha\\IT\\Cources\\EPAM\\repo\\epam_2019\\Lab3\\resources\\data.bin");
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);
            outputStream.writeObject(box);
            outputStream.close();
        } catch (
                FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Box loadFromFile() {
        Box box = null;
        File file = new File(FILE_PATH);
        try {
            FileInputStream fis = new FileInputStream("d:\\Pasha\\IT\\Cources\\EPAM\\repo\\epam_2019\\Lab3\\resources\\data.bin");
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