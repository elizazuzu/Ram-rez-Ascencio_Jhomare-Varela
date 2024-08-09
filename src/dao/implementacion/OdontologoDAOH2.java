package dao.implementacion;

import dao.BD;
import dao.IDao;
import modelo.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Odontologo guardar");
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOlogos (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setString(4, odontologo.getMatricula());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
                logger.info("Odontologo guardado con Id:" + odontologo.getId(rs.getInt("ID")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return odontologo;
    }

    @Override
    public List<Odontologo> ListarTodos() {
        logger.info("ListarTodos Odontologos");
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo = null;
        try {
            connection = BD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ODONTOLOGOS");
            while (rs.next()) {
                odontologo = new Odontologo(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("MATRICULA")
                );
                odontologos.add(odontologo);
                odontologo.getId(rs.getInt("ID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }
        return (List<Odontologo>) odontologos;

    }
}



