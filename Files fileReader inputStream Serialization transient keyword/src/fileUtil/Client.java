package fileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Client {
    CustomFileWriter customFileWriter;
    CustomFileReader customFileReader;

    Client() {
        customFileReader = new CustomFileReaderImpl();
        customFileWriter = new CustomFileWriterImpl();
    }

    public static void main(String[] args) {
//        Client client = new Client();
//        //10. Serializable obyektin jvmdən kənarda həyatda qalması üçün jvmə implements olan marker interfacedirş
//        //boş interfacedir sadədcə jvm bu işi görməsi üçün xəbərfr verir.
//
//
//        //11.Transient və serialVersionUID nə işə yarayır , yuxarda ObjectInputStream,
//        // ObjectOutputStream kodları üzərində nümunə kodları vasitəsi ilə izah edin
//        Employee employee = new Employee("eli", "Cabbarov", 651);
//        client.customFileWriter.writeWithObjectOutputStream("text.txt", employee);
//        client.customFileReader.readWithObjectInputStream("text.txt");
//        //surname transient etdiyimiz üçün read etdiyimiz zaman null olaraq görsənir
//
//
//        File file = new File("C:\\Users\\user\\Pictures\\Desktop Backgrounds\\" + "Image 1.jpg");
//        File file1 = new File("newPictures");
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file);
//            byte[] bytes;
//            bytes = fileInputStream.readAllBytes();
//            OutputStream fileOutputStream = new FileOutputStream(file1);
//            fileOutputStream.write(bytes);
//            fileOutputStream.close();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }



        Path sourcePath = Paths.get("C:\\Users\\user\\Pictures\\zed.jpg");
        Path targetPath = Paths.get("zed.png");
        Path path = Paths.get("text1.txt");

        try {
//            Files.copy(sourcePath,targetPath);
            if(!Files.exists(path)){
                Files.createFile(path);
            }
            Files.writeString(path,"hello world;\n", StandardOpenOption.APPEND);
        }catch (IOException exception){
            exception.printStackTrace();
        }






    }
}
