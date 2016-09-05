import name.rex.commlib.database.Redis;
import name.rex.commlib.io.FileHelper;
import name.rex.commlib.security.MessageDigestHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class FileTest
{
    byte data[];
    String md5;
    String text;
    
    @Before
    public void Before()
    {
        data = new byte[1024];
        for( int i = 0 ; i < data.length; i++ )
        {
            data[i] = (byte)i;
        }

        md5 = MessageDigestHelper.md5String( data );
        System.out.println( "Orig data md5: " + md5 );

        text = "sdfsdfsd司法解释的开发商的sdfsdfdsf都是非法所得发";
    }

    public void checkWriteByte()
    {
        FileHelper.writeByteFile( "a.bin", data );
    }

    @Test
    public void checkReadByte()
    {
        checkWriteByte();
        byte[] readData = FileHelper.readByteFile( "a.bin" );
        String readMd5 = MessageDigestHelper.md5String( readData );
        System.out.println( "read md5: " + readMd5 );
        Assert.assertTrue( readMd5.equals( md5 ) );
    }

    public void checkWriteText()
    {
        FileHelper.writeTextFile( "a.txt", text );
    }

    @Test
    public void checkReadText()
    {
        checkWriteText();
        String readText = FileHelper.readTextFile( "a.txt" );
        System.out.println( "read text: " + readText );
        Assert.assertTrue( readText.equals( text ) );
    }
}
