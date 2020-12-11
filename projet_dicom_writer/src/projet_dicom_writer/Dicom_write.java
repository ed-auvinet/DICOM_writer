package projet_dicom_writer;
import java.io.*;
import java.util.ArrayList;




public class Dicom_write {
	private String nom_fichier;
	private ByteArrayOutputStream Sortie;
	private byte octetvalue;
	private ArrayList<Byte> list_tempo; //utiliser list<Integer> instead ?
	//utiliser le ArrayList<byte> à la place pour 
	//package dicom_writer;
	
	public Dicom_write() {
		/*Prepare le dicom avec le preambule et la norme*/
		int i;
		for (i=0; i==4;i++) { 
				byte elem=(int) 0; // ajout 32 octet de 0,  4x =128 octets 
				list_tempo.add(elem);
		}
		list_tempo.add((byte) 'D'); //0x44);  quelle taille fait 0x..
		list_tempo.add((byte) 'I'); //0x49);
		list_tempo.add((byte) 'C'); //0x43);
		list_tempo.add((byte) 'M'); //0x4D);
		
	}

	
	
	public void addTag(char tag) {
		//en endian, à ajouter 
		/*Ajoute une lettre en 16bit */
		list_tempo.add((byte) tag);
		
	}
	public void addVRstrict(char VR) {
		/*Ajoute une lettre en 16bit */
		//en endian, à ajouter 
		list_tempo.add((byte) VR);
		
	}
	public void addVR(char VR) {
		//en endian, à ajouter 
		list_tempo.add((byte) VR);
		
	}
	public void addValueLengStrict(int longueur) {
		//int unsigned remplacé par int tant qu'on dépasse pas les 2 millions
		// ajoute un nombre complet
		//en endian, à ajouter 
		list_tempo.add((byte) longueur);
		
	}
	public void addValueLeng(char longueur) {
		//en endian, à ajouter 
		list_tempo.add((byte) longueur);
		
	}
	public void addValue(int valeur) {
		//en endian, à ajouter 
		list_tempo.add((byte) valeur);
		
	}
	
			
		
		public void set_data_VRstrict(String tag, String VR, int longueur, int[] value) {
			/*Nombre est le TAG
			 * Utilisation du code Endian Data Input Stream modifié.... à ajouter ici à chaque étapes */
			char VR1=VR.charAt(0);
			char VR2=VR.charAt(1);
			// (Quelle taille a ce VR1 ? une ou 2 chiffre ? Comment les ajouter 
			// regarder lorsqu'il tournera) AH AH Non gardons le comme ça, il sera transformé en binaire 
			int ite;
			for (ite=0; ite<3;ite++) {
				int elem=tag.charAt(0);
				list_tempo.add(elem);
			}

		}
		
		
		public ByteArrayOutputStream export() throws IOException {
			byte[] result = new byte[list_tempo.size()];
			for(int i = 0; i < list_tempo.size(); i++) {
			    result[i] = list_tempo.get(i);// .byteValue(); ajoute ça si marche pas ? 
			}
			ByteArrayOutputStream Sortie = new ByteArrayOutputStream(result.length); 
			Sortie.write(result);
			return Sortie;
		}
		

}

