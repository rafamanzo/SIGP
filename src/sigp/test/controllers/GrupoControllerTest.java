package sigp.test.controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;

import sigp.src.Grupo;
import sigp.src.controllers.GrupoController;
import sigp.src.dao.GrupoDao;

public class GrupoControllerTest {
	GrupoController controller;
	Result result;
	GrupoDao dao;
	List<Grupo> list;
	
	@Before
	public void setUp() throws Exception {
		result = mock(Result.class);
		dao = mock(GrupoDao.class);
		controller = new GrupoController(result, dao);
		
		GrupoController controlmock = mock(GrupoController.class);
		when(result.redirectTo(GrupoController.class)).thenReturn(controlmock);
		
		setUpDao();
	}
	
	public void setUpDao() {
		list = new ArrayList<Grupo>();
		{
			Grupo d = new Grupo();
			d.setIdGrupo(1L);
			d.setNome("Grupo Principal");
			d.setResponsavel(null);
			list.add(d);
		}
		{
			Grupo d = new Grupo();
			d.setIdGrupo(2L);
			d.setNome("Sistemas Operacionais");
			d.setResponsavel(list.get(0));
			list.add(d);
		}
		when(dao.list()).thenReturn(list);
		when(dao.getGrupo(1L)).thenReturn(list.get(0));
		when(dao.getGrupo(2L)).thenReturn(list.get(1));
	}

	@After
	public void tearDown() throws Exception {
		controller = null;
		result = null;
		dao = null;
	}

	@Test
	public void testIndex() {
		controller.index();
		verify(result).include("grupos", list);
	}

	@Test
	public void testCria() {
		{
			Grupo d = list.get(0);
			controller.cria(d, 0L);
			verify(dao).save(d);
		}
		{
			Grupo d = new Grupo();
			d.setNome("Teste Particular");
			controller.cria(d, 1L);
			verify(dao).save(d);
			assertSame(d.getResponsavel(), list.get(0));
		}
	}

	@Test
	public void testVisualiza() {
		Grupo d = list.get(0);
		controller.visualiza(d.getIdGrupo());
		verify(result).include("grupo", d);
	}

	@Test
	public void testAltera() {
		{
			Grupo d = list.get(0);
			controller.altera(d, 0L);
			verify(dao).update(d);
		}
		{
			Grupo d = new Grupo();
			d.setNome("Teste Particular");
			controller.altera(d, 1L);
			verify(dao).update(d);
			assertSame(d.getResponsavel(), list.get(0));
		}
	}

	@Test
	public void testRemove() {
		Grupo d = list.get(0);
		controller.remove(d.getIdGrupo());
		verify(dao).delete(d);
	}

}
