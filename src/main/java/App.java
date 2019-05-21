import org.apache.log4j.BasicConfigurator;
import org.docx4j.openpackaging.packages.PresentationMLPackage;
import org.docx4j.openpackaging.packages.SpreadsheetMLPackage;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.odftoolkit.odfdom.doc.OdfPresentationDocument;
import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import java.io.File;

public class App {

    public static void main(String[] args) {

        BasicConfigurator.configure();

        try {
            OdfTextDocument odt = OdfTextDocument.newTextDocument();
            OdfPresentationDocument odp = OdfPresentationDocument.newPresentationDocument();
            OdfSpreadsheetDocument ods = OdfSpreadsheetDocument.newSpreadsheetDocument();
            odt.save("File.odt");
            odp.save("File.odp");
            ods.save("File.ods");

            WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
            PresentationMLPackage presentationMLPackage = PresentationMLPackage.createPackage();
            SpreadsheetMLPackage spreadsheetMLPackage = SpreadsheetMLPackage.createPackage();

            // File exportWordFile = new File("File.doc");
            File exportWordFile = new File("File.docx");
            //File exportPresentationFile = new File("File.ppt");
            File exportPresentationFile = new File("File.pptx");
            //File exportSpreadSheetFile = new File("File.xls");
            File exportSpreadSheetFile = new File("File.xlsx");

            wordPackage.save(exportWordFile);
            presentationMLPackage.save(exportPresentationFile);
            spreadsheetMLPackage.save(exportSpreadSheetFile);

        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
