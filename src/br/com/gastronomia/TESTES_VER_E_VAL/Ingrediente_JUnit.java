package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.IngredienteBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Ingrediente;
import br.com.gastronomia.model.Usuario;
import br.com.gastronomia.util.TipoDeIngrediente;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class Ingrediente_JUnit {

    @org.junit.Test
    public void testeValido1() throws Exception {
        Ingrediente i = new Ingrediente();
        i.setId(5501);

        IngredienteBO ibo = new IngredienteBO();
        ibo.createIngrediente(i);

        assertEquals(ibo.getIngredienteById(5501), i);
    }

    @org.junit.Test
    public void testeValido2() {
        Ingrediente i = new Ingrediente();
        i.setId(5501);

        IngredienteBO ibo = new IngredienteBO();

        assertTrue(ibo.createIngrediente(i));
    }

    @org.junit.Test
    public void testeValido3() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();

        Ingrediente i = new Ingrediente();
        i.setId(5501);
        i.setNome("Alface");
        i.setCriador(new Usuario());
        i.setAlergenico("Nenhum");
        i.setTipo(TipoDeIngrediente.COMUM);
        ingredientes.add(i);

        Ingrediente i2 = new Ingrediente();
        i2.setId(5502);
        i2.setNome("Abóbora");
        i2.setCriador(new Usuario());
        i2.setAlergenico("Nenhum");
        i2.setTipo(TipoDeIngrediente.COMUM);
        ingredientes.add(i2);

        IngredienteBO ibo = new IngredienteBO();

        ibo.createIngrediente(i);
        ibo.createIngrediente(i2);

        assertEquals(ingredientes, ibo.listIngrediente());
    }

    @org.junit.Test
    public void testeInvalido1() {

        IngredienteBO ibo = new IngredienteBO();

        assertFalse(ibo.createIngrediente(null));
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido2() throws Exception {
        Ingrediente i = new Ingrediente();
        i.setId(5501);

        Ingrediente i2 = new Ingrediente();
        i.setId(5502);

        Ingrediente i3 = new Ingrediente();
        i.setId(5503);

        IngredienteBO ibo = new IngredienteBO();
        ibo.createIngrediente(i);
        ibo.createIngrediente(i2);
        ibo.createIngrediente(i3);

        ibo.getIngredienteById(5504);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido3() throws Exception {
        Ingrediente i = new Ingrediente();
        i.setId(5501);

        Ingrediente i2 = new Ingrediente();
        i.setId(5502);

        Ingrediente i3 = new Ingrediente();
        i.setId(5503);

        IngredienteBO ibo = new IngredienteBO();
        ibo.createIngrediente(i);
        ibo.createIngrediente(i2);
        ibo.createIngrediente(i3);

        ibo.getIngredienteById(-1);
    }

    @org.junit.Test (expected = EmptyStackException.class)
    public void testeInvalido4() {
        IngredienteBO ibo = new IngredienteBO();
        ibo.listIngrediente();
    }
}
