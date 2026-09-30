/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2.vista;

public class MercatException extends Exception{
    
    public MercatException(){
        super(); // constructor per defecte
    }
    public MercatException(String s){
        super(s); // constructor amb missatge
    }

}
