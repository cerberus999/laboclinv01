/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestComponents;

/**
 *
 * @author Lenovo
 */
    import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class DocumentListenerInJTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable DocumentListener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(new Object[][]{
                {"Row 1", "Value 1"},
                {"Row 2", "Value 2"},
                {"Row 3", "Value 3"}
        }, new String[]{"Field 1", "Field 2"});

        JTable table = new JTable(model);
        new MyCellEditor(table);
        table.getColumnModel().getColumn(0).setCellEditor(new MyCellEditor(table));
        table.getColumnModel().getColumn(1).setCellEditor(new MyCellEditor(table));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyCellEditor extends DefaultCellEditor {
    private JTextField textField;

    public MyCellEditor(JTable table) {
        super(new JTextField());
        textField = (JTextField) getComponent();
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                showOptionPane();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showOptionPane();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components don't fire these events
            }

            private void showOptionPane() {
                int selectedRow = table.getEditingRow();
                int selectedColumn = table.getEditingColumn();
                if (selectedRow != -1 && selectedColumn != -1) {
                    Object editedValue = textField.getText();
                    JOptionPane.showMessageDialog(
                            table,
                            "Edited value: " + editedValue,
                            "Cell Edited",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
    }
}
