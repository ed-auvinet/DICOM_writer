package projet_dicom_writer;
import java.io.*;
import java.util.ArrayList;




public class Dicom_write {
	private String nom_fichier;
	private ByteArrayOutputStream Sortie;
	private byte octetvalue;
	private ArrayList<Byte> list_tempo = new ArrayList<Byte>(); //utiliser list<Integer> instead ?
	//utiliser le ArrayList<byte> à la place pour 
	//package dicom_writer;
	
	public Dicom_write() {
		/*Prepare le dicom avec le preambule et la norme*/
		int i;
		for (i=0; i==4;i++) { 
				byte elem=(int) 0; // ajout 32 octet de 0,  4x =128 octets 
				list_tempo.add(elem);
		}
		list_tempo.add((byte) 'D'); //0x44);  
		list_tempo.add((byte) 'I'); //0x49);
		list_tempo.add((byte) 'C'); //0x43);
		list_tempo.add((byte) 'M'); //0x4D);
		
		//Dicom-Meta-Information-Header
	}

	
	
	public void addTag(char g1, char g2) {
		/*Ajoutes le tag en 16bits - */
		// Ajout little endian
		list_tempo.add((byte)g1);
		list_tempo.add((byte)g2);
		
	}
	public void addVRstrict(char VR1, char VR2) {
		/*Ajoute les 2 VR ainsi que 2byte vide 
		 * Finie */
		list_tempo.add((byte) VR1);
		list_tempo.add((byte) VR2);
		list_tempo.add((byte) 0);
		list_tempo.add((byte) 0);
		
		
	}
	public void addVR(char VR1, char VR2) {
		/*Ajoute une lettre en 16bit - 
		 * Finie */
		list_tempo.add((byte) VR1);
		list_tempo.add((byte) VR2);
		
	}
	public void addValueLengStrict(int longueur) {
		// int unsigned remplacé par int tant qu'on dépasse pas les 2 millions
		// ajoute un nombre complet
		// fonction little endian ICI ajouter 
		list_tempo.add((byte) longueur);
		
	}
	public void addValueLeng(char longueur) {
		//ajoute fonction little endian 
		list_tempo.add((byte) longueur);
	}
	
	public void addValueInt (int Valeur) {
		//little endian fonction
		list_tempo.add((byte) Valeur);
		
	}
	public void addValueIntlist(ArrayList<Integer> valeur) {
		//en endian, à ajouter 
		int i;
		for (i=0; i== (int)valeur.size();i++) { 
			list_tempo.add((byte) valeur.get(i).intValue());
		}
	}
	
	public void addValueText(String Text) {
		//en endian, à ajouter 

	}
	
		
	public void set_data_VRstrict(char g1, char g2 , char el1, char el2, char VR1, char VR2, int longueur ) {

		this.addTag(g1, g2, el1, el2);
		this.addVRstrict(VR1,VR2);
		this.addValueLengStrict(longueur);

		
	}
	
	public void set_data_VR(char g1, char g2, char el1, char el2 ,char VR1, char VR2, char longueur) {
		int i;
		this.addTag(g1, g2, el1, el2);
		this.addVR(VR1,VR2);
		this.addValueLeng(longueur);

	
	}
	
	public void set_data(ArrayList<Integer> valeur) {
	/*Ajoutes un data element d'un paquet de données
	 * 
	 * */
		this.addTag ((char) 54,(char) 00,(char) 10,(char) 11);
		this.addVRstrict('O','B');
		this.addValueLengStrict(valeur.size());
		

	}
		/* public void set_data_VRstrict(String tag, String VR, int longueur, int[] value) {
			/*Nombre est le TAG
			 * Utilisation du code Endian Data Input Stream modifié.... à ajouter ici à chaque étapes */
			/* char VR1=VR.charAt(0);
			char VR2=VR.charAt(1);
			// (Quelle taille a ce VR1 ? une ou 2 chiffre ? Comment les ajouter 
			// regarder lorsqu'il tournera) AH AH Non gardons le comme ça, il sera transformé en binaire 
			int ite;
			for (ite=0; ite<3;ite++) {
				int elem=tag.charAt(0);
				list_tempo.add(elem);
			} 

		} */
		
		
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

