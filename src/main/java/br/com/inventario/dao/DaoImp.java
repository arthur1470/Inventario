package br.com.inventario.dao;

import org.hibernate.Session;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class DaoImp<T extends Serializable> implements Dao<T> {

    @Inject
    private Session session;

    public void guardar(T entidade) throws Exception {
        session.merge(entidade);
    }

    public void remover(T entidade) throws Exception {
        session.delete(entidade);
    }

    public List<T> listar(Class<T> classe) {
        return session.createQuery("FROM" + classe.getName()).list();
    }
}