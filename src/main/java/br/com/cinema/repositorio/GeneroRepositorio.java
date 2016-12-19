package br.com.cinema.repositorio;

import br.com.cinema.modelo.Genero;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class GeneroRepositorio {
    
    @Inject
    private EntityManager manager;
    
    public Genero porId(Integer id) {
        return manager.find(Genero.class, id);
    }
    
    public List<Genero> buscarGeneros(){
        return manager.createQuery("from Genero", Genero.class).getResultList();
    }
}
