/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO.RellenoBD;

import BO.AdministradorBO;
import BO.CocineroBO;
import BO.PedidoBO;
import BO.PlatilloBO;
import BO.RepartidorBO;
import BO.UbicacionBO;
import Entidades.Cocinero;
import Fabricas.FactoryBO;
import dto.AdministradorDTO;
import dto.CocineroDTO;
import dto.RepartidorDTO;
import dto.UbicacionDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author rayoa
 */
public class LlenarBD {

    @Test
    public void rellenarBD() throws Exception {
        CocineroBO cocineroBO = FactoryBO.crearCocineroBO();
        RepartidorBO repartidorBO = FactoryBO.crearRepartidorBO();
        AdministradorBO administradorBO = FactoryBO.crearAdministradorBO();
        UbicacionBO ubicacionBO = FactoryBO.crearUbicacionBO();
        PlatilloBO platilloBO = FactoryBO.crearPlatilloBO();
        PedidoBO pedidoBO = FactoryBO.crearPedidoBO();

        Cocinero cocinero = cocineroBO.buscarCocineroPorIdFriendlyBO("000001");
        if (cocinero == null) { //buscar un cocinero (el cual se debe crear Abajo), basicamente condicion para que no se llene 2 veces con lo mismo
            //todos los new entidades para rellenar la BD

            CocineroDTO cocineroDTO = new CocineroDTO();
            cocineroDTO.setApodo("Freddys");
            cocineroDTO.setConsideracionesExtras("Alergico al 1800");
            cocineroDTO.setDiasTrabajo("LMMiJV");
            cocineroDTO.setDisponible(true);
            cocineroDTO.setDomicilio("Calle de la A 567");
            cocineroDTO.setHorario("de 9 a 5PM");
            cocineroDTO.setNombreCompleto("Freddy Ali Castro Roman");
            cocineroDTO.setSalarioDiario(250.10);
            cocineroDTO.setTelefono("5931458501");
            cocineroDTO.setCurp("LOPE920315HDFRMS09");
            boolean exito = cocineroBO.crearCocineroBO(cocineroDTO, "Contraseña123");
            assertEquals(exito, true);
            cocineroBO.deshabilitarCocineroBO("000001");

            CocineroDTO cocineroDTO1 = new CocineroDTO();
            cocineroDTO1.setApodo("Juan");
            cocineroDTO1.setConsideracionesExtras("Ninguna");
            cocineroDTO1.setDiasTrabajo("LMMiJV");
            cocineroDTO1.setDisponible(true);
            cocineroDTO1.setDomicilio("Avenida de la Paz 123");
            cocineroDTO1.setHorario("de 10 a 6PM");
            cocineroDTO1.setNombreCompleto("Juan Carlos Pérez");
            cocineroDTO1.setSalarioDiario(300.50);
            cocineroDTO1.setTelefono("5931458502");
            cocineroDTO1.setCurp("PERE750202HDFRMC05");
            boolean exito1 = cocineroBO.crearCocineroBO(cocineroDTO1, "Contraseña456");
            assertEquals(exito1, true);

            CocineroDTO cocineroDTO2 = new CocineroDTO();
            cocineroDTO2.setApodo("Sofia");
            cocineroDTO2.setConsideracionesExtras("Vegetariana");
            cocineroDTO2.setDiasTrabajo("MMiJV");
            cocineroDTO2.setDisponible(true);
            cocineroDTO2.setDomicilio("Calle de la Libertad 456");
            cocineroDTO2.setHorario("de 11 a 7PM");
            cocineroDTO2.setNombreCompleto("Sofía Martínez");
            cocineroDTO2.setSalarioDiario(280.75);
            cocineroDTO2.setTelefono("5931458503");
            cocineroDTO2.setCurp("MART850505HDFRZN02");
            boolean exito2 = cocineroBO.crearCocineroBO(cocineroDTO2, "Contraseña789");
            assertEquals(exito2, true);

            CocineroDTO cocineroDTO3 = new CocineroDTO();
            cocineroDTO3.setApodo("Chefsito");
            cocineroDTO3.setConsideracionesExtras("Cuidado con aplastarlo accidentalmente");
            cocineroDTO3.setDiasTrabajo("LMMiJVSD");
            cocineroDTO3.setDisponible(true);
            cocineroDTO3.setDomicilio("Kiawa (ITSON Nainari)");
            cocineroDTO3.setHorario("24 HR todos los dias");
            cocineroDTO3.setNombreCompleto("Remy Chefsito");
            cocineroDTO3.setSalarioDiario(550.00);
            cocineroDTO3.setTelefono("5931458504");
            cocineroDTO3.setCurp("HERN900101HDFRLT07");
            boolean exito3 = cocineroBO.crearCocineroBO(cocineroDTO3, "ChefsitoLocuras555");
            assertEquals(exito3, true);

            RepartidorDTO repartidor = new RepartidorDTO();

            repartidor.setNombreCompleto("Lucas Alberto Rodriguez");
            repartidor.setTelefono("5551234567");
            repartidor.setDisponible(true);
            repartidor.setDomicilio("Calle Domingo 5422");
            repartidor.setApodo("Lucas Locuras");
            repartidor.setSalarioDiario(500.75);
            repartidor.setDiasTrabajo("LMMiJ");
            repartidor.setHorario("9:00 AM - 6:00 PM");
            repartidor.setConsideracionesExtras("Tiene motocicleta propia y licencia vigente");
            repartidor.setCurp("GARC800101HDFRNL00");

            boolean exitoRepartidor = repartidorBO.crearRepartidorBO(repartidor);
            assertEquals(exito, true);

            RepartidorDTO repartidor1 = new RepartidorDTO();
            repartidor1.setNombreCompleto("María de los Angeles");
            repartidor1.setTelefono("5559876543");
            repartidor1.setDisponible(true);
            repartidor1.setDomicilio("Avenida de la Esperanza 123");
            repartidor1.setApodo("Maye");
            repartidor1.setSalarioDiario(480.50);
            repartidor1.setDiasTrabajo("LMMiJ");
            repartidor1.setHorario("10:00 AM - 7:00 PM");
            repartidor1.setConsideracionesExtras("Experiencia en entregas rápidas");
            repartidor1.setCurp("SAND880707HDFRPL03");

            boolean exitoRepartidor1 = repartidorBO.crearRepartidorBO(repartidor1);
            assertEquals(exitoRepartidor1, true);

            RepartidorDTO repartidor2 = new RepartidorDTO();
            repartidor2.setNombreCompleto("Mario Enrique Osuna Cuen");
            repartidor2.setTelefono("5556543210");
            repartidor2.setDisponible(true);
            repartidor2.setDomicilio("Calle de la Libertad 456");
            repartidor2.setApodo("El Rápido");
            repartidor2.setSalarioDiario(520.00);
            repartidor2.setDiasTrabajo("MMiJ");
            repartidor2.setHorario("8:00 AM - 5:00 PM");
            repartidor2.setConsideracionesExtras("Es el mas Experimentado actualmente");
            repartidor2.setCurp("GUTI950404HDFRMC01");

            boolean exitoRepartidor2 = repartidorBO.crearRepartidorBO(repartidor2);
            assertEquals(exitoRepartidor2, true);

            RepartidorDTO repartidor3 = new RepartidorDTO();
            repartidor3.setNombreCompleto("Christian Gibran Duran Solano");
            repartidor3.setTelefono("5553219876");
            repartidor3.setDisponible(true);
            repartidor3.setDomicilio("Calle del 1800 789");
            repartidor3.setApodo("Yaibrans");
            repartidor3.setSalarioDiario(490.25);
            repartidor3.setDiasTrabajo("LJVS");
            repartidor3.setHorario("11:00 AM - 8:00 PM");
            repartidor3.setConsideracionesExtras("Flexible con horarios");
            repartidor3.setCurp("RAMI760606HDFRJN08");

            boolean exitoRepartidor3 = repartidorBO.crearRepartidorBO(repartidor3);
            assertEquals(exitoRepartidor3, true);

            AdministradorDTO admin = new AdministradorDTO();
            admin.setNombreCompleto("Adrian Macias Estrada");
            admin.setTelefono("1231231231");
            boolean exitoAdmin = administradorBO.crearAdministradorBO(admin, "profe123");
            assertEquals(exito, true);

            AdministradorDTO admin1 = new AdministradorDTO();
            admin1.setNombreCompleto("Victor Hugo Domitsu Kono");
            admin1.setTelefono("9876543210");
            boolean exitoAdmin1 = administradorBO.crearAdministradorBO(admin1, "VHDK");
            assertEquals(exitoAdmin1, true);

            AdministradorDTO admin2 = new AdministradorDTO();
            admin2.setNombreCompleto("Manuel Domitsu Kono");
            admin2.setTelefono("4567891230");
            boolean exitoAdmin2 = administradorBO.crearAdministradorBO(admin2, "AdminSEGURIDAD25");
            assertEquals(exitoAdmin2, true);

            AdministradorDTO admin3 = new AdministradorDTO();
            admin3.setNombreCompleto("Ariel Eduardo Borbon Izaguirre");
            admin3.setTelefono("6442048917");
            boolean exitoAdmin3 = administradorBO.crearAdministradorBO(admin3, "Kiawa123");
            assertEquals(exitoAdmin3, true);

// Salones 1610 a 1615
            UbicacionDTO ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1600");
            ubicacionDTO1.setSalon("Av1610");
            boolean exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);
            assertEquals(exitoUbicacion1, true);

            UbicacionDTO ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1600");
            ubicacionDTO2.setSalon("Av1611");
            boolean exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);
            assertEquals(exitoUbicacion2, true);

            UbicacionDTO ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1600");
            ubicacionDTO3.setSalon("Av1612");
            boolean exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);
            assertEquals(exitoUbicacion3, true);

            UbicacionDTO ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1600");
            ubicacionDTO4.setSalon("Av1613");
            boolean exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);
            assertEquals(exitoUbicacion4, true);

            UbicacionDTO ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1600");
            ubicacionDTO5.setSalon("Av1614");
            boolean exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);
            assertEquals(exitoUbicacion5, true);

            UbicacionDTO ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1600");
            ubicacionDTO6.setSalon("Av1615");
            boolean exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);
            assertEquals(exitoUbicacion6, true);

// Salones 1620 a 1623
            UbicacionDTO ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1600");
            ubicacionDTO7.setSalon("Av1620");
            boolean exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);
            assertEquals(exitoUbicacion7, true);

            UbicacionDTO ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1600");
            ubicacionDTO8.setSalon("Av1621");
            boolean exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);
            assertEquals(exitoUbicacion8, true);

            UbicacionDTO ubicacionDTO9 = new UbicacionDTO();
            ubicacionDTO9.setEdificio("1600");
            ubicacionDTO9.setSalon("Av1622");
            boolean exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);
            assertEquals(exitoUbicacion9, true);

            UbicacionDTO ubicacionDTO10 = new UbicacionDTO();
            ubicacionDTO10.setEdificio("1600");
            ubicacionDTO10.setSalon("Av1623");
            boolean exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);
            assertEquals(exitoUbicacion10, true);

            // Salones 1511 a 1515
            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1500");
            ubicacionDTO1.setSalon("Av1511");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);
            assertEquals(exitoUbicacion1, true);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1500");
            ubicacionDTO2.setSalon("Av1512");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);
            assertEquals(exitoUbicacion2, true);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1500");
            ubicacionDTO3.setSalon("Av1513");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);
            assertEquals(exitoUbicacion3, true);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1500");
            ubicacionDTO4.setSalon("Av1514");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);
            assertEquals(exitoUbicacion4, true);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1500");
            ubicacionDTO5.setSalon("Av1515");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);
            assertEquals(exitoUbicacion5, true);

// Salones 1521 a 1525
            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1500");
            ubicacionDTO6.setSalon("Av1521");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);
            assertEquals(exitoUbicacion6, true);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1500");
            ubicacionDTO7.setSalon("Av1522");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);
            assertEquals(exitoUbicacion7, true);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1500");
            ubicacionDTO8.setSalon("Av1523");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);
            assertEquals(exitoUbicacion8, true);

            ubicacionDTO9 = new UbicacionDTO();
            ubicacionDTO9.setEdificio("1500");
            ubicacionDTO9.setSalon("Av1524");
            exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);
            assertEquals(exitoUbicacion9, true);

            ubicacionDTO10 = new UbicacionDTO();
            ubicacionDTO10.setEdificio("1500");
            ubicacionDTO10.setSalon("Av1525");
            exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);
            assertEquals(exitoUbicacion10, true);

            // Salones 1311 a 1315
            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1300");
            ubicacionDTO1.setSalon("Av1311");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);
            assertEquals(exitoUbicacion1, true);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1300");
            ubicacionDTO2.setSalon("Av1312");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);
            assertEquals(exitoUbicacion2, true);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1300");
            ubicacionDTO3.setSalon("Av1313");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);
            assertEquals(exitoUbicacion3, true);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1300");
            ubicacionDTO4.setSalon("Av1314");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);
            assertEquals(exitoUbicacion4, true);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1300");
            ubicacionDTO5.setSalon("Av1315");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);
            assertEquals(exitoUbicacion5, true);

// Salones 1321 a 1325
            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1300");
            ubicacionDTO6.setSalon("Av1321");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);
            assertEquals(exitoUbicacion6, true);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1300");
            ubicacionDTO7.setSalon("Av1322");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);
            assertEquals(exitoUbicacion7, true);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1300");
            ubicacionDTO8.setSalon("Av1323");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);
            assertEquals(exitoUbicacion8, true);

            ubicacionDTO9.setEdificio("1300");
            ubicacionDTO9.setSalon("Av1324");
            exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);
            assertEquals(exitoUbicacion9, true);

            ubicacionDTO10.setEdificio("1300");
            ubicacionDTO10.setSalon("Av1325");
            exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);
            assertEquals(exitoUbicacion10, true);

            // Salones Av1821 a Av1828
            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1800");
            ubicacionDTO1.setSalon("Av1821");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);
            assertEquals(exitoUbicacion1, true);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1800");
            ubicacionDTO2.setSalon("Av1822");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);
            assertEquals(exitoUbicacion2, true);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1800");
            ubicacionDTO3.setSalon("Av1823");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);
            assertEquals(exitoUbicacion3, true);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1800");
            ubicacionDTO4.setSalon("Av1824");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);
            assertEquals(exitoUbicacion4, true);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1800");
            ubicacionDTO5.setSalon("Av1825");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);
            assertEquals(exitoUbicacion5, true);

            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1800");
            ubicacionDTO6.setSalon("Av1826");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);
            assertEquals(exitoUbicacion6, true);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1800");
            ubicacionDTO7.setSalon("Av1827");
             exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);
            assertEquals(exitoUbicacion7, true);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1800");
            ubicacionDTO8.setSalon("Av1828");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);
            assertEquals(exitoUbicacion8, true);

// Salones Av1831 a Av1838
            ubicacionDTO9 = new UbicacionDTO();
            ubicacionDTO9.setEdificio("1800");
            ubicacionDTO9.setSalon("Av1831");
            exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);
            assertEquals(exitoUbicacion9, true);

            ubicacionDTO10 = new UbicacionDTO();
            ubicacionDTO10.setEdificio("1800");
            ubicacionDTO10.setSalon("Av1832");
            exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);
            assertEquals(exitoUbicacion10, true);

            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1800");
            ubicacionDTO1.setSalon("Av1833");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);
            assertEquals(exitoUbicacion1, true);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1800");
            ubicacionDTO2.setSalon("Av1834");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);
            assertEquals(exitoUbicacion2, true);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1800");
            ubicacionDTO3.setSalon("Av1835");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);
            assertEquals(exitoUbicacion3, true);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1800");
            ubicacionDTO4.setSalon("Av1836");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);
            assertEquals(exitoUbicacion4, true);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1800");
            ubicacionDTO5.setSalon("Av1837");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);
            assertEquals(exitoUbicacion5, true);

            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1800");
            ubicacionDTO6.setSalon("Av1838");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);
            assertEquals(exitoUbicacion6, true);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("Polideportivo");
            ubicacionDTO7.setSalon("Polideportivo");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);
            assertEquals(true, exitoUbicacion7);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("Tutorias");
            ubicacionDTO8.setEdificio("Tutorias");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);
            assertEquals(true, exitoUbicacion8);
            
            
            

        }
    }
}
