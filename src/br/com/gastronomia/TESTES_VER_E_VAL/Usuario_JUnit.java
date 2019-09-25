package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.UsuarioBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Usuario;
import br.com.gastronomia.util.TipoDeUsuario;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import java.security.NoSuchAlgorithmException;

public class Usuario_JUnit {

    Usuario usuario;
    UsuarioBO usuarioBO;

    @Before
    public void beforeEachTestMethod() throws ValidationException, NoSuchAlgorithmException {
        usuario = new Usuario("000.000.000-00", "Fulano da Silva Sauro");
        usuario.setEmail("user@user.com");
        usuario.setMatricula("123456");
        usuario.setStatus(true);
        usuario.setTipo(TipoDeUsuario.USUARIO);
        usuarioBO = new UsuarioBO();
        boolean value = usuarioBO.createUser(usuario);
    }

    @After
    public void afterEachTestMethod() {
        usuario = null;
        usuarioBO = null;
    }

    @Test
    public void test_user_creation() throws ValidationException, NoSuchAlgorithmException {
        Assert.assertTrue(usuarioBO.createUser(usuario));
    }

    @Test
    public void test_get_by_id() throws ValidationException {
        Usuario user = usuarioBO.getUserById(0);
        Assert.assertSame(usuario, user);
    }

    @Test
    public void test_get_by_cpf() throws ValidationException {
        Usuario user = usuarioBO.getUserByCpf(usuario);
        Assert.assertSame(usuario, user);

    }

    @Test
    public void test_get_by_matricula() throws ValidationException {
        Usuario user = usuarioBO.getUserByMatricula(usuario);
        Assert.assertSame(usuario, user);

    }

    @Test
    public void test_get_by_email() throws ValidationException {
        Usuario user = usuarioBO.getUserByEmail(usuario);
        Assert.assertSame(usuario, user);

    }

    @Test (expected = ValidationException.class)
    public void test_invalid_get_by_id() throws ValidationException {
        Usuario atb = usuarioBO.getUserById(-1);
    }

    @Test (expected = ValidationException.class)
    public void test_invalid_get_by_cpf() throws ValidationException {
        Usuario atb = usuarioBO.getUserByCpf(null);
    }

    @Test (expected = ValidationException.class)
    public void test_invalid_get_by_matricula() throws ValidationException {
        Usuario atb = usuarioBO.getUserByMatricula(null);
    }

    @Test (expected = ValidationException.class)
    public void test_invalid_get_by_email() throws ValidationException {
        Usuario atb = usuarioBO.getUserByEmail(null);
    }
}
