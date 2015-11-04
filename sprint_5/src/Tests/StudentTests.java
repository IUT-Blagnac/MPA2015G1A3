package Tests;

import Models.Student;
import junit.framework.TestCase;

public class StudentTests extends TestCase {
	
	public static void testCreation(){
		String id = "42";
		String groupe = "Z";
		String nom = "Menvussat";
		String prenom = "Gerard";
		
		Student testeur = new Student(groupe,id,nom,prenom);
		
		assertEquals("Affiche : "+id,id,testeur.getId());
		assertEquals("Affiche : "+groupe,groupe,testeur.getGroup());
		assertEquals("Affiche : "+nom,nom,testeur.getFirstName());
		assertEquals("Affiche : "+prenom,prenom,testeur.getLastName());
	}
	
	public static void testModification(){
		String id = "42";
		String groupe = "Z";
		String nom = "Menvussat";
		String prenom = "Gerard";
		
		String newId = "666";
		String newGroupe = "A";
		String newNom = "ztakess";
		String newPrenom = "Helena";
		
		Student testeur = new Student(id,groupe,nom,prenom);
		
		testeur.setId(newId);
		testeur.setGroup(newGroupe);
		testeur.setFirstName(newNom);
		testeur.setLastName(newPrenom);
		
		
		assertEquals("Affiche : "+newId,newId,testeur.getId());
		assertEquals("Affiche : "+newGroupe,newGroupe,testeur.getGroup());
		assertEquals("Affiche : "+newNom,newNom,testeur.getFirstName());
		assertEquals("Affiche : "+newPrenom,newPrenom,testeur.getLastName());
		
	}

}
