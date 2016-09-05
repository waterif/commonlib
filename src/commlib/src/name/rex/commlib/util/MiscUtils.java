package name.rex.commlib.util;

public class MiscUtils
{
    public static byte[] int2LittleEndianByte( int a )
    {
        byte[] b = new byte[4];

        b[0] = (byte)( a & 0xff );
        b[1] = (byte)( a >> 8 & 0xff );
        b[2] = (byte)( a >> 16 & 0xff );
        b[3] = (byte)( a >> 24 & 0xff );

        return b;
    }

    public static byte[] int2BigEndianByte( int a )
    {
        byte[] b = new byte[4];

        b[3] = (byte)( a & 0xff );
        b[2] = (byte)( a >> 8 & 0xff );
        b[1] = (byte)( a >> 16 & 0xff );
        b[0] = (byte)( a >> 24 & 0xff );
        
        return b;
    }
}
