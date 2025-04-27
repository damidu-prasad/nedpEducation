package lk.exon.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lk.exon.models.Subject;

import java.util.List;

public class SubjectDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("educationPU");

    public List<Subject> getAllSubjects() {
        EntityManager em = emf.createEntityManager();
        List<Subject> subjects = em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
        em.close();
        return subjects;
    }
}
