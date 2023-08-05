package abstarctfactoryExp;

public class App {
    public static void main(String[] args) {
        FileExporterFactory fileExporterFactory = new JpgFileExporterFactory();
        FileExporter fileExporter = fileExporterFactory.createFile();
        System.out.println(fileExporter.fileGenerate("say my name"));


    }
}