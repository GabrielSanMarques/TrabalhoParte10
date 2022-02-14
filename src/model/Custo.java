/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.CustoDAO;
import dao.ExceptionDAO;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Custo {

    private int codigo;
    private String identificacao;
    private float valor;
    private char periodicidade;
    
    public Custo(){};

    public Custo(String identificacao, float valor, char periodicidade) {
        this.identificacao = identificacao;
        this.valor = valor;
        this.periodicidade = periodicidade;
    }
    
    /**
     * @return the identificacao
     */
    public String getIdentificacao() {
        return identificacao;
    }

    /**
     * @param identificacao_ the identificacao to set
     */
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
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

    /**
     * @return the periodicidade
     */
    public char getPeriodicidade() {
        return periodicidade;
    }

    /**
     * @param periodicidade the periodicidade to set
     */
    public void setPeriodicidade(char periodicidade) {
        this.periodicidade = periodicidade;
    }
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void cadastrarCusto(Custo custo) throws ExceptionDAO
    {
        new CustoDAO().cadastrarCusto(custo);
    }
    
    public void atualizarCusto(Custo custo) throws ExceptionDAO
    {
        new CustoDAO().atualizarCusto(custo);
    }
    
    public void excluirCusto(Custo custo) throws ExceptionDAO
    {
        new CustoDAO().excluirCusto(custo);
    }
    
    public ArrayList<Custo> listarCustos() throws ExceptionDAO
    {
        return new CustoDAO().listarCustos();
    }
    
    
}
