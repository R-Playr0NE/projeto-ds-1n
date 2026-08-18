package com.projeto1N.exemplo1N.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto1N.exemplo1N.Entity.Funcionario;
import com.projeto1N.exemplo1N.Entity.Produto;
import com.projeto1N.exemplo1N.Service.EmpresaService;
import com.projeto1N.exemplo1N.Service.FuncionarioService;
import com.projeto1N.exemplo1N.Service.ProdutoService;

@Controller
@RequestMapping("/produtoCTR")
public class ProdutoController {
    
    private final ProdutoService oProdutoService;
    private final EmpresaService oEmpresaService;

    public ProdutoController(
        ProdutoService oProdutoService,
        EmpresaService oEmpresaService) {

        this.oProdutoService = oProdutoService;
        this.oEmpresaService = oEmpresaService;
        }

    @GetMapping("/formCadastrar")
    public String showFormCadastrar(Model oModel) {
        
        oModel.addAttribute("produto", new Produto());
        oModel.addAttribute("empresas", oEmpresaService.listarEmpresas());

        return "cadastrarProduto";
    }

    @GetMapping("/listarAll")
    public String listarTodosProd(Model oModel) {

        oModel.addAttribute("produtos",
        oProdutoService.listarTodosProd());

        return "listarProduto";
    }

    @PostMapping("/salvarProduto")
    public String cadastrarProduto(@ModelAttribute Produto oProduto) {

        if(oProduto.getCodigo_prod() != null){
            oProdutoService.atualizarProduto(
                oProduto.getCodigo_prod(), oProduto);
        }
        else {
            oProdutoService.cadastrarProduto(oProduto);
        }

        oProdutoService.cadastrarProduto(oProduto);
        return "redirect:/produtoCTR/listarAll";
    }

    @GetMapping("editarProd/{id}")
    public String atualizarProduto(@PathVariable("id") Long id, Model oModel) {

        Produto produtoExistente =
        oProdutoService.buscarProdutoCodigo(id)
            .orElseThrow(() -> new IllegalArgumentException(
                "Produto não encontrado com o Código: " + id));

        oModel.addAttribute("produto", produtoExistente);
        oModel.addAttribute("empresas",oEmpresaService.listarEmpresas());

        return "cadastrarProduto";
    }

    @GetMapping("/deletarProd/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {

        oProdutoService.deletarProduto(id);
        return "redirect:/produtoCTR/listarAll";
    }

}
