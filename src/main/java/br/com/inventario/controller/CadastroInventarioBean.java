package br.com.inventario.controller;

import br.com.inventario.model.Inventario;
import br.com.inventario.model.Produto;
import br.com.inventario.model.ProdutoInserido;
import br.com.inventario.service.InventarioService;
import br.com.inventario.service.ProdutoService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named("cadastroInventarioBean")
@SessionScoped
public class CadastroInventarioBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private InventarioService service;

    @Inject
    private ProdutoService produtoService;

    private Inventario inventario;
    private Produto produto;
    private ProdutoInserido produtoInserido;
    private List<String> nomeProdutos;

    // Inicializador

    @PostConstruct
    public void init() {
        inventario = new Inventario();
        produto = new Produto();
        produtoInserido = new ProdutoInserido();
        nomeProdutos = produtoService.obterNomeProdutos();
    }

    // Métodos

    public void adicionar() {
        boolean produtoJaAdicionado = false;

        Produto p = produtoService.obterProduto(produto);

        if (p != null) {

            this.produtoInserido.setProduto(p);

            for (ProdutoInserido produtoInserido : inventario.getProdutosInseridos()) {
                if (this.produtoInserido.getProduto().equals(produtoInserido.getProduto())) {
                    produtoJaAdicionado = true;
                }
            }

            if (produtoJaAdicionado) {
                for (ProdutoInserido produtoInserido : inventario.getProdutosInseridos()) {
                    if (this.produtoInserido.getProduto().equals(produtoInserido.getProduto())) {

                        if (this.produtoInserido.getQuantidade() == null) {
                            this.produtoInserido.setQuantidade(1);
                        }

                        produtoInserido.setQuantidade(produtoInserido.getQuantidade()
                                + this.produtoInserido.getQuantidade());
                    }
                }
            } else {

                if (this.produtoInserido.getQuantidade() == null) {
                    this.produtoInserido.setQuantidade(1);
                }

                this.inventario.getProdutosInseridos().add(this.produtoInserido);
            }
            this.produto = new Produto();
            this.produtoInserido = new ProdutoInserido();
        }
    }

    public void salvar() {
        this.inventario.setDataDoInventario(new Date());
        service.salvar(inventario);

        init();
    }

    public List<String> consultaNomeProduto(String query) {
        List<String> nomeProdutosSugeridos = new ArrayList<>();

        for(String nome : this.nomeProdutos){

            if(nome.toLowerCase().startsWith(query.toLowerCase())){
                nomeProdutosSugeridos.add(nome);
            }
        }
        return nomeProdutosSugeridos;
    }

    // Getters e Setters

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<String> getNomeProdutos() {
        return nomeProdutos;
    }

    public ProdutoInserido getProdutoInserido() {
        return produtoInserido;
    }

    public void setProdutoInserido(ProdutoInserido produtoInserido) {
        this.produtoInserido = produtoInserido;
    }
}
