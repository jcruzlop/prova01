/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.model;

import java.io.Serializable;
import java.util.Iterator;
import prog2.vista.MercatException;

public class LlistaArticles extends Llista<Article> implements Serializable {
    
    public void afegir(Article article) throws MercatException {
        if (contains(article.getId())){
            throw new MercatException("Hi ha un article amb el mateix id");
        }
        else this.llista.add(article);
    }
            
    public boolean contains(String articleId) {
        for(Iterator iter = this.llista.iterator(); iter.hasNext();) {
            Article a = (Article) iter.next();
            if(a.getId().equals(articleId)){
               return true;
            }
        }       
        return false;
    }
}
