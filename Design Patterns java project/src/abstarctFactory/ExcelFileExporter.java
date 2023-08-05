package abstarctFactory;

public class ExcelFileExporter implements FileExporter {
    @Override
    public String fileGenerate(String message) {
        return "EXCEL {" + message + "}" + ".xlsx";
    }


}
