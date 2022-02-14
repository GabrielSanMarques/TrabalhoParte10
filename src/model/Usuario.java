/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.ExceptionDAO;
import dao.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    private float valor_hora;
    private ArrayList<String> dias_trabalhados;
    private int carga_horaria_diaria;
    private int dias_ferias;
    private float pretensao_salarial;

    public Usuario(){};
    
    public Usuario(String nome, String email, String senha, ArrayList<String> dias_trabalhados, int carga_horaria_diaria, int dias_ferias, float pretensao_salarial) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dias_trabalhados = dias_trabalhados;
        this.carga_horaria_diaria = carga_horaria_diaria;
        this.dias_ferias = dias_ferias;
        this.pretensao_salarial = pretensao_salarial;
        this.valor_hora = calculaValor();
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the valor_hora
     */
    public float getValor_hora() {
        return valor_hora;
    }

    /**
     * @param valor_hora the valor_hora to set
     */
    public void setValor_hora(float valor_hora) {
        this.valor_hora = valor_hora;
    }

    /**
     * @return the dias_trabalhados
     */
    public ArrayList<String> getDias_trabalhados() {
        return dias_trabalhados;
    }

    /**
     * @param dias_trabalhados the dias_trabalhados to set
     */
    public void setDias_trabalhados(ArrayList<String> dias_trabalhados) {
        this.dias_trabalhados = dias_trabalhados;
    }

    /**
     * @return the carga_horaria_diaria
     */
    public int getCarga_horaria_diaria() {
        return carga_horaria_diaria;
    }

    /**
     * @param carga_horaria_diaria the carga_horaria_diaria to set
     */
    public void setCarga_horaria_diaria(int carga_horaria_diaria) {
        this.carga_horaria_diaria = carga_horaria_diaria;
    }

    /**
     * @return the dias_ferias
     */
    public int getDias_ferias() {
        return dias_ferias;
    }

    /**
     * @param dias_ferias the dias_ferias to set
     */
    public void setDias_ferias(int dias_ferias) {
        this.dias_ferias = dias_ferias;
    }

    /**
     * @return the pretensao_salarial
     */
    public float getPretensao_salarial() {
        return pretensao_salarial;
    }

    /**
     * @param pretensao_salarial the pretensao_salarial to set
     */
    public void setPretensao_salarial(float pretensao_salarial) {
        this.pretensao_salarial = pretensao_salarial;
    }
    
    public void cadastrarUsuario(Usuario usuario) throws ExceptionDAO   
    {
        new UsuarioDAO().cadastrarUsuario(usuario);
    }
    
    public void atualizarUsuario(Usuario usuario) throws ExceptionDAO
    {
        new UsuarioDAO().atualizarUsuario(usuario);
    }
    
    public float calculaValor()
    {
       return (pretensao_salarial * 12)/((dias_trabalhados.size() * 52 - dias_ferias) * carga_horaria_diaria);
    }
    
}
