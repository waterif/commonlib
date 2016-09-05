package name.rex.commlib.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class CipherHelper {

	/**
	 * AES/ECB/PKCS5Padding 加密，只支持128位（16个字节）秘钥
	 *      为了方便查看，对密文进行了base64编码
	 * @param oriStr           源字符串
	 * @param encryptKey       秘钥
	 * @return                 密文
	 * @throws Exception
	 */
	public static String aesEncrypt(String oriStr, String encryptKey) throws Exception
	{
		if ( encryptKey == null || encryptKey.length() != 16)
		{
			throw new Exception( "secret key must 16 byte!" );
		}
		
		SecretKeySpec skey = new SecretKeySpec(encryptKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skey);
		byte[] crypted = cipher.doFinal(oriStr.getBytes());
			
		// return new BASE64Encoder().encode(crypted);
        return Base64.encodeBase64String( crypted );
	}

	/**
	* AES/ECB/PKCS5Padding 解密，只支持128位（16个字节）秘钥
	*         为了方便查看，对密文进行了base64编码
	 * @param ciphertext      密文
	 * @param encryptKey        秘钥
	 * @return           源字符串
	 * @throws Exception
	 */
	public static String aesDecrypt(String ciphertext, String encryptKey) throws Exception
	{
		if ( encryptKey == null || encryptKey.length() != 16)
        {
			throw new Exception( "secret key must 16 byte!" );
        }
		
		SecretKeySpec skey = new SecretKeySpec(encryptKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skey);
		byte[] output = cipher.doFinal( Base64.decodeBase64( ciphertext ) );

		return new String(output);
	}

	/**
	 * 生成签名字符串
	 * @param token
	 * @param timestamp
	 * @param random
	 * @return
	 * @throws
	 */
	public static String genSignature ( String token, long timestamp, String random ) throws NoSuchAlgorithmException  
	{
		String[] arr = { token, timestamp + "", random };
	
        //根据元素的自然顺序对指定对象数组按升序进行排序
		Arrays.sort(arr);

		String str = arr[0] + arr[1] + arr[2];
		byte[] bt = str.getBytes();
		MessageDigest md = MessageDigest.getInstance("SHA1");
		
        md.update(bt);

		return bytes2Hex(md.digest());		
	}
	/**
	 * 字节数组转换成16进制字符串
	 * @param bts
	 * @return
	 */
	private static String bytes2Hex( byte[] bts ) 
	{
		StringBuilder des = new StringBuilder();
		String tmp = null;
		for (int i = 0; i < bts.length; i++) 
		{
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) 
				des.append( "0" );

			des.append( tmp );
		}
		
		return des.toString();
	}

	private static String token = "1234qwerqwerasdf213";
	public static void main(String[] args) 
	{
		String key = "123456asdr4tf345";
		String data = "阿斯蒂芬问问";
		
		try
		{
			String hou = CipherHelper.aesEncrypt(data, key);
			System.out.println(hou);
			System.out.println(CipherHelper.aesDecrypt(hou, key));
			
			long timestamp = System.currentTimeMillis();
			String random = UUID.randomUUID().toString();
			System.out.println( "timestamp : "+timestamp + "\n random : " + random + "\n Signature : " + genSignature (token, timestamp, random) );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
