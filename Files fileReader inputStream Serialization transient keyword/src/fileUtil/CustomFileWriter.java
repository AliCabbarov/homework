package fileUtil;

import java.io.Serializable;

public interface CustomFileWriter extends Serializable {
    void writeWithFileWriter(String pathName, String data);
    void writeWithOutputStream(String pathName, String data);
    void writeWithObjectOutputStream(String pathName,Employee employee);
    void writeWithPrintWriter(String pathName, String data);
    void writeWithPrintStream(String pathName, String data);

}
