package jus.aoo.sgbdComportements;

import java.util.Iterator;

import jus.aoo.sgbdComposants._Tuple;

public class Identity extends StateLessRelationUnaire{
	public _Iterator <_Tuple> iterator () {
			
		private <_Tuple> ct = r.iterator ();
		
		return new Iterator <_Tuple> (){
			
			public boolean hasNext(){ return ct.hasNext();}		
			public _Tuple next() { return ct.next(); }
		};
	}
}
