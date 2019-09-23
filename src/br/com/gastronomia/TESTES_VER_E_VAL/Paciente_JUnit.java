package br.com.gastronomia.TESTES_VER_E_VAL;

import br.com.gastronomia.bo.dietoterapia.PacienteBO;
import br.com.gastronomia.model.dietoterapia.Paciente;

import java.util.Date;

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
        p.setId(67890);
        p.setNome("Otavio");
        p.setSexo('M');
        p.setRestricaoAlimentar("Eutrófico");
        Date d = new Date(1990,04,02);
        p.setDataNascimento(d);
        p.setStatus(true);

        PacienteBO pbo = new PacienteBO();
        pbo.criarPaciente(p);

        assertEquals(pbo.getUserById(81920), p);
    }


/*    @org.junit.Test (expected = HorasTrabalhadasException.class)
    public void situacao6() throws Exception{
        Trabalhador t = new Trabalhador(-1, 110);
    }*/
}
