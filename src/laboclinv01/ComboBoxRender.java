/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

/**
 *
 * @author Lenovo
 */
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ComboBoxRender extends DefaultTableCellRenderer{

    JComboBox<String> jcb;
    
    public ComboBoxRender(JComboBox jcb){
        this.jcb = jcb;
    }
    
    //Error al usar un nuevo combo box en una linea distinta
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component res;
        res = table.getColumnModel().getColumn(column).getCellEditor().getTableCellEditorComponent(table, value, hasFocus, row, column);
        if(res.getClass().getName().contains("ComboBox")){
            res = jcb;
        }else{
            res = new JLabel();
        }
    return res;
    }

    @Override
    protected void setValue(Object o) {
        super.setValue(o.toString()); //To change body of generated methods, choose Tools | Templates.
    }
}
              
