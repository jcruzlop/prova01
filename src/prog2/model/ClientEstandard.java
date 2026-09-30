/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

public class ClientEstandard extends Client {

    public final static float MENSUALITAT = 0;
    public final static float DESCOMPTE_ENV = 0;

    public ClientEstandard(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    @Override
    public String tipusClient() {
        return "Estandard";
    }

    @Override
    public float calcMensual() {
        return MENSUALITAT;
    }

    @Override
    public float descompteEnv() {
        return DESCOMPTE_ENV;
    }
}
