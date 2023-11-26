package co.com.bancolombia.model.animales.gateways;

import co.com.bancolombia.model.animales.Animales;

import java.util.List;
public interface AnimalesRepository {
    Animales createAnimales(Animales animales) throws Exception;

    Animales findAnimalesById(String id) throws Exception;

    Animales updateAnimalesById(String var1, Animales animales) throws Exception;

    boolean deleteAnimalesById(String id);

    List<Animales> getAllAnimales();

    List<Animales> getDomesticos();
}
