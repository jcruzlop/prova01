/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

public class Article implements Serializable {
   private String id;
   private String nom;
   private float preu;
   private int tempsFinsEnv;
   private boolean admetUrgent;
   
    public Article (String id, String nom, float preu,  int tempsFinsEnv, boolean admetUrgent){
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.tempsFinsEnv = tempsFinsEnv; 
        this.admetUrgent = admetUrgent;
    }

    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setNom(String nom){
         this.nom = nom;
    }
    public String getNom(){
         return nom;
    }
    
    public void setPreu(float preu){
        this.preu = preu;
    }
    
    public float getPreu(){
        return this.preu;
    }

    public void setTempsFinsEnv(int tempsFinsEnv){
        this.tempsFinsEnv = tempsFinsEnv;
    }
    
    public int getTempsFinsEnv(){
        return this.tempsFinsEnv;
    }

    public void setAdmetUrgent(boolean admetUrgent){
        this.admetUrgent = admetUrgent;
    }
    
    public boolean getAdmetUrgent(){
        return this.admetUrgent;
    }

    @Override
    public String toString() {
        return "Id=" + getId() + ", Nom=" + getNom() + ", Preu=" + getPreu() + ", Temps fins env.=" + getTempsFinsEnv() + ", Enviament Urgent=" + getAdmetUrgent() + ". ";
    }
}
