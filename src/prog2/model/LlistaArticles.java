/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Iterator;
import prog2.vista.MercatException;
import java.util.Objects;
public class LlistaArticles extends Llista<Article> implements Serializable {

    public void afegir(Article article) throws MercatException {
        if (contains(article.getId())) {
            throw new MercatException("Hi ha un article amb el mateix id");
        }
        this.llista.add(article);
    }

    public boolean contains(String articleId) {
        // Comprova si hi ha un article amb l'id donat a la llista con un bucle while
        Iterator<Article> it = this.llista.iterator();
        while (it.hasNext()) {
            Article article = it.next();
            if (Objects.equals(article.getId(), articleId)) {
                return true;
            }
        }
        return false;
    }
}
