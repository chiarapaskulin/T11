package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.UsuarioBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Usuario;
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
        usuarioBO = new UsuarioBO();
        boolean value = usuarioBO.createUser(usuario);
    }

    @After
    public void afterEachTestMethod() {
        usuario = null;
        usuarioBO = null;
    }

    @Test
    public void test_cause_effect_graph() {


    }

    @Test
    public void test_to_String_valido() {

        Assert.assertEquals("Atributo Cálcio ID: 0 unidade: g multiplicador: 1 obrigatório:true status:true", usuario.toString());
    }

    @Test (expected = ValidationException.class)
    public void test_get_by_id() throws ValidationException {
        Usuario atb = usuarioBO.getUserById(-1);
    }
}
