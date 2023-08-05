package abstarctfactoryExp;

public class PdfFileExporter implements FileExporter{
    @Override
    public String fileGenerate(String message) {
        return "Pdf{"+message+"}.pdf";
    }
}
