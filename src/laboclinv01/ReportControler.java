/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Lenovo
 */
public class ReportControler {
    public static void mostrarReporte(String file, HashMap map, float zoom){
        Connection conexion = SqlConector.conectar();
        String dir = "C:\\Reports\\"+file;//C:\\Users\\Lenovo\\Documents\\NetBeansProjects\\LABOCLINv01\\src\\Reports\\" + file;
        try{
            JasperPrint jp;
            JasperReport jr;
            jr = JasperCompileManager.compileReport(dir);
            jp = JasperFillManager.fillReport(jr, map, conexion);
            
            JasperViewer jv = new JasperViewer(jp, false);
            
            jv.setZoomRatio(zoom);
            jv.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            //jv.setUndecorated(true);
            jv.setVisible(true);
            SqlConector.closeConn();
        }catch(NoClassDefFoundError | JRException je){
            JOptionPane.showMessageDialog(null, je.getMessage());
        }
    }
}
