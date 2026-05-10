public class clsVectorGral {
    static clsGenerales objG = new clsGenerales();
    static int i;

    public clsVectorGral() {
    } // constructor

    public int[] llenarEnteros(int[] Vect, String Texto) {
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerEntero("[" + i + "]" + Texto + ":");
        } else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public int[] llenarEnterosPos(int[] Vect, String Texto) {
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerEnteroPos("[" + i + "]" + Texto + ":");
        } else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public int[] llenarEnterosPosMy0(int[] Vect, String Texto) {
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerEnteroPosMy0("[" + i + "]" + Texto + ":");
        } else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public int[] llenarEnterosNeg(int[] Vect, String Texto) {
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerEnteroNeg("[" + i + "]" + Texto + ":");
        } else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public float[] llenarReales_f(float[] Vect, String Texto) {
        if (Vect != null)
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerReal_f("[" + i + "]" + Texto + ":");
        else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public float[] llenarRealesPos_f(float[] Vect, String Texto) {
        if (Vect != null)
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerRealPos_f("[" + i + "]" + Texto + ":");
        else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public float[] llenarRealesPosMy0_f(float[] Vect, String Texto) {
        if (Vect != null)
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerRealPosMy0_f("[" + i + "]" + Texto + ":");
        else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public float[] llenarRealesNeg_f(float[] Vect, String Texto) {
        if (Vect != null)
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerRealNeg_f("[" + i + "]" + Texto + ":");
        else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public String[] llenarCadenas(String[] Vect, String Texto) {
        if (Vect != null)
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerCadena("[" + i + "]" + Texto + ":");
        else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public String[] llenarCadenas2(String[] Vect, String Texto) {
        if (Vect != null)
            for (i = 0; i < Vect.length; i++)
                Vect[i] = objG.leerCadena2("[" + i + "]" + Texto + ":");
        else
            objG.Mensaje("Error, Vector Vació");
        return Vect;
    }

    public int sumarEnteros(int[] Vect) {
        int acum = 0;
        for (i = 0; i < Vect.length; i++)
            acum += Vect[i];
        return acum;
    }

    public float sumarReales_f(float[] Vect) {
        float acum = 0;
        for (i = 0; i < Vect.length; i++)
            acum += Vect[i];
        return acum;
    }

    public void mostrarEnteros(int[] Vect, String Texto) {
        String Dato = Texto + "\n";
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Dato += Vect[i] + "\n";
            objG.Mensaje(Dato);
        } else
            objG.Mensaje("Error, Vector Vació");
    }

    public void mostrarReales_f(float[] Vect, String Texto) {
        String Dato = Texto + "\n";
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Dato += Vect[i] + "\n";
            objG.Mensaje(Dato);
        } else
            objG.Mensaje("Error, Vector Vació");
    }

    public void mostrarCadenas(String[] Vect, String Texto) {
        String Dato = Texto + "\n";
        if (Vect != null) {
            for (i = 0; i < Vect.length; i++)
                Dato += Vect[i] + "\n";
            objG.Mensaje(Dato);
        } else
            objG.Mensaje("Error, Vector Vació");
    }

}// Fin