package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.dietoterapia.AtendimentoNutricionalBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Usuario;
import br.com.gastronomia.model.dietoterapia.AtendimentoNutricional;
import br.com.gastronomia.model.dietoterapia.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class AtendimentoNutricional_JUnit {

    @org.junit.Test
    public void testeValido1() throws Exception{
        AtendimentoNutricional an = new AtendimentoNutricional();
        an.setPaciente(new Paciente());
        an.setAluno(new Usuario());
        an.setProfessor(new Usuario());
        Date d = new Date(2018,12,11);
        an.setData(d);
        an.setStatus(true);
        an.setId(74839);

        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.criarAtendimento(an);

        assertEquals(anbo.getById(74839), an);
    }

    @org.junit.Test
    public void testeValido2() throws Exception{
        AtendimentoNutricional an1 = new AtendimentoNutricional();
        an1.setPaciente(new Paciente());
        an1.setAluno(new Usuario());
        an1.setProfessor(new Usuario());
        Date d1 = new Date(2019,9,19);
        an1.setData(d1);
        an1.setStatus(true);
        an1.setId(76952);

        AtendimentoNutricional an2 = new AtendimentoNutricional();
        an2.setPaciente(new Paciente());
        an2.setAluno(new Usuario());
        an2.setProfessor(new Usuario());
        Date d2 = new Date(2018,7,24);
        an2.setData(d2);
        an2.setStatus(true);
        an2.setId(82247);

        AtendimentoNutricional an3 = new AtendimentoNutricional();
        an3.setPaciente(new Paciente());
        an3.setAluno(new Usuario());
        an3.setProfessor(new Usuario());
        Date d3 = new Date(2018,1,14);
        an3.setData(d3);
        an3.setStatus(true);
        an3.setId(95204);

        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.criarAtendimento(an1);
        anbo.criarAtendimento(an2);
        anbo.criarAtendimento(an3);

        assertEquals(anbo.getById(82247), an2);
    }

    @org.junit.Test
    public void testeValido3() throws Exception{
        ArrayList<AtendimentoNutricional> lista = new ArrayList<>();

        AtendimentoNutricional an1 = new AtendimentoNutricional();
        an1.setPaciente(new Paciente());
        an1.setAluno(new Usuario());
        an1.setProfessor(new Usuario());
        Date d1 = new Date(2018,11,30);
        an1.setData(d1);
        an1.setStatus(true);
        an1.setId(60852);
        lista.add(an1);

        AtendimentoNutricional an2 = new AtendimentoNutricional();
        an2.setPaciente(new Paciente());
        an2.setAluno(new Usuario());
        an2.setProfessor(new Usuario());
        Date d2 = new Date(2019,4,1);
        an2.setData(d2);
        an2.setStatus(true);
        an2.setId(96731);
        lista.add(an2);

        AtendimentoNutricional an3 = new AtendimentoNutricional();
        an3.setPaciente(new Paciente());
        an3.setAluno(new Usuario());
        an3.setProfessor(new Usuario());
        Date d3 = new Date(2018,6,2);
        an3.setData(d3);
        an3.setStatus(true);
        an3.setId(65721);
        lista.add(an3);

        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.criarAtendimento(an1);
        anbo.criarAtendimento(an2);
        anbo.criarAtendimento(an3);

        assertEquals(anbo.list(), lista);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido1() throws Exception{
        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.criarAtendimento(null);
    }


    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido2() throws Exception{
        AtendimentoNutricional an1 = new AtendimentoNutricional();
        an1.setPaciente(new Paciente());
        an1.setAluno(new Usuario());
        an1.setProfessor(new Usuario());
        Date d1 = new Date(2018,2,22);
        an1.setData(d1);
        an1.setStatus(true);
        an1.setId(51247);

        AtendimentoNutricional an2 = new AtendimentoNutricional();
        an2.setPaciente(new Paciente());
        an2.setAluno(new Usuario());
        an2.setProfessor(new Usuario());
        Date d2 = new Date(2017,4,23);
        an2.setData(d2);
        an2.setStatus(true);
        an2.setId(42965);

        AtendimentoNutricional an3 = new AtendimentoNutricional();
        an3.setPaciente(new Paciente());
        an3.setAluno(new Usuario());
        an3.setProfessor(new Usuario());
        Date d3 = new Date(2019,6,24);
        an3.setData(d3);
        an3.setStatus(true);
        an3.setId(15206);

        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.criarAtendimento(an1);
        anbo.criarAtendimento(an2);
        anbo.criarAtendimento(an3);

        anbo.getById(1);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido3() throws Exception{
        AtendimentoNutricional an1 = new AtendimentoNutricional();
        an1.setPaciente(new Paciente());
        an1.setAluno(new Usuario());
        an1.setProfessor(new Usuario());
        Date d1 = new Date(2019,5,4);
        an1.setData(d1);
        an1.setStatus(true);
        an1.setId(60923);

        AtendimentoNutricional an2 = new AtendimentoNutricional();
        an2.setPaciente(new Paciente());
        an2.setAluno(new Usuario());
        an2.setProfessor(new Usuario());
        Date d2 = new Date(2019,8,21);
        an2.setData(d2);
        an2.setStatus(true);
        an2.setId(32058);

        AtendimentoNutricional an3 = new AtendimentoNutricional();
        an3.setPaciente(new Paciente());
        an3.setAluno(new Usuario());
        an3.setProfessor(new Usuario());
        Date d3 = new Date(2019,5,24);
        an3.setData(d3);
        an3.setStatus(true);
        an3.setId(74605);

        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.criarAtendimento(an1);
        anbo.criarAtendimento(an2);
        anbo.criarAtendimento(an3);

        anbo.getById(-1);
    }

    @org.junit.Test (expected = EmptyStackException.class)
    public void testeInvalido4() throws Exception{
        AtendimentoNutricionalBO anbo = new AtendimentoNutricionalBO();
        anbo.list();
    }
}
