package com.saudeemsuasmaos.restapi.repository;

import com.saudeemsuasmaos.restapi.model.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface  UsuarioRepositorio extends CrudRepository<Usuario,Long>{
    
   // Iterable<Usuario> Obter(String brand, String model);
}
