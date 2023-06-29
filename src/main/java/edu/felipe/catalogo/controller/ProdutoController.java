package edu.felipe.catalogo.controller;
import edu.felipe.catalogo.model.Produto;
import edu.felipe.catalogo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/criar")
    private ResponseEntity<Produto> criarproduto(@RequestBody Produto produto){
        return ResponseEntity.ok(produtoService.criarproduto(produto));
    }

    @PutMapping("/editar/{idProduto}")
    private ResponseEntity<Produto> editarproduto(@PathVariable Long idProduto, @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.editarproduto(idProduto, produto));
    }

    @DeleteMapping("/deletar/{idProduto}")
    private ResponseEntity<Void> deletarproduto(@PathVariable Long idProduto) throws Exception {
        produtoService.deletarproduto(idProduto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{idProduto}")
    private ResponseEntity<Produto> buscarproduto(@PathVariable Long idProduto) {
        return ResponseEntity.ok(produtoService.buscarproduto(idProduto));
    }

    @GetMapping("/buscar")
    private ResponseEntity<List<Produto>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }


}
