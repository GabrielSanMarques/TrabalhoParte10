/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.BeneficioDAO;
import dao.CustoDAO;
import dao.ExceptionDAO;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Beneficio{

    private String identificacao;
    private float valor;
    private char periodicidade;

    public Beneficio(){};
    
    public Beneficio(String identificacao, float valor, char periodicidade) {
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
     * @param identificacao the identificacao to set
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
    
    public void cadastrarBeneficio(Beneficio beneficio) throws ExceptionDAO
    {
        new BeneficioDAO().cadastrarBeneficio(beneficio);
    }
    
    public ArrayList<Beneficio> listarBeneficios() throws ExceptionDAO
    {
        return new BeneficioDAO().listarBeneficios();
    }
}

