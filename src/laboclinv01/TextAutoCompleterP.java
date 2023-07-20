/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboclinv01;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Lenovo
 */
public class TextAutoCompleterP extends TextAutoCompleter{
    
    
    
    public TextAutoCompleterP(JTextComponent jtc, Object[] os, int i) {
        super(jtc, os, i);
    }
    
    public TextAutoCompleterP(JTextComponent jtc, ArrayList<Object> al, int i) {
        super(jtc, al, i);
    }
    
     public TextAutoCompleterP(JTextComponent jtc) {
        super(jtc);
    }
    
    public ArrayList<Object> getItemsAL(){
        ArrayList<Object> res = items;
        return res;
    }
}
