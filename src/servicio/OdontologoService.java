package servicio;

import dao.IDao;
import modelo.Odontologo;
import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoIDao;

    // Constructor para inyectar la implementación deseada
    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    public List<Odontologo> listarTodos() {
        return odontologoIDao.ListarTodos();
    }
}