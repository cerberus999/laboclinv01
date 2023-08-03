/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class JTextFieldControl {
    
    public static void limitarCaracteres(KeyEvent e, JTextField txt, int limit){
        if(txt.getText().length() == limit)
            e.consume();
    }   
}
