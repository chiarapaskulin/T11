package br.com.gastronomia.bo.dietoterapia;

import br.com.gastronomia.dao.dietoterapia.PacienteDAO;
import br.com.gastronomia.exception.ValidationException;
import br.com.gastronomia.model.dietoterapia.Paciente;
//import org.hibernate.exception.ConstraintViolationException;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

public class PacienteBO {

    //private PacienteDAO pacienteDAO;

    //MOCK PARA VER E VAL
    ArrayList<Paciente> pacientes;

    public PacienteBO() {
        //pacienteDAO = new PacienteDAO();
        pacientes = new ArrayList<>();
    }

    public Paciente criarPaciente(Paciente paciente) throws NoSuchAlgorithmException, ValidationException {
        if (paciente != null) {
            try {
                if(!sexoValido(paciente)) {
                    throw new ValidationException("Sexo do paciente a ser criado inválido.");
                }
                //pacienteDAO.save(paciente);
                paciente.setStatus(true);
                pacientes.add(paciente);
                return paciente;
            }
//            catch (ConstraintViolationException e) {
//                throw new ValidationException(e.getMessage());
//            }
            catch (Exception e) {
                throw new ValidationException(e.getMessage());
            }
        }else{
            throw new ValidationException("Paciente null");
        }
    }

    public Paciente getUserById(long id) throws ValidationException {
        if (id > 0) {
            //Paciente paciente = pacienteDAO.findPacienteByID(id);
            for(Paciente pac : pacientes){
                if(pac.getId() == id) return pac;
            }
            throw new ValidationException("ID Inválido");
        }
        throw new ValidationException("ID Inválido");

    }

    public ArrayList<Paciente> /*HashMap<String, List<Paciente>>*/ list() throws EmptyStackException {
//        ArrayList<Paciente> pacientes = null;
//        HashMap<String, List<Paciente>> list = new HashMap<String, List<Paciente>>();
//        pacientes = (ArrayList<Paciente>) pacienteDAO.listAll(Paciente.class);
//        list.put("Pacientes", pacientes);
            if(pacientes.isEmpty()) throw new EmptyStackException();
            return pacientes;
    }


//    public boolean /*long*/ deactivatePaciente(/*long id*/int index) throws ValidationException {
//        return pacienteDAO.alterStatus(id, false);
//    }

//    public long activatePaciente(long id) throws ValidationException {
//        return pacienteDAO.alterStatus(id, true);
//    }

//    public long updatePaciente(Paciente paciente) throws ValidationException {
//        if (paciente != null) {
//            if(getUserById(paciente.getId()) != null) {
//
//                if(!sexoValido(paciente)) {
//                    throw new ValidationException("Sexo do paciente a ser criado inválido.");
//                }
//
//                return pacienteDAO.updatePaciente(paciente);
//            } else {
//                throw new ValidationException("Paciente não existente");
//            }
//            //paciente.setStatus(true);
//        } else {
//            throw new ValidationException("Dados inseridos para atualização insuficientes.");
//        }
//    }

    // Checks

    private boolean sexoValido(Paciente paciente) {
        if(paciente.getSexo() == 'F' || paciente.getSexo() == 'M') {
            return true;
        }
        return false;
    }
}
