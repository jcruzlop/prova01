/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

public class ClientPremium extends Client {
    
    public final static float MENSUALITAT = 4;
    public final static float DESCOMPTE_ENV = 20;

    public ClientPremium(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    @Override
    public String tipusClient() {
        return "Premium";
    }

    @Override
    public float calcMensual() {
        // TBD?
        return MENSUALITAT;
    }
    
    @Override
    public float descompteEnv() {
        return DESCOMPTE_ENV;
    }

}
