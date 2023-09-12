/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestComponents;

import java.util.concurrent.TimeUnit;
/**
 *
 * @author Lenovo
 */
 
public class Main
{
    public static void wait(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
 
    public static void main(String[] args) {
        System.out.println("Start…");
        for(int i=0;i<5;i++){
            System.out.println(i + " second elapsed…");
            wait(1000);
        }
    }
}
