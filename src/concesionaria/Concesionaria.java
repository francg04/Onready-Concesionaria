package concesionaria;

import java.util.ArrayList;
import java.util.List;
import vehiculos.*;

public class Concesionaria
{
	List<Vehiculo> lista_vehiculos; 
	List<Vehiculo> vehiculos_ordenados; // Cree otra lista para tener las 2, la ordenada y la "desordenada". Pero se puede hacer con 1 sola, pero luego del proceso de ordenacion, quedaran en ese orden.
	List<Vehiculo> contiene; // En caso que se cambie el parametro de buqueda, permite almacenar mas de 1 valor (en caso de existir) y mostrar los resultados.
	Vehiculo mas_caro;
	Vehiculo mas_barato;
	
	public Concesionaria()
	{
		lista_vehiculos = new ArrayList<Vehiculo>();
		contiene = new ArrayList<Vehiculo>();
		mas_caro = null;
		mas_barato = null;
		cargar_datos();
		mas_caro_y_mas_barato();
		ordenar_de_mayor_a_menor();
	}
	private void cargar_datos()
	{
		lista_vehiculos.add(new Auto("Peugeot", "206", 200_000, 4));
		lista_vehiculos.add(new Moto("Honda", "Titan", 60_000, "125cc"));
		lista_vehiculos.add(new Auto("Peugeot", "208", 250_000, 5));
		lista_vehiculos.add(new Moto("Yamaha", "YBR", 80_500.5, "160cc"));
	}
	private void mas_caro_y_mas_barato()
	{
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
	}
	private void ordenar_de_mayor_a_menor()
	{
		vehiculos_ordenados = new ArrayList<Vehiculo>();
		for (Vehiculo x:lista_vehiculos)
		{
			vehiculos_ordenados.add(x);
		}
		for(int x=0; x<vehiculos_ordenados.size(); x++)
		{
			for (int y=0+x; y<vehiculos_ordenados.size(); y++ )
			{
				if(vehiculos_ordenados.get(x).getPrecio() < vehiculos_ordenados.get(y).getPrecio())
				{
					Vehiculo backup = vehiculos_ordenados.get(x);
					vehiculos_ordenados.set(x, vehiculos_ordenados.get(y));
					vehiculos_ordenados.set(y, backup);
				}
			}
		}
	}
	private void contiene(char x)
	{
		for(Vehiculo vehiculo: lista_vehiculos)
		{
			if(Herramienta.contiene_letra(x, vehiculo.getModelo()))
			{
				contiene.add(vehiculo);
			}
		}
	}
	private void mostrar_vehiculos_contienen(char x)
	{
		contiene(x);
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
	}
	public void mostrarDatos()
	{
		for(Vehiculo vehiculo:lista_vehiculos)
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
		System.out.println("=============================");
		System.out.println("Vehiculos ordenados por precio de mayor a menor:");
		for(Vehiculo vehiculo: vehiculos_ordenados)
		{
			System.out.println(vehiculo.getVehiculo());
		}
	}
}
