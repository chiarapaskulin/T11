package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.GrupoReceitasBO;
import br.com.gastronomia.model.GrupoReceitas;
import br.com.gastronomia.exception.ValidationException;

import java.util.ArrayList;
import java.util.EmptyStackException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GrupoReceitas_JUnit {

    @org.junit.Test
    public void testeValido1() throws Exception {
        GrupoReceitas g = new GrupoReceitas();
        g.setId(9090);

        GrupoReceitasBO gbo = new GrupoReceitasBO();
        assertTrue(gbo.createGroup(g));

    }

    @org.junit.Test
    public void testeValido2() throws Exception {
        ArrayList<GrupoReceitas> grupo = new ArrayList<>();

        GrupoReceitas g1 = new GrupoReceitas();
        g1.setId(1234);

        GrupoReceitas g2 = new GrupoReceitas();
        g2.setId(1255);

        GrupoReceitas g3 = new GrupoReceitas();
        g3.setId(3030);

        grupo.add(g1);
        grupo.add(g2);
        grupo.add(g3);

        GrupoReceitasBO gbo = new GrupoReceitasBO();

        gbo.createGroup(g1);
        gbo.createGroup(g2);
        gbo.createGroup(g3);

        assertEquals(grupo, gbo.listGroups());
    }

    @org.junit.Test
    public void testeValido3() throws Exception {
        GrupoReceitas g = new GrupoReceitas();
        g.setId(9090);

        GrupoReceitasBO gbo = new GrupoReceitasBO();
        gbo.createGroup(g);

        assertEquals(gbo.getGroupByCod(9090), g);

    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido1() throws Exception {
        GrupoReceitasBO gbo = new GrupoReceitasBO();
        gbo.createGroup(null);
    }

    @org.junit.Test (expected = EmptyStackException.class)
    public void testeInvalido2() throws Exception {
        GrupoReceitasBO gbo = new GrupoReceitasBO();
        gbo.listGroups();
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido3() throws Exception {
        GrupoReceitas g1 = new GrupoReceitas();
        g1.setId(2);

        GrupoReceitas g2 = new GrupoReceitas();
        g2.setId(3);

        GrupoReceitas g3 = new GrupoReceitas();
        g3.setId(4);


        GrupoReceitasBO gbo = new GrupoReceitasBO();
        gbo.createGroup(g1);
        gbo.createGroup(g2);
        gbo.createGroup(g3);

        gbo.getGroupByCod(1);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido4() throws Exception {
        GrupoReceitas g1 = new GrupoReceitas();
        g1.setId(2);

        GrupoReceitas g2 = new GrupoReceitas();
        g2.setId(3);

        GrupoReceitas g3 = new GrupoReceitas();
        g3.setId(4);


        GrupoReceitasBO gbo = new GrupoReceitasBO();
        gbo.createGroup(g1);
        gbo.createGroup(g2);
        gbo.createGroup(g3);

        gbo.getGroupByCod(-1);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido5() throws Exception {
        GrupoReceitas g1 = new GrupoReceitas();
        g1.setId(2);

        GrupoReceitas g2 = new GrupoReceitas();
        g2.setId(3);

        GrupoReceitas g3 = new GrupoReceitas();
        g3.setId(4);


        GrupoReceitasBO gbo = new GrupoReceitasBO();
        gbo.createGroup(g1);
        gbo.createGroup(g2);
        gbo.createGroup(g3);

        gbo.getGroupByCod(0);
    }

}
