/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.util.Date;

public class ComandaNormal extends Comanda {
    
    public final static float PREU_ENV = 1;
    
    public ComandaNormal(Article article, Client client, int quantitat, Date data) {
        super(article, client, quantitat, data);
    }
    
    @Override
    public String tipusComanda() {
        return "Normal";
    }

    @Override
    public float preuEnviament() {
        return PREU_ENV * (100-this.client.descompteEnv())/100;
    }    
    
    public int tempsEnviament()
    {
     return this.getArticle().getTempsFinsEnv();
    }
    
    public int tempsRebuda(){
        return 2 * 60;
    }

}
