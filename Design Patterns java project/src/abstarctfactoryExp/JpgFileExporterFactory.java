package abstarctfactoryExp;

public class JpgFileExporterFactory implements FileExporterFactory{
    @Override
    public FileExporter createFile() {
        return new JpgFileExporter();
    }
}
