package com.saudeemsuasmaos.restapi.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@Entity

public class Usuario {
    
    @Id    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String Nome;
    private long Cpf;
    private long Rg;
    private long NumeroSus;   
    private String Endereco;
    private String Geneno;
    private Date DataNascimento;
    private String NomeMae;
    private String Telefone;
    private String Email;
    private String Tipo;

  
    private String Senha;
    

    @Tolerate
    public Usuario(){
        
    }    

    public long getId() {
        return this.Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public long getCpf() {
        return this.Cpf;
    }

    public void setCpf(long Cpf) {
        this.Cpf = Cpf;
    }

    public long getRg() {
        return this.Rg;
    }

    public void setRg(long Rg) {
        this.Rg = Rg;
    }

    public long getNumeroSus() {
        return this.NumeroSus;
    }

    public void setNumeroSus(long numeroSus) {
        this.NumeroSus = numeroSus;
    }


    public String getTipo() {
        return this.Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }


    public String getEndereco() {
        return this.Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getGeneno() {
        return this.Geneno;
    }

    public void setGeneno(String Geneno) {
        this.Geneno = Geneno;
    }

    public Date getDataNascimento() {
        return this.DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getNomeMae() {
        return this.NomeMae;
    }

    public void setNomeMae(String NomeMae) {
        this.NomeMae = NomeMae;
    }

    public String getTelefone() {
        return this.Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
 
}

