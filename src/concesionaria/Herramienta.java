package concesionaria;

public abstract class Herramienta
{
	public static boolean contiene_letra(char letra, String oracion)
	{
		for(int i=0; i<oracion.length(); i++)
		{
			if (oracion.charAt(i)==letra)
			{
				return true;
			}
		}
		return false;
	}
}
