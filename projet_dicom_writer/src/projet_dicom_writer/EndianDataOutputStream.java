package projet_dicom_writer;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class EndianDataOutputStream extends OutputStream implements DataOutput {
/*
 * Simple class to add endian support ton DataOutputStream
 * User antonin
 * Date 16.11.2020
 * EST A UTILISER PLUS TARD, finir le reste du code comme si l'on codait en BIG ENDIAN
 * 
 * Inspired By 
 * 
 * Simple class to add endian support to DataInputStream.
 * User: michael
 * Date: 9/12/13
 * Time: 4:39 PM
 */
	ByteArrayOutputStream dataout;
	private ByteBuffer buffer = ByteBuffer.allocate(8);
	ByteOrder order = ByteOrder.BIG_ENDIAN;
	
	public EndianDataOutputStream (int nbroctet) {
		/*Constructor 
		 * Initialize the output to a number of Byte different then the defaut 32 bytes */
		//this.order=;
	}
	
    public EndianDataOutputStream order(ByteOrder o){
        order = o;
        return this;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return dataIn.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return dataIn.read(b, off, len);
    }

    @Deprecated
    @Override
    public String readLine() throws IOException {
        return dataIn.readLine();
    }

    @Override
    public boolean readBoolean() throws IOException {
        return dataIn.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return dataIn.readByte();
    }

    @Override
    public int read() throws IOException {
        return readByte();
    }

    @Override
    public boolean markSupported(){
        return dataIn.markSupported();
    }

    @Override
    public void mark(int readlimit) {
        dataIn.mark(readlimit);
    }

    @Override
    public void reset() throws IOException {
        dataIn.reset();
    }

    @Override
    public char readChar() throws IOException {
        return dataIn.readChar();
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        dataIn.readFully(b);
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        dataIn.readFully(b, off, len);
    }

    @Override
    public String readUTF() throws IOException {
        return dataIn.readUTF();
    }

    @Override
    public int skipBytes(int n) throws IOException {
        return dataIn.skipBytes(n);
    }

    @Override
    public double readDouble() throws IOException {
        long tmp = readLong();
        return Double.longBitsToDouble( tmp );
    }

    @Override
    public float readFloat() throws IOException {
        int tmp = readInt();
        return Float.intBitsToFloat( tmp );
    }

    @Override
    public int readInt() throws IOException {
        buffer.clear();
        buffer.order( ByteOrder.BIG_ENDIAN )
                .putInt( dataIn.readInt() )
                .flip();
        return buffer.order( order ).getInt();
    }

    @Override
    public long readLong() throws IOException {
        buffer.clear();
        buffer.order( ByteOrder.BIG_ENDIAN )
                .putLong( dataIn.readLong() )
                .flip();
        return buffer.order( order ).getLong();
    }

    @Override
    public short readShort() throws IOException {
        buffer.clear();
        buffer.order( ByteOrder.BIG_ENDIAN )
                .putShort( dataIn.readShort () )
                .flip();
        return buffer.order( order ).getShort();
    }

    @Override
    public int readUnsignedByte() throws IOException {
        return (int)dataIn.readByte();
    }

    @Override
    public int readUnsignedShort() throws IOException {
        return (int)readShort();
    }

@Override
public void writeBoolean(boolean arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeByte(int arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeBytes(String arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeChar(int arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeChars(String arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeDouble(double arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeFloat(float arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeInt(int arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeLong(long arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeShort(int arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void writeUTF(String arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void write(int arg0) throws IOException {
	// TODO Auto-generated method stub
	
}
}

}