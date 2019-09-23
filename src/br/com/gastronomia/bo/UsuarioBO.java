package br.com.gastronomia.bo;

import br.com.gastronomia.dao.UsuarioDAO;
import br.com.gastronomia.dto.UsuarioLoginDTO;
import br.com.gastronomia.exception.UsuarioInativoException;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Usuario;
import br.com.gastronomia.util.*;
//import org.hibernate.exception.ConstraintViolationException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

public class UsuarioBO {
	
	//private UsuarioDAO usuarioDAO;

	//MOCK PARA VER E VAL
	ArrayList<Usuario> usuarios;

	public UsuarioBO() {
		//usuarioDAO = new UsuarioDAO();
		usuarios = new ArrayList<>();
	}

/*	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}*/

	public boolean validateCPF(Usuario usuario) throws ValidationException {
		if (Validator.validaCpf.fazConta(usuario.getCpf()))
			return true;
		throw new ValidationException("Usuário Inválido");
	}

	public boolean createUser(Usuario usuario) throws NoSuchAlgorithmException, ValidationException {
		if (usuario != null || !usuario.getSenha().isEmpty()) {
			String encryptedPassword = EncryptUtil.encrypt2(usuario.getSenha());
			usuario.setSenha(encryptedPassword);

			//SendMail sendMail = new SendMail();
			//String subject = "Confirmação de email";
//			String body = "localhost:8080/auth/" + EncryptUtil.encrypt2(String.valueOf(usuario.getMatricula()));
			//String body = "Bem Vindo ao NUTRITECH. Acesse  o link http://www.homo.ages.pucrs.br/nutritech/ para começar";
			//sendMail.envio(usuario.getEmail(), usuario.getNome(), subject, body);

			try {
				//usuarioDAO.save(usuario);
				usuarios.add(usuario);
			}
/*			catch (ConstraintViolationException e) {
				switch (e.getConstraintName()) {
					case "cpf_uc":
						throw new ValidationException("CPF inserido já cadastrado");
					case "email_uc":
						throw new ValidationException("Email inserido já cadastrado");
					case "matricula_uc":
						throw new ValidationException("Matricula inserida já cadastrada");
				}
			}*/
			catch (Exception e) {
				throw new ValidationException(e.getMessage());
			}
		}
		return true;
	}

/*	public void esqueceuSenha(String email, String nome, long id){
		String hash = email + System.nanoTime();

		SendMail sendMail = new SendMail();
		String subject = "NUTRITECH - Redefinir senha";
		String body = "Acesse  o link para redefinir sua senha: http://www.homo.ages.pucrs.br/nutritech/#/usuario/"+id;
		sendMail.envio(email,"",  subject, body);
	}*/

/*	public long deactivateUser(long id) throws ValidationException {
		return usuarioDAO.alterStatus(id, false);
	}

	public long activateUser(long id) throws ValidationException {
		return usuarioDAO.alterStatus(id, true);
	}

	public long updateUser(Usuario usuario) throws ValidationException, NoSuchAlgorithmException {
		if (usuario != null) {
			String encryptedPassword = null;
			if (usuario.getSenha().isEmpty()) {
				encryptedPassword = usuarioDAO.findUserByID(usuario.getId()).getSenha();
			} else {
				encryptedPassword = EncryptUtil.encrypt2(usuario.getSenha());
			}
			usuario.setSenha(encryptedPassword);
			return usuarioDAO.updateUser(usuario);
		}
		throw new ValidationException("invalido");

	}*/
/*
	public Usuario validate(Usuario newUsuario) {
		return newUsuario;
	}*/

/*	public Usuario userExists(UsuarioLoginDTO usuarioLogin) throws NoSuchAlgorithmException, ValidationException, UsuarioInativoException {
		usuarioLogin.setSenha(EncryptUtil.encrypt2(usuarioLogin.getSenha()));
		Usuario returnedUsuario = null;
		try {
			returnedUsuario = usuarioDAO.findUserByEmail(usuarioLogin.getEmail());
		} catch(Exception e) {
			throw new ValidationException(MensagemContantes.MSG_ERR_USUARIO_SENHA_INVALIDOS);
		}
		if (!usuarioLogin.getSenha().equals(returnedUsuario.getSenha()))
			throw new ValidationException(MensagemContantes.MSG_ERR_USUARIO_SENHA_INVALIDOS);
		if (!returnedUsuario.isStatus())
			throw new UsuarioInativoException("Usuário Inativo");
		return returnedUsuario;
	}*/

	public ArrayList<Usuario>/*HashMap<String, List<Usuario>>*/ listUser() {
//		ArrayList<Usuario> usuarios = null;
//		HashMap<String, List<Usuario>> listUsers = new HashMap<String, List<Usuario>>();
//		usuarios = (ArrayList<Usuario>) usuarioDAO.listAll(Usuario.class);
//		listUsers.put("Usuarios", usuarios);
//		return listUsers;
		if(usuarios.isEmpty()) throw new EmptyStackException();
		return usuarios;
	}

	public ArrayList<Usuario> /*HashMap<String, List<Usuario>>*/ listProf() {
//		ArrayList<Usuario> usuarios = null;
//		HashMap<String, List<Usuario>> listUsers = new HashMap<String, List<Usuario>>();
//		usuarios = (ArrayList<Usuario>) usuarioDAO.listUsersByType(TipoDeUsuario.PROFESSOR);
//		listUsers.put("Usuarios", usuarios);
//		return listUsers;

		if(usuarios.isEmpty()) throw new EmptyStackException();
		ArrayList<Usuario> professores = new ArrayList<>();
		for(int i=0; i<usuarios.size(); i++){
			if(usuarios.get(i).getTipo() == TipoDeUsuario.PROFESSOR){
				professores.get(i);
			}
		}
		if(professores.isEmpty()) throw new EmptyStackException();
		return professores;
	}

	public ArrayList<Usuario> /*HashMap<String, List<Usuario>>*/ listAlunos() {
//		ArrayList<Usuario> usuarios = null;
//		HashMap<String, List<Usuario>> listUsers = new HashMap<String, List<Usuario>>();
//		usuarios = (ArrayList<Usuario>) usuarioDAO.listUsersByType(TipoDeUsuario.USUARIO);
//		listUsers.put("Usuarios", usuarios);
//		return listUsers;

		if(usuarios.isEmpty()) throw new EmptyStackException();
		ArrayList<Usuario> alunos = new ArrayList<>();
		for(int i=0; i<usuarios.size(); i++){
			if(usuarios.get(i).getTipo() == TipoDeUsuario.USUARIO){
				alunos.get(i);
			}
		}
		if(alunos.isEmpty()) throw new EmptyStackException();
		return alunos;
	}


	public Usuario getUserByCpf(Usuario usuarioLogin) throws ValidationException {
		if (usuarioLogin != null) {
			//return usuarioDAO.findUserByCPF(usuarioLogin.getCpf());
			if(usuarios.isEmpty()) throw new EmptyStackException();
			for(int i=0; i<usuarios.size(); i++){
				if(usuarios.get(i).getCpf() == usuarioLogin.getCpf()){
					return usuarios.get(i);
				}
			}
			throw new ValidationException("Não existe Usuário com esse CPF");
		}
		throw new ValidationException("CPF Invalido");
	}
	
	public Usuario getUserByEmail(Usuario usuarioLogin) throws ValidationException {
		if (usuarioLogin != null) {
			//return usuarioDAO.findUserByEmail(usuarioLogin.getEmail());
			if(usuarios.isEmpty()) throw new EmptyStackException();
			for(int i=0; i<usuarios.size(); i++){
				if(usuarios.get(i).getEmail() == usuarioLogin.getEmail()){
					return usuarios.get(i);
				}
			}
			throw new ValidationException("Não existe Usuário com esse e-mail");
		}
		throw new ValidationException("E-mail Inválido");
	}
	
	public Usuario getUserByMatricula(Usuario usuarioLogin) throws ValidationException {
		if (usuarioLogin != null) {
			//return usuarioDAO.findUserByMatricula(usuarioLogin.getMatricula());
			if(usuarios.isEmpty()) throw new EmptyStackException();
			for(int i=0; i<usuarios.size(); i++){
				if(usuarios.get(i).getMatricula() == usuarioLogin.getMatricula()){
					return usuarios.get(i);
				}
			}
			throw new ValidationException("Não existe Usuário com essa matrícula");
		}
		throw new ValidationException("Matrícula Inválida");
	}
	
	public Usuario getUserById(long id) throws ValidationException {
		if (id > 0) {
			/*Usuario usuario = usuarioDAO.findUserByID(id);
			usuario.setSenha("");
			return usuario;*/
			for(Usuario user : usuarios){
				if(user.getId() == id) return user;
			}
			throw new ValidationException("ID Inválido");
		}
		throw new ValidationException("ID Inválido");

	}

}
