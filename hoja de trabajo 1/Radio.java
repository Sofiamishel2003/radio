import java.util.ArrayList;

//
//
//  @ Project : Laboratorio4
//  @ File Name : Principal.java
//  @ Date : 11/8/2022
//  @ Author : 
// BSLJLFAJSFKSAJKFKJASDFKJSAHFKJSDFDS
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
		String menu = "\n\nPor favor seleccione una opción que desee \n1. Encender radio. \n2. Cambiar de AM a FM. \n3. Avanzar el dial de las emisoras \n4. Guardar emisora \n5. Seleccionar emisora \n6. Apagar Radio y salir.";
		int opcionPrincipal = 1;
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
						if(rolonas.isOn() == false)
						{
							rolonas.on();
						}else if(rolonas.isOn() == true)
						{
							System.out.println("El radio ya se encontraba encendido");
						}
						break;
					}
					case 2:
					{
						if(rolonas.isOn() == true)
						{
							String freq = "";
							System.out.println("¿En que frecuancia deseas tu radio? \n1. AM \n2. FM");
							freq = teclado.nextLine();
							freq = teclado.nextLine();
							rolonas.setFrequence(freq);
							System.out.println("Ahora tu radio está en: " + rolonas.getFrequence());
						}
						break;
					}
					case 3:
					{
						if(rolonas.isOn() == true)
						{
							int opcionAdeAtras = 1;
							while(opcionAdeAtras < 3 && opcionAdeAtras >= 1)
							{
							System.out.println("¿Deseas avanzar o retroceder el dial de las emisoras? \n1. Avanzar\n2. Retroceder\n3. Salir al menú principal");
							opcionAdeAtras = teclado.nextInt();
							
								if(opcionAdeAtras == 1)
								{
									rolonas.Forward();
								}else if(opcionAdeAtras == 2)
								{
									rolonas.Backward();
								}
								if(rolonas.getFrequence()=="AM")System.out.println("La emisora actual es:"+ rolonas.getAMActualStation());
								else System.out.println("La emisora actual es:"+ rolonas.getFMActualStation());
							}
						}
						break;
					}
					case 4:
					{
						if(rolonas.isOn() == true)
						{
							int respuesta;
							respuesta=1;
							while(respuesta != 3)
								{
									System.out.println("¿Deseas guardar la emisora actual ?" + "\" \n1. Si\n2. No\n3. Salir");
									respuesta = teclado.nextInt();
									if(respuesta == 1)
									{
										System.out.println("¿En que número de botón quisiera guardar la emisora? (solo hay 12 botones)");
										int boton = teclado.nextInt();
										if (rolonas.getFrequence()=="AM")
										{
											rolonas.saveAMStation(rolonas.getAMActualStation(), boton);
											System.out.println("¡Emisora guardada!");
										}
										else
										{
											rolonas.saveFMStation(rolonas.getFMActualStation(), boton);
											System.out.println("¡Emisora guardada!");
										}
									}
									if(respuesta == 2)
									{
										System.out.println("¿En que número de botón quisiera guardar la emisora? (solo hay 12 botones)");
										int boton = teclado.nextInt();
										if(rolonas.getFrequence()=="FM") 
											{
											double estacionSeleccionada;
											System.out.println("¿Qué emisora deseas guardar?: ");
											estacionSeleccionada = teclado.nextDouble();
											if(87.9<=estacionSeleccionada && estacionSeleccionada<=107.9 && estacionSeleccionada%0.2==0)
											{
												rolonas.saveFMStation(estacionSeleccionada, boton);
											}
											else
											{
												System.out.println("Emisora ingresada incorrecta");
											}
											}
										else 
											{
											int estacionSeleccionada;
											System.out.println("¿Qué emisora deseas guardar?: ");
											estacionSeleccionada = teclado.nextInt();
											if(530<=estacionSeleccionada && estacionSeleccionada<=1610 && estacionSeleccionada%10==0)
											{
												rolonas.saveAMStation(estacionSeleccionada, boton);
												System.out.println("Se guardo en el boton " +boton+" la emisora "+estacionSeleccionada);

											}
											else
											{
												System.out.println("Emisora ingresada incorrecta");
												System.out.println("Se guardo en el boton " +boton+" la emisora "+estacionSeleccionada);
											}
											}
										

									}
								}
							
						}
						break;
					}
					case 5:
					{
						System.out.println("Ingrese el botón de la emisora que quiere");
						int boton2 = teclado.nextInt(); 
						if(rolonas.getFrequence()=="AM")
						{
							rolonas.setAMActualStation(rolonas.getAMSlot(boton2));
							System.out.println("La emisora actual es: "+rolonas.getAMActualStation());
						}
						else
						{
							rolonas.setFMActualStation(rolonas.getFMSlot(boton2));
							System.out.println("La emisora actual es: "+rolonas.getFMActualStation());
						}
						break;
					}
				}
			}
			catch(Exception e){
				System.out.println("Error dato incoherente");

			}
		}
	}
}