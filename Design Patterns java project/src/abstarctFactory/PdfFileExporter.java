package abstarctFactory;

public class PdfFileExporter implements FileExporter {
    @Override
    public String fileGenerate(String message) {
        return "PDF  {" + message + "} " + ".pdf";
    }
}
