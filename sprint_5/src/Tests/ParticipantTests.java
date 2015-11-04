package Tests;

import Models.Participant;
import junit.framework.TestCase;

public class ParticipantTests extends TestCase{
	
	
	
	public static void testCreation(){
		String id = "42";
		String nom = "Menvussat";
		String prenom = "Gerard";
		
		Participant testeur = new Participant(id,nom,prenom);
		
		assertEquals("Affiche : "+id,id,testeur.getId());
		assertEquals("Affiche : "+nom,nom,testeur.getFirstName());
		assertEquals("Affiche : "+prenom,prenom,testeur.getLastName());
	}
	
	public static void testModification(){
		String id = "42";
		String nom = "Menvussat";
		String prenom = "Gerard";
		
		String newId = "666";
		String newNom = "ztakess";
		String newPrenom = "Helena";
		
		Participant testeur = new Participant(id,nom,prenom);
		testeur.setId(newId);
		testeur.setFirstName(newNom);
		testeur.setLastName(newPrenom);
		
		
		assertEquals("Affiche : "+newId,newId,testeur.getId());
		assertEquals("Affiche : "+newNom,newNom,testeur.getFirstName());
		assertEquals("Affiche : "+newPrenom,newPrenom,testeur.getLastName());
		
	}

}
