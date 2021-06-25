package com.saudeemsuasmaos.restapi.api;

import java.util.Optional;

import com.saudeemsuasmaos.restapi.model.Usuario;
import com.saudeemsuasmaos.restapi.repository.UsuarioRepositorio;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
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
      //usuario.setNome("Leandro");
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
        Usuario gToEdit = gOpt.get();
        gToEdit.setNome(usuario.getNome());
        gToEdit.setCpf(usuario.getCpf());
        gToEdit.setEmail(usuario.getEmail());
        this.usuarioRepositorio.save(gToEdit);
        return gToEdit;
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
