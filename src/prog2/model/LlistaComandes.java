/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import prog2.vista.MercatException;

public class LlistaComandes extends Llista<Comanda> implements Serializable {

    public void afegir(Comanda comanda) throws MercatException {
        if (comanda.tipusComanda().equals("Urgent") && !comanda.getArticle().getAdmetUrgent()){
            throw new MercatException("l'article no admet enviament urgent");
        }
        else
            this.llista.add(comanda);
    }             
}

