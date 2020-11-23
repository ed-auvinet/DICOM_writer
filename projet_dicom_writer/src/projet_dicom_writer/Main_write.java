package projet_dicom_writer;

public class Main_write {

	public static void main(String[] args) {
		//TODO Auto-generated method stub 
		double Data_accel[][] ; //fonction qui récupère le csv // = new Dicom_bluetooth();
		// ne pas oublier les try catch 
		Dicom_write myFichier = new Dicom_write();
		myFichier.set_nom_fichier(args[0]);	
		myFichier.set_valeur(Data_accel);
		


	}

}
