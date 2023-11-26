package co.com.bancolombia.apirest;

import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.usecase.animales.AnimalesUseCase;
import java.io.IOException;
import java.util.List;
import lombok.Generated;

import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = {"/api"},
        produces = {"application/json"}
)
@ResponseBody
public class AnimalesController {
    private final AnimalesUseCase animalesUseCase;

    @PostMapping(path = {"/createAnimales"}
    )
    public void createAnimales(String name, String habitat, int numpatas, boolean gender, boolean isDomestic) {
        try {
            Animales animales1 = new Animales();
            animales1.setAnimalesname(name);
            animales1.setHabitat(habitat);
            animales1.setNumpatas(numpatas);
            animales1.setGenero(gender);
            animales1.setDomesticos(isDomestic);
            Animales animales = animalesUseCase.createAnimales(animales1);

            System.out.println("**** ANIMALES CREATED " + animales.toString());
        } catch (Exception var5) {
            String msg = var5.getMessage();
            //animalesController = new AnimalesController(animales, HttpStatus.UNPROCESSABLE_ENTITY, msg);
            System.out.println(msg);
        }

        /*return animalesController;*/
    }

    //@GetMapping(
    //        path = {"/animalesById/{id}"}
    //)
//    public Animales findAnimalesById(@PathVariable String id) throws IOException {
//        System.out.println("Finding Animales by id - From EP.");
//
//        //AnimalesController animalesController;
//        try {
//            Animales animales = animalesUseCase.findAnimalesById(id);
//            //animalesController = new AnimalesController(animales, HttpStatus.FOUND, "Animales founded.");
//            //System.out.println("**** " + HttpStatus.FOUND);
//            //return animalesController;
//        } catch (Exception var5) {
//            String msg = var5.getMessage();
//            //animalesController = new AnimalesController((Animales)null, HttpStatus.NOT_FOUND, msg);
//            System.out.println(msg + " " + HttpStatus.NOT_FOUND);
//           // return new Animales(animales);
//        }
//        //return animales;
//    }

    @PutMapping(
            path = {"/updateAnimales/{id}"}
    )
    public Animales updateAnimales(@PathVariable String id, String name, String habitat, int numpatas, boolean gender, boolean isDomestic) {
       try {
           Animales animales1 = new Animales();
           animales1.setId(id);
           animales1.setAnimalesname(name);
           animales1.setHabitat(habitat);
           animales1.setNumpatas(numpatas);
           animales1.setGenero(gender);
           animales1.setDomesticos(isDomestic);
           Animales animales = animalesUseCase.updateAnimalesById(id, animales1);
           System.out.println("**** ANIMALES UPDATED " + animales.toString());
           return animales;
        } catch (Exception var6) {
            String msg = var6.getMessage();
        //    animalesController = new AnimalesController((Animales)null, HttpStatus.BAD_REQUEST, msg);
            System.out.println(msg);
        }
       return null;
    }

    @DeleteMapping(
            path = {"/deleteAnimales/{id}"}
    )
    public boolean deleteAnimalesById(@PathVariable String id) {

        return animalesUseCase.deleteAnimalesById(id);
    }

    @GetMapping(
            path = {"/listAnimales/"}
    )
    public List<Animales> getAllAnimales() {
        List<Animales> animalesList;
        animalesList = animalesUseCase.getAllAnimales();
        return animalesList;
    }

    @GetMapping(
            path = {"/getDomesticos/"}
    )
    public List<Animales> getDomesticos() {
        List<Animales> animalesList;
        animalesList = animalesUseCase.getDomesticos();
        return animalesList;
    }

    @Generated
    public AnimalesController(AnimalesUseCase useCase) {
        this.animalesUseCase = useCase;
    }
}
