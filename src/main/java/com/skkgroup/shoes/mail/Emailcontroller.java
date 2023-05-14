package com.skkgroup.shoes.mail;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.net.URL;

@RestController
@RequestMapping("/app/v1/mail")
public class Emailcontroller {
    @Autowired
    EmailServiceImpl emailService;
    @PostMapping("/send")
    public String Sendm(){

        try {
            emailService.sendSimpleMessage("rassoul76@yahoo.fr","testing", "hoc vv");
            return "email sent";
        }catch (Exception e) {
            System.out.println("Something went wrong.");
            return "error";
        }

    }

    @GetMapping("/generate-pdf")
    public void generatePdf(HttpServletResponse response) throws Exception {

        // Set content type and disposition
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.pdf\"");

        // Create PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        // Add content to PDF
        Paragraph paragraph = new Paragraph();
        paragraph.add("Hello, world!");
        document.add(paragraph);

        // Close document
        document.close();
    }

    @GetMapping("/generate-pdfa")
    public void generatePdfa(HttpServletResponse response) throws Exception {

        // Set content type and disposition
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.pdf\"");

        // Create PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        PdfWriter.getInstance(document, new FileOutputStream("example.pdf"));
        document.open();

        // Add content to PDF
        Paragraph title = new Paragraph();
        title.setFont(new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
        title.add("Sample PDF");
        document.add(title);

        Paragraph paragraph = new Paragraph();
        paragraph.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nec velit commodo, suscipit arcu eu, tincidunt orci. Vivamus placerat mi nec felis ullamcorper tincidunt. Sed vel convallis magna. Aenean ac sapien commodo, eleifend odio in, suscipit mauris. Nullam sit amet commodo velit. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Donec vel felis tincidunt, consequat odio ac, tristique mauris. Duis a dolor quis ipsum venenatis pellentesque. Fusce dictum euismod ipsum, vel interdum nunc laoreet ut.");
        document.add(paragraph);

        PdfPTable table = new PdfPTable(3);
        PdfPCell cell = new PdfPCell(new Phrase("Header"));
        cell.setColspan(3);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("1.3");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");
        document.add(table);

        Image image = Image.getInstance(new URL("https://websitedemos.net/recycled-shoe-store-04/wp-content/uploads/sites/983/2021/11/recycled-shoe-product-image-007.jpg"));
        image.scaleToFit(400, 400);
        document.add(image);

        // Close document
        document.close();
    }
}
