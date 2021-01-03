package concesionaria;

import java.util.ArrayList;
import java.util.List;

import herramientas.ListaGenerica;
import vehiculos.*;

public class Concesionaria
{
	List<Vehiculo> lista_vehiculos; 
	List<Vehiculo> vehiculos_ordenados; // Cree otra lista para tener las 2, la ordenada y la "desordenada". Pero se puede hacer con 1 sola, pero luego del proceso de ordenacion, quedaran en ese orden.
	List<Vehiculo> contiene; // En caso que se cambie el parametro de buqueda, permite almacenar mas de 1 valor (en caso de existir) y mostrar los resultados.
	Vehiculo mas_caro;
	Vehiculo mas_barato;
	ListaGenerica<Vehiculo> lista;
	ListaGenerica<Vehiculo> lista_ordenada;
	ListaGenerica<Vehiculo> lista_contiene;
	
	public Concesionaria()
	{
		lista_vehiculos = new ArrayList<Vehiculo>();
		contiene = new ArrayList<Vehiculo>();
		mas_caro = null;
		mas_barato = null;
		cargar_datos();
		mas_caro_y_mas_barato();
		//ordenar_de_mayor_a_menor();
	}
	private void cargar_datos()
	{
		/*
		lista_vehiculos.add(new Auto("Peugeot", "206", 200_000, 4));
		lista_vehiculos.add(new Moto("Honda", "Titan", 60_000, "125cc"));
		lista_vehiculos.add(new Auto("Peugeot", "208", 250_000, 5));
		lista_vehiculos.add(new Moto("Yamaha", "YBR", 80_500.5, "160cc"));
		*/
		
		//pruebas_ListaGenerica();
		
		lista = new ListaGenerica<Vehiculo>();
		lista.agregar(new Auto("Peugeot", "206", 200_000, 4));
		lista.agregar(new Moto("Honda", "Titan", 60_000, "125cc"));
		lista.agregar(new Auto("Peugeot", "208", 250_000, 5));
		lista.agregar(new Moto("Yamaha", "YBR", 80_500.5, "160cc"));
		
	}
	private void mas_caro_y_mas_barato()
	{
		mas_caro = lista.obtener(0);
		mas_barato = lista.obtener(0);
		for (int i = 1; i < lista.cantidad(); i++)
		{
			if(mas_caro.getPrecio() < lista.obtener(i).getPrecio())
			{
				mas_caro = lista.obtener(i);
			}
			else if (mas_barato.getPrecio() > lista.obtener(i).getPrecio())
			{
				mas_barato = lista.obtener(i);
			}
		}
		/*
		mas_caro = lista_vehiculos.get(0);
		mas_barato = lista_vehiculos.get(0);
		for (int i=1; i<lista_vehiculos.size(); i++)
		{
			if(mas_caro.getPrecio() < lista_vehiculos.get(i).getPrecio())
			{
				mas_caro = lista_vehiculos.get(i);
			}
			else if (mas_barato.getPrecio() > lista_vehiculos.get(i).getPrecio())
			{
				mas_barato = lista_vehiculos.get(i);
			}
		}
		*/
	}
	private void ordenar_de_mayor_a_menor()
	{
		/*
		vehiculos_ordenados = new ArrayList<Vehiculo>();
		for(Vehiculo vehiculo : lista_vehiculos)
		{
			vehiculos_ordenados.add(vehiculo);
		}
		for(int x=0; x < vehiculos_ordenados.size(); x++)
		{
			for (int y=0+x; y < vehiculos_ordenados.size(); y++ )
			{
				if(vehiculos_ordenados.get(x).getPrecio() < vehiculos_ordenados.get(y).getPrecio())
				{
					Vehiculo backup = vehiculos_ordenados.get(x);
					vehiculos_ordenados.set(x, vehiculos_ordenados.get(y));
					vehiculos_ordenados.set(y, backup);
				}
			}
		}
		*/
		
		lista_ordenada = new ListaGenerica<Vehiculo>();
		for (Vehiculo x : lista)
		{
			lista_ordenada.agregar(x);
		}
		
		for(int x=0; x < lista_ordenada.cantidad(); x++)
		{
			for (int y=0+x; y < lista_ordenada.cantidad(); y++ )
			{
				if(lista_ordenada.obtener(x).getPrecio() < lista_ordenada.obtener(y).getPrecio())
				{
					Vehiculo remplazado = lista_ordenada.remplazar(x, lista_ordenada.quitar(y));
					lista_ordenada.insertar(y, remplazado);
				}
			}
		}
	}
	private void contiene(char x)
	{
		lista_contiene = new ListaGenerica<Vehiculo>();
		for (Vehiculo vehiculo: lista)
		{
			if(Herramienta.contiene_letra(x, vehiculo.getModelo()))
			{
				lista_contiene.agregar(vehiculo);
			}
		}
		/*
		for(Vehiculo vehiculo: lista_vehiculos)
		{
			if(Herramienta.contiene_letra(x, vehiculo.getModelo()))
			{
				contiene.add(vehiculo);
			}
		}
		*/
	}
	private void mostrar_vehiculos_contienen(char x)
	{
		contiene(x);
		if(lista_contiene.cantidad()==1)
		{
			System.out.println("Vehiculo que contiene en el modelo la letra '"+x+"' : "+lista_contiene.obtener(0).getVehiculo()+" $"+lista_contiene.obtener(0).getPrecio());
		}
		else if(contiene.size()>1)
		{
			System.out.println("Vehiculos que contienen en el modelo la letra '"+x+"' : ");
			for(Vehiculo vehiculo : lista_contiene)
			{
				System.out.println(vehiculo.getVehiculo()+" $"+vehiculo.getPrecio());
			}
		}
		/*
		if(contiene.size()==1)
		{
			System.out.println("Vehiculo que contiene en el modelo la letra '"+x+"' : "+contiene.get(0).getVehiculo()+" $"+contiene.get(0).getPrecio());
		}
		else if(contiene.size()>1)
		{
			System.out.println("Vehiculos que contienen en el modelo la letra '"+x+"' : ");
			for(Vehiculo vehiculo:contiene)
			{
				System.out.println(vehiculo.getVehiculo()+" $"+vehiculo.getPrecio());
			}
		}
		*/
	}
	public void mostrarDatos()
	{
		for(Vehiculo vehiculo:lista)
		{
			if(vehiculo instanceof Auto)
			{
				System.out.println(((Auto)vehiculo).toString());
			}
			else if(vehiculo instanceof Moto)
			{
				System.out.println(((Moto)vehiculo).toString());
			}
		}
		
		System.out.println("=============================");
		System.out.println("Vehiculo mas caro: "+mas_caro.getVehiculo());
		System.out.println("Vehiculo mas barato: "+mas_barato.getVehiculo());
		mostrar_vehiculos_contienen('Y');
		
		//System.out.println("Cantidad de datos: "+lista.cantidad());
		ordenar_de_mayor_a_menor();
		
		System.out.println("=============================");
		System.out.println("Vehiculos ordenados por precio de mayor a menor:");
		
		for(Vehiculo vehiculo: lista_ordenada)
		//for(Vehiculo vehiculo: vehiculos_ordenados)
		{
			System.out.println(vehiculo.getVehiculo()+" - $"+vehiculo.getPrecio());
		}
	}
	// Pruebas LISTA GENERICA
	/*
	private void pruebas_ListaGenerica()
	{
		ListaGenerica<Vehiculo> lista = new ListaGenerica<Vehiculo>();
		lista.agregar(new Auto("Peugeot", "206", 200_000, 4));
		lista.agregar(new Moto("Honda", "Titan", 60_000, "125cc"));
		lista.agregar(new Auto("Peugeot", "208", 250_000, 5));
		lista.agregar(new Moto("Yamaha", "YBR", 80_500.5, "160cc"));
		
		System.out.println("----------------------------------------------\n"+
						   "Lista generica\n"+
						   "----------------------------------------------\n");
		lista.mostrar();
		
		//--------	insertar()	---------
		
		System.out.println("-----------------------------------------------\n"+
						   "Insertamos elemento en pos 2\n"+
						   "-----------------------------------------------\n");
		lista.insertar(1, new Auto("Peugeot", "504", 70_000, 4));
		
		for(int i=0; i<lista.cantidad(); i++)
		{
			System.out.println(lista.obtener(i).toString());
		}
		
		//---------		quitar()	----------
		
		System.out.println("-----------------------------------------------\n"+
				   		   "Eliminamos ultimo elemento\n"+
						   "-----------------------------------------------\n");
		Vehiculo quitado = lista.quitar();
		for(Vehiculo vehiculo:lista)
		{
			System.out.println(vehiculo.toString());
		}
		System.out.println("\nElemento quitado: "+ quitado.getVehiculo()+"\n");
		
		//---------		remplazar()		-----------
		
		System.out.println("-----------------------------------------------\n"+
						   "Remplazamos elemento 3 (Entra Yamaha - YBR | POR | Honda - Titan)\n"+
						   "-----------------------------------------------\n");
		Vehiculo remplazado = lista.remplazar(2, quitado);
		
		for(Vehiculo vehiculo:lista)
		{
			System.out.println(vehiculo.toString());
		}
		System.out.println("\nElemento Remplazado = " +remplazado.getVehiculo()+"\n");
		
		//-----------	quitar(pos)		---------------
		
		System.out.println("-----------------------------------------------\n"+
				   		  "Quitamos elemento en pos 2 (Peugeot - 504)\n"+
				   		  "-----------------------------------------------\n");
		Vehiculo quitado_2 = lista.quitar(1);
		for(Vehiculo vehiculo:lista)
		{
			System.out.println(vehiculo.toString());
		}
		System.out.println("\n Elemento quitado: "+quitado_2.getVehiculo());
		System.out.println("----------------------------------------------\n");
	}
	*/
}
