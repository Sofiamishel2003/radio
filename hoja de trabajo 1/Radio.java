import java.util.ArrayList;

//
//
//  @ Project : Laboratorio4
//  @ File Name : Principal.java
//  @ Date : 11/8/2022
//  @ Author : 
//
//

import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;

public class Radio {
	public static void main(String[] args) 
    {
		radio_metodos rolonas = new radio_metodos();
		System.out.println("¡Bienvenido a la Radio head!");
		Scanner teclado = new Scanner(System.in);
		String menu = "\n\nPor favor seleccione una opción que desee \n1. Encender radio. \n2. Seleccionar Modo Radio. \n3. Avanzar el dial de las emisoras \n4. Guardar emisora \n5. Seleccionar emisora \n6. Apagar Radio y salir.";
		int opcionPrincipal = 1;
		boolean estadoRadio = false;
		while(opcionPrincipal < 7 && opcionPrincipal >= 1)
		{
			try
			{
				System.out.println(menu);
				opcionPrincipal = teclado.nextInt();
				switch(opcionPrincipal)
				{
					case 1:
					{
						if(rolonas.getEstado() == false)
						{
							rolonas.on();
						}else if(rolonas.getEstado() == true)
						{
							System.out.println("El radio ya se encontraba encendido");
						}
						break;
					}
					case 2:
					{
						if(rolonas.getEstado() == true)
						{
							String freq = "";
							System.out.println("¿En que frecuancia deseas tu radio? \n1. AM \n2. FM");
							freq = teclado.nextLine();
							rolonas.setFrequence(freq);
							System.out.println("Ahora tu radio está en: " + rolonas.getFrequence());
						}
						break;
					}
					case 3:
					{
						if(rolonas.getEstado() == true)
						{
							int opcionAdeAtras = 1;
							System.out.println("¿Deseas avanzar o retroceder el dial de las emisoras? \n1. Avanzar\n2. Retroceder\n3. Salir al menú principal");
							opcionAdeAtras = teclado.nextInt();
							while(opcionAdeAtras < 3 && opcionAdeAtras >= 1)
							{
								if(opcionAdeAtras == 1)
								{
									rolonas.Forward();
								}else if(opcionAdeAtras == 2)
								{
									rolonas.Backward();
								}
							}
						}
						break;
					}
					case 4:
					{
						if(rolonas.getEstado() == true)
						{
							if(rolonas.getFrequence().equalsIgnoreCase("FM"))
							{
								int respuesta;
								System.out.println("¿Deseas guardar la emisora actual \"" + rolonas.getEmisoraFM() + "\"? \n1. Si\n2. No\n3. Salir");
								respuesta = teclado.nextInt();
								while(respuesta != 3)
								{
									if(respuesta == 1)
									{
										rolonas.setFMActualStation(rolonas.getEmisoraFM());
										System.out.println("¡Emisora guardada!");
									}
									if(respuesta == 2)
									{
										double estacionSeleccionada;
										System.out.println("¿Qué emisora deseas guardar?: ");
										estacionSeleccionada = teclado.nextDouble();
										boolean bandera = false;
										while(bandera = false)
										{
											if(estacionSeleccionada < 107.9 && estacionSeleccionada >= 87.9)
										{
											rolonas.setFMActualStation(estacionSeleccionada);
											bandera = true;
										}else 
										{
											System.out.println("Seleccione una emisora dentro del rango de 87.9 a 107.9 por favor: \n");
											estacionSeleccionada = teclado.nextDouble();
										}
										}
										

									}
								}
							}else if(rolonas.getFrequence().equalsIgnoreCase("AM"))
							{
								int respuesta2;
								System.out.println("¿Deseas guardar la emisora actual \"" + rolonas.getEmisoraAM() + "\"? \n1. Si\n2. No\n3. Salir");
								respuesta2 = teclado.nextInt();
								while(respuesta2 != 3)
								{
									if(respuesta2 == 1)
									{
										rolonas.setAMActualStation(rolonas.getEmisoraAM());
									}
								}
							}
						}
						break;
					}
				}
			}
			catch(Exception e){

			}
		}
	}
}