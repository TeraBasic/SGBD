package jus.aoo.sgbdComposants;
import java.util.Iterator;

public class Tuple implements _Tuple {
    private final Object[] contenu;
    
    
    public Tuple(Object... tab){
   	 this.contenu = tab;
    }
    
    public Object get(int index){
   	 return this.contenu[index];
    }

     
    public Iterator<Object> iterator() {
   	 return new Iterator<Object>() {
   		 private int index = 0;
   		 @Override public boolean hasNext() {return index<contenu.length;}
   		 @Override public Object next() {return contenu[index++];}
   	 };
    }
    @Override public int getDegree() {return contenu.length;}
    
}

