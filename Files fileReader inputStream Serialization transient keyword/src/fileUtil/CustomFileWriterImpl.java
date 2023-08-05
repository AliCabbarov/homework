package fileUtil;

import java.io.*;

public class CustomFileWriterImpl implements CustomFileWriter,Serializable {
    @Override
    public void writeWithFileWriter(String pathName, String data) {
        File file = new File(pathName);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            if (!file.exists()) {
                System.out.println("file created..");
                file.createNewFile();
            }
            bufferedWriter.write(data);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void writeWithOutputStream(String pathName, String data) {
        File file = new File(pathName);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
            if (!file.exists()) {
                System.out.println("file created..");
                file.createNewFile();
            }
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void writeWithObjectOutputStream(String pathName, Employee employee) {
        File file = new File(pathName);
        try {
            if (!file.exists()) {
                System.out.println("file created..");
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void writeWithPrintWriter(String pathName, String data) {
        File file = new File(pathName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            if (!file.exists()) {
                System.out.println("file created..");
                file.createNewFile();
            }
            printWriter.write(data);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void writeWithPrintStream(String pathName, String data) {
        File file = new File(pathName);
        try (PrintStream printStream = new PrintStream(file)) {
            if (!file.exists()) {
                System.out.println("file created..");
                file.createNewFile();
            }
            printStream.write(data.getBytes());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
