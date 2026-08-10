package com.projeto1N.exemplo1N.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projeto1N.exemplo1N.Entity.Funcionario;
import com.projeto1N.exemplo1N.Repository.FuncionarioRepository;

import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {
    
    private final FuncionarioRepository oFuncionarioRepository;

    public FuncionarioService(FuncionarioRepository oFuncionarioRepository) {
        this.oFuncionarioRepository = oFuncionarioRepository;
    }

    public List<Funcionario> listarTodosFunc() {
        return oFuncionarioRepository.findAll();
    }

    public Funcionario cadastrarFuncionario(Funcionario oFuncionario) {
        return oFuncionarioRepository.save(oFuncionario);
    }

    public Optional<Funcionario> buscarFuncionarioId(Long id) {
        return oFuncionarioRepository.findById(id);
    }

    public void deletarFuncionario(Long id) {
        Funcionario funcionarioExcluir = buscarFuncionarioId(id)
            .orElseThrow(() -> new IllegalArgumentException(
                "Funcionario não encontrada com o ID: " + id));

        oFuncionarioRepository.delete(funcionarioExcluir);
    }

    @Transactional
    public void atualizarFuncionario(Long id, Funcionario dadosAlterar) {
        
        Funcionario funcE = buscarFuncionarioId(id)
            .orElseThrow(() -> new IllegalArgumentException(
            "Funcionario não encontrado com o ID: " + id));

        funcE.setNome_funcionario(dadosAlterar.getNome_funcionario());
        funcE.setCargo_funcionario(dadosAlterar.getCargo_funcionario());
        funcE.setSalario_funcionario(dadosAlterar.getSalario_funcionario());
        funcE.setEmpresaID(dadosAlterar.getEmpresaID());

    }

}
