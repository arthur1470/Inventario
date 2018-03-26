package br.com.inventario.service;

import br.com.inventario.dao.Dao;
import br.com.inventario.model.Produto;
import br.com.inventario.util.hibernate.Transactional;

import javax.inject.Inject;
import java.io.Serializable;

public class ProdutoService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Dao dao;

    @Transactional
    public void guardar(Produto produto) {
        try {
            dao.guardar(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
