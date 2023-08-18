/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Lenovo
 */
public class CustomCelCMlEditor extends AbstractCellEditor implements TableCellEditor{
    Object currentValue;
    
    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        
    }
    
}
