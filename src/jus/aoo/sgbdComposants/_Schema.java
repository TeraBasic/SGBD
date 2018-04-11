package jus.aoo.sgbdComposants;

import java.util.Iterator;

public interface _Schema extends Iterable<Object>{

    int getDegree();
    public Object getNomAttribut(int t);
    Iterator<Object> iterator();

}

