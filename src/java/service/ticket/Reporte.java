package service.ticket;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.sql.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import conversiones.Conversiones;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Reporte {
    String year;    
    int idResponsable;
    
    public Reporte(String year, int idResponsable){
       this.year = year;
       this.idResponsable = idResponsable;
    }
    
    public void GenerarReporteAnual(){
        //parqueaderoRegistro pr = new parqueaderoRegistro();
        //String nombrePdf = pr.label_fecha.getText();
        //System.out.println(fechaHoy);
        Rectangle pageSize = new Rectangle(1200f,700f);
        
        Document documento = new Document(pageSize);
        
        
        //
        //String ruta = System.getProperty("user.home");
        //System.out.println(ruta + "\\Desktop\\tiquetes\\reportes\\"+nombrePdf+".pdf");
        try{
            
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "\\Desktop\\"+year+".pdf"));
        Image header = Image.getInstance("C:\\Users\\JUAN\\Documents\\NetBeansProjects\\ParqueaderoWeb01\\images\\HEAD.png");
    
        header.scaleToFit(450,800);
        header.setAlignment(Chunk.ALIGN_CENTER);
        
        //
        Anchor imagenCond = null;
        Font fuente = new Font();
        Font fcab = new Font();
        
        documento.open();
        fuente.setColor(BaseColor.BLUE);
        fuente.setStyle(Font.UNDERLINE);
        fcab.setStyle(Font.BOLD);
        //fcab.setStyle();
        //imagenCond = new Anchor(rs.getString(10)+"\n ",fuente);        
        documento.add(header);
        
        PdfPTable tabla = new PdfPTable(9);
        //float[] medidas = {0.55f,2.25f,0.55f,0.55f};
        //tabla.setWidths(medidas);
        tabla.setWidthPercentage(105);
        Anchor t1 = new Anchor("PARQUEO #",fcab);        
        tabla.addCell(t1);
        Anchor t2 = new Anchor("TIPO VEHICULO",fcab);
        tabla.addCell(t2);
        Anchor t3 = new Anchor("PLACA",fcab);
        tabla.addCell(t3);

        //FECHA
        Anchor t4 = new Anchor("FECHA ENTRADA",fcab);
        tabla.addCell(t4);
        Anchor t5 = new Anchor("FECHA SALIDA",fcab);
        tabla.addCell(t5);

        Anchor t6 = new Anchor("TIEMPO MINUTOS",fcab);
        tabla.addCell(t6);
        Anchor t7 = new Anchor("VALOR A PAGAR",fcab);
        tabla.addCell(t7);
        Anchor t8 = new Anchor("ID RESPONSABLE",fcab);
        tabla.addCell(t8);
        Anchor t9 = new Anchor("RESPONSABLE",fcab);
        tabla.addCell(t9);
           
           try{
               Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/parking_web","root","");
               //PreparedStatement pst = cn.prepareStatement("select * from park where ");
               PreparedStatement pst = cn.prepareStatement("select * from parqueo where hora_entrada like '%"+year+"%'"+"AND id_responsable like '%"+idResponsable+"%'");
               ResultSet rs = pst.executeQuery();
               
               if(rs.next()){
                   do{
                        //esta condicion es para que haga los reportes diarios y en los pdfs
                    //no acumule los del dia anterior etc.
                    //if(rs.getString(6).equals(fechaHoy)){   
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                        //
                        
                        /*
                        String fecha = Conversiones.convertirFecha(rs.getString(6));
                        tabla.addCell(fecha+"\n ");
                        String hora = Conversiones.convertirHora(rs.getString(6));
                        tabla.addCell(hora);
                        
                        String fecha2 = Conversiones.convertirFecha(rs.getString(7));
                        tabla.addCell(fecha2);
                        String hora2 = Conversiones.convertirHora(rs.getString(7));
                        tabla.addCell(hora2);
                        */
                        /*
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(7));
                        */
                        /*
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                        */
                        
                        //tabla.addCell(rs.getString(10)+ " " + imagenCond);
                        
                        //tabla.addCell("ww.dfd".);
                        
                        /*
                        if(rs.getString(10).equals("Retirado S.T.")){
                            
                            imagenCond = new Anchor(rs.getString(10)+"\n ",fuente);                        
                            imagenCond.setReference("file:///"+rs.getString(12));
                            tabla.addCell(imagenCond);
                            
                        }else{                           
                            tabla.addCell(rs.getString(10));
                            }
                        
                        tabla.addCell(rs.getString(11));
                       */
                   }while(rs.next());
                   documento.add(tabla);
               }
           }catch(DocumentException | SQLException e){
               e.printStackTrace();
           }
           documento.close();
           //JOptionPane.showMessageDialog(null, "Reporte Creado.");
           //
        }catch(DocumentException | HeadlessException | FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         String ruta = System.getProperty("user.home");
        try {
            Runtime.getRuntime().exec("cmd /c start "+ ruta+"\\Desktop\\"+year+".pdf");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }