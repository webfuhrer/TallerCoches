import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PrincipalTaller implements Constantes{

	public static void main(String[] args) {
	/*	Map<String, String> mapa=new HashMap();
		mapa.put("Alex", "alex@mail.com");
		mapa.put("Nico", "nico@mail.com");
		mapa.put("Sara", "sara@mail.com");
		
		Set<String> claves =mapa.keySet();
		Iterator<String> it=claves.iterator();
		while(it.hasNext())
		{
			String clave=it.next();
			String valor=mapa.get(clave);
			System.out.println("Clave: "+clave+" Valor: "+valor);
		}*/
		int opcion=EntradaSalida.pedirOpcion();
		Map<String, Coche> mapa_coches=AccesoBD.recuperarMapa();
		
		while(opcion!=SALIR)
		{
			switch(opcion)
			{
			case INSERTAR:
				String matricula=EntradaSalida.pedirMatricula();
				Coche c=EntradaSalida.pedirCoche();
				mapa_coches.put(matricula, c);
				break;
			case LISTAR:
				EntradaSalida.listarCoches(mapa_coches);
				break;
			case BUSCAR:
				ArrayList<String> marcas=AccesoBD.listarMarcas();//SELECT DISTINCT marca FROM t_taller
				String marca=EntradaSalida.pedirMarcaBuscada(marcas);
				ArrayList<Coche> lista_coches_marca=AccesoBD.buscarPorMarca(marca);
				Entrdasalida.mostrarcoches(lista_coches);
				break;
			}
		
		}
		AccesoBD.grabarMapa(mapa_coches);
	}

}
