package com.saudeemsuasmaos.restapi.api;

import java.util.Optional;

import com.saudeemsuasmaos.restapi.model.Usuario;
import com.saudeemsuasmaos.restapi.repository.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/usuario")

public class UsuarioApi {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;      
    
    @PostMapping("/inserir")
    public Usuario inserir(@RequestBody Usuario usuario) {      
      this.usuarioRepositorio.save(usuario);
      return usuario;
    }
  
    @GetMapping("/obter/{id}")
    public Usuario view(@PathVariable("id") long id) {
      Optional<Usuario> gOpt = this.usuarioRepositorio.findById(id);
      if(gOpt.isPresent()){
        return gOpt.get();
      }
      return null;
    }
  
    @PutMapping("/atualizar/{id}")
    public Usuario update(@PathVariable("id") long id, @RequestBody Usuario usuario) {
      Optional<Usuario> gOpt = this.usuarioRepositorio.findById(id);
      if(gOpt.isPresent()){
        Usuario usuarioAlterar = gOpt.get();
        usuarioAlterar.setNome(usuario.getNome());
        usuarioAlterar.setCpf(usuario.getCpf());
        usuarioAlterar.setRg(usuario.getRg());
        usuarioAlterar.setEmail(usuario.getEmail());
        usuarioAlterar.setNumeroSus(usuario.getNumeroSus());
        usuarioAlterar.setEndereco(usuario.getEndereco());
        usuarioAlterar.setGeneno(usuario.getGeneno());
        usuarioAlterar.setDataNascimento(usuario.getDataNascimento());
        usuarioAlterar.setNomeMae(usuario.getNomeMae());
        usuarioAlterar.setTelefone(usuario.getTelefone());
        usuarioAlterar.setTipo(usuario.getTipo());
        
        this.usuarioRepositorio.save(usuarioAlterar);
        return usuarioAlterar;
      }
      return null;
    }
  
    @GetMapping("/obterTodos")
    public List<Usuario> getAll() {
      List<Usuario> gadgets = new ArrayList<>();
      this.usuarioRepositorio.findAll().forEach(gadgets::add);
      return gadgets;
    }
  
    // @GetMapping("/buscar/{filtro}")
    // public List<Usuario> buscar(@PathVariable("filtro") String filtro) {
    //   List<Usuario> usuarios = new ArrayList<>();
    //   this.usuarioRepositorio.Obter(filtro, filtro)
    //     .forEach(usuarios::add);
    //   return usuarios;
    // }
  
    @DeleteMapping("/deletar/{id}")
    public Usuario delete(@PathVariable("id") long id) {
      Optional<Usuario> gOpt = this.usuarioRepositorio.findById(id);
      if(gOpt.isPresent()){
        Usuario gToDelete = gOpt.get();
        this.usuarioRepositorio.delete(gToDelete);
        return gToDelete;
      }
      return null;
    }
    
}
