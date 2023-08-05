package abstarctFactory;

public class PdfFileFileExporterFactory implements FileExporterFactory{
    @Override
    public FileExporter createFileExporter() {
        return new PdfFileExporter();
    }
}
