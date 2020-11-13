import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
// https://northstar-www.dartmouth.edu/doc/idl/html_6.2/Value_Representations.html
public class Data_element_reader
{
	public byte[] VR;
	//public unsigned long UL;
	void Data_read(InputStream inputStream)
	{
		System.out.println("Lecture d'un data_element");
		EndianDataInputStream inst = new EndianDataInputStream(inputStream);
		inst.order(ByteOrder.LITTLE_ENDIAN);
		short Tag_group=0;
		//byte[] Tag_group =new byte[2]; 
		short Tag_element=0;
		//byte[] Tag_element =new byte[2];
		VR =new byte[2];
		byte[] VR_reserved =new byte[2];
		try{
		Tag_group=inst.readShort();
		Tag_element=inst.readShort();
		//inputStream.read(Tag_element);
		inputStream.read(VR);
		} catch (IOException e){}
		System.out.println("Tag_group: "+Tag_group);
		System.out.println("Tag_element: "+Tag_element);
		if(VR[0]=='O')
		{
			if(VR[1]=='B')
			{
				System.out.println("tab OB");
			}
			if(VR[1]=='W')
			{
				System.out.println("tab OW");
			}
			if(VR[1]=='F')
			{
				System.out.println("tab OF");
			}
		}
		if(VR[0]=='S')
		{
			if(VR[1]=='Q')
			{
				System.out.println("tab SQ");
			}
		} 
		if(VR[0]=='U')
		{
			if(VR[1]=='T')
			{
				System.out.println("tab UT");
			}
			if(VR[1]=='N')
			{
				System.out.println("tab UN");
			}
			if(VR[1]=='I')
			{
				System.out.println("tab UI");
			}
			if(VR[1]=='L')
			{
				System.out.println("tab UL");
//				try{
//					inputStream.read(VR_reserved);
//				} catch (IOException e){}

				short myShort=0;
				try{
					myShort = inst.readShort();
				} catch (IOException e){}
				System.out.println("Value Length :"+myShort);  

				int myInt=0;
				try{
					myInt = inst.readInt();
				} catch (IOException e){}
				System.out.println("Value: "+myInt);  

/*
				byte[] test =new byte[4];
				try{
				inputStream.read(test);
				} catch (IOException e){}
				String st1 = String.format("%02X", test[0]);
				String st2 = String.format("%02X", test[1]);
				String st3 = String.format("%02X", test[2]);
				String st4 = String.format("%02X", test[3]);
				System.out.println(" byte 1: "+st1+" "+st2+ " " +st3+" " +st4);
*/
			}
		}
 
	}
}
