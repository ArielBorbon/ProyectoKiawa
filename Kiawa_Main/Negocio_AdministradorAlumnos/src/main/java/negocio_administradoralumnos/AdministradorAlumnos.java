
package negocio_administradoralumnos;

import dto.AlumnoDTO;
import logica.LogicaAlumnos;

/**
 *
 * @author jalt2
 */
public class AdministradorAlumnos implements IAdministradorAlumnos {
    private static AdministradorAlumnos instancia;
    private LogicaAlumnos logicaAlumnos= new LogicaAlumnos();

    private AdministradorAlumnos() {
    }

    public static AdministradorAlumnos getInstance() {
        if (instancia==null) {
            instancia = new AdministradorAlumnos();
        }
        return instancia;
    }

    @Override
    public AlumnoDTO usuarioActual() {
        return logicaAlumnos.obtenerAlumnoDTO();
    }
}
