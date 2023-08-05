package abstarctfactoryExp;

public class PdfFileExporterFactory implements FileExporterFactory{
    @Override
    public FileExporter createFile() {
        return new PdfFileExporter();
    }
}
