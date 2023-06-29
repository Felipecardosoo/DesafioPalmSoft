package edu.felipe.catalogo.service;

import edu.felipe.catalogo.model.Produto;
import edu.felipe.catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto criarproduto(Produto produto){
        return produtoRepository.save(produto);
     }

    public Produto editarproduto(Long idProduto, Produto produtoinfnova) {
        Produto produtoinfantiga = new Produto();
        produtoinfantiga = produtoRepository.findById(idProduto).get();
        if(produtoinfnova.getNome() != null) {
            produtoinfantiga.setNome(produtoinfnova.getNome());
        }
        if(produtoinfnova.getValor() != null || !produtoinfnova.getValor().equals(0));
            produtoinfantiga.setValor(produtoinfnova.getValor());

        return produtoRepository.save(produtoinfantiga);
    }

    public void deletarproduto(Long idProduto) throws Exception {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        if(produto.isPresent()){
            if(produto.get().getValor().equals(new BigDecimal("10.00"))){
                throw new Exception("Não é possível deletar produtos com valor 10");
            }
            produtoRepository.delete(produto.get());
        }
    }
    public Produto buscarproduto(Long idProduto) {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        produtoRepository.getReferenceById(idProduto);
        return produto.get();
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();

    }



}



