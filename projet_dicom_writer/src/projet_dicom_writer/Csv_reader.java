package projet_dicom_writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv_reader {
// reçoit les valeurs de 6 capteurs instants par instants

ArrayList<Integer> x_values;
public ArrayList<Integer> csvread(String nom_du_fichier) {
double values_temps;
int valint;
String valstr;
try (BufferedReader br = new BufferedReader(new FileReader("x.csv"))) {
    String line;
    while ((line = br.readLine()) != null) {
        String[] values = line.split(";");
        valstr=values.toString();
        values_temps=Double.parseDouble(valstr);
        values_temps=values_temps*1000;
        valint=(int)values_temps;
        x_values.add(valint);        
    }    

} catch (IOException e) {
    e.printStackTrace();

}
return x_values;
}
}