public class ejerciciodificil2 {
    static clsGenerales cls = new clsGenerales();
    static clsVectorGral vec = new clsVectorGral();
    public static void main(String[] args) {
        procesar();
    }   
    public static void procesar(){
        int cantidadDePacientes = cls.leerEnteroPosMy0("Ingrese el numero de pacientes a procesar");
        String[] nombre = new String[cantidadDePacientes];
        int[] edad = new int[cantidadDePacientes];
        int[] dias = new int[cantidadDePacientes];
        float[] costosPorPaciente = new float[cantidadDePacientes];
        String[] area = new String[cantidadDePacientes];
        String nombrePacientePED="";
        String acomuladorNombres="";
        String nombrePacienteURG="";
        String nombrePacienteCIR="";
        float costoT=0,costoAcomulador=0, facturadoEnURG=0, facturadoEnPED=0, facturandoEnCIR=0, promedioPED=0,costoPacienteEnURG=0,costoPacienteEnPED=0,costoPacienteEnCIR=0;
        float pacientesMnA18=0,PromedioPacientesMnA18=0,AcomuladorPacientesMnA18=0,promedio18=0;
        for (int i = 0; i < nombre.length; i++) {
            nombre[i] = cls.leerCadena2("Ingrese el nombre del paciente");
            edad[i] = cls.leerEnteroPos("Ingrese la edad del paciente: " + nombre[i]);
            area[i] = validarArea();
            costoT = (area[i].equals("URG")) ? 150000 : (area[i].equals("PED")) ? 90000 : 200000;
            dias[i] = cls.leerEnteroPosMy0("Ingrese la cantidad de dias hospitalizado");
            costosPorPaciente[i] = costoT * dias[i];
            cls.Mensaje("El total de coste por el paciente: " + nombre[i] + " es de: " + costosPorPaciente[i]);
            if(area[i].equals("URG")){
                facturadoEnURG += costoT;
                if(costosPorPaciente[i] > costoPacienteEnURG){
                    costoPacienteEnURG = costosPorPaciente[i];
                    nombrePacienteURG = nombre[i];
                }
            }
            else if(area[i].equals("PED")){
                facturadoEnPED += costoT;
                if(costosPorPaciente[i] > costoPacienteEnPED){
                    costoPacienteEnPED = costosPorPaciente[i];
                    nombrePacientePED = nombre[i];
                }
                if(edad[i] < 18){
                    pacientesMnA18++;
                    AcomuladorPacientesMnA18 += costosPorPaciente[i];
                    acomuladorNombres += "Pacientes menores de 18 que estan en PED: "+nombre[i] + " ,";

                }
            }else{
                facturandoEnCIR += costoT;
                if(costosPorPaciente[i] > costoPacienteEnCIR){
                    costoPacienteEnCIR = costosPorPaciente[i];
                    nombrePacienteCIR = nombre[i];
                }
            }
            
        }
        if(pacientesMnA18 != 0)
            promedio18 = AcomuladorPacientesMnA18/pacientesMnA18;
        String menoresPED = acomuladorNombres.isEmpty() ? "ninguno" : acomuladorNombres;
        String h = ordenarVectores(nombre, costosPorPaciente);
        cls.Mensaje("El total facturado por el area URG: " + facturadoEnURG + "\n" + 
            "El total facturado por el area PED: " + facturadoEnPED + "\n" + 
            "El total facturado por el area CIR: " + facturandoEnCIR
            + "\n" + "El paciente mas costoso de URG fue: " + nombrePacienteURG +" con un coste de: " + costoPacienteEnURG +
            "\n el paciente mas caro de PED fue: " + nombrePacientePED + " con un coste de: " + costoPacienteEnPED +
            "\n el paciente mas caro de CIR fue: " + nombrePacienteCIR + " con un coste de: " + costoPacienteEnCIR +
            "\n" + menoresPED + "\n" +
            "Promedio de costos de personas en PED que son menores de edad: " + promedio18 +
            "\n " +  h);

        
    }
    public static String validarArea(){
        String area;
        do{
            area = cls.leerCadena2("Ingrese su area, 'URG', 'PED' o 'CIR'").toUpperCase();
            if(!area.equals("CIR") && !area.equals("URG") && !area.equals("PED"))
                cls.Mensaje("Area no valida porfavor intente nuevamente");
        }while(!area.equals("CIR") && !area.equals("URG") && !area.equals("PED"));
        return area;
    }
    public static String ordenarVectores(String nombres[], float[] costoPorPaciente){
        float bandera=0;
        String nombreBandera="";
        String salida="";
        for (int i = 0; i < nombres.length; i++) {
            for (int j = i + 1; j < nombres.length; j++) {
                if(costoPorPaciente[j] > costoPorPaciente[i]){
                    bandera = costoPorPaciente[i];
                    costoPorPaciente[i] = costoPorPaciente[j];
                    costoPorPaciente[j] = bandera;
                    nombreBandera = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = nombreBandera;
                }
            }
        }
        for (int i = 0; i < costoPorPaciente.length; i++) {
            salida += "El paciente: " + nombres[i] + " tuvo un costo total de: " + costoPorPaciente[i] + "\n";
        }
        return salida;
    }
}


//Hospital — pacientes por área
//Un hospital tiene N pacientes. Cada paciente tiene: nombre, edad (≥ 0), área (solo acepta: "URG", "PED", "CIR") y 
// días hospitalizado (> 0). El costo diario es: URG = $150.000, PED = $90.000, CIR = $200.000. Calcular y mostrar:
//— El costo total de hospitalización por paciente.
//— El total facturado por cada área.
//— El paciente más costoso de cada área.
//— Los pacientes menores de 18 años hospitalizados en PED y su costo promedio.
//— Listado final ordenado por costo total de mayor a menor.
