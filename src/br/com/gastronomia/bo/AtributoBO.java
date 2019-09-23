package br.com.gastronomia.bo;

import br.com.gastronomia.dao.AtributoDAO;
import br.com.gastronomia.dao.ReceitaDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Atributo;
import br.com.gastronomia.model.IngredienteAtributo;
import br.com.gastronomia.model.Receita;
import br.com.gastronomia.model.ReceitaIngrediente;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

//branch demo
public class AtributoBO {
	//private AtributoDAO atributoDAO;

	//MOCK PARA VER E VAL
	ArrayList<Atributo> atributos;

	public AtributoBO() {
		//atributoDAO = new AtributoDAO();
		atributos = new ArrayList<>();
	}

//	public void setAtributoDAO(AtributoDAO atributoDAO) {
//		this.atributoDAO = atributoDAO;
//	}

	public boolean createAtributo(Atributo atributo) throws ValidationException, NoSuchAlgorithmException {
		if (atributo != null) {
			try {
				//atributo.setStatus(true);
				atributos.add(atributo);
				//atributoDAO.save(atributo);
				return true;
			} catch (Exception e) {
				throw new ValidationException("Atributo já existente.");
			}
		}
		throw new ValidationException("invalido");

	}

//	public long inactiveAtributo(long id) throws ValidationException {
//		ReceitaDAO receitaDAO = new ReceitaDAO();
//		List<Receita> receitas = receitaDAO.listAllReceitas();
//
//		for (Receita receita : receitas) {
//			for(ReceitaIngrediente receitaIngrediente : receita.getReceitaIngrediente()) {
//				for(IngredienteAtributo ingredienteAtributo : receitaIngrediente.getIngrediente().getIngredienteAtributo()) {
//					if(ingredienteAtributo.getAtributo().getId() == id) {
//						throw new ValidationException("Atributo vínculado à uma receita.");
//					}
//				}
//			}
//		}
//
//		return atributoDAO.alterStatus(id, false);
//	}

//	public long activateUser(long id) throws ValidationException {
//		return atributoDAO.alterStatus(id, true);
//	}

//	public long updateAtributo(Atributo atributo) throws ValidationException {
//		if (atributo != null) {
//			atributo.setStatus(true);
//			return atributoDAO.updateAtributo(atributo);
//		}
//		throw new ValidationException("invalido");
//
//	}
	
//	//Mantive este m�todo, mas n�o vejo qual a utilidade dele
//	public Atributo validate(Atributo newAtributo) {
//		return newAtributo;
//	}

	public ArrayList<Atributo>/*HashMap<String, List<Atributo>>*/ listAtributos() {
//		ArrayList<Atributo> atributos = null;
//		HashMap<String, List<Atributo>> listAtributos = new HashMap<String, List<Atributo>>();
//		atributos = (ArrayList<Atributo>) atributoDAO.listAllOrder(Atributo.class, "Ordem");
//		listAtributos.put("Atributos", atributos);
		if(atributos.isEmpty()) throw new EmptyStackException();
		return atributos;
	}

//	public HashMap<String, List<Atributo>> listActivesAtributos() {
//		ArrayList<Atributo> atributos = null;
//		HashMap<String, List<Atributo>> listAtributos = new HashMap<String, List<Atributo>>();
//		atributos = (ArrayList<Atributo>) atributoDAO.findMultipleObjects("status", Atributo.class,	true);
//
//
//		listAtributos.put("Atributos", atributos);
//		return listAtributos;
//	}

	public Atributo getAtributoById(long id) throws ValidationException {
		if (id!= 0) {
			for(Atributo atb : atributos){
				if(atb.getId() == id) return atb;
			}
			throw new ValidationException("ID Inválido");
		}
		throw new ValidationException("ID Inválido");
	}

}
