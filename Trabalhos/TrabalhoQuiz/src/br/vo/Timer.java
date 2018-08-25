package br.vo;

import br.controller.ControllerMainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 * @author 104884
 */
public class Timer implements Runnable {

    private long msMaximo;
    private long msAtual;
    private long msPrimeiro;
    private ControllerMainFrame controller;
    private Thread timer = null;
    private boolean running;
    
    public Timer(ControllerMainFrame controller) {
        this.controller = controller;
    }
    
    public void destruir() {
        try {
            this.finalize();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
    
    public long getTempoRestante() {
        return this.msMaximo - this.msAtual;
    }
    
    public void atualizaCronometro() {
        this.msAtual = System.currentTimeMillis();
    }
    
    public void iniciarCronometro() {
        this.msPrimeiro = System.currentTimeMillis();
        this.msMaximo = this.msPrimeiro + 60000;
        this.msAtual = this.msPrimeiro;
        this.timer = new Thread(this);
        this.running = true;
        this.timer.start();
    }
    
    public long pararCronometro() {
        this.running = false;
        return this.getTempoRestante();
    }
    
    @Override
    public void run() {
        while(running) {
            
            try {
                this.atualizaCronometro();
                this.controller.atualizaTimer(this.getTempoRestante() / 1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        }
    }
    
}
