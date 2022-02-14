/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.ExceptionDAO;
import dao.ProjetoDAO;
import java.util.Date;

/**
 *
 * @author Gabriel
 */
public class Projeto {

    private String identificacao;
    private String descricao;
    private String cliente;
    private Date data_entrega;
    private int horas_conclusao;
    private float valor;

    public Projeto(String identificacao, String descricao, String cliente, Date data_entrega, int horas_conclusao, float valor) {
        this.identificacao = identificacao;
        this.descricao = descricao;
        this.cliente = cliente;
        this.data_entrega = data_entrega;
        this.horas_conclusao = horas_conclusao;
        this.valor = valor;
    }
        
    /**
     * @return the identificacao
     */
    public String getIdentificacao() {
        return identificacao;
    }

    /**
     * @param identificacao the identificacao to set
     */
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the data_entrega
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * @return the horas_conclusao
     */
    public int getHoras_conclusao() {
        return horas_conclusao;
    }

    /**
     * @param horas_conclusao the horas_conclusao to set
     */
    public void setHoras_conclusao(int horas_conclusao) {
        this.horas_conclusao = horas_conclusao;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
    public void cadastrarProjeto(Projeto projeto) throws ExceptionDAO
    {
        new ProjetoDAO().cadastrarProjeto(projeto);
    }
}
