package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.AnimalesEntity;
import co.com.bancolombia.model.animales.Animales;
import co.com.bancolombia.model.animales.gateways.AnimalesRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
@AllArgsConstructor
public class JPAAnimalesImpl implements AnimalesRepository {
    private JPARepositoryAdapter jpaRepositoryAdapter ;

    @PersistenceContext
    private EntityManager entityManager;

    public Animales createAnimales(Animales animales) throws IOException {
        if (!animales.getAnimalesname().isEmpty()) {
            String id = UUID.randomUUID().toString();
            animales.setId(id);
            jpaRepositoryAdapter.save(animales);
            return animales;
        } else {
            animales.setAnimalesname("");
            animales.setHabitat("");
            animales.setGenero(false);
            animales.setNumpatas(0);
            animales.setDomesticos(false);
            throw new IOException("---- Can't create this Animales. Name is missing - From Impl.");
        }
    }

    public Animales findAnimalesById(String id) throws IOException {
        Animales animales = jpaRepositoryAdapter.findById(id);
        if (animales != null) {
            return animales;
        } else {
            throw new IOException("Animales Id: " + id + " Doesn't Exists.");
        }
    }

    public Animales updateAnimalesById(String id, Animales animales) throws IOException {
        Animales animales1 = jpaRepositoryAdapter.findById(id);
        if (animales1 == null) {
            animales.setAnimalesname("");
            animales.setHabitat("");
            animales.setGenero(false);
            animales.setNumpatas(0);
            animales.setDomesticos(false);
            throw new IOException("---- Can't UPDATE, this Animales Does Not Exists. From Impl." + id);
        } else if (!animales.getAnimalesname().isEmpty()) {
            return jpaRepositoryAdapter.save(animales);
        } else {
            throw new IOException("---- Can't UPDATE because Name to update is missing. From Impl." + id);
        }
    }

    public boolean deleteAnimalesById(String id) {
        Animales animales = jpaRepositoryAdapter.findById(id);
        if (animales != null) {
            jpaRepositoryAdapter.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Animales> getAllAnimales() {
        return jpaRepositoryAdapter.findAll();
    }

    @Override
    public List<Animales> getDomesticos() {
        Query query = entityManager
                .createQuery("SELECT a FROM AnimalesEntity a WHERE a.domesticos = :v1");
        query.setParameter("v1", true);

        List<Animales> listAnimales = new ArrayList<Animales>();
        if(!query.getResultList().isEmpty()) {
            for (Object _a : query.getResultList()) {
                AnimalesEntity _animal = (AnimalesEntity) _a;
                Animales animal = new Animales();
                animal.setId(_animal.getId());
                animal.setAnimalesname(_animal.getAnimalesname());
                animal.setHabitat(_animal.getHabitat());
                animal.setNumpatas(_animal.getNumpatas());
                animal.setGenero(_animal.isGenero());
                animal.setDomesticos(_animal.isDomesticos());
                listAnimales.add(animal);
            }
        }
        return listAnimales;
    }
}