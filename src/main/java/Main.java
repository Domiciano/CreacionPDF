import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {


        try {
            Document document = new Document(new Rectangle(800, 600));

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("certificado.pdf"));
            document.open();



            Image back = Image.getInstance("back.png");
            back.setAbsolutePosition(0, 0);
            back.scaleToFit(document.getPageSize().getWidth(), document.getPageSize().getHeight());

            Image logo = Image.getInstance("logo.png");
            logo.scaleToFit(150, 50); // Establecer ancho y alto máximos en píxeles


            Image firma = Image.getInstance("firma.png");
            firma.scaleToFit(150, 150); // Establecer ancho y alto máximos en píxeles

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);



            Paragraph first = new Paragraph("Confiere el diploma en:");
            Paragraph program = new Paragraph("MICROMASTER EN DISEÑO DE INTERACCIÓN", new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD));
            Paragraph second = new Paragraph("A");
            Paragraph name = new Paragraph("NESTOR TOBAR ARAUJO", new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD));

            Chunk duration = new Chunk("380 horas", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
            Paragraph desc = new Paragraph("El programa tuvo una duración de ");
            desc.add(duration);
            Paragraph desc2 = new Paragraph("En testimonio de ello se expide en la ciudad de Santiago de Cali el 2 de julio de 2023.");



            document.add(back);
            document.add(logo);
            document.add(first);
            document.add(program);
            document.add(second);
            document.add(name);
            document.add(desc);
            document.add(desc2);


            PdfPCell cell1 = new PdfPCell();
            cell1.addElement(firma);
            cell1.addElement(new Paragraph("Leonardo Bustamante"));
            cell1.addElement(new Paragraph("Profesor Tiempo completo"));
            cell1.addElement(new Paragraph("Facultad de ingeniería"));
            cell1.setBorder(0);
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell();
            cell2.setBorder(0);
            cell2.addElement(firma);
            cell2.addElement(new Paragraph("Domiciano Rincón"));
            cell2.addElement(new Paragraph("Profesor Tiempo completo"));
            cell2.addElement(new Paragraph("Facultad de ingeniería"));
            table.addCell(cell2);




            document.add(table);



            // Cerrar el documento PDF
            document.close();


            System.out.println("Certificado generado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
