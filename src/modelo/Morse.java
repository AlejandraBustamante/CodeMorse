package modelo;

import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Morse {
	public static void main(String[] args) {
		char letras[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
		String code[] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....","-....","--...","---..","----."};
		
		int opc = 0;
		do{
			System.out.println("--Selecciona opcion--");
			System.out.println("1.- Texto a Morse");
			System.out.println("2.- Morse a Texto");
			System.out.println("3.- Salir");
			Scanner sc1 = new Scanner(System.in);  
			opc = Integer.parseInt(sc1.nextLine());
			
			if(opc == 1) {
				System.out.print("Introduzca una frase para traducir a Morse: ");
				Scanner sc = new Scanner(System.in);
				String men = sc.nextLine();
				String men2 = men.toUpperCase();
				char[] mander = men2.toCharArray();
				String salida = "";
				for(int i=0; i<men.length(); i++) {
					for(int j=0; j<letras.length; j++)
						if( mander[i] == letras[j] )
							salida += code[j]+" ";
					if(mander[i] == ' ')
						salida += "   ";
				}
				
				System.out.println(salida);
			}else if(opc == 2) {
				System.out.print("Introduzca el código Morse que desea descrifrar: ");
				Scanner sc2 = new Scanner(System.in); 
				String men3 = sc2.nextLine();
				String t1[] = men3.split("   ");
				String salida2 = "";
				for (int i = 0; i < t1.length; i++) {
					StringTokenizer tokens=new StringTokenizer(t1[i], " ");
					while(tokens.hasMoreTokens()) {
						String token = tokens.nextToken();
						for(int j=0; j<code.length; j++)
							if( token.equals(code[j]) )
								salida2 += letras[j];
					}
					salida2 += " ";
				}
				System.out.println(salida2);
			}else if(opc != 3)
				System.out.println("Opción no válida");
		}while (opc != 3);
		System.out.println("Programa Finalizado");
	 }
}