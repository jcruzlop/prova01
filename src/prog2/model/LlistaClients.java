/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Iterator;
import prog2.vista.MercatException;

public class LlistaClients extends Llista<Client> implements Serializable {
    
    public void afegir(Client client) throws MercatException {
        if (contains(client.getEmail())){
            throw new MercatException("Hi ha un client amb el mateix email");
        }
        else this.llista.add(client);
    }
            
    public boolean contains(String clientEmail) {
        for(Iterator iter = this.llista.iterator(); iter.hasNext();) {
            Client c = (Client) iter.next();
            if(c.getEmail().equals(clientEmail)){
               return true;
            }
        }       
        return false;
    }
}
