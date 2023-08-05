package abstarctfactoryExp;

public class ExcelFileExporterFactory implements FileExporterFactory{
    @Override
    public FileExporter createFile() {
        return new ExcelFileExporter();
    }
}
