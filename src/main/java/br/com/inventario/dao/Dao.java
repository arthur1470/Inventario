package br.com.inventario.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Serializable> extends Serializable {

    void guardar(T entidade) throws Exception;

    void remover(T entidade) throws Exception;

    List<T> listar(Class<T> classe);
}
