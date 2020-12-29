package vehiculos;

public class Moto extends Vehiculo
{
	private String cilindrada;
	
	public Moto ()
	{
		super();
		setCilindrada("");
	}
	public Moto (String marca, String modelo, double precio, String cilindrada)
	{
		super(marca, modelo, precio);
		this.setCilindrada(cilindrada);
	}
	public String getCilindrada()
	{
		return cilindrada;
	}
	public void setCilindrada(String cilindrada)
	{
		this.cilindrada = cilindrada;
	}
	public String toString()
	{
		return super.toString()+" // Cilindrada: "+cilindrada+" // Precio: $"+precio;
	}
}
