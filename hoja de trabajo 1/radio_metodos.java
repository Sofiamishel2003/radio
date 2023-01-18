//
//
//  @ Project : hoja de trabajo 1
//  @ File Name : Radio.java
//  @ Date : 17/01/2023
//  @ Author : Sofía Velásquez, Joaquín Campos, Julio García Salas
// 
//
import java.util.Scanner;
import java.util.Random;
public class radio_metodos implements IRadio{ // declaracion
    // de variables
    // protegidas y
    // creacion de
    // la clase
    // padre
private Boolean modulation;
private Boolean estado;
private int emisoraAM;
private double emisoraFM;
private int emisora;
private int posAM;
private int posFM;
private int emisorasAM[];  
private double emisorasFM[];  
Scanner teclado = new Scanner(System.in);
public radio_metodos() 
    {
    modulation = true;
    emisoraFM = 87.9;
    emisoraAM = 530;
    estado = false;
    posAM = 0;
    posFM = 0;
    emisorasAM=new int[12];
    emisorasFM=new double[12];
    }

@Override
// ----------PRENDER Y APAGAR----------------------
public void on() 
{
    estado = true;
    System.out.println("El radio está encendido");
}
public void off()
{
    estado = false;
    System.out.println("El radio está apagado");
}

/** 
 * @return boolean
 */
public boolean isOn()
{
    return estado;
}

/** 
 * @param freq
 * @throws Exception
 */
// ----------FRECUENCIA-----------------------
public void setFrequence(String freq) throws Exception
{   if (Integer.parseInt(freq)==1) {
        modulation = true;
    }
    else if(Integer.parseInt(freq)==2)
    {
        modulation = false;
    }else if(Integer.parseInt(freq) != 1 && Integer.parseInt(freq) != 2)
    {
        throw new Exception();
    }
    System.out.println("La frecuencia está en " + modulation);
}

/** 
 * @return String
 */
public String getFrequence()
{
    String ans="FM";
    if(modulation)
    {
        ans="AM";
    }
    return ans;
}

/** 
 * @return double
 */
public double getFMActualStation()
{
    return emisoraFM;
}

/** 
 * @return int
 */
public int getAMActualStation()
{
    return emisoraAM;
}

/** 
 * @param actualStation
 */
public void setFMActualStation(double actualStation)
{
    emisoraFM=actualStation;
    
}

/** 
 * @param actualStation
 */
public void setAMActualStation(int actualStation) 
{
    emisoraAM=actualStation;
}

/** 
 * @param actualStation
 * @param slot
 */
public void saveFMStation(double actualStation, int slot)
{
    emisorasFM[slot-1]=actualStation;
}

/** 
 * @param actualStation
 * @param slot
 */
public void saveAMStation(int actualStation, int slot)
{
    emisorasAM[slot-1]=actualStation;
}

/** 
 * @param slot
 * @return double
 */
public double getFMSlot(int slot)
{
    return emisorasFM[slot-1];
}	

/** 
 * @param slot
 * @return int
 */
public int getAMSlot(int slot)
{
    return emisorasAM[slot-1];
}
public void Forward()
{
    if (modulation==true) 
    {
    emisoraAM = emisoraAM + 10;
    System.out.println("La emisora es " + emisoraAM);
    } 
    else {
    emisoraFM = emisoraFM + 0.2;
    System.out.println("La emisora es " + emisoraFM);
    }
}
public void Backward()
{
    if (modulation==true) 
    {
    emisoraAM = emisoraAM - 10;
    System.out.println("La emisora es " + emisoraAM);
    } 
    else {
    emisoraFM = emisoraFM - 0.2;
    System.out.println("La emisora es " + emisoraFM);
    }
}
}
