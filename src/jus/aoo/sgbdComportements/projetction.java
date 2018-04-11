package jus.aoo.sgbdComportements;
//import jus.aoo.sgbdComportements.projection;
import java.util.List;

import jus.aoo.sgbdComportements._Relation;
import jus.aoo.sgbdComposants.Attribut;
import jus.aoo.sgbdComposants.Schema;
import jus.aoo.sgbdComposants._Schema;

public class projetction {
	
	public void createProjection(String s,List<Attribut> l){
		_Relation r = null;
		_Schema sc ;
		if(l.size()==0) { sc = r.schema();
		}
		else {
			sc = new Schema(l);
		}
		 new Projection(s,sc);
	//	return 
		
	}

}