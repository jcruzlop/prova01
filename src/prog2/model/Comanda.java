/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Timer;

public abstract class Comanda implements Serializable {
    private Article article;
    protected Client client;
    private int quantitat;
    private Date data;
    private boolean enviada;
    private boolean rebuda;
    private boolean cancelada;
    
    public Comanda(Article article, Client client, int quantitat, Date data){
        this.article = article;
        this.client = client;
        this.quantitat = quantitat;
        this.data = data;
        this.enviada = false;
        this.rebuda = false;
        this.cancelada = false;
    }
    
    public void setArticle(Article article){
        this.article = article;
    }
    
    public Article getArticle(){
        return this.article;
    }
    
    public void setClient(Client client){
        this.client = client;
    }
    
    public Client getClient(){
        return this.client;
    }
    
    public void setQuantitat(int quantitat){
        this.quantitat = quantitat;
    }
    
    public int getQuantitat(){
        return this.quantitat;
    }
    
    public void setData(Date data){
        this.data = data;
    }
    
    public Date getData(){
        return this.data;
    }
    
    public float calcPreu(){
        return this.quantitat * this.article.getPreu();
    }
    
    public abstract String tipusComanda();
    
    public void setEnviada(boolean enviada){
        this.enviada = enviada;
    }
            
    public boolean getEnviada(){
        return this.enviada;
    }
    
    public void setRebuda(boolean rebuda){
        this.rebuda = rebuda;
    }
    
    public boolean getRebuda(){
        return this.rebuda;
    }
    
    public abstract float preuEnviament();
    
    public abstract int tempsEnviament();
    
    public abstract int tempsRebuda();
    
    @Override
    public String toString() {
        return "Tipus=" + this.tipusComanda() + ", Article=" + this.article.getNom() + ", Client=" + this.client.getNom() + ", Quantitat=" + getQuantitat() + ", Data de creacio=" + getData() + ", Enviada=" + getEnviada() + ", Rebuda=" + getRebuda() + ", Cancel·lada=" + getCancelada() + ", Preu Articles=" + calcPreu() + ", Preu Enviament=" + this.preuEnviament() + ". ";
    }
    
    public void processa(){
        boolean daemon = true;
        Timer timer = new Timer(daemon); 
        long tempsEnvMilisegs = tempsEnviament() * 1000;
        timer.schedule(new EnvComandaTimerTask(this), tempsEnvMilisegs);
    }

    public void cancela(){
        this.cancelada = true;
    }

    public boolean getCancelada() {
        return this.cancelada;
    }
}
