package br.com.gastronomia.bo;

import br.com.gastronomia.dao.AtributoDAO;
import br.com.gastronomia.dao.IngredienteDAO;
import br.com.gastronomia.dao.ReceitaDAO;
import br.com.gastronomia.dao.UsuarioDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Ingrediente;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

public class IngredienteBO {
	/*private IngredienteDAO ingredienteDAO;
	private UsuarioDAO usuarioDAO;
	private AtributoDAO atributoDAO;
	private ReceitaDAO receitaDAO;*/

	//MOCK PARA VER E VAL
	ArrayList<Ingrediente> ingredientes;

	public IngredienteBO() {
		/*ingredienteDAO = new IngredienteDAO();
		usuarioDAO = new UsuarioDAO();
		atributoDAO = new AtributoDAO();
		receitaDAO = new ReceitaDAO();*/
		ingredientes = new ArrayList<>();
	}


//	public long inactiveIngrediente(long id) throws ValidationException  {
//		if (id > 0){
//			List<Ingrediente> ingredientes = ingredienteDAO.findReceitaIngredienteByIdIngrediente(id);
//			if (ingredientes.size() > 0)
//				throw new ValidationException("Ingrediente não pode ser excluído, pois está vinculado a uma ou mais receitas.");
//		}
//		return ingredienteDAO.alterStatus(id, false);
//	}
//
//	public long activateIngrediente(long id) throws ValidationException  {
//		return ingredienteDAO.alterStatus(id, true);
//	}
//
//	public long updateIngrediente(Ingrediente ingrediente) throws ValidationException {
//		if (ingrediente != null) {
//			return ingredienteDAO.updateIngrediente(ingrediente);
//		}
//		throw new ValidationException("invalido");
//
//	}

	public boolean createIngrediente(Ingrediente ingrediente) throws NullPointerException {
		if (ingrediente != null) {
			try {
				//ingredienteDAO.save(ingrediente);
				ingredientes.add(ingrediente);
				return true;
			} catch (NullPointerException e) {
				throw new NullPointerException("Erro no cadastro.");
			}
		}
		return false;
	}


	public ArrayList<Ingrediente> /*HashMap<String, List<Ingrediente>>*/ listIngrediente() {
//		ArrayList<Ingrediente> ingredientes = null;
//		HashMap<String, List<Ingrediente>> listIngredientes = new HashMap<String, List<Ingrediente>>();
//		ingredientes = (ArrayList<Ingrediente>) ingredienteDAO.listAllIngredientes();
//		listIngredientes.put("Ingredientes", ingredientes);
//		return listIngredientes;

		if(ingredientes.isEmpty()) throw new EmptyStackException();
		return ingredientes;
	}

	public Ingrediente getIngredienteById(/*long id*/int index) throws ValidationException {
		if (index > 0) {
			//return ingredienteDAO.findIngredienteById(id);
			Ingrediente ing = ingredientes.get(index);
			if(ing==null) throw new ValidationException("Index Inválido");
			return ing;
		}
		throw new ValidationException("Index inválido");

	}

}
