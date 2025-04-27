package lk.exon.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lk.exon.models.Stream;

import java.util.List;

public class StreamDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("educationPU");

    public List<Stream> getAllStreams() {
        EntityManager em = emf.createEntityManager();
        List<Stream> stream = em.createQuery("SELECT s FROM Stream s", Stream.class).getResultList();
        em.close();
        return stream;
    }
}
