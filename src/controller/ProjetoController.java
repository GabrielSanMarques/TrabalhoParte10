/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ExceptionDAO;
import java.util.Date;
import model.Projeto;

/**
 *
 * @author Gabriel
 */
public class ProjetoController {
    public boolean cadastrarProjeto(String identificacao, String descricao, String cliente, Date data_entrega, int horas_conclusao, float valor)
    {
        
        if(identificacao != null && identificacao.length() > 0 && descricao != null && descricao.length() > 0 && cliente != null && cliente.length() > 0)
        {
            try
            {
                Projeto projeto = new Projeto(identificacao, descricao, cliente, data_entrega, horas_conclusao, valor);
                projeto.cadastrarProjeto(projeto);
                return true;
            }
            catch(ExceptionDAO e)
            {
                e.printStackTrace();
            }   
        }
        return false;
    }
}
