package herramientas;

import java.util.Iterator;

public class ListaGenerica<E> implements Iterator<E>, Iterable<E>
{
	class nodo{
		E valor;
		nodo siguiente;
	}
	private nodo raiz = null;
	private int cantidad = 0;
	private int indice = 0;
	
	public void agregar(E valor)
	{
		nodo nuevo = new nodo();
		nuevo.valor = valor;
		if(vacio())
		{
			nuevo.siguiente = raiz;
			raiz = nuevo;
		}
		else
		{
			nodo recorre = raiz;
			while(recorre.siguiente!=null)
			{
				recorre = recorre.siguiente;
			}
			nuevo.siguiente = recorre.siguiente;
			recorre.siguiente = nuevo;
		}
	}
	public E obtener(int indice)
	{
		nodo recorre = raiz;
		if(indice >= 0 && indice < cantidad())
		{
			for (int x=0; x < indice ; x++)
			{
				recorre = recorre.siguiente;
			}
			return recorre.valor;
		}
		return null;
	}
	public E quitar() // quita el ultimo elemento;
	{
		nodo recorre = raiz;
		E valor = null;
		if(cantidad() > 0)
		{
			if(cantidad() > 1)
			{
				nodo anterior = null;
				while(recorre.siguiente != null)
				{
					anterior = recorre;
					recorre = recorre.siguiente;
				}
				valor = anterior.siguiente.valor;
				anterior.siguiente = recorre.siguiente;
			}
			else
			{
				valor = raiz.valor;
				raiz = null;
			}
		}
		return valor;
	}
	public E quitar(int indice) // quita el elemento indicado
	{
		E valor = null;
		if (!vacio())
		{
			if(indice > -1 && indice < cantidad())
			{
				if(indice == 0)
				{
					valor = raiz.valor;
					raiz = raiz.siguiente;
				}
				else
				{
					nodo recorre = raiz;
					nodo anterior = recorre;
					int posicion = 0;
					while(posicion < indice)
					{
						anterior = recorre;
						recorre = recorre.siguiente;
						posicion++;
					}
					valor = recorre.valor;
					anterior.siguiente = recorre.siguiente;
				}
			}
		}
		return valor;
	}
	public void insertar(int posicion, E valor)
	{
		nodo nuevo = new nodo();
		nuevo.valor = valor;
		if(posicion == 0)
		{
			nuevo.siguiente = raiz;
			raiz = nuevo;
		}
		else
		{
			if(posicion > 0 && posicion <= cantidad())
			{
				nodo recorre = raiz;
				nodo anterior = recorre;
				int indice = 0;
				while(indice < posicion)
				{
					anterior = recorre;
					recorre = recorre.siguiente;
					indice++;
				}
				nuevo.siguiente = recorre;
				anterior.siguiente = nuevo;
			}
		}
	}
	public E remplazar(int posicion, E valor) // Devuelve el valor remplazado
	{
		E remplazado = null;
		if(!vacio())
		{
			nodo nuevo = new nodo();
			nuevo.valor = valor;
			if(posicion >= 0 && posicion < cantidad())
			{
				if(posicion == 0)
				{
					remplazado = raiz.valor;
					nuevo.siguiente = raiz.siguiente;
					raiz = nuevo;
				}
				else
				{
					nodo recorre = raiz;
					nodo anterior = recorre;
					for(int x = 0; x < posicion; x++)
					{
						anterior = recorre;
						recorre = recorre.siguiente;
					}
					remplazado = recorre.valor;
					nuevo.siguiente = recorre.siguiente;
					anterior.siguiente = nuevo;
				}
			}
		}
		return remplazado;
	}
	public int cantidad()
	{
		nodo recorre = raiz;
		int cantidad = 0;
		while(recorre != null)
		{
			recorre = recorre.siguiente;
			cantidad++;
		}
		return cantidad;
	}
	public void mostrar()
	{
		nodo recorre = raiz;
		while(recorre != null)
		{
			System.out.println(recorre.valor);
			recorre = recorre.siguiente;
		}
	}
	public boolean vacio()
	{
		if(raiz==null)
		{
			return true;
		}
		return false;
	}
	@Override
	public boolean hasNext()
	{
		if(obtener(indice) != null)
		{
			return true;
		}
		else
		{
			indice = 0;
			return false;
		}
	}
	@Override
	public E next()
	{
		E valor = null;
		if(hasNext())
		{
			valor = obtener(indice);
			indice++;
		}
		else
		{
			valor = obtener(indice);
		}
		return valor;
	}
	@Override
	public Iterator<E> iterator()
	{
		return this;
	}
}
