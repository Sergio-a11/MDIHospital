/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
//archivos
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//librerias ajenas a itext
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.tools.jar.Main;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class ArchPdf {

    private File ruta_destino;

    public ArchPdf(){
        ruta_destino=null;
    }

    /* metodo que hace uso de la clase itext para manipular archivos PDF*/
    public void crear_PDF(HistoriaClinica hs){
        //abre ventana de dialogo "guardar"
        Colocar_Destino();
        //si destino es diferente de null
        if(this.ruta_destino!=null){
            try {
                // se crea instancia del documento
                Document mipdf = new Document();
                // se establece una instancia a un documento pdf
                PdfWriter pw=PdfWriter.getInstance(mipdf, new FileOutputStream(this.ruta_destino + ".pdf"));
                mipdf.open();// se abre el documento
                mipdf.addTitle("Recibo de Historia Clinica"); // se añade el titulo
                /*mipdf.addAuthor(a); // se añade el autor del documento
                mipdf.addSubject(s); //se añade el asunto del documento
                mipdf.addKeywords(k); //Se agregan palabras claves*/
                mipdf.add(new Paragraph("Hospital MDI \n"));
                String info = "";
                if(hs.getDtsServicio() instanceof CitaMedGenr || hs.getDtsServicio() instanceof Vacunacion){
                  mipdf.add(new Paragraph(hs.toString()+ "\nValor: " +hs.valor()+"\n")); 
                  info += hs.toString()+ "\nValor: "+hs.valor()+"\n";
                }
                if(hs.getDtsServicio() instanceof Laboratorios){
                  mipdf.add(new Paragraph(hs.toString()+ "\nValor: " +hs.valorLAB((Laboratorios) hs.getDtsServicio())+"\n"));  
                  info += hs.toString()+ "\nValor: " +hs.valorLAB((Laboratorios) hs.getDtsServicio())+"\n";
                }
                if(hs.getDtsServicio() instanceof Hospitalizacion){
                  mipdf.add(new Paragraph(hs.toString()+ "\nValor: " +hs.valorHOPS((Hospitalizacion)hs.getDtsServicio())+"\n"));  
                  info += hs.toString()+ "\nValor :"+hs.valorHOPS((Hospitalizacion)hs.getDtsServicio())+"\n";
                }
                //código de barras
                mipdf.add(codBar(mipdf, pw, hs.getFecha()+"-"+hs.getDtsPaciente().getIdentificacion()));
                //código QR
                mipdf.add(QRcod(mipdf, info));
                // se añade el contendio del PDF
                
                mipdf.close(); //se cierra el PDF&
                JOptionPane.showMessageDialog(null,"Documento PDF creado");
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(null,"Error "+ex.toString());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"Error "+ex.toString());
            }
        }
    }
    /* abre la ventana de dialogo GUARDAR*/
    public void Colocar_Destino(){
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf","PDF");
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.setFileFilter(filter);
       int result = fileChooser.showSaveDialog(null);
       if ( result == JFileChooser.APPROVE_OPTION ){
           this.ruta_destino = fileChooser.getSelectedFile().getAbsoluteFile();
        }
    }
    public Image codBar(Document doc, PdfWriter pw, String InfoCod)
    {
        PdfContentByte cimg = pw.getDirectContent();
        Barcode128 code128 =new Barcode128();
        code128.setCode(InfoCod);
        code128.setCodeType(Barcode128.CODE128);
        code128.setTextAlignment(Element.ALIGN_CENTER);
        Image img=code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
        img.setAlignment(Element.ALIGN_CENTER);
        return img;
    }
    public File getRuta_destino() {
        return ruta_destino;
    }

    public void setRuta_destino(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    }
    
    public Image QRcod(Document doc, String InfoCod) throws BadElementException
    {
        BarcodeQRCode qrcode = new BarcodeQRCode(InfoCod, 300, 300, null);
        Image img= qrcode.getImage();
        img.setAlignment(Element.ALIGN_CENTER);
        return img;
    }
}