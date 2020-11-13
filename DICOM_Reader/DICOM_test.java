public class DICOM_test {
  int x = 5;

  public static void main(String[] args) {
    DICOM_read myObj = new DICOM_read();
	myObj.open(args[0]);
  }
}
