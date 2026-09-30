/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.adaptador;

import java.util.ArrayList;
import java.util.List;
import prog2.model.Article;
import prog2.model.Client;
import prog2.model.Comanda;
import prog2.model.Dades;
import prog2.vista.MercatException;

public class Adaptador {
    private Dades dades;
    
    public Adaptador() {
        dades = new Dades();
    }
    
    public void guardaDades(String camiDesti) throws MercatException {
        dades.guardaDades(camiDesti);
    }
    
    public void carregaDades(String camiOrigen) throws MercatException {
        dades = Dades.carregaDades(camiOrigen);
    }
    
    public void afegirArticle(String id, String nom, float preu, int tempsFinsEnv, boolean admetUrgent) throws MercatException {
        this.dades.afegirArticle(id, nom, preu, tempsFinsEnv, admetUrgent);
    }

    public List<String> recuperaArticles() {
        ArrayList<Article> llistaArticles = dades.recuperaArticles();
        List<String> llista = new ArrayList<>();
        for (Article a : llistaArticles) {
            llista.add(a.toString());
        }
        return llista;
    }

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        this.dades.afegirClient(email, nom, adreca, esPremium);
    }

    public List<String> recuperaClients() {
        ArrayList<Client> llistaClients = dades.recuperaClients();
        List<String> llista = new ArrayList<>();
        for (Client c : llistaClients) {
            llista.add(c.toString());
        }
        return llista;
    }

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        this.dades.afegirComanda(articlePos, clientPos, quantitat, esUrgent);
    }

    public void cancelarComanda(int position) throws MercatException {
        this.dades.cancelarComanda(position);
    }

    public List<String> recuperaComandes() {
        ArrayList<Comanda> llistaComandes = dades.recuperaComandes();
        List<String> llista = new ArrayList<>();
        for (Comanda c : llistaComandes) {
            llista.add(c.toString());
        }
        return llista;
    }
    
    public List<String> recuperaComandesCancelades() {
        ArrayList<Comanda> llistaComandes = dades.recuperaComandesCancelades();
        List<String> llista = new ArrayList<>();
        for (Comanda c : llistaComandes) {
            llista.add(c.toString());
        }
        return llista;
    }

}
