package br.edu.ifpr.loja.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpr.loja.model.Produto; 
import br.edu.ifpr.loja.repository.ProdutoRepository;

@RestController
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository repository) {
        this.produtoRepository = repository;
    }

    @GetMapping("/produtos")
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    public Produto buscar(@PathVariable int id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PostMapping("/produtos")
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("produtos/{id}")
    public Produto atualizar(@PathVariable int id, @RequestBody Produto dados) {
        Produto produto = produtoRepository.findById(id).orElse(null);

        if (produto == null) {
            return null;
        }

        produto.setNome(dados.getNome());
        produto.setPreco(dados.getPreco());

        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public Produto excluir(@PathVariable int id) {
        Produto produto = produtoRepository.findById(id).orElse(null);

        if (produto == null) {
            return null;
        }

        produtoRepository.delete(produto);

        return produto;
    }

    @PatchMapping("/produtos/{id}")
    public Produto atualizarParcial(@PathVariable int id, @RequestBody Produto dados) {
        Produto produto = produtoRepository.findById(id).orElse(null);

        if (produto == null) {
            return null;
        }

        if (dados.getNome() != null) {
            produto.setNome(dados.getNome());
        }

        if (dados.getPreco() != 0.0) {
            produto.setPreco(dados.getPreco());
        }

        return produtoRepository.save(produto);
    }

    /*
     * Métodos crud HTTP:
     * 
     * GET -> Buscar/listar
     * POST -> Salvar
     * DELETE -> Deletar
     * PUT -> Atualizar/alterar
     * 
     */

}