package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Controller {
	
	
	public static void main(String[] args) {
		
		String rutaFicheroPar = "ficheros/ficheroPares.txt";
		String rutaFicheroImpar = "ficheros/ficheroImpares.txt";
		/*******************************************************/
		Controller controller = new Controller();
		ArrayList<Integer> listadoDatosPares = controller.lecturaDatosFichero(rutaFicheroPar);
		ArrayList<Integer> listadoDatosImpares = controller.lecturaDatosFichero(rutaFicheroImpar);
		
		controller.mezclarDatosDosListados(listadoDatosPares, listadoDatosImpares);
	}
	// practica nueva ->
	// mirar el mergeo de datos en ficheros
	// dados dos ficheros previamente ordenados por la clave que se desee, comparar entre ellos y mezclar reordenandolos
	// leerlo y sacarlo a un tercer fichero
	// leer cada fichero y mezclarlos en el tercer fichero
	// fichero1 < || > || == fichero2 si uno es menor que dos, se graba en el 3 y el 1 avanzará
	// en el fichero3 tendrá que aparecer todos los datos de ambos ficheros ordenados
			
	
	// 1era opcion .- hacerlo metiendo los datos en dos arrayList llamando al mismo metodo de lectura
	// para despues en otro metodo compararlo y crear el tercer fichero
	// 2da opcion .- hacerlo todo de una tacada en un mismo metodo, leerlos, compararlos e introducirlo en un nuevo fichero
	
	/************************INICIO DE LA LOGICA*****************************************/
	public ArrayList<Integer> lecturaDatosFichero(String rutaFichero) {
		ArrayList<Integer> listaDatosFichero = new ArrayList<Integer>();
		
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
				String fichero;
				while((fichero = br.readLine())!=null) {
					listaDatosFichero.add(Integer.parseInt(fichero));
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
	
	
	public void mezclarDatosDosListados(ArrayList<Integer> listadoDatosPares, ArrayList<Integer> listadoDatosImpares) {
		int i = 0;
		int j = 0;
		int n = 0;
		try {
			FileWriter fw = new FileWriter("ficheros/ficheroTotalDatosOrdenados.txt");
			BufferedWriter bw = new BufferedWriter(fw);			
			while(n < listadoDatosPares.size() + listadoDatosImpares.size()) {
				if(listadoDatosPares.get(i) < listadoDatosImpares.get(j)) {
					bw.write(listadoDatosPares.get(i));
					i++;
				}else {
					bw.write(listadoDatosImpares.get(i));
					j++;
				} 
					n++;
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error I/O");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Error IndexOutOfBounds");
			System.out.println();
			if( i >= listadoDatosPares.size()) {
				i--;
			}else {
				j--;
			} n--;
		}
	}
	
	
	
	
	
	
	

}
