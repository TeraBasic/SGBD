package jus.aoo.sgbdComposants;
import java.util.Iterator;

public class Schema implements _Schema {
    private final Object[] attributs;
    
    public Schema(Object... tab){
   	 this.attributs = tab;
    }
    
    public Object getNomAttribut(int index){
   	 return this.attributs[index];
    }
    
     public Iterator<Object> iterator() {
   	 return new Iterator<Object>() {
   		 private int index = 0;
   		 @Override public boolean hasNext() {return index<attributs.length;}
   		 @Override public Object next() {return attributs[index++];}
   	 };
    }
    public int getDegree() {return attributs.length;}
}
