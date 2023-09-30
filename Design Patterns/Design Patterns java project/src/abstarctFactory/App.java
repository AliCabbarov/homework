package abstarctFactory;

public class App {
    public static void main(String[] args) {
        FileExporterFactory fileExporterFactory = new PdfFileFileExporterFactory();
        FileExporter fileExporter = fileExporterFactory.createFileExporter();
        System.out.println(fileExporter.fileGenerate("hello"));
    }

}
