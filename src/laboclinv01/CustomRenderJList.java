/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Lenovo
 */
public class CustomRenderJList {

    
    public CustomRenderJList(){
        
    }
    
    /**
     *
     * @param model
     * @param jList
     */
    public static void setFont(DefaultListModel<String> model, JList<String> jList) {
        
        jList.setModel(model);
        
        // Crear un mapa de atributos para aplicar diferentes fuentes
        Map<TextAttribute, Object> fontAttributes = new HashMap<>();
        Font normalFont = jList.getFont();
        Font boldFont = normalFont.deriveFont(Font.BOLD);
        Font italicFont = normalFont.deriveFont(Font.ITALIC);
        fontAttributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        fontAttributes.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
        Font underlinedFont = normalFont.deriveFont(fontAttributes);

        // Establecer el renderizador personalizado para aplicar diferentes fuentes
        jList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                switch (index) {
                    case 1:
                        label.setFont(boldFont);
                        break;
                    case 2:
                        label.setFont(italicFont);
                        break;
                    case 3:
                        label.setFont(underlinedFont);
                        break;
                    default:
                        break;
                }
                return label;
            }
        });
    }
}
