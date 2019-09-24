package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.model.Atributo;
import br.com.gastronomia.bo.AtributoBO;
import br.com.gastronomia.exception.ValidationException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class Atributo_JUnit {

    Atributo atributo;
    AtributoBO atributoBO;

    @Before
    public void beforeEachTestMethod() throws ValidationException {
        atributo = new Atributo("Cálcio", 1);
        atributo.setObrigatorio(true);
        atributo.setOrdem(1L);
        atributo.setStatus(true);
        atributo.setValorDiario(100);

        atributoBO = new AtributoBO();
        try {
            boolean value = atributoBO.createAtributo(atributo);
        } catch (Exception e) {
            throw new ValidationException("AtributoBO não inicializado...");
        }
    }

    @After
    public void afterEachTestMethod() {
        atributo = null;
        atributoBO = null;
    }

    @Test
    public void test_to_String_valido() {

        Assert.assertEquals("Atributo Cálcio ID: 0 unidade: g multiplicador: 1 obrigatório:true status:true", atributo.toString());
    }

    @Test (expected = ValidationException.class)
    public void test_get_by_id() throws ValidationException {
        Atributo atb = atributoBO.getAtributoById(-1);
    }
}
