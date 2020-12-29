package vehiculos;

public class Auto extends Vehiculo
{
	private int puertas;
	public Auto()
	{
		super();
		puertas=0;
	}
	public Auto(String marca, String modelo, double precio, int puertas)
	{
		super(marca, modelo, precio);
		this.puertas=puertas;
	}
	public int getPuertas()
	{
		return puertas;
	}
	public void setPuertas(int puertas)
	{
		this.puertas = puertas;
	}
	
	public String toString()
	{
		return super.toString()+" // Puertas: "+puertas+" // Precio: $"+precio;
	}
}
