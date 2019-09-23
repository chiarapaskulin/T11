package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.dietoterapia.PacienteBO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.dietoterapia.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class Paciente_JUnit {

    @org.junit.Test
    public void testeValido1() throws Exception{
        Paciente p = new Paciente();
        p.setId(81920);
        p.setNome("Leonardo");
        p.setSexo('M');
        p.setRestricaoAlimentar("Ovovegetariano");
        Date d = new Date(1990,04,01);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);

        assertEquals(pbo.getUserById(81920), p);
    }

    @org.junit.Test
    public void testeValido2() throws Exception{
        Paciente p = new Paciente();
        p.setId(83920);
        p.setNome("Debora");
        p.setSexo('F');
        p.setRestricaoAlimentar("Ovovegetariano");
        Date d = new Date(1999,10,31);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);

        assertEquals(pbo.getUserById(83920), p);
    }

    @org.junit.Test
    public void testeValido3() throws Exception{
        ArrayList<Paciente> pacientes = new ArrayList<>();

        Paciente p1 = new Paciente();
        p1.setId(17283);
        p1.setNome("Alice");
        p1.setSexo('F');
        p1.setRestricaoAlimentar("Vegetariano");
        Date d1 = new Date(1999,10,30);
        p1.setDataNascimento(d1);
        p1.setStatus(true);
        pacientes.add(p1);

        Paciente p2 = new Paciente();
        p2.setId(74829);
        p2.setNome("Fernando");
        p2.setSexo('M');
        p2.setRestricaoAlimentar("Eutrófico");
        Date d2 = new Date(2003,01,04);
        p2.setDataNascimento(d2);
        p2.setStatus(true);
        pacientes.add(p2);

        Paciente p3 = new Paciente();
        p3.setId(13579);
        p3.setNome("Thiago");
        p3.setSexo('M');
        p3.setRestricaoAlimentar("Vegetariano");
        Date d3 = new Date(2003,02,04);
        p3.setDataNascimento(d3);
        p3.setStatus(true);
        pacientes.add(p3);

        PacienteBO pbo = new PacienteBO();

        pbo.criarPaciente(p1);
        pbo.criarPaciente(p2);
        pbo.criarPaciente(p3);

        assertEquals(pacientes, pbo.list());
    }

    @org.junit.Test
    public void testeValido4 () throws Exception{
        Paciente p1 = new Paciente();
        p1.setId(94719);
        p1.setNome("Julia");
        p1.setSexo('F');
        p1.setRestricaoAlimentar("Eutrófico");
        Date d1 = new Date(1994,12,17);
        p1.setDataNascimento(d1);
        p1.setStatus(true);

        Paciente p2 = new Paciente();
        p2.setId(24930);
        p2.setNome("Camila");
        p2.setSexo('F');
        p2.setRestricaoAlimentar("Vegetariano");
        Date d2 = new Date(1994,11,17);
        p2.setDataNascimento(d2);
        p2.setStatus(true);

        Paciente p3 = new Paciente();
        p3.setId(73912);
        p3.setNome("Jorge");
        p3.setSexo('M');
        p3.setRestricaoAlimentar("Eutrófico");
        Date d3 = new Date(1971,03,16);
        p3.setDataNascimento(d3);
        p3.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p1);
        pbo.criarPaciente(p2);
        pbo.criarPaciente(p3);

        assertEquals(pbo.getUserById(24930), p2);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido1() throws Exception{
        Paciente p = new Paciente();
        p.setId(24680);
        p.setNome("Camila");
        p.setSexo('E');
        p.setRestricaoAlimentar("Ovovegetariano");
        Date d = new Date(1999,02,03);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido2() throws Exception{
        Paciente p = new Paciente();
        p.setId(45598);
        p.setNome("Laura");
        p.setSexo('G');
        p.setRestricaoAlimentar("Eutrófico");
        Date d = new Date(1998,12,21);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido3() throws Exception{
        Paciente p = new Paciente();
        p.setId(99782);
        p.setNome("Lorenzo");
        p.setSexo('L');
        p.setRestricaoAlimentar("Vegetariano");
        Date d = new Date(1992,05,14);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido4() throws Exception{
        Paciente p = new Paciente();
        p.setId(93119);
        p.setNome("Martim");
        p.setSexo('N');
        p.setRestricaoAlimentar("Eutrófico");
        Date d = new Date(2000,11,18);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido5() throws Exception{
        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(null);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido6() throws Exception{
        Paciente p1 = new Paciente();
        p1.setId(27402);
        p1.setNome("Mariana");
        p1.setSexo('F');
        p1.setRestricaoAlimentar("Vegetariano");
        Date d1 = new Date(2000,04,30);
        p1.setDataNascimento(d1);
        p1.setStatus(true);

        Paciente p2 = new Paciente();
        p2.setId(84012);
        p2.setNome("José");
        p2.setSexo('M');
        p2.setRestricaoAlimentar("Ovovegetariano");
        Date d2 = new Date(2001,04,02);
        p2.setDataNascimento(d2);
        p2.setStatus(true);

        Paciente p3 = new Paciente();
        p3.setId(73819);
        p3.setNome("Lucas");
        p3.setSexo('M');
        p3.setRestricaoAlimentar("Eutrófico");
        Date d3 = new Date(2000,11,30);
        p3.setDataNascimento(d3);
        p3.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p1);
        pbo.criarPaciente(p2);
        pbo.criarPaciente(p3);

        pbo.getUserById(1);
    }

    @org.junit.Test (expected = ValidationException.class)
    public void testeInvalido7() throws Exception{
        Paciente p1 = new Paciente();
        p1.setId(27402);
        p1.setNome("Mariana");
        p1.setSexo('F');
        p1.setRestricaoAlimentar("Vegetariano");
        Date d1 = new Date(2000,04,30);
        p1.setDataNascimento(d1);
        p1.setStatus(true);

        Paciente p2 = new Paciente();
        p2.setId(84012);
        p2.setNome("José");
        p2.setSexo('M');
        p2.setRestricaoAlimentar("Ovovegetariano");
        Date d2 = new Date(2001,04,02);
        p2.setDataNascimento(d2);
        p2.setStatus(true);

        Paciente p3 = new Paciente();
        p3.setId(73819);
        p3.setNome("Lucas");
        p3.setSexo('M');
        p3.setRestricaoAlimentar("Eutrófico");
        Date d3 = new Date(2000,11,30);
        p3.setDataNascimento(d3);
        p3.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p1);
        pbo.criarPaciente(p2);
        pbo.criarPaciente(p3);

        pbo.getUserById(-1);
    }

    @org.junit.Test (expected = EmptyStackException.class)
    public void testeInvalido8() throws Exception{
        PacienteBO pbo = new PacienteBO();
        pbo.list();
    }
}
