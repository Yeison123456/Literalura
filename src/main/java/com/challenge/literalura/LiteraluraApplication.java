package com.challenge.literalura;


import com.challenge.literalura.Service.libroService;

import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication {

	private static final libroService libroService = new libroService();

	public static void main(String[] args) {

		boolean prueba= true;
		Scanner lectura= new Scanner(System.in);
		while(prueba){
			System.out.println("""
					
					*******************************************************************
					Elija la opción a través de su numero:
				   \\s
					1) Buscar libro por titulo
					2) Listar libros registrados
					3) Listar autores registrados
					4) Listar autores vivos en un determinado año
					5) Listar libros por idioma
					0) Salir\\s
					Elija una opción válida:
				   \\s
					*********************************************************************
				   \\s
				   \\s""");

			try {
				var numero= lectura.nextInt();

				if (numero==0){
					break;
				} else {
					switch (numero){
						case 1:
							System.out.println("Ingrese el nombre del libro que desea buscar");
							lectura.nextLine();
							String name = lectura.nextLine();
							System.out.println(name);
							libroService.findAPI(name);

							break;
						case 2:

							break;
						case 3:

							break;
						case 4:
							System.out.println("Ingrese el año vivo de autor(es) que desea buscar:");
							break;
						case 5:
							System.out.println("""
									Ingrese el idioma para buscar los libros:
									es- español
									en- inglés
									fr- francés
									pt- portugués
									\\s
									""");
							break;
					}
				}
			} catch (Exception e){
				System.out.println("Hubo un error: "+e.getMessage());
			}

			prueba=false;
		}
		System.out.println("Termino el programa, Gracias por participar :D");
	}

}
