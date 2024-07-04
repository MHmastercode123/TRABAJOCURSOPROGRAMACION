import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
   
        private static ArrayList<RegistroClientes> Arrclientes = new ArrayList<>();
        private static ArrayList<RegistroProducto> ArrProductos = new ArrayList<>();
        private static Scanner read = new Scanner(System.in);
        private static final String nombreArchivoprd = "registroproductos.txt";
    	private static final String nombreArchivocli = "registroclientes.txt";
    public static void main(String[] args) throws Exception {
        
        
        cargarProductos();
        cargarClientes();
        
        boolean salir = false;
        int opcion;
         

        try {
            
            while(! salir ) { 
                mostrarmenu();
                opcion = read.nextInt();
            read.nextLine();
            switch (opcion) {
           
            case 1: Añadirproductos();
            break;

            
            case 2: Añadirclientes();
            break;

            case 3:
                    
                    System.out.println("         PRODUCTOS REGISTRADOS");
            
                    System.out.println("===================================");
                    
                    verificaciondeRegistroproductos();
                    System.out.println("===============================");
                    
                    System.out.println("         CLIENTES REGISTRADOS");

                    System.out.println("===============================");
                    verificaciondeRegistroclientes();
            break;

            case 4:
                guardarClientes();
                guardarProductos();
            salir = true;
            System.out.println("estas saliendo de el menu...");
            break;

            default:
            System.out.println("seleccion invalida , escriba otra vez porfavor");
                break;
            }
        
        }
    }   catch (Exception e) {
            System.out.println(e);
        }
        
    }

        private static void mostrarmenu(){
            System.out.println("          MENU DE REGISTRO");
            System.out.println("==================================");
            System.out.println("1)  Registrar productos ");
            System.out.println("2)  Registrar cliente");
            System.out.println("3)  verificacion de productos y clientes");
            System.out.println("4)  Quieres salir ");
            
        }
        public static void Añadirproductos(){
            System.out.println(" si desea volver al menu escriba 'cancel'  ");
            System.out.println("=================================");
            System.out.println("                                    ");
            System.out.println(" Agrega el nombre del producto");
            String Nombre = read.nextLine();
           if (Nombre.equalsIgnoreCase("cancelar")) return;
            System.out.println("Agrega la cantidad del producto");
            int cantidad = read.nextInt();
            read.nextLine();
            String cant = Integer.toString(cantidad);
            if (cant.equalsIgnoreCase("cancelar")) return;
            System.out.println("Agrega el codigo del producto");
            String codigo = read.nextLine();
            if (codigo.equalsIgnoreCase("cancelar")) return;
            System.out.println("Agrega el costo del producto");
            double costo = read.nextDouble();
            if (costo <= 0 ) return;
            System.out.println("==================================");
            System.out.println("se agrego su producto correctamente");

            RegistroProducto registro = new RegistroProducto(Nombre, cantidad, codigo, costo);
            ArrProductos.add(registro);
            
        }

    
        public static void verificaciondeRegistroproductos(){
           if (ArrProductos.isEmpty()) {
            System.out.println("no hay ningun producto registrado");
           }else{
                for (RegistroProducto registro : ArrProductos) {
                    registro.MostrarInformacionproductos();
                    System.out.println();
                }
            
           }
            
        }
        
        
        public static void Añadirclientes(){
            System.out.println(" si desea volver al menu escriba 'cancel'  ");
            System.out.println("=================================");
            System.out.println("                                    ");
            System.out.println(" Agrega el nombre del cliente");
            String nombrecliente = read.nextLine();
            if (nombrecliente.equalsIgnoreCase("cancelar")) return;
           
            System.out.println("Agrega la cedula del cliente");
            String cedula= read.nextLine();
            
          
            if (cedula.equalsIgnoreCase("cancelar")) return;
            System.out.println("Agrega la edad del cliente");
            int edad = read.nextInt();
            read.nextLine();
            
            String age = Integer.toString(edad);
            if (age.equalsIgnoreCase("cancelar")) return;
            System.out.println("Agrega la direccion del cliente");
            
             String direccion = read.nextLine();
            if (direccion.equalsIgnoreCase("cancelar")) return;
         
            
            System.out.println("==================================");
            System.out.println("se agrego al cliente correctamente");

            RegistroClientes registroclient = new RegistroClientes(nombrecliente, edad, cedula, direccion);
            Arrclientes.add(registroclient);
            
        }

        public static void verificaciondeRegistroclientes(){
            if (Arrclientes.isEmpty()) {
             System.out.println("no hay ningun cliente registrado");
            }else{
                 for (RegistroClientes registroclient : Arrclientes) {
                     registroclient.Mostrarinformacionclientes();
                     System.out.println();
                 }
             
            }
             
         }


          private static void guardarProductos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoprd))) {
            for (RegistroProducto registro : ArrProductos ) {
                writer.write(registro.toString());
                writer.newLine();
            }
            System.out.println("Productos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los productos: " + e.getMessage());
        }
    }


        private static void cargarProductos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivoprd))) {
            String line;
            while ((line = reader.readLine()) != null) {
                RegistroProducto registro = RegistroProducto.fromString(line);
                ArrProductos.add(registro);
            }
            System.out.println("Productos cargados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de productos no encontrado");
        } catch (IOException e) {
            System.out.println("Error al cargar los productos: " + e);
        }
    }

    private static void guardarClientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivocli))) {
            for (RegistroClientes registroclient : Arrclientes) {
                writer.write(registroclient.toString());
                writer.newLine();
            }
            System.out.println("Clientes guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes: " + e.getMessage());
        }
    }

    private static void cargarClientes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivocli))) {
            String line;
            while ((line = reader.readLine()) != null) {
                RegistroClientes registroclient = RegistroClientes.fromString(line);
                Arrclientes.add(registroclient);
            }
            System.out.println("clientes cargados exitosamente");
        }catch (FileNotFoundException e ){ 
            System.out.println("Archivo de clientes no encontrado");
            }catch(IOException e) {
                System.out.println("Error de guardado" +e);
            }
           



        }

    }

























