/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sigp.src.controllers;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import sigp.src.Grupo;
import sigp.src.dao.GrupoDao;
import java.util.List;

@Resource
public class GrupoController {
	private final Result result;
	private final GrupoDao dao;

	public GrupoController(Result result, GrupoDao dao) {
		this.result = result;
		this.dao = dao;
	}

	@Path("/grupo/")
	public void index() {
		List<Grupo> l = dao.getList();
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i));
		result.include("grupos", l);
	}

	@Path("/grupo/novo")
	public void form_novo() {
	}
	
	@Path("/grupo/cria")
	public void save(final Grupo grupo) {
		dao.add(grupo);
		result.redirectTo(GrupoController.class).index();
	}
	
	
	@Path("/grupo/ver/{idGrupo}")
	public void visualiza(Long idGrupo) {
		Grupo grupo = dao.getGrupo(idGrupo);
		if(grupo == null)
			result.redirectTo(GrupoController.class).index();
		else
			result.include("grupo", grupo);
	}

}
