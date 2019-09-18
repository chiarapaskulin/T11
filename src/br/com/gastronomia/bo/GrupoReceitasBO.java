package br.com.gastronomia.bo;

import br.com.gastronomia.dao.GrupoReceitasDAO;
import br.com.gastronomia.dao.ReceitaDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.GrupoReceitas;
import br.com.gastronomia.model.Receita;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

public class GrupoReceitasBO {
	//private GrupoReceitasDAO grupoReceitasDAO;

	//MOCK PARA VER E VAL
	ArrayList<GrupoReceitas> grupoReceitas;

	public GrupoReceitasBO() {
		//grupoReceitasDAO = new GrupoReceitasDAO();
		grupoReceitas = new ArrayList<>();
	}

//	public void setGrupoReceitasDAO(GrupoReceitasDAO grupoReceitasDAO) {
//		this.grupoReceitasDAO = grupoReceitasDAO;
//	}

	public boolean createGroup(GrupoReceitas grupo) throws ValidationException, NoSuchAlgorithmException {
		if (grupo != null) {
			try {
				//grupo.setStatus(true);
				//grupoReceitasDAO.save(grupo);
				grupoReceitas.add(grupo);
				return true;
			} catch (Exception e) {
				throw new ValidationException("Grupo já existente.");
			}
		}
		throw new ValidationException("invalido");

	}

//	public long deactivateGroup(long id) throws ValidationException  {
//
//		ReceitaDAO receitaDAO = new ReceitaDAO();
//		List<Receita> receitas = receitaDAO.listAllReceitas();
//
//		for (Receita receita : receitas) {
//			if(receita.getGrupoReceita().getId() == id) {
//				throw new ValidationException("Grupo vínculado à uma receita.");
//			}
//		}
//
//		return grupoReceitasDAO.alterStatus(id, false);
//	}

//	public long activateGroup(long id) throws ValidationException  {
//		return grupoReceitasDAO.alterStatus(id, true);
//	}

//	public long updateGroup(GrupoReceitas grupoReceitas) throws ValidationException {
//		if (grupoReceitas != null) {
//			grupoReceitas.setStatus(true);
//			return grupoReceitasDAO.updateGroup(grupoReceitas);
//		}
//		throw new ValidationException("invalido");
//
//	}

//	public GrupoReceitas validate(GrupoReceitas grupoReceitas) {
//		return grupoReceitas;
//	}

	public ArrayList<GrupoReceitas> /*HashMap<String, List<GrupoReceitas>>*/ listGroups() {
//		ArrayList<GrupoReceitas> grupoReceitas = null;
//		HashMap<String, List<GrupoReceitas>> listGrupoReceitas = new HashMap<String, List<GrupoReceitas>>();
//		grupoReceitas = (ArrayList<GrupoReceitas>) grupoReceitasDAO.listAll(GrupoReceitas.class);
//		listGrupoReceitas.put("Grupos", grupoReceitas);
//		return listGrupoReceitas;
		if(grupoReceitas.isEmpty()) throw new EmptyStackException();
		return grupoReceitas;
	}

//	public HashMap<String, List<GrupoReceitas>> listGroupsActived() {
//
//		HashMap<String, List<GrupoReceitas>> listGrupoReceitas = new HashMap<String, List<GrupoReceitas>>();
//		List<GrupoReceitas> grupoReceitas = grupoReceitasDAO.findMultipleObjects("status", GrupoReceitas.class,true);
//		listGrupoReceitas.put("Grupos", grupoReceitas);
//		return listGrupoReceitas;
//	}

	public GrupoReceitas getGroupByCod(/*long id*/int index) throws ValidationException {
		if (index != 0) {
			//return grupoReceitasDAO.findGroupByID(id);
			GrupoReceitas gReceitas = grupoReceitas.get(index);
			if(gReceitas==null) throw new ValidationException("Index Inválido");
			return gReceitas;
		}
		throw new ValidationException("Index Inválido");
	}
}
