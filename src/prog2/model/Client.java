/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;

public abstract class Client implements Serializable {
   private String email;
   private String nom;
   private String adreca;
   
   public Client(String email, String nom, String adreca){
       this.email = email;
       this.nom = nom;
       this.adreca = adreca;
   }
   
   public void setEmail(String email){
       this.email = email;
   }
   
   public String getEmail(){
       return this.email;
   }
   
   public void setNom(String nom){
       this.nom = nom;
   }
   
   public String getNom(){
       return this.nom;
   }
   
   public void setAdreca(String adreca){
       this.adreca = adreca;
   }
   
   public String getAdreca(){
       return this.adreca;
   }
   
   public abstract String tipusClient();
   
   public abstract float calcMensual();
   
   public abstract float descompteEnv();
      
   @Override
    public String toString() {
        return "Tipus=" + this.tipusClient() + ", Email=" + getEmail() + ", Nom=" + getNom() + ", Adreca=" + getAdreca() + ", Descompte Enviament=" + descompteEnv() + ", Mensualitat=" + calcMensual() + ".";
    }
}
