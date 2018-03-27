package br.com.inventario.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.inventario.dao.Dao;
import br.com.inventario.model.Produto;
import br.com.inventario.util.hibernate.Transactional;
import br.com.inventario.util.jsf.FacesUtil;

public class ProdutoService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Dao<Produto> dao;

    @Transactional
    public void salvar(Produto produto) {
        try {
            dao.salvar(produto);
            FacesUtil.addInfoMessage("Sucesso!");
        } catch (Exception e) {
        	System.out.println("entrou no catch");
            FacesUtil.addErrorMessage("Error!");
        }
    }
    
    public List<Produto> listarTodos(){
    	return dao.listar(Produto.class);
    }
    
    public Produto obterProduto(Produto produto) {
    	try {
			return dao.obterProduto(produto);			
		} catch (Exception e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
    	return null;
    }
    
    public List<String> obterNomeProdutos(){
    	return dao.obterNomeProdutos();
    }
}
