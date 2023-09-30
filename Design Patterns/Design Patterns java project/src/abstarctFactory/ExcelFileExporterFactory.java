package abstarctFactory;

public class ExcelFileExporterFactory implements FileExporterFactory{
    @Override
    public FileExporter createFileExporter() {
        return new ExcelFileExporter();
    }
}
