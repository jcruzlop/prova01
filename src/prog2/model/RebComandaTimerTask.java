/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.TimerTask;
import javax.swing.JOptionPane;

public class RebComandaTimerTask extends TimerTask {    
    private Comanda comanda;
    
    public RebComandaTimerTask(Comanda comanda){
        this.comanda = comanda;
    }
    
    public void run(){
        this.comanda.setRebuda(true);
        JOptionPane.showMessageDialog(null, "Comanda Rebuda: " + this.comanda);
    }
}
