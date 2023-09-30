package abstarctfactoryExp;

public class ExcelFileExporter implements FileExporter{
    @Override
    public String fileGenerate(String message) {
        return "Excel {"+ message+"}.xlsx" ;
    }
}
