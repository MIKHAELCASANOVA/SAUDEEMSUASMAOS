package com.saudeemsuasmaos.restapi.model;
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
    private long Prontuario_Sus;
    private String Endereco;
    private String Geneno;
    private String DataNascimento;
    private String NomeMae;
    private String Telefone;
    private String Email;
    private String Senha;

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

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

    public long getProntuario_Sus() {
        return this.Prontuario_Sus;
    }

    public void setProntuario_Sus(long Prontuario_Sus) {
        this.Prontuario_Sus = Prontuario_Sus;
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

    public String getDataNascimento() {
        return this.DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
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
 
}

