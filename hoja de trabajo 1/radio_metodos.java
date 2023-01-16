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
private int pos;
private int emisorasAM[];  
private double emisorasFM[];  
Scanner teclado = new Scanner(System.in);
public radio_metodos() 
    {
    modulation = true;
    emisoraFM = 87.9;
    emisoraAM = 530;
    estado = false;
    pos = 0;
    emisorasAM=new int[12];
    emisorasFM=new double[12];
    }

    public Boolean isModulation() {
        return this.modulation;
    }

    public Boolean getModulation() {
        return this.modulation;
    }

    public void setModulation(Boolean modulation) {
        this.modulation = modulation;
    }

    public Boolean isEstado() {
        return this.estado;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public int getEmisoraAM() {
        return this.emisoraAM;
    }

    public void setEmisoraAM(int emisoraAM) {
        this.emisoraAM = emisoraAM;
    }

    public double getEmisoraFM() {
        return this.emisoraFM;
    }

    public void setEmisoraFM(double emisoraFM) {
        this.emisoraFM = emisoraFM;
    }

    public int getEmisora() {
        return this.emisora;
    }

    public void setEmisora(int emisora) {
        this.emisora = emisora;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
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
public boolean isOn()
{
    return estado;
}
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
public String getFrequence()
{
    String ans="FM";
    if(modulation)
    {
        ans="AM";
    }
    return ans;
}
public double getFMActualStation()
{
    return emisorasFM[pos];
}
public int getAMActualStation()
{
    return emisorasAM[pos];
}
public void setFMActualStation(double actualStation)
{
    if(pos!=0 && pos!=12)
    {
        pos=pos+1;
    }
    else if (pos==12)
    {
        pos=0;
    }
    emisorasFM[pos]=actualStation;
    
}
public void setAMActualStation(int actualStation) 
{
    if(pos!=0 && pos!=12)
    {
        pos=pos+1;
    }
    else if (pos==12)
    {
        pos=0;
    }
    emisorasAM[pos]=actualStation;
}
public void saveFMStation(double actualStation, int slot)
{
    emisoraFM=emisorasFM[slot-1];
}
public void saveAMStation(int actualStation, int slot)
{
    emisoraAM=emisorasAM[slot-1];
}
public double getFMSlot(int slot)
{
    return emisorasFM[slot-1];
}	
public int getAMSlot(int slot)
{
    return emisorasAM[slot-1];
}
public void Forward()
{
    if (modulation==true) 
    {
    emisoraAM = emisora + 10;
    System.out.println("La emisora es " + emisoraAM);
    } 
    else {
    emisoraFM = emisora + 0.2;
    System.out.println("La emisora es " + emisoraFM);
    }
}
public void Backward()
{
    if (modulation==true) 
    {
    emisoraAM = emisora + 10;
    System.out.println("La emisora es " + emisoraAM);
    } 
    else {
    emisoraFM = emisora + 0.2;
    System.out.println("La emisora es " + emisoraFM);
    }
}
}
