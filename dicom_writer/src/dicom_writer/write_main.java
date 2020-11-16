import java.io.*;

package dicom_writer;

public class write_main {
	
	public static void main(String[] args) {
		
		dicom_write myFichier = new dicom_write();
		myFichier.set_nom_fichier(args[0]);
	    
	}

}
