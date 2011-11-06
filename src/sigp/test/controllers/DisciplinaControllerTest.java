package sigp.test.controllers;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import sigp.src.Disciplina;
import sigp.src.controllers.DisciplinaController;
import sigp.src.dao.DisciplinaDao;
import sigp.src.dao.GrupoDao;

public class DisciplinaControllerTest {
	DisciplinaController controller;
	Result result;
	Validator validator;
	DisciplinaDao dao;
	GrupoDao grupoDao;
	List<Disciplina> list;
	
	@Before
	public void setUp() throws Exception {
		result = mock(Result.class);
		dao = mock(DisciplinaDao.class);
		grupoDao = mock(GrupoDao.class);
		validator = mock(Validator.class);
		controller = new DisciplinaController(result, validator, dao, grupoDao);
		
		DisciplinaController controlmock = mock(DisciplinaController.class);
		when(result.redirectTo(DisciplinaController.class)).thenReturn(controlmock);
		when(validator.onErrorForwardTo(controller)).thenReturn(controlmock);
		
		setUpDao();
	}
	
	public void setUpDao() {
		list = new ArrayList<Disciplina>();
		{
			Disciplina d = new Disciplina();
			d.setIdDisciplina(1L);
			d.setSigla("MAC110");
			d.setNome("Introdução à Computação");
			d.setEmenta("Matéria de introdução.");
			list.add(d);
		}
		{
			Disciplina d = new Disciplina();
			d.setIdDisciplina(2L);
			d.setSigla("MAC442");
			d.setNome("Sistemas Operacionais");
			d.setEmenta("Mexer com o kernel de um SO ai, materia marota.");
			list.add(d);
		}
		when(dao.list()).thenReturn(list);
		when(dao.getDisciplina(1L)).thenReturn(list.get(0));
		when(dao.getDisciplina(2L)).thenReturn(list.get(1));
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
		verify(result).include("disciplinas", list);
	}

	@Test
	public void testCria() {
		Disciplina d = list.get(0);
		controller.cria(d);
		verify(dao).save(d);
	}

	@Test
	public void testVisualiza() {
		Disciplina d = list.get(0);
		controller.visualiza(d.getIdDisciplina());
		verify(result).include("disciplina", d);
	}

	@Test
	public void testAltera() {
		Disciplina d = list.get(0);
		controller.altera(d);
		verify(dao).update(d);
	}

	@Test
	public void testRemove() {
		Disciplina d = list.get(0);
		controller.remove(d.getIdDisciplina());
		verify(dao).delete(d);
	}

}
