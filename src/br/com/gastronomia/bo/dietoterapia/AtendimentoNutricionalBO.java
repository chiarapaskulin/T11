package br.com.gastronomia.bo.dietoterapia;

import br.com.gastronomia.dao.UsuarioDAO;
import br.com.gastronomia.dao.dietoterapia.AtendimentoNutricionalDAO;
import br.com.gastronomia.dao.dietoterapia.PacienteDAO;
import br.com.gastronomia.dto.AtendimentoNutricionalDTO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.Usuario;
import br.com.gastronomia.model.dietoterapia.AtendimentoNutricional;
import br.com.gastronomia.model.dietoterapia.Paciente;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AtendimentoNutricionalBO {
    //private AtendimentoNutricionalDAO atendimentoDAO;
    //private PacienteDAO pacienteDAO;
    //private UsuarioDAO usuarioDAO;

    //MOCK PARA VER E VAL:
    ArrayList<AtendimentoNutricional> atendimentosNutricionais;

    public AtendimentoNutricionalBO() {
        //atendimentoDAO = new AtendimentoNutricionalDAO();
        //pacienteDAO = new PacienteDAO();
        //usuarioDAO = new UsuarioDAO();
        atendimentosNutricionais = new ArrayList<>();
    }

    public ArrayList<AtendimentoNutricional>/*Map<String, List<AtendimentoNutricional>>*/ list() throws EmptyStackException {
        if(atendimentosNutricionais.isEmpty()) throw new EmptyStackException();
        return atendimentosNutricionais;
//        try {
//            return Collections.singletonMap("Atendimentos", atendimentoDAO.listAll(AtendimentoNutricional.class));
//        } catch (final Exception e) {
//            return Collections.singletonMap("Atendimentos", Collections.emptyList());
//        }


    }

    public AtendimentoNutricional criarAtendimento(AtendimentoNutricional an /*AtendimentoNutricionalDTO dto*/) throws ValidationException {
//        if (dto == null) throw new IllegalArgumentException();
//        try {
//            Usuario aluno = usuarioDAO.findUserByID(dto.getIdAluno());
//            Usuario professor = usuarioDAO.findUserByID(dto.getIdProfessor());
//            Paciente paciente = pacienteDAO.findPacienteByID(dto.getIdPaciente());
//
//            AtendimentoNutricional atendimento = new AtendimentoNutricional(aluno, professor, paciente, dto.getData(), dto.getStatus());
//            long id = atendimentoDAO.save(atendimento);
//            atendimento.setId(id);
//
//            return atendimento;
//        }
//        catch (Exception e) {
//            throw new ValidationException(e.getMessage());
//        }
        if(an==null)throw new ValidationException("Atendimento Nutricional inválido");
        atendimentosNutricionais.add(an);
        return an;
    }

//    public boolean /*long*/ deactivateAtendimentoNutricional(/*long id*/int index) throws ValidationException {
//        return atendimentoDAO.alterStatus(id, false);
//    }

//    public long atualizarAtendimento(/*AtendimentoNutricionalDTO dto*/) throws NoSuchAlgorithmException, ValidationException {
//        if (dto == null)
//            throw new IllegalArgumentException();
//
//        Usuario aluno = usuarioDAO.findUserByID(dto.getIdAluno());
//        Usuario professor = usuarioDAO.findUserByID(dto.getIdProfessor());
//        Paciente paciente = pacienteDAO.findPacienteByID(dto.getIdPaciente());
//
//        AtendimentoNutricional atendimento = new AtendimentoNutricional(aluno, professor, paciente, dto.getData(), dto.getStatus());
//        atendimento.setId(dto.getId());
//
//        if (atendimentoDAO.findAtendimentoByID(dto.getId()) == null)
//            return atendimentoDAO.save(atendimento);
//        else
//            return atendimentoDAO.updateAtendimento(atendimento);
//    }

  public AtendimentoNutricional getById( long id) throws ValidationException {
        if (id > 0) {
            //AtendimentoNutricional atendimento = atendimentoDAO.findAtendimentoByID(id);
            for(AtendimentoNutricional atn : atendimentosNutricionais){
                if(atn.getId() == id) return atn;
            }
            throw new ValidationException("ID Inválido");
        }
        throw new ValidationException("ID Inválido");
    }

}
