package projet_dicom_writer;
import java.io.*;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;



public class Dicom_write {
	private String nom_fichier;
	private ByteArrayOutputStream Sortie;
	private byte octetvalue;
	private ArrayList<Integer> list_tempo; //utiliser list<Integer> instead ?
	
	//package dicom_writer;
	public Dicom_write(int total_size) {
		/*Prepare le dicom avec le preambule et la norme*/
		int i;
		for (i=0; i<127;i++) { 
				list_tempo.add(0x00);	//plus sûr on aurait pu utilisé 0 aussi peut-être
		}
		list_tempo.add(0x44);
		list_tempo.add(0x49);
		list_tempo.add(0x43);
		list_tempo.add(0x4D);
	}
	
	
	
	public void set_nom_fichier(String nom) {
			this.nom_fichier=nom;
			
		}
		public void set_data_VRstrict(String tag, String VR, int longueur, int[] value) {
			/*Nombre est le TAG
			 * Utilisation du code Endian Data Input Stream modifié.... à ajouter ici à chaque étapes */
			char VR1=VR.charAt(0);
			char VR2=VR.charAt(1);
			int valueVR1=(int) VR1; // (Quelle taille a ce VR1 ? une ou 2 chiffre ? Comment les ajouter 
			int valueVR2=(int) VR2; // regarder lorsqu'il tournera) AH AH Non gardons le comme ça, il sera transformé en binaire 
			int ite;
			for (ite=0; ite<tag.length();ite++) {
				int elem=tag.charAt(0);
				list_tempo.add(elem);
			}
			
			list_tempo.add(longueur);
			
			for (ite=0; ite<value.length;ite++) {
			list_tempo.add(value[ite]);
			}
			
			
		}
		public void	set_data_VR(int tag, String VR, int longueur, int[] value) {
			char VR1=VR.charAt(0);
			char VR2=VR.charAt(1);
			int valueVR1=(int) VR1;
			int valueVR2=(int) VR2;
			//int b=0x4F;
			
			
			
			
		}
		public void set_valeur(double valeurs[][]) {
			/*Rentre les valeurs des accélérotmetre dans le dicom 
			 * 
			*/
			
			
			
		}
		
		private byte[] translate(){
			/*Transforme une ArrayList en int[]
			 * MODIFICATION transforme ArrayList<Integer> to byte[] !*/
			int ite;
			int MaxL=list_tempo.size();
			byte[] list_tempo_byte=new byte[MaxL];
			for (ite =0; ite<MaxL;ite++) {
				int temp=list_tempo.get(ite); // Si  problème, remplacer en Integer
				list_tempo_byte[ite] =(byte) temp; //byteValue si Integer
				}
			return list_tempo_byte;
				
			}
			
		
			
			
		}
		public ByteArrayOutputStream export() {
			byte[] list_tempo_byte=translate();
			ByteArrayOutputStream Sortie = new ByteArrayOutputStream(table_tempo.length);
			Sortie.write(list_tempo_byte);
			return Sortie;
		}
		

}

