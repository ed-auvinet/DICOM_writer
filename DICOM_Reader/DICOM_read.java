import java.io.*;

public class DICOM_read {
	String nom_fichier;

	public void set_nom_fichier(String nom)
	{
		this.nom_fichier=nom;
	}
	public void open(String nom_fichier)
	{
		this.nom_fichier=nom_fichier;
		System.out.println("Ouverture du fichier:"+nom_fichier);
		try
		{
      			//File myObj = new File(nom_fichier);
			InputStream inputStream = new FileInputStream(nom_fichier);
			int byteRead;
			byte[] zero_pad = new byte[128];
			inputStream.read(zero_pad); 
			byte[] DICOM_ent=new byte[4];
			inputStream.read(DICOM_ent);
			if(DICOM_ent[0]=='D')
			{
				System.out.println("Dicom present");
				Data_element_reader data=new Data_element_reader();
				data.Data_read(inputStream);
			} 

		}
		catch (IOException e)
		{
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		}
	}
}
