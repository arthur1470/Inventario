package br.com.inventario.controller;

import br.com.inventario.model.Produto;
import br.com.inventario.service.ProdutoService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("cadastroProdutoBean")
@ViewScoped
public class CadastroProdutoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Produto produto;

    @Inject
    private ProdutoService service;

    public CadastroProdutoBean(){
        this.produto = new Produto();
    }

    public void salvar(){
        service.salvar(produto);
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
