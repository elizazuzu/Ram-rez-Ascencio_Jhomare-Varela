import  dao.BD;
import dao.implementacion.OdontologoDAOH2;
import modelo.Odontologo;
import servicio.OdontologoService;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        BD.creteTable();
        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());
        Odontologo odontologo1 = new Odontologo(1, "juan", "perez", "1234");
        odontologoService.guardar(odontologo1);

        //List<Odontologo> listaOdontologo = odontologos.listarTodos();
        odontologoService.listarTodos().forEach(odontologo ->
                System.out.println(odontologo.getNombre() + " " + odontologo.getApellido())
        );


    }
}
