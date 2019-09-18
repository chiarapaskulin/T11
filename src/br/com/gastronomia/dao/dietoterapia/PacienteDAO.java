package br.com.gastronomia.dao.dietoterapia;

//import br.com.gastronomia.db.GenericHibernateDAO;
//import br.com.gastronomia.exception.ValidationException;
//import br.com.gastronomia.model.dietoterapia.Paciente;
//
//import java.util.Date;
//import java.util.List;

public class PacienteDAO{//} extends GenericHibernateDAO<Paciente> {
//
//    public Paciente findPacienteByNome(String nome){
//        return (Paciente) findSingleObject("nome", Paciente.class, nome);
//    }
//
//    public Paciente findPacienteByDataNascimento(Date dataNascimento){
//        return (Paciente) findSingleObject("DataNascimento", Paciente.class, dataNascimento);
//
//    }
//
//    public Paciente findPacienteByIdpaciente(long idPaciente) {
//        return (Paciente) findSingleObject("IdPaciente", Paciente.class, idPaciente);
//    }
//
//    public List<Paciente> listPacientes() {
//        return (List<Paciente>) listAll(Paciente.class);
//    }
//
//
//    public long removePaciente(Paciente paciente) throws ValidationException {
//        return remove(paciente);
//    }
//
//    public Paciente findPacienteByID(long id) throws ValidationException  {
//        return (Paciente) findId(id, Paciente.class);
//    }
//
//    public long updatePaciente(Paciente paciente) throws ValidationException  {
//        return merge(paciente);
//    }
//
//    public long criarPaciente(Paciente paciente) throws ValidationException{
//        return  save(paciente);
//    }
//
//    public long alterStatus(long id, boolean status) throws ValidationException  {
//        Paciente paciente = findPacienteByID(id);
//        paciente.setStatus(status);
//        return merge(paciente);
//    }

}
