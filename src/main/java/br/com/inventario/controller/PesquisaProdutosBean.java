package br.com.inventario.controller;

import br.com.inventario.model.Produto;
import br.com.inventario.service.ProdutoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("pesquisaProdutosBean")
@SessionScoped
public class PesquisaProdutosBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private List<Produto> produtos;

    @Inject
    private ProdutoService service;

    public void init(){
        this.produtos = service.listarTodos();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
