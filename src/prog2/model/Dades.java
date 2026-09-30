/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import prog2.vista.MercatException;

public class Dades implements Serializable, InDades {
    private LlistaArticles llistaArticles;
    private LlistaClients llistaClients;
    private LlistaComandes llistaComandes;
    
    public Dades(){
        llistaArticles = new LlistaArticles();
        llistaClients = new LlistaClients();
        llistaComandes = new LlistaComandes();
    }

    public void guardaDades(String camiDesti) throws MercatException {
                if (camiDesti == null) {
            throw new MercatException("Cami fitxer desti no valid");
        }
        
        File file = new File(camiDesti);
        FileOutputStream fout = null;
        try {
            // Preparem el fitxer de sortida
            fout = new FileOutputStream(file);
            
            // Guardem el fitxer
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
            
        } catch (FileNotFoundException ex) {
            throw new MercatException("Fitxer no trobat");
        } catch (IOException ex) {
            throw new MercatException("Problema d'escriptura");
        } finally {
            try {
                if(fout!=null) {
                    fout.close();
                }
            } catch (IOException ex) {
                throw new MercatException("No s'ha pogut tancar el fitxer");
            }
        }

    }
    
    public static Dades carregaDades(String camiOrigen) throws MercatException {
        if (camiOrigen == null) {
            throw new MercatException("Cami fitxer origen no valid");
        }
        // Comprovem si el fitxer existeix
        File fitxerOrigen = new File(camiOrigen);
        if (!fitxerOrigen.exists()) {
            throw new MercatException("Fitxer desti no existeix");
        }
        
        Dades model=null;
    
        
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            // Preparem el fitxer d'entrada
            fin = new FileInputStream(fitxerOrigen);
            
            // Carreguem les dades
            ois = new ObjectInputStream(fin);
            model=(Dades)ois.readObject();
        } catch (ClassNotFoundException ex) {
            throw new MercatException("No es pot castejar a objecte tipus Dades");
        } catch (FileNotFoundException ex) {
            throw new MercatException("Fitxer no trobat");
        } catch (IOException ex) {
            throw new MercatException("Problema de lectura");
        } finally {
            try {
                fin.close();
            } catch (IOException ex) {
                throw new MercatException("No es pot tancar fitxer");
            }
            try {
                ois.close();
            } catch (IOException ex) {
                throw new MercatException("No es pot tancar sortida");
            }
        }
        
        return model;
    }

    public void afegirArticle(String id, String nom, float preu, int tempsFinsEnv, boolean admetUrgent) throws MercatException {
        Article a = new Article(id, nom, preu, tempsFinsEnv, admetUrgent);
        llistaArticles.afegir(a);
    }

    public ArrayList<Article> recuperaArticles() {
        return llistaArticles.getArrayList();
    }

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        if(esPremium){
            ClientPremium c = new ClientPremium(email, nom, adreca);
            llistaClients.afegir(c);
        }
        else {
            ClientEstandard c = new ClientEstandard(email, nom, adreca);
            llistaClients.afegir(c);
        }
    }

    public ArrayList<Client> recuperaClients() {
        return llistaClients.getArrayList();
    }

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        Article a = llistaArticles.getAt(articlePos);
        Client c = llistaClients.getAt(clientPos);
        Date data = new Date();
        if(esUrgent){
            ComandaUrgent comanda = new ComandaUrgent(a, c, quantitat, data);
            llistaComandes.afegir(comanda);
            comanda.processa();
        } else{
            ComandaNormal comanda = new ComandaNormal(a, c, quantitat, data);
            llistaComandes.afegir(comanda);
            comanda.processa();
        }
    }
    
    public void cancelarComanda(int position) throws MercatException {
        Comanda c = this.llistaComandes.getAt(position);
        if (c.getEnviada()) {
            throw new MercatException("La comanda ja ha estat enviada");
        }
        else {
            c.cancela();
            //this.llistaComandes.esborrar(c);
        }
    }
    
    public ArrayList<Comanda> recuperaComandes() {
        return llistaComandes.getArrayList();
    }

    public ArrayList<Comanda> recuperaComandesCancelades() {
        ArrayList<Comanda> lc = new ArrayList<>();
        for (Comanda c : llistaComandes.getArrayList()) {
            if (c.getCancelada()){
                lc.add(c);
            }
        }
        return lc;
    }
}
