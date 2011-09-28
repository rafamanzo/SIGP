package sigp.src.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCodificator {
	private  String passw;
	
	public PasswordCodificator(String str) {
		this.passw = password(str);
	}
	
	public String codificado(){
		return this.passw;
	}
	
	public  String password(String password){
		String passwordHash = null;
		
		try{
			MessageDigest coding = MessageDigest.getInstance("MD5");
			coding.update(password.getBytes());	
			BigInteger hash = new BigInteger(1, coding.digest());
			passwordHash = hash.toString(16);
		}catch (NoSuchAlgorithmException e){
			
		}
		return pad(passwordHash, 32, '0');
	}
	
	private  String pad(String s, int length, char pad){
		StringBuffer buffer = new StringBuffer(s);
		while (buffer.length() < length){
			buffer.insert(0, pad);
		}
		return buffer.toString();
	}

}
