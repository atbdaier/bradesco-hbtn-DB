package models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Curso;

public class CursoModel {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!! - " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Curso findById(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Curso.class, id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar curso por ID !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public  List<Curso> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM Curso", Curso.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar todos os cursos !!!" + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao atualizar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.contains(curso) ? curso : em.merge(curso));
            em.getTransaction().commit();
            System.out.println("Curso deletado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao deletar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }
}