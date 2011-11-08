package sigp.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sigp.src.hash.PasswordCodificator;

public class PasswordCodificatorTest {

	@Test
	public void testCodificado() {
		assertEquals("d0b69b14678161a87ddb479cbb52fed1", new PasswordCodificator("alfafa").codificado());
		assertEquals("9eb71ab7420eb452a22787ca4fab501b", new PasswordCodificator("batata").codificado());
		assertEquals("4297f44b13955235245b2497399d7a93", new PasswordCodificator("123123").codificado());
		assertEquals("5f4dcc3b5aa765d61d8327deb882cf99", new PasswordCodificator("password").codificado());
	}

}
