import javax.swing.JOptionPane;
public class clsGenerales{
// base
public clsGenerales()// primer metodo constructor, reserva espacio en memoria, y realizar procedimientos
{
    // constructor vacio, poner simpre las llaves
}
public void Mensaje (String Texto){
    JOptionPane.showMessageDialog(null, Texto);
}

public int leerEntero ( String Texto){
    try{
        return Integer.parseInt(JOptionPane.showInputDialog(Texto));
    }
    catch (Exception ex){
        Mensaje("Error, tipo de dato entero no valido");
        return leerEntero (  Texto);
    }
}

public float leerReal_f ( String Texto){
    try {
        return Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
    }
    catch (Exception ex ){
        return leerReal_f ( "Error, tipo de real no valido");

    }
}
public String leerCadena (String Texto){
    return JOptionPane.showInputDialog(null, Texto).trim();
}






// segunda parte de la tarea
public int leerEnteroPos(String Texto)
{
    try
    {
        int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
        if (Dato >= 0)
            return Dato;
        else
        {
            Mensaje("Valor no válido, debe ser entero mayor o igual a cero, reintente por favor");
            return leerEnteroPos(Texto); // aca se aplica la recurisividad
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerEnteroPos(Texto);
    }
}

public int leerEnteroPosMy0(String Texto)
{
    try
    {
        int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
        if (Dato > 0)
            return Dato;
        else
        {
            Mensaje("Valor no válido, debe ser entero mayor a cero, reintente por favor");
            return leerEnteroPosMy0(Texto);
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerEnteroPosMy0(Texto);
    }
}

public int leerEnteroNeg(String Texto)
{
    try
    {
        int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
        if (Dato < 0)
            return Dato;
        else
        {
            Mensaje("Valor no válido, debe ser entero negativo (<0), reintente por favor");
            return leerEnteroNeg(Texto);
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerEnteroNeg(Texto);
    }
}

public float leerRealPos_f(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato >= 0)
            return Dato;
        else
        {
            Mensaje("Valor no válido, debe ser decimal mayor o igual a cero, reintente por favor");
            return leerRealPos_f(Texto);
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerRealPos_f(Texto);
    }
}

public float leerRealPosMy0_f(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato > 0)
            return Dato;
        else
        {
            Mensaje("Valor no válido, debe ser decimal mayor a cero, reintente por favor");
            return leerRealPosMy0_f(Texto);
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerRealPosMy0_f(Texto);
    }
}

public float leerRealNeg_f(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato < 0)
            return Dato;
        else
        {
            Mensaje("Valor no válido, debe ser decimal negativo, reintente por favor");
            return leerRealNeg_f(Texto);
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerRealNeg_f(Texto);
    }
}

public String leerCadena2(String Texto)
{
    String Dato = JOptionPane.showInputDialog(null, Texto).trim(); // funcion trim quita espacios al inicio y al final de la cadena

    if (Dato.isEmpty()) // isEmpty verifica si es vacia la cadena
    {
        Mensaje("Valor no válido, debe ser cadena diferente de vacío, reintente por favor");
        return leerCadena2(Texto);
    }
    else
        return Dato;
}

public float leerNota_05(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato >= 0 && Dato <= 5)
            return Dato;
        else
        {
            Mensaje("Nota no válida, debe ser decimal entre 0 y 5 inclusive, reintente por favor");
            return leerNota_05(Texto);
        }
    }
    catch (Exception ex)
    {
        Mensaje("Error. Tipo de dato o valor no válido");
        return leerNota_05(Texto);
    }
}
}

