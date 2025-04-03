
package negocio_administradoralumnos;

import dto.AlumnoDTO;

/**
 *
 * @author jalt2
 */
public class AdministradorAlumnos implements IAdministradorAlumnos {
    private static final AdministradorAlumnos instancia = new AdministradorAlumnos();

    private AdministradorAlumnos() {
    }

    public static AdministradorAlumnos getInstance() {
        return instancia;
    }

    @Override
    public AlumnoDTO usuarioActual() {
        AlumnoDTO usuarioActual = new AlumnoDTO("Ariel");
        return usuarioActual;
    }
}
