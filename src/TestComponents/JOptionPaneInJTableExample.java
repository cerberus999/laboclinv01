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

public class JOptionPaneInJTableExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable JOptionPane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(new Object[][]{
                {"Row 1", "Value 1"},
                {"Row 2", "Value 2"},
                {"Row 3", "Value 3"}
        }, new String[]{"Field 1", "Field 2"});

        JTable table = new JTable(model);
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column != -1) {
                        Object editedValue = table.getValueAt(row, column);
                        JOptionPane.showMessageDialog(
                                table,
                                "Edited value: " + editedValue,
                                "Cell Edited",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}
