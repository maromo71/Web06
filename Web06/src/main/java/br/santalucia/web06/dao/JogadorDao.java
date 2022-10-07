package br.santalucia.web06.dao;

import br.santalucia.web06.model.Jogador;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class JogadorDao {
    @PersistenceContext
    private EntityManager em;
    private EntityTransaction tx;

    public JogadorDao(){

    }

    public void adicionar(Jogador jogador){
        em = JpaUtil.getEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.persist(jogador);
        tx.commit();
        em.close();
    }

    public List<Jogador> getJogadores(){
        em = JpaUtil.getEntityManager();
        List<Jogador> lista = new ArrayList<>();
        Query query = em.createQuery("select j from Jogador j");
        lista = query.getResultList();

        return lista;
    }

    public void remover(Jogador jogador){
        em = JpaUtil.getEntityManager();
        Jogador j = em.find(Jogador.class, jogador.getIdJogador());
        tx = em.getTransaction();
        tx.begin();
        em.remove(jogador);
        tx.commit();
        em.close();
    }

    public void editar(Jogador jogador){
        em = JpaUtil.getEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.merge(jogador);
        tx.commit();
        em.close();
    }

    public Jogador buscar(int idJogador){
        em = JpaUtil.getEntityManager();
        Jogador j = em.find(Jogador.class, idJogador);
        em.close();
        return  j;
    }
}
