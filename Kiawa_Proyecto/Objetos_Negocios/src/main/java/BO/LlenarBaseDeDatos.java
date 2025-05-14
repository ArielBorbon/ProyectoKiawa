/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Fabricas.FactoryBO;
import dto.AdministradorDTO;
import dto.CocineroDTO;
import dto.DetallePedidoDTO;
import dto.PedidoDTO;
import dto.PlatilloDTO;
import dto.RepartidorDTO;
import dto.UbicacionDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC Gamer
 */
public class LlenarBaseDeDatos {
        public static void rellenarBD() throws Exception {
        CocineroBO cocineroBO = FactoryBO.crearCocineroBO();
        RepartidorBO repartidorBO = FactoryBO.crearRepartidorBO();
        AdministradorBO administradorBO = FactoryBO.crearAdministradorBO();
        UbicacionBO ubicacionBO = FactoryBO.crearUbicacionBO();
        PlatilloBO platilloBO = FactoryBO.crearPlatilloBO();
        PedidoBO pedidoBO = FactoryBO.crearPedidoBO();

        if (cocineroBO.buscarCocineroPorIdFriendlyBO("000001") == null) {

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

            boolean exitoRepartidor = repartidorBO.crearRepartidorBO(repartidor , "Lucas123");

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

            boolean exitoRepartidor1 = repartidorBO.crearRepartidorBO(repartidor1 , "Maye555");

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
            repartidorBO.deshabilitarRepartidorBO("000003");

            boolean exitoRepartidor2 = repartidorBO.crearRepartidorBO(repartidor2 , "MosunasTeams");

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

            boolean exitoRepartidor3 = repartidorBO.crearRepartidorBO(repartidor3 , "Repartidor123");

            AdministradorDTO admin = new AdministradorDTO();
            admin.setNombreCompleto("Adrian Macias Estrada");
            admin.setTelefono("1231231231");
            boolean exitoAdmin = administradorBO.crearAdministradorBO(admin, "profe123");

            AdministradorDTO admin1 = new AdministradorDTO();
            admin1.setNombreCompleto("Victor Hugo Domitsu Kono");
            admin1.setTelefono("9876543210");
            boolean exitoAdmin1 = administradorBO.crearAdministradorBO(admin1, "VHDK");

            AdministradorDTO admin2 = new AdministradorDTO();
            admin2.setNombreCompleto("Manuel Domitsu Kono");
            admin2.setTelefono("4567891230");
            boolean exitoAdmin2 = administradorBO.crearAdministradorBO(admin2, "AdminSEGURIDAD25");

            AdministradorDTO admin3 = new AdministradorDTO();
            admin3.setNombreCompleto("Ariel Eduardo Borbon Izaguirre");
            admin3.setTelefono("6442048917");
            boolean exitoAdmin3 = administradorBO.crearAdministradorBO(admin3, "Kiawa123");

// Salones 1610 a 1615
            UbicacionDTO ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1600");
            ubicacionDTO1.setSalon("Av1610");
            boolean exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);

            UbicacionDTO ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1600");
            ubicacionDTO2.setSalon("Av1611");
            boolean exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);

            UbicacionDTO ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1600");
            ubicacionDTO3.setSalon("Av1612");
            boolean exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);

            UbicacionDTO ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1600");
            ubicacionDTO4.setSalon("Av1613");
            boolean exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);

            UbicacionDTO ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1600");
            ubicacionDTO5.setSalon("Av1614");
            boolean exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);

            UbicacionDTO ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1600");
            ubicacionDTO6.setSalon("Av1615");
            boolean exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);

// Salones 1620 a 1623
            UbicacionDTO ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1600");
            ubicacionDTO7.setSalon("Av1620");
            boolean exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);

            UbicacionDTO ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1600");
            ubicacionDTO8.setSalon("Av1621");
            boolean exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);

            UbicacionDTO ubicacionDTO9 = new UbicacionDTO();
            ubicacionDTO9.setEdificio("1600");
            ubicacionDTO9.setSalon("Av1622");
            boolean exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);

            UbicacionDTO ubicacionDTO10 = new UbicacionDTO();
            ubicacionDTO10.setEdificio("1600");
            ubicacionDTO10.setSalon("Av1623");
            boolean exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);

            // Salones 1511 a 1515
            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1500");
            ubicacionDTO1.setSalon("Av1511");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1500");
            ubicacionDTO2.setSalon("Av1512");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1500");
            ubicacionDTO3.setSalon("Av1513");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1500");
            ubicacionDTO4.setSalon("Av1514");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1500");
            ubicacionDTO5.setSalon("Av1515");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);

// Salones 1521 a 1525
            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1500");
            ubicacionDTO6.setSalon("Av1521");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1500");
            ubicacionDTO7.setSalon("Av1522");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1500");
            ubicacionDTO8.setSalon("Av1523");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);

            ubicacionDTO9 = new UbicacionDTO();
            ubicacionDTO9.setEdificio("1500");
            ubicacionDTO9.setSalon("Av1524");
            exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);

            ubicacionDTO10 = new UbicacionDTO();
            ubicacionDTO10.setEdificio("1500");
            ubicacionDTO10.setSalon("Av1525");
            exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);

            // Salones 1311 a 1315
            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1300");
            ubicacionDTO1.setSalon("Av1311");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1300");
            ubicacionDTO2.setSalon("Av1312");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1300");
            ubicacionDTO3.setSalon("Av1313");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1300");
            ubicacionDTO4.setSalon("Av1314");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1300");
            ubicacionDTO5.setSalon("Av1315");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);

// Salones 1321 a 1325
            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1300");
            ubicacionDTO6.setSalon("Av1321");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1300");
            ubicacionDTO7.setSalon("Av1322");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1300");
            ubicacionDTO8.setSalon("Av1323");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);

            ubicacionDTO9.setEdificio("1300");
            ubicacionDTO9.setSalon("Av1324");
            exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);

            ubicacionDTO10.setEdificio("1300");
            ubicacionDTO10.setSalon("Av1325");
            exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);

            // Salones Av1821 a Av1828
            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1800");
            ubicacionDTO1.setSalon("Av1821");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1800");
            ubicacionDTO2.setSalon("Av1822");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1800");
            ubicacionDTO3.setSalon("Av1823");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1800");
            ubicacionDTO4.setSalon("Av1824");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1800");
            ubicacionDTO5.setSalon("Av1825");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);

            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1800");
            ubicacionDTO6.setSalon("Av1826");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("1800");
            ubicacionDTO7.setSalon("Av1827");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("1800");
            ubicacionDTO8.setSalon("Av1828");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);

// Salones Av1831 a Av1838
            ubicacionDTO9 = new UbicacionDTO();
            ubicacionDTO9.setEdificio("1800");
            ubicacionDTO9.setSalon("Av1831");
            exitoUbicacion9 = ubicacionBO.crearUbicacionBO(ubicacionDTO9);

            ubicacionDTO10 = new UbicacionDTO();
            ubicacionDTO10.setEdificio("1800");
            ubicacionDTO10.setSalon("Av1832");
            exitoUbicacion10 = ubicacionBO.crearUbicacionBO(ubicacionDTO10);

            ubicacionDTO1 = new UbicacionDTO();
            ubicacionDTO1.setEdificio("1800");
            ubicacionDTO1.setSalon("Av1833");
            exitoUbicacion1 = ubicacionBO.crearUbicacionBO(ubicacionDTO1);

            ubicacionDTO2 = new UbicacionDTO();
            ubicacionDTO2.setEdificio("1800");
            ubicacionDTO2.setSalon("Av1834");
            exitoUbicacion2 = ubicacionBO.crearUbicacionBO(ubicacionDTO2);

            ubicacionDTO3 = new UbicacionDTO();
            ubicacionDTO3.setEdificio("1800");
            ubicacionDTO3.setSalon("Av1835");
            exitoUbicacion3 = ubicacionBO.crearUbicacionBO(ubicacionDTO3);

            ubicacionDTO4 = new UbicacionDTO();
            ubicacionDTO4.setEdificio("1800");
            ubicacionDTO4.setSalon("Av1836");
            exitoUbicacion4 = ubicacionBO.crearUbicacionBO(ubicacionDTO4);

            ubicacionDTO5 = new UbicacionDTO();
            ubicacionDTO5.setEdificio("1800");
            ubicacionDTO5.setSalon("Av1837");
            exitoUbicacion5 = ubicacionBO.crearUbicacionBO(ubicacionDTO5);

            ubicacionDTO6 = new UbicacionDTO();
            ubicacionDTO6.setEdificio("1800");
            ubicacionDTO6.setSalon("Av1838");
            exitoUbicacion6 = ubicacionBO.crearUbicacionBO(ubicacionDTO6);

            ubicacionDTO7 = new UbicacionDTO();
            ubicacionDTO7.setEdificio("Polideportivo");
            ubicacionDTO7.setSalon("Polideportivo");
            exitoUbicacion7 = ubicacionBO.crearUbicacionBO(ubicacionDTO7);

            ubicacionDTO8 = new UbicacionDTO();
            ubicacionDTO8.setEdificio("Tutorias");
            ubicacionDTO8.setSalon("Tutorias");
            exitoUbicacion8 = ubicacionBO.crearUbicacionBO(ubicacionDTO8);

            PlatilloDTO platillo1 = new PlatilloDTO();
            platillo1.setNombre("Sopa de tomate");
            platillo1.setPrecio(40.50);
            platillo1.setDescripcion("Sopa cremosa de tomate con albahaca.");
            platillo1.setExistencias(15);
            platillo1.setCategoria("ENTRADA");
            platillo1.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo1);
            PlatilloDTO platillo2 = new PlatilloDTO();
            platillo2.setNombre("Lomo saltado");
            platillo2.setPrecio(35.90);
            platillo2.setDescripcion("Tiras de res salteadas con cebolla, tomate y papas.");
            platillo2.setExistencias(10);
            platillo2.setCategoria("PLATO_FUERTE");
            platillo2.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo2);
            PlatilloDTO platillo3 = new PlatilloDTO();
            platillo3.setNombre("Tarta de limón");
            platillo3.setPrecio(33.80);
            platillo3.setDescripcion("Postre dulce con base crujiente y crema de limón.");
            platillo3.setExistencias(12);
            platillo3.setCategoria("POSTRE");
            platillo3.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo3);
            PlatilloDTO platillo4 = new PlatilloDTO();
            platillo4.setNombre("Croquetas de jamón");
            platillo4.setPrecio(10.00);
            platillo4.setDescripcion("Croquetas crujientes rellenas de jamón serrano.");
            platillo4.setExistencias(20);
            platillo4.setCategoria("SNACK");
            platillo4.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo4);
            PlatilloDTO platillo5 = new PlatilloDTO();
            platillo5.setNombre("Agua mineral");
            platillo5.setPrecio(21.50);
            platillo5.setDescripcion("Botella de agua mineral con gas.");
            platillo5.setExistencias(30);
            platillo5.setCategoria("BEBIDA");
            platillo5.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo5);
            PlatilloDTO platillo6 = new PlatilloDTO();
            platillo6.setNombre("Crema de champiñones");
            platillo6.setPrecio(21.80);
            platillo6.setDescripcion("Sopa cremosa de champiñones.");
            platillo6.setExistencias(18);
            platillo6.setCategoria("ENTRADA");
            platillo6.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo6);
            PlatilloDTO platillo7 = new PlatilloDTO();
            platillo7.setNombre("Pechuga rellena de espinaca");
            platillo7.setPrecio(44.20);
            platillo7.setDescripcion("Pechuga de pollo rellena con espinaca y queso.");
            platillo7.setExistencias(8);
            platillo7.setCategoria("PLATO_FUERTE");
            platillo7.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo7);

            PlatilloDTO platillo8 = new PlatilloDTO();
            platillo8.setNombre("Brownie con nuez");
            platillo8.setPrecio(30.50);
            platillo8.setDescripcion("Brownie de chocolate con trozos de nuez.");
            platillo8.setExistencias(14);
            platillo8.setCategoria("POSTRE");
            platillo8.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo8);

            PlatilloDTO platillo9 = new PlatilloDTO();
            platillo9.setNombre("Bruschettas de tomate");
            platillo9.setPrecio(40.20);
            platillo9.setDescripcion("Pan tostado con tomate, ajo y albahaca.");
            platillo9.setExistencias(16);
            platillo9.setCategoria("ENTRADA");
            platillo9.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo9);

            PlatilloDTO platillo10 = new PlatilloDTO();
            platillo10.setNombre("Filete de salmón");
            platillo10.setPrecio(130.50);
            platillo10.setDescripcion("Salmón a la plancha con guarnición de vegetales.");
            platillo10.setExistencias(9);
            platillo10.setCategoria("PLATO_FUERTE");
            platillo10.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo10);

            PlatilloDTO platillo11 = new PlatilloDTO();
            platillo11.setNombre("Cheesecake de frutos rojos");
            platillo11.setPrecio(40.80);
            platillo11.setDescripcion("Tarta de queso con cobertura de frutos rojos.");
            platillo11.setExistencias(10);
            platillo11.setCategoria("POSTRE");
            platillo11.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo11);

            PlatilloDTO platillo12 = new PlatilloDTO();
            platillo12.setNombre("Nachos con queso");
            platillo12.setPrecio(50.50);
            platillo12.setDescripcion("Totopos cubiertos con queso fundido y jalapeños.");
            platillo12.setExistencias(22);
            platillo12.setCategoria("SNACK");
            platillo12.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo12);

            PlatilloDTO platillo13 = new PlatilloDTO();
            platillo13.setNombre("Limonada natural");
            platillo13.setPrecio(20.00);
            platillo13.setDescripcion("Limonada fría elaborada con jugo natural.");
            platillo13.setExistencias(25);
            platillo13.setCategoria("BEBIDA");
            platillo13.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo13);

            PlatilloDTO platillo14 = new PlatilloDTO();
            platillo14.setNombre("Rollitos primavera");
            platillo14.setPrecio(30.90);
            platillo14.setDescripcion("Rollos fritos rellenos de vegetales.");
            platillo14.setExistencias(19);
            platillo14.setCategoria("ENTRADA");
            platillo14.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo14);

            PlatilloDTO platillo15 = new PlatilloDTO();
            platillo15.setNombre("Arroz chaufa");
            platillo15.setPrecio(80.80);
            platillo15.setDescripcion("Arroz salteado estilo oriental con pollo y huevo.");
            platillo15.setExistencias(13);
            platillo15.setCategoria("PLATO_FUERTE");
            platillo15.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo15);

            PlatilloDTO platillo16 = new PlatilloDTO();
            platillo16.setNombre("Helado artesanal de vainilla");
            platillo16.setPrecio(30.20);
            platillo16.setDescripcion("Helado cremoso de vainilla con esencia natural.");
            platillo16.setExistencias(17);
            platillo16.setCategoria("POSTRE");
            platillo16.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo16);

            PlatilloDTO platillo17 = new PlatilloDTO();
            platillo17.setNombre("Tostadas de atún");
            platillo17.setPrecio(40.70);
            platillo17.setDescripcion("Tostadas crujientes con mezcla de atún y vegetales.");
            platillo17.setExistencias(14);
            platillo17.setCategoria("ENTRADA");
            platillo17.setDisponible(true);
            platilloBO.agregarPlatilloBO(platillo17);

            PlatilloDTO platillo18 = new PlatilloDTO();
            platillo18.setNombre("Lasagna de carne");
            platillo18.setPrecio(28.90);
            platillo18.setDescripcion("Capas de pasta con carne, salsa bechamel y queso gratinado.");
            platillo18.setExistencias(11);
            platillo18.setCategoria("PLATO_FUERTE");
            platillo18.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo18);

            PlatilloDTO platillo19 = new PlatilloDTO();
            platillo19.setNombre("Mousse de chocolate");
            platillo19.setPrecio(22.30);
            platillo19.setDescripcion("Postre esponjoso y cremoso de chocolate.");
            platillo19.setExistencias(12);
            platillo19.setCategoria("POSTRE");
            platillo19.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo19);

            PlatilloDTO platillo20 = new PlatilloDTO();
            platillo20.setNombre("Palomitas con caramelo");
            platillo20.setPrecio(19.00);
            platillo20.setDescripcion("Palomitas dulces cubiertas con caramelo.");
            platillo20.setExistencias(21);
            platillo20.setCategoria("SNACK");
            platillo20.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo20);

            PlatilloDTO platillo21 = new PlatilloDTO();
            platillo21.setNombre("Té helado de durazno");
            platillo21.setPrecio(35.30);
            platillo21.setDescripcion("Refrescante bebida de té con sabor a durazno.");
            platillo21.setExistencias(28);
            platillo21.setCategoria("BEBIDA");
            platillo21.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo21);

            PlatilloDTO platillo22 = new PlatilloDTO();
            platillo22.setNombre("Carpaccio de res");
            platillo22.setPrecio(33.50);
            platillo22.setDescripcion("Láminas finas de res cruda marinada con limón y aceite de oliva.");
            platillo22.setExistencias(10);
            platillo22.setCategoria("ENTRADA");
            platillo22.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo22);

            PlatilloDTO platillo23 = new PlatilloDTO();
            platillo23.setNombre("Pollo tikka masala");
            platillo23.setPrecio(55.50);
            platillo23.setDescripcion("Pollo marinado en especias y yogur, servido con salsa cremosa.");
            platillo23.setExistencias(9);
            platillo23.setCategoria("PLATO_FUERTE");
            platillo23.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo23);

            PlatilloDTO platillo24 = new PlatilloDTO();
            platillo24.setNombre("Panqueques con miel");
            platillo24.setPrecio(40.00);
            platillo24.setDescripcion("Panqueques suaves servidos con miel de maple.");
            platillo24.setExistencias(15);
            platillo24.setCategoria("POSTRE");
            platillo24.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo24);

            PlatilloDTO platillo25 = new PlatilloDTO();
            platillo25.setNombre("Gazpacho andaluz");
            platillo25.setPrecio(33.10);
            platillo25.setDescripcion("Sopa fría de tomate, pepino y pimientos.");
            platillo25.setExistencias(13);
            platillo25.setCategoria("ENTRADA");
            platillo25.setDisponible(true);
            platilloBO.agregarPlatilloBO(platillo25);
       
            PlatilloDTO platillo26 = new PlatilloDTO();
            platillo26.setNombre("Canelones de espinaca");
            platillo26.setPrecio(19.70);
            platillo26.setDescripcion("Pasta rellena de espinaca y ricotta, horneada con salsa.");
            platillo26.setExistencias(10);
            platillo26.setCategoria("PLATO_FUERTE");
            platillo26.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo26);
       

            PlatilloDTO platillo27 = new PlatilloDTO();
            platillo27.setNombre("Flan napolitano");
            platillo27.setPrecio(20.90);
            platillo27.setDescripcion("Postre tradicional con caramelo.");
            platillo27.setExistencias(16);
            platillo27.setCategoria("POSTRE");
            platillo27.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo27);
         

            PlatilloDTO platillo28 = new PlatilloDTO();
            platillo28.setNombre("Chips de plátano");
            platillo28.setPrecio(23.80);
            platillo28.setDescripcion("Rodajas de plátano frito, crujientes y saladas.");
            platillo28.setExistencias(18);
            platillo28.setCategoria("SNACK");
            platillo28.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo28);
       
            PlatilloDTO platillo29 = new PlatilloDTO();
            platillo29.setNombre("Jugo de naranja natural");
            platillo29.setPrecio(15.50);
            platillo29.setDescripcion("Jugo recién exprimido, sin azúcar añadida.");
            platillo29.setExistencias(24);
            platillo29.setCategoria("BEBIDA");
            platillo29.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo29);
     

            PlatilloDTO platillo30 = new PlatilloDTO();
            platillo30.setNombre("Brochetas caprese");
            platillo30.setPrecio(4.60);
            platillo30.setDescripcion("Tomate cherry, mozzarella y albahaca en brochetas.");
            platillo30.setExistencias(15);
            platillo30.setCategoria("ENTRADA");
            platillo30.setDisponible(true);
            platilloBO.agregarPlatilloBO(platillo30);

            PlatilloDTO platillo31 = new PlatilloDTO();
            platillo31.setNombre("Risotto de hongos");
            platillo31.setPrecio(85.00);
            platillo31.setDescripcion("Arroz cremoso cocinado con hongos y parmesano.");
            platillo31.setExistencias(8);
            platillo31.setCategoria("PLATO_FUERTE");
            platillo31.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo31);

            PlatilloDTO platillo32 = new PlatilloDTO();
            platillo32.setNombre("Tiramisú");
            platillo32.setPrecio(75.00);
            platillo32.setDescripcion("Postre italiano con café, queso mascarpone y cacao.");
            platillo32.setExistencias(14);
            platillo32.setCategoria("POSTRE");
            platillo32.setDisponible(true);
            exito = platilloBO.agregarPlatilloBO(platillo32);


            PedidoDTO pedido = new PedidoDTO();
            pedido.setNombreAlumno("Ariel Borbon");

            UbicacionDTO ubicacion = new UbicacionDTO();
            ubicacion.setEdificio("1800");
            ubicacion.setSalon("Av1823");
            pedido.setUbicacionEntrega(ubicacion);

            DetallePedidoDTO detalle1 = new DetallePedidoDTO();
            detalle1.setNombrePlatillo("Lasagna de carne");
            detalle1.setCantidad(2);
            detalle1.setPrecioUnitario(28.90);
            detalle1.setNota("Sin cebolla");
            detalle1.setSubtotal(detalle1.getCantidad() * detalle1.getPrecioUnitario());

            DetallePedidoDTO detalle2 = new DetallePedidoDTO();
            detalle2.setNombrePlatillo("Limonada natural");
            detalle2.setCantidad(3);
            detalle2.setPrecioUnitario(20.00);
            detalle2.setNota("Con poco hielo");
            detalle2.setSubtotal(detalle2.getCantidad() * detalle2.getPrecioUnitario());

            DetallePedidoDTO detalle3 = new DetallePedidoDTO();
            detalle3.setNombrePlatillo("Tiramisú");
            detalle3.setCantidad(1);
            detalle3.setPrecioUnitario(75.00);
            detalle3.setNota("Para llevar");
            detalle3.setSubtotal(detalle3.getCantidad() * detalle3.getPrecioUnitario());

            List<DetallePedidoDTO> listaDetalles = new ArrayList<>();
            listaDetalles.add(detalle1);
            listaDetalles.add(detalle2);
            listaDetalles.add(detalle3);

            pedido.setTelefonoContacto("5536728490");
            pedido.setInstruccionesEntrega("Tocar antes de entrar al salón");
            pedido.setFechaPedido(new Date());
            pedido.setEstado("PENDIENTE");

            pedido.setPlatillos(listaDetalles);
            exito = pedidoBO.crearPedidoBO(pedido, listaDetalles, "000001");
            DetallePedidoDTO detalleA = new DetallePedidoDTO();
            detalleA.setNombrePlatillo("Risotto de hongos");
            detalleA.setCantidad(1);
            detalleA.setPrecioUnitario(85.00);
            detalleA.setNota("Sin queso");
            detalleA.setSubtotal(detalleA.getCantidad() * detalleA.getPrecioUnitario());

            DetallePedidoDTO detalleB = new DetallePedidoDTO();
            detalleB.setNombrePlatillo("Jugo de naranja natural");
            detalleB.setCantidad(2);
            detalleB.setPrecioUnitario(15.50);
            detalleB.setNota("Frío, sin azúcar");
            detalleB.setSubtotal(detalleB.getCantidad() * detalleB.getPrecioUnitario());

            DetallePedidoDTO detalleC = new DetallePedidoDTO();
            detalleC.setNombrePlatillo("Flan napolitano");
            detalleC.setCantidad(2);
            detalleC.setPrecioUnitario(20.90);
            detalleC.setNota("Bien frío");
            detalleC.setSubtotal(detalleC.getCantidad() * detalleC.getPrecioUnitario());

            List<DetallePedidoDTO> listaDetalles2 = new ArrayList<>();
            listaDetalles2.add(detalleA);
            listaDetalles2.add(detalleB);
            listaDetalles2.add(detalleC);
            PedidoDTO pedido2 = new PedidoDTO();
            pedido2.setNombreAlumno("Ariel Borbon");

            UbicacionDTO ubicacion2 = new UbicacionDTO();
            ubicacion2.setEdificio("1800");
            ubicacion2.setSalon("Av1836");
            pedido2.setUbicacionEntrega(ubicacion2);

            pedido2.setTelefonoContacto("5598764321");
            pedido2.setInstruccionesEntrega("Entregar directo en la entrada del salón");
            pedido2.setFechaPedido(new Date());
            pedido2.setEstado("PENDIENTE");

            pedido2.setPlatillos(listaDetalles2);
            exito = pedidoBO.crearPedidoBO(pedido2, listaDetalles2, "000001");
        }
    }
}
