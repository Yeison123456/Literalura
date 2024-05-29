package com.challenge.literalura;

import com.challenge.literalura.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Scanner lectura = new Scanner(System.in);
			int prueba = 1;

			LibroService libroService = ctx.getBean(LibroService.class);

			while (prueba==1) {
				System.out.println("""
                        *******************************************************************
                        Elija la opción a través de su número:
                        1) Buscar libro por título
                        2) Listar libros registrados
                        3) Listar autores registrados
                        4) Listar autores vivos en un determinado año
                        5) Listar libros por idioma
                        0) Salir
                        Elija una opción válida:
                        *********************************************************************
                        """);

				try {
					int numero = lectura.nextInt();

					if (numero == 0) {
						break;
					} else {
						switch (numero) {
							case 1:
								System.out.println("Ingrese el nombre del libro que desea buscar");
								lectura.nextLine();
								String name = lectura.nextLine();
								libroService.findAPI(name);
								break;
							case 2:
								// Lógica para listar libros registrados
								break;
							case 3:
								// Lógica para listar autores registrados
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
                                        """);
								break;
							default:
								System.out.println("Opción no válida, por favor intente de nuevo.");
								break;
						}
					}
				} catch (Exception e) {
					System.out.println("Hubo un error: " + e.getMessage());
				}

				System.out.println("Quiere consultar algo mas? 1. Si  0. No");
				lectura.nextLine();
				prueba = lectura.nextInt();
			}
			System.out.println("Termino el programa, Gracias por participar :D");
		};
	}
}
