package Schema;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dans_fichier {
	private FileWriter fileWriter = null;
	//private String fileName;

	public Dans_fichier() {
		// TODO Auto-generated constructor stub
	}
	
	// ajouter une ligne dans le fichier .txt. Il faut tansformer les truples en String, puis on peut utiliser cette méthodes
	public void add(String nomDeFichier,String buffer, boolean doAppend) {
		try {
			fileWriter = new FileWriter("./"+nomDeFichier,doAppend);
			fileWriter.append(buffer+"\n");	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}				
	}
	
	/* Cette méthodes dans le commentaire est le moyen de utiliser la méthodes supp
	 * private int checkDelete(String[] strs) {
		int deleteReturn;
		boolean isId = isNumberic(strs[1]);
		deleteReturn = action.actDelete(strs, isId);
		
		if(deleteReturn == -1) {
			ui.displayQueryFail();
			ui.displayHelpDelete();
		}
		return 0;
	}*/
	// is Id pour distinguer le premier ligne est le clé primaire ou pas;
	public int supp(String nomDeFichier,String[] strs, boolean isId) {
		//queryFile = new QueryFile();
		//writeFile = new WriteFile();
		String[] ramStrs = new String[100];		//size100
		int resultDelete;
		String[] tempDelete;
		//recupere tous tuples
		ramStrs = tousTuples(nomDeFichier);
		//si le prémier attribut est clé primaire;
		if(isId) {
			int j = 0;
			while(true) {
				if(ramStrs[j] == null) {
					resultDelete = -1;
					break;
				}
				// recupere la ligne qu'on vas supprimer sous forme de tableau de chaine de caractères
				tempDelete = ramStrs[j].split(" ");
				if(strs[0].equals(tempDelete[0])) {
					resultDelete = j;
					break;
				}
				j++;
			}
		} else {
			int j = 0;
			while(true) {
				if(ramStrs[j] == null){
					resultDelete = -1;
					break;
				}
				tempDelete = ramStrs[j].split(" ");
				if(strs[0].equals(tempDelete[1])) {
					resultDelete = j;
					break;
				}
				j++;
			}
		}
		if(resultDelete != -1) {
			ramStrs[resultDelete] = "";
			//stocker les données dans les fichiers sans la ligne qu'on a déja supprimé
			for(int j = 0; ramStrs[j] != null && j < 100; j++) {
				if( ! "".equals(ramStrs[j])) {
					if(j == 0 || (j == 1 && "".equals(ramStrs[0]))) {	/// BUG DELETE the first line
						add(nomDeFichier,ramStrs[j], false);
					}else {
						add(nomDeFichier,ramStrs[j], true);
					}
				}
			}
		}else {
			return -1;
		}		
		return 0;						
	}
	//recupére tous les lignes dans le fichier sous formes de tableau de chanes de caractère
	public String[] tousTuples(String nomDeFichier) {							
		int resultCount = 0;
		String[] strs = new String[100];//size: 100 members
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(nomDeFichier);
			bufferedReader = new BufferedReader(fileReader);	// /home/hadoop/eclipse-workspace/MyDatabase
														
			String tempStr;
			for(resultCount = 0; (resultCount == 0 || strs[resultCount-1] != null);) {	//short cut
				try {
					if( ! "".equals((tempStr = bufferedReader.readLine()))) {
						strs[resultCount] = tempStr;
						resultCount++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(resultCount == 1 && strs[0] == null) {
			System.out.println("< 0 result(s).>");	
			return null;
		}else {
			return strs;
		}
	}
	
}
