package fileUtil;

import java.io.Serializable;

public interface CustomFileReader extends Serializable {
    void readWithFileReader(String pathName);
    void readWithInputStream(String pathName);
    void readWithObjectInputStream(String pathName);

}
