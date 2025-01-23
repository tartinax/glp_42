package org.marine.inventory;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> dictionnary;


    public Inventory() {dictionnary = new HashMap<String,Integer>();}


    public int getElem(String elem){return dictionnary.get(elem);}

    public void put(String elem, int nb){
        dictionnary.put(elem, nb);
    }


    public void rem(String elem){
        dictionnary.remove(elem);
    }


    public void add(String elem,int nb){
        if (dictionnary.containsKey(elem)) {
            dictionnary.put(elem, dictionnary.get(elem) + nb);
        }
        else{
            put(elem,nb);
        }
    }


}
