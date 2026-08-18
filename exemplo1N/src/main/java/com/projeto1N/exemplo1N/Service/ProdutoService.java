package com.projeto1N.exemplo1N.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Entity.Funcionario;
import com.projeto1N.exemplo1N.Entity.Produto;
import com.projeto1N.exemplo1N.Repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    
    private final ProdutoRepository oProdutoRepository;

    public ProdutoService(ProdutoRepository oProdutoRepository) {
        this.oProdutoRepository = oProdutoRepository;
    }

    public List<Produto> listarTodosProd() {
        return oProdutoRepository.findAll();
    }

    public Produto cadastrarProduto(Produto oProduto) {
        return oProdutoRepository.save(oProduto);
    }

    public Optional<Produto> buscarProdutoCodigo(Long id) {
        return oProdutoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        Produto produtoExcluir = buscarProdutoCodigo(id)
            .orElseThrow(() -> new IllegalArgumentException(
                "Produto não encontrada com o Código: " + id));

        oProdutoRepository.delete(produtoExcluir);
    }

    @Transactional
    public void atualizarProduto(Long id, Produto dadosAlterar) {
        
        Produto funcE = buscarProdutoCodigo(id)
            .orElseThrow(() -> new IllegalArgumentException(
            "Produto não encontrado com o Código: " + id));

        funcE.setNome_prod(dadosAlterar.getNome_prod());
        funcE.setPerco_prod(dadosAlterar.getPerco_prod());
        funcE.setEmpresaID(dadosAlterar.getEmpresaID());

    }

}
