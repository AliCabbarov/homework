package fileUtil;

import java.io.*;

public class CustomFileReaderImpl implements CustomFileReader, Serializable {
    @Override
    public void readWithFileReader(String pathName) {
        File file = new File(pathName);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            if (!file.exists()) {
                System.err.println("file oes not exist!!");
                return;
            }
            bufferedReader.read();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void readWithInputStream(String pathName) {
        File file = new File(pathName);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
            if (!file.exists()) {
                System.err.println("file oes not exist!!");
                return;
            }
            bufferedInputStream.read();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void readWithObjectInputStream(String pathName) {
        File file = new File(pathName);
        try {
            if (!file.exists()) {
                System.err.println("file oes not exist!!");
                return;
            }
            FileInputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Employee employee = (Employee) objectInputStream.readObject();
            System.out.println(employee.toString());
        } catch (Throwable exception) {
            exception.printStackTrace();
        }

    }
}
