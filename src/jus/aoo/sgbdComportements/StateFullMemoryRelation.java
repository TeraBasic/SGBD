package jus.aoo.sgbdComportements;

import java.util.ArrayList;
import java.util.Iterator;

import jus.aoo.sgbdComposants.Tuple;
import jus.aoo.sgbdComposants._Tuple;

public class StateFullMemoryRelation extends StateFullRelation {

	private ArrayList <_Tuple> tuples;

 public Iterator <_Tuple> iterator() {
		 return new Iterator<_Tuple>() {
		
			 private int index = 0;	
			 private boolean hasNext = index < tuples.size();
			
			public _Tuple next() {
				_Tuple t = tuples.get(index);
				index++;
				return t;
			}	
			public boolean hasNext() {			
				return hasNext;
			}
		};
	}
}
