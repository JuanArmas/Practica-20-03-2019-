package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
	
	
	public static void main(String[] args) {
		
		String rutaFicheroPar = "ficheros/ficheroPares.txt";
		String rutaFicheroImpar = "ficheros/ficheroImpares.txt";
		/*******************************************************/
		Controller controller = new Controller();
		ArrayList<String> listadoDatosPares = controller.mergeoDatosFichero(rutaFicheroPar);
		ArrayList<String> listadoDatosImpares = controller.mergeoDatosFichero(rutaFicheroImpar);
		

	}
	// practica nueva ->
	// mirar el mergeo de datos en ficheros
	// dados dos ficheros previamente ordenados por la clave que se desee, comparar entre ellos y mezclar reordenandolos
	// leerlo y sacarlo a un tercer fichero
	// leer cada fichero y mezclarlos en el tercer fichero
	// fichero1 < || > || == fichero2 si uno es menor que dos, se graba en el 3 y el 1 avanzará
	// en el fichero3 tendrá que aparecer todos los datos de ambos ficheros ordenados
			
	
	// 1era opcion .- hacerlo metiendo los datos en dos array list en metodos diferentes y despues en otro metodo compararlo y
		// crear el tercer fichero
	// 2da opcion .- hacerlo todo de una tacada en un mismo metodo, leerlos, compararlos e introducirlo en un nuevo fichero
	
	/************************INICIO DE LA LOGICA*****************************************/
	public ArrayList<String> mergeoDatosFichero(String rutaFichero) {
		ArrayList<String> listaDatosFichero = new ArrayList<String>();
		
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
				String fichero;
				while((fichero = br.readLine())!=null) {
					listaDatosFichero.add(fichero);
				}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error FileNotFound");
		} catch (IOException e) {
			System.out.println("Error I/O");
		}
		return listaDatosFichero;
	}
	
	
	
	
	
	
	
	
	
	

}
