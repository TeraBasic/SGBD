package jus.aoo.sgbdComportements;

import java.util.Iterator;
import jus.aoo.sgbdComposants.Attribut;
import jus.aoo.sgbdComposants.Schema;
import jus.aoo.sgbdComposants.Tuple;
import jus.aoo.sgbdComposants._Schema;
import jus.aoo.sgbdComposants._Tuple;

public class Projection extends StateLessRelationUnaire {
	/**
	 * 
	 */
	private final int[] indexes ;

	public Projection(_Relation r, _Schema schema ) {
		super("Projection(" + r.name() + ")",schema, r);
		indexes = new int[schema.getDegree()];
		for(int i =0; i<indexes.length;i++){
			indexes[i]=r.schema().get(schema.get(i));
		}
	}

	@Override
	public long cardinalite() {
		return r.cardinalite();
	}

	@Override
	public Iterator<_Tuple> iterator() {
		return new Iterator<_Tuple>() {
			private Iterator<_Tuple> ct = r.iterator();

			public boolean hasNext() {
				return ct.hasNext();
			}

			public _Tuple next() {
				Tuple t = (Tuple)ct.next();
				Object[] x = new Object[indexes.length];
				for(int i=0; i<indexes.length;i++)  x[i]=t.get(indexes[i]);
				return new Tuple(x);
			}
		};
	}
}
