package br.com.inventario.dao;

import java.io.Serializable;
import java.util.List;

import br.com.inventario.model.Produto;

public interface Dao<T extends Serializable> extends Serializable {

    void salvar(T entidade) throws Exception;
    
    void alterar(T entidade) throws Exception;

    void remover(T entidade) throws Exception;

    List<T> listar(Class<T> classe);    
    
    T obterPorId(Class<T> classe, Object id) throws Exception;
    
    Produto obterProduto(Produto produto) throws Exception;
    
    List<String> obterNomeProdutos();
} 
