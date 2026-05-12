public class ejerciciodificil1 {
    static clsGenerales cls = new clsGenerales();
    static clsVectorGral vec = new clsVectorGral();
    public static void main(String[] args) {
        procesar();
        
    }
    public static void procesar(){
        int numeroClientes = cls.leerEnteroPosMy0("Ingrese la cantidad de clientes a procesar");
        String cedula[] = new String[numeroClientes];
        boolean accesoConcedido[] = new boolean[numeroClientes];
        float salario[] = new float[numeroClientes];
        boolean prestamoTrue[] = new boolean[numeroClientes];
        float prestamo=0, totalDineroPrestado=0, prestamoMasAlto=0, totalPrestamoRechazados=0,promedioRechazados=0;
        int kRechazados=0, aprobados=0;
        String mensaje="", clienteDelPrestamoMasAlto="";
        boolean aprobado=true;
        for (int i = 0; i < salario.length; i++) {
            cedula[i] = cls.leerCadena2("Ingrese la cedula de la persona a procesar");
            salario[i] = cls.leerRealPosMy0_f("Ingrese el salario de la persona con cedula: " + cedula[i]);
            prestamo = cls.leerRealPosMy0_f("Ingrese el monto del prestamo que desea adquirir");
            aprobado = prestamoAprobado(salario[i], prestamo);
            accesoConcedido[i] = aprobado;
            if(aprobado){
                mensaje = "Felicidades su prestamo de: " + prestamo + " ha sido aprobado gracias a que su suelo aplica dentro de nuestro rango de prestamo";
                aprobados++;
                prestamoTrue[i] = true;
                totalDineroPrestado += prestamo;
                if(prestamoMasAlto < prestamo){
                    prestamoMasAlto = prestamo;
                    clienteDelPrestamoMasAlto = cedula[i];
                    }
            }else{
                mensaje = "Oops, este prestamo no es posible para usted ya que su suelo es muy bajo para el prestamo que esta pidiendo";
                kRechazados++;
                prestamoTrue[i] = false;
                totalPrestamoRechazados += prestamo;
            }
            cls.Mensaje(mensaje);
        }
        String nombresAprobados[] = new String[aprobados];
        if(kRechazados != 0)
            promedioRechazados = totalPrestamoRechazados/kRechazados;
        nombresAprobados = nombreAprobados(prestamoTrue, cedula, numeroClientes);
        String aprobadosConcatenado = "Personas aprobadas: \n";
        for(String a: nombresAprobados){
            aprobadosConcatenado += a + " \n";
        }
        if(kRechazados ==0)
            promedioRechazados =0;
        cls.Mensaje("Personas que pudieron hacer el prestamo de forma exitosa: " + aprobadosConcatenado + "\n" + 
            "El total de dinero prestado es de: " + totalDineroPrestado + "\n" + 
            "El cliente con el prestamo mas alto aprobado fue ID: " + clienteDelPrestamoMasAlto + " con un valor de: " + prestamoMasAlto + "\n" +
            "a esta cantidad de personas se les rechazo el prestamo: " + kRechazados + "\n" + 
            "el promedio de prestamos solicitado por los rechazados fue de: " + promedioRechazados
        );
    }
    public static boolean prestamoAprobado(float x, float prestamo){
        if((x * 40) < prestamo)
            return false;
        else
            return true;
    }
    public static String[] nombreAprobados(boolean[] esAprobado, String[] cedula, int k){
        String p[] = new String[k];
        int j=0;
        for (int i = 0; i < cedula.length; i++) {
            if(esAprobado[i]){
                p[j] = cedula[i];
                j++;
            }
            
        }
        return p;
    }
   
   
}
//un Banco tiene N clientes. Cada cliente tiene: cédula (String, no vacía), salario mensual 
// (> 0) y un préstamo solicitado (> 0). 
// El banco aprueba el préstamo solo si el prést
// amo es ≤ 40 veces el salario del cliente. Mostrar:
//— Para cada cliente si fue aprobado o rechazado y el motivo.
//— Un vector solo con los clientes aprobados y el total de dinero prestado.
//— El cliente con el préstamo más alto aprobado.
//— Cuántos fueron rechazados y el promedio de préstamos solicitados por rechazados.
