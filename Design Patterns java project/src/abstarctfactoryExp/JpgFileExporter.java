package abstarctfactoryExp;

public class JpgFileExporter implements FileExporter{
    @Override
    public String fileGenerate(String message) {
        return "Jpg {"+message+"}.jpg";
    }
}
