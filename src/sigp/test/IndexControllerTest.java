package sigp.test;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;

import sigp.src.controllers.IndexController;


public class IndexControllerTest {

	IndexController controller;
	Result result;
	@Before
	public void setUp() throws Exception {
		result = mock(Result.class);
		controller = new IndexController(result);
	}

	@After
	public void tearDown() throws Exception {
		result = null;
		controller = null;
	}

	@Test
	public void testIndex() {
		controller.index();
	}

}
