public class ejerciciosuperdificil {
    static clsGenerales cls = new clsGenerales();
    static clsVectorGral vec = new clsVectorGral();
    public static void main(String[] args) {
        procesar();
        
    }
    public static String validarCategoria(){
        String categoria;
        do{
            categoria = cls.leerCadena2("INgrese su categoria 'PRO', 'AME' O 'JUN'").toUpperCase();
            if(!categoria.equals("PRO" ) && !categoria.equals("AME") && !categoria.equals("JUN")){
                cls.Mensaje("Categoria incorrecta, porfavor digite un valor valido");
            }
        }while(!categoria.equals("PRO" ) && !categoria.equals("AME") && !categoria.equals("JUN"));
        return categoria;
    }
    private static void procesar(){
        int cantidadDePersonas = cls.leerEnteroPos("Ingrese la cantidad de personas a procesar"),jugadorSuperioresAlPromedio=0, z=0;
        if(cantidadDePersonas==0){
            throw new IllegalArgumentException("El sistema finalizo, no hay personas para procesar");
        }
        String[] nombres = new String[cantidadDePersonas];
        float[] puntos = new float[cantidadDePersonas];
        int[] partidasJugadas = new int[cantidadDePersonas];
        String[] categoria = new String[cantidadDePersonas];
        String[] pais = new String[cantidadDePersonas], mejorJugador = new String[2];
        String top3 ="",promedioAME="",promedioPRO="",promedioJUN="";
        String topGeneral="", nombreDeJugadoresPro="";
        String jugadorGlobal="", jugadoresMayorAlPromedio="Jugadores con puntaje mayor al promedio: \n";
        
        float promPRO=0,promAME=0,promJUN=0,promedio,sumarTotal=0,masPuntos=-1;
        int oi=0;

        for (int i = 0; i < pais.length; i++) {
            nombres[i] = cls.leerCadena2("Ingrese su nombre");
            puntos[i] = cls.leerRealPos_f("Ingrese la cantidad de puntos que hizo");
            partidasJugadas[i] = cls.leerEntero("Ingrese la cantidad de partidas jugadas");
            categoria[i] = validarCategoria();
            pais[i] = cls.leerCadena2("Ingrese su pais");
            sumarTotal += puntos[i];
            if(puntos[i] > masPuntos){
                masPuntos = puntos[i];
                oi=i;
            }
        }
        int contadorMismoPais=0;
        for (int i = 0; i < cantidadDePersonas; i++) {
            if(pais[i].equals(pais[oi]) && i != oi){
                contadorMismoPais++;
            }
            
        }
        int j=0;
        String nombresMismoPais[] = new String[contadorMismoPais];
        for (int i = 0; i < cantidadDePersonas; i++) {
            
            if(pais[i].equals(pais[oi]) && pais[oi] != pais[oi]){
                nombresMismoPais[j] = nombres[i];
            }
            
            
        }
        promedio = sumarTotal/cantidadDePersonas;
        for(float n: puntos){
            if(n > promedio)
                jugadorSuperioresAlPromedio++;
        }
            String[] jugadoresSuperioresAlPromedio = new String[jugadorSuperioresAlPromedio];
        for (int i = 0; i < jugadoresSuperioresAlPromedio.length; i++) {
            if(puntos[i] > promedio){
                jugadoresSuperioresAlPromedio[z] = nombres[i];
                z++; 

            }
        }
        
        for(String a : jugadoresSuperioresAlPromedio){
            jugadoresMayorAlPromedio += a + " ,";
        }
        int contadorpros=0;
        for (int i = 0; i < jugadoresSuperioresAlPromedio.length; i++) {
            if(categoria[i].equals("PRO") && puntos[i] > 100){
                contadorpros++;

            }
    
        }
        String nombresJugadoresProsMy100[] = new String[contadorpros];
        String jugadoresProMejores100 = "Jugadores pro con mas de 100 puntos: \n";
        j =0;
        for (int i = 0; i < cantidadDePersonas; i++) {
            
            if(categoria[i].equals("PRO") && puntos[i] > 100){
                nombresJugadoresProsMy100[j] = nombres[i];
                jugadoresProMejores100 += nombresJugadoresProsMy100[j] + ", ";
                j++;
                

            }
            
        }
        
        mejorJugador = mejorJugador(puntos, partidasJugadas, nombres);
        jugadorGlobal = "El mejor jugador de toda la lista fue: " + mejorJugador[1] + " con una cantidad de: " + puntos + " puntos";
        String banderaNombre="";
        float banderaPuntos=0;
        String banderaPais="";
        String banderaCategoria="";
        int banderaPartidasJugadas=0;

        for (int i = 0; i < nombresJugadoresProsMy100.length; i++) {
            for (int k = i + 1; k < nombresJugadoresProsMy100.length; k++) {
                if(puntos[i] < puntos[j]){
                    banderaPuntos = puntos[i];
                    puntos[i] = puntos[j];
                    puntos[j] = banderaPuntos;

                    banderaNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = banderaNombre;
                    
                    banderaPais = pais[i];
                    pais[i] = pais[j];
                    pais[j] = banderaPais;

                    banderaCategoria = categoria[i];
                    categoria[i] = categoria[j];
                    categoria[j] = banderaCategoria;

                    banderaPartidasJugadas = partidasJugadas[i];
                    partidasJugadas[i] = partidasJugadas[j];
                    partidasJugadas[j] = banderaPartidasJugadas;
                }
            }

            
        }
        top3 = "EL TOP 3 ES: \n";
        for (int i = 0; i < 2; i++) {
            top3 = "Jugador: " + nombres[i] + " ha conseguido: " + puntos[i] + " puntos, del pais: " + pais[i] + " de la categoria: " + categoria[i] + " con una cantidad de partidas: " + partidasJugadas[i] + "\n";
        }
        for (int i = 3; i < nombresJugadoresProsMy100.length; i++) {
            topGeneral= "Jugador: " + nombres[i] + " ha conseguido: " + puntos[i] + " puntos, del pais: " + pais[i] + " de la categoria: " + categoria[i] + " con una cantidad de partidas: " + partidasJugadas[i] + "\n";
            
        }

        promPRO = promedioCategoria(categoria, puntos, "PRO");
        promAME = promedioCategoria(categoria, puntos, "AME");
        promJUN = promedioCategoria(categoria, puntos, "JUN");
        promedioPRO = (promPRO==-1) ? "Sin jugadores en esta categoría" : "El promedio de los jugadores en la categoria pro fue de: " + promPRO;
        promedioAME = (promAME==-1) ? "Sin jugadores en esta categoría" : "El promedio de los jugadores en la categoria AME fue de: " + promAME;
        promedioJUN = (promJUN==-1) ? "Sin jugadores en esta categoría" : "El promedio de los jugadores de la categoria JUN fue de; " + promJUN;

        

    }
        
    private static float promedioCategoria(String categoria[],float[] puntos,String categoriaDeseada){
        float promPRO=0, promAME=0,promJUN=0;
        int j=0,k=0,w=0;
        for (int i = 0; i < puntos.length; i++) {
            if(categoria[i].equals("PRO")){
                promPRO += puntos[i];
                j++;
            }
            else if(categoria[i].equals("AME")){
                promAME += puntos[i];
                k++;
            }else{
                promJUN += puntos[i];
                w++;
            }
        }
        if(categoriaDeseada.equals("PRO") && j==0)
            return -1;
        if(categoriaDeseada.equals("AME") && k==0)
            return -1;
        if(categoriaDeseada.equals("JUN") && w==0)
            return -1;
        return (categoriaDeseada.equals("PRO")) ? promPRO/j : (categoriaDeseada.equals("AME")) ? promAME/k : promJUN/w;
    }
    private static String[] mejorJugador(float[] puntos, int[] partidasJugadas, String[] nombres){
        float puntosAltos=-1;
        float promedioj=0;
        String nombreGanador="";
        String[] salida = new String[2];
        for (int i = 1; i < partidasJugadas.length; i++) {
            promedioj = puntos[i] / partidasJugadas[i];
            if(promedioj > puntosAltos){
                puntosAltos = promedioj;
                nombreGanador = nombres[i];
            }
        }
        salida[0] = String.valueOf(puntosAltos);
        salida[1] = nombreGanador;
        return salida;
    }
}

/* Ejercicio final — Liga de videojuegos
Combina todo: arrays paralelos, filtros dinámicos, ordenamiento, promedios condicionales y lógica de negocio

Contexto
Una empresa organiza una liga de videojuegos con N jugadores. Cada jugador tiene:
Nombre (no vacío)
Categoría: solo "PRO", "AME" (amateur) o "JUN" (junior)
Puntos acumulados en la liga (entero ≥ 0)
Número de partidas jugadas (entero > 0)
País de origen (no vacío)
40%
Parte A — Estadísticas generales
Calcular y mostrar:
El promedio de puntos por categoría (PRO, AME, JUN por separado). Si ningún jugador pertenece a una categoría, mostrar "Sin jugadores en esta categoría".
El jugador con el mayor promedio de puntos por partida (puntos / partidas) de toda la liga y su promedio.
La cantidad de jugadores que superan el promedio general de puntos de toda la liga.
Métodos sugeridos
validarCategoria()
promedioCategoria()
mejorPromedioPorPartida()
superanPromedio()
Ver pista
Pedir ayuda ↗
35%
Parte B — Filtros dinámicos
Crear un vector dinámico con los nombres de los jugadores PRO que tienen más de 100 puntos. Si no hay ninguno, mostrar "Ningún PRO supera los 100 puntos".
Crear un vector dinámico con los jugadores del mismo país que el jugador con más puntos (excluyéndolo a él). Si nadie más es del mismo país,
 mostrar "El líder no tiene compatriotas en la liga".
Métodos sugeridos
filtrarProConMas100()
compatriotasDelLider()
Ver pista
Pedir ayuda ↗
25%
Parte C — Ranking final
Ordenar todos los jugadores de mayor a menor puntos (burbuja con arrays paralelos: nombre, categoría, puntos, partidas, país).
Mostrar el ranking con posición, nombre, categoría, puntos y país.
Mostrar por separado el top 3. Si hay menos de 3 jugadores, mostrar los que haya.
Métodos sugeridos
ordenarLiga()
mostrarRanking()
mostrarTop3()
Ver pista
Pedir ayuda ↗
Trampas clásicas de este ejercicio
División por cero
Hay 3 divisiones posibles: promedio por categoría, promedio general y puntos/partidas. Protege cada una.
5 arrays paralelos
Al ordenar con burbuja, debes intercambiar los 5. Olvidar uno mezcla los datos.
Posición del líder
Guarda la posición (int posLider), no solo los puntos. La necesitas para buscar el país.
 */