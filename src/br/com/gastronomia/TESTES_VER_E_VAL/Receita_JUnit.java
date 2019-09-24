package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.ReceitaBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Receita;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class Receita_JUnit {

    @org.junit.Test
    public void testeValido1() throws Exception {
        Receita r = new Receita();
        r.setId(9090);

        ReceitaBO rbo = new ReceitaBO();
        assertTrue(rbo.createReceita(r));

    }

    @org.junit.Test
    public void testeValido2() throws Exception {
        ArrayList<Receita> receitas = new ArrayList<>();

        Receita r1 = new Receita();
        r1.setId(9090);

        Receita r2 = new Receita();
        r1.setId(8090);

        Receita r3 = new Receita();
        r1.setId(9095);

        receitas.add(r1);
        receitas.add(r2);
        receitas.add(r3);

        ReceitaBO rbo = new ReceitaBO();

        rbo.createReceita(r1);
        rbo.createReceita(r2);
        rbo.createReceita(r3);

        assertEquals(receitas, rbo.listReceita());
    }

    @org.junit.Test
    public void testeValido3() throws Exception {
        Receita r1 = new Receita();
        r1.setId(9090);

        ReceitaBO rbo = new ReceitaBO();
        rbo.createReceita(r1);

        assertEquals(rbo.getReceitaById(9090), r1);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido1() throws Exception {

        ReceitaBO rbo = new ReceitaBO();
        rbo.createReceita(null);
    }

    @org.junit.Test (expected = EmptyStackException.class)
    public void testeInvalido2() {
        ReceitaBO rbo = new ReceitaBO();
        rbo.listReceita();
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido3() throws Exception {
        Receita r = new Receita();
        r.setId(5501);

        Receita r2 = new Receita();
        r2.setId(5502);

        Receita r3 = new Receita();
        r3.setId(5503);

        ReceitaBO rbo = new ReceitaBO();
        rbo.createReceita(r);
        rbo.createReceita(r2);
        rbo.createReceita(r3);

        rbo.getReceitaById(5504);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido4() throws Exception {
        Receita r = new Receita();
        r.setId(5501);

        Receita r2 = new Receita();
        r2.setId(5502);

        Receita r3 = new Receita();
        r3.setId(5503);

        ReceitaBO rbo = new ReceitaBO();
        rbo.createReceita(r);
        rbo.createReceita(r2);
        rbo.createReceita(r3);

        rbo.getReceitaById(-1);
    }

}
