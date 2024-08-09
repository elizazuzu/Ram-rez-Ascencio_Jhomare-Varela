package dao.implementacion;

import dao.IDao;
import modelo.Odontologo;

import java.util.List;
import java.util.logging.Logger;


import dao.IDao;

import static dao.implementacion.OdontologoDAOH2.logger;

public class OdontologoSinBD implements IDao<Odontologo> {

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(odontologo.getId(1));
        odontologo.add(odontologo);


        return odontologo;

    }

    @Override
    public List<Odontologo> ListarTodos() {

        return null;
    }
}
