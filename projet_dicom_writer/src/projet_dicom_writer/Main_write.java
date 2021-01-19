package projet_dicom_writer;

import java.util.ArrayList;

public class Main_write {

	public static void main(String[] args) {
		//TODO Auto-generated method stub 
		//double Data_accel[] ; fonction qui récupère le csv // = new Dicom_bluetooth();
		
		ArrayList<Integer> records = new ArrayList<Integer>();
		int i;
		//Crée un ensemble de données Random pour tester
		for (i=0; i<24 ;i++) {
			records.add((int) Math.random());
		}

		//Data_user myData= new Data_user(); objet qui contient toutes les sauvegardes de l'application
		//myData.getTag;
		//myData.getVR;
		//MyData.getValue;
		//ne pas oublier les try catch 
		
		Dicom_write myFichier = new Dicom_write();
		
		// Ajouter les ajout de valeur, attention doivent être dans l'ordre, fonction qui doit les trier ! 
		
		// Remplissage des MetaInformations
		// myFichier.addTag((byte) 0 ,(byte) 2,(byte) 0,(byte) 0 );
		
		
		
		//Remplissage des Waveforms
		//Type de données dans les waveforme
		myFichier.addTag((char) 0x5400,(char) 0x1006);		//5400 1006 CS 0004 SL // 32bit signés
		myFichier.addVR('C', 'S');
		myFichier.addValueLeng( (char) 4);
		myFichier.addVR('S','L'); // ajoute la valeur qui sont des caractères ici.
		
		myFichier.addTag((char) 0x003A,(char) 0x0005);		//003A 0005 US 0002 6 // Nombre de channels 6 
		myFichier.addVR('U', 'S');
		myFichier.addValueLeng( (char) 2);
		myFichier.addValueLeng((char) 0x6); // ajoute la valeur qui 16bit non signés
		
		myFichier.addTag((char) 0x003A,(char) 0x0010);		//003A 0005 US 0002 6 // Nombre de channels 6 
		myFichier.addVR('U', 'L');
		myFichier.addValueLeng( (char) 0x0004);
		myFichier.addValueInt((int) 0x4); // ajoute la valeur en 32bit non signé via un 32 bit signés
		
		//00 3A 00 10 UL 00 04 4 // Nombre de sample par channels 4
		
	}

}
