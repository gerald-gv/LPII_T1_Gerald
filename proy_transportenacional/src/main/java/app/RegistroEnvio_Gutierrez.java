package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.entity.EnumSucursal;
import model.entity.Envio;
import model.entity.Sucursal;
import model.entity.Transporte;

public class RegistroEnvio_Gutierrez {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proy_transportenacional");
		EntityManager em = emf.createEntityManager();
		
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		
        try {
            em.getTransaction().begin();

            System.out.print("Ingrese el número de placa del transporte: ");
            String placa = bfr.readLine();


            System.out.println("Seleccione la sucursal para el transporte:");
            System.out.println("1: Lima - FRIOS");
            System.out.println("2: Cusco - SECOS");
            System.out.println("3: Arequipa - PELIGROSOS");
            System.out.print("Ingrese el número de sucursal: ");
            int sucursalId = Integer.parseInt(bfr.readLine());

            Sucursal sucursal = null;
            EnumSucursal tipoAlmacen = null;

            switch (sucursalId) {
                case 1:
                    sucursal = new Sucursal();
                    sucursal.setNombre_ciudad("Lima");
                    tipoAlmacen = EnumSucursal.FRIOS;
                    break;
                case 2:
                    sucursal = new Sucursal();
                    sucursal.setNombre_ciudad("Cusco");
                    tipoAlmacen = EnumSucursal.SECOS;
                    break;
                case 3:
                    sucursal = new Sucursal();
                    sucursal.setNombre_ciudad("Arequipa");
                    tipoAlmacen = EnumSucursal.PELIGROSOS;
                    break;
                default:
                    System.err.println("Opción no válida. Por favor seleccione una opción válida.");
                    return;
            }

            sucursal.setTipo_almacen(tipoAlmacen);

            em.persist(sucursal);

            Transporte transporte = new Transporte();
            transporte.setPlaca_vehiculo(placa);
            transporte.setSucursal(sucursal);  
            transporte.setCapacidad_kg(BigDecimal.valueOf(1500));

            em.persist(transporte);
            
            System.out.print("Ingrese el peso del paquete (en kg): ");
            BigDecimal pesoPaquete = new BigDecimal(bfr.readLine());

            System.out.print("Ingrese el destino final: ");
            String destinoFinal = bfr.readLine();

            Envio envio = new Envio();
            envio.setFecha_despacho(new Date());
            envio.setTransporte(transporte); 
            envio.setPeso_paquete(pesoPaquete);
            envio.setDestino_final(destinoFinal);

 
            em.persist(envio);

            em.getTransaction().commit();

            System.out.println("Envío registrado exitosamente" );

        } catch (IOException e) {
            System.err.println("Error al leer los datos: " + e.getMessage());
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Error al registrar el envío: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
	}
}
