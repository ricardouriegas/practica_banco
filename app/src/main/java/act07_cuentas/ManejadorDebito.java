package act07_cuentas;

import java.util.*;
import java.text.*;

public class ManejadorDebito {
    private static final Scanner in = new Scanner(System.in);
    private static HashMap<String, ArrayList<Debito>> cuentas = FileManagement.deserializarCuentasDebito();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    /*******************************************************************/
    /***************************Buscar Cuenta***************************/
    /*******************************************************************/
    public static ArrayList<Debito> obtenerListaCuentas(String rfc){
        if(cuentas.containsKey(rfc)){
            return cuentas.get(rfc);
        } else {
            return null;
        }
    }
    
    /*******************************************************************/
    /***************************Agregar Cuenta**************************/
    /*******************************************************************/
    public static void crearCuenta(String rfc){
        System.out.println("Ingresa el saldo inicial de la cuenta: ");
        double saldo;
        do {
            saldo = Double.parseDouble(in.nextLine());
            if(saldo <= 0) System.out.println(
                "Saldo incorrecto, ingrese un valor mayor a 0");
            
        } while (saldo <= 0);

        if(!cuentas.containsKey(rfc)){
            cuentas.put(rfc, new ArrayList<Debito>());
            cuentas.get(rfc).add(new Debito(saldo, rfc));
        } else {
            cuentas.get(rfc).add(new Debito(saldo, rfc));
            System.out.println("Cuenta agregada con éxito");
        }
        ManejadorDebito.save();
    }

    /*******************************************************************/
    /***************************Cancelar Cuenta*************************/
    /*******************************************************************/
    public static void cancelarCuenta(String rfc, String numCuenta){
        // obtener cuentas del usuario
        ArrayList<Debito> cuentasUsuario = obtenerListaCuentas(rfc);

        // validar si el usuario tiene cuentas
        if (cuentasUsuario == null)
            return;

        // buscar la cuenta
        for(Debito cuenta : cuentasUsuario){
            if(cuenta.getIdentificadorCuenta() == numCuenta){
                if (cuenta.getSaldo() != 0){
                    System.out.println(
                        "No se puede eliminar la cuenta, saldo diferente de 0");
                    return;
                } else {
                    cuentasUsuario.remove(cuenta);
                    System.out.println("Cuenta eliminada");
                    return;
                }
            }
        }

        // si no se encontró la cuenta
        System.out.println("No se encontró el numero de cuenta");
    }

    /*******************************************************************/
    /***********************Cliente Tiene Cuentas***********************/
    /*******************************************************************/
    public static boolean clienteTieneCuentas(String rfc){
        if(cuentas.containsKey(rfc))
            return true;
        else
            return false;
    }

    /*******************************************************************/
    /***************************Verificar Cuenta************************/
    /*******************************************************************/
    public static boolean verificarIdentificador(String rfc, int num){
        if(!cuentas.containsKey(rfc))
            return true;
        
        ArrayList<Debito> cuentasUsuario = obtenerListaCuentas(rfc);

        String possibleId = rfc + String.valueOf(num);
        for(Debito d : cuentasUsuario)
            if(d.getRfc().equals(possibleId))
                return false;
        return true;
    }

    /**
     * Función para realizar un retiro de la cuenta
     * 
     * @param cuenta
     * @throws Exception
      */
    public static void realizarDeposito(Debito cuenta) throws Exception{
        if(cuenta==null){
            System.out.println("No se encontró la cuenta");
            return;
        }
        
        System.out.println("Ingresa el concepto del depósito: ");
        String concepto = in.nextLine();
        
        System.out.println("Ingresa la cantidad a depositar: ");
        double cantidad;
        
        do {
            cantidad = Double.parseDouble(in.nextLine());
            if(cantidad>0) break;
            else System.out.println("No puede ser un valor menor o igual que");
        } while (true);
        
        String fechaStr;
        Date fechaNacimiento;
        do {
            System.out.println("Ingresa la fecha de la operación (mm/dd/yyyy): ");
            fechaStr = in.nextLine();
            if(ManejadorClientes.isValidDate(fechaStr)){
                fechaNacimiento = sdf.parse(fechaStr);
                break;
            } else {
                System.out.println("Fecha inválida");
            }
        } while (true);
        
        String tipo = "Depósito";
        cuenta.setSaldo(cuenta.getSaldo() + cantidad);
        cuenta.agregarMovimiento(new Movimiento(concepto, cantidad, fechaNacimiento, tipo));
    }



    /**
     * Obtiene una cuenta con un ID en específico
      */
    public static Debito buscarCuentaEspecifica(String rfc, String identificador){
        ArrayList<Debito> c = obtenerListaCuentas(rfc);
        if(c == null) return null;

        for(Debito d : c){
            if(d.getIdentificadorCuenta().equals(identificador))
                return d;
        }
        return null;
    }

    public static void mostrarCuentasRegistradas(String rfc){
        ArrayList<Debito> arr = obtenerListaCuentas(rfc);

        if(arr==null||arr.isEmpty()){
            System.out.println("No hay cuentas registradas");
            return;
        }

        System.out.println("Cuentas registradas: ");
        for(Debito a : arr){
            System.out.println(a.toString());
        }
    }

    public static void eliminarRegistro(String rfc){
        if(cuentas.containsKey(rfc)){
            cuentas.remove(rfc);
        }
    }

    /**
     * Función que guarda los datos realizados
      */
    public static void save(){
        FileManagement.serializarCuentasDebito(cuentas);
    }

    /*******************************************************************/
    /***********************CONSULTA MOVIMIENTOS***********************/
    /*******************************************************************/
    public static void consultarMovimientos (String rfc, String identificador) {
        Debito cuentaConMovimientos = buscarCuentaEspecifica(rfc, identificador);

        // validar que la cuenta tenga movimientos
    }
}
