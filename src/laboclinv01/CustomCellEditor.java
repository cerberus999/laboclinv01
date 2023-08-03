/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

import java.awt.Component;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class CustomCellEditor extends DefaultCellEditor{
    private int maxLength;
        
    
    public CustomCellEditor(JTextField txt,int maxLength) {
        super(txt);
        txt.setMargin(new Insets(0, 0, 0, 0));
        this.maxLength = maxLength;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        JTextField editor = (JTextField) super.getTableCellEditorComponent(jtable, o, bln, i, i1);
        editor.setText(o != null ? o.toString() : "");
        return editor;
    }

    @Override
    public boolean stopCellEditing() {
        JTextField editor = (JTextField) getComponent();
        String value = editor.getText();
        if (value.length() > maxLength)
            editor.setText(value.substring(0, maxLength));
        return super.stopCellEditing();
    }

    @Override
    public boolean shouldSelectCell(EventObject eo) {
        if (eo instanceof KeyEvent) {
            KeyEvent e = (KeyEvent) eo;
            JTextField editor = (JTextField) getComponent();
            String value = editor.getText();
            if (value.length() > maxLength && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE || e.getKeyCode() != KeyEvent.VK_DELETE)) {
                return false;
            }
        }
        return super.shouldSelectCell(eo);
    }
    
    
}
