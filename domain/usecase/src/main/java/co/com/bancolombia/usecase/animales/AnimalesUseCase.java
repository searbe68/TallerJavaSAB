package co.com.bancolombia.usecase.animales;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AnimalesUseCase {

    private AnimalesRepository animalesRepository;

    public Animales createAnimales(Animales animales) throws Exception {

        animalesRepository.createAnimales(animales);

        return animales;
    }
    public boolean deleteAnimales(String id) throws Exception {
         return animalesRepository.deleteAnimalesById(id);
     }

    public Animales findAnimalesById(String id) throws Exception {
        return animalesRepository.findAnimalesById(id);
    }

    public Animales updateAnimalesById(String id, Animales animales) throws Exception {
        animalesRepository.updateAnimalesById(id, animales);
        return animales;
    }

    public boolean deleteAnimalesById(String id) {
        return animalesRepository.deleteAnimalesById(id);
    }

    public List<Animales> getAllAnimales() {
        return animalesRepository.getAllAnimales();
    }

    public List<Animales> getDomesticos(){
        return animalesRepository.getDomesticos();
    }
}
