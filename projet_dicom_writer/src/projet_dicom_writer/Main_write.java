package projet_dicom_writer;

public class Main_write {

	public static void main(String[] args) {
		//TODO Auto-generated method stub 
		double Data_accel[] ; //fonction qui récupère le csv // = new Dicom_bluetooth();
		
		//Data_user myData= new Data_user(); objet qui contient toutes les sauvegardes de l'application
		//myData.getTag;
		//myData.getVR;
		//MyData.getValue;
		// ne pas oublier les try catch 
		Dicom_write myFichier = new Dicom_write();
		
		// Ajouter les ajout de valeur, attention doivent être dans l'ordre, fonction qui doit les trier ! 
		
		myFichier.set_nom_fichier(args[0]);	
		myFichier.set_valeur(Data_accel);
		


	}

}
