/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ExceptionDAO;
import java.util.ArrayList;
import model.Custo;

/**
 *
 * @author Gabriel
 */
public class CustoController {
    public boolean cadastrarCusto(String identificacao, float valor, char periodicidade)
    {
        if(identificacao != null && identificacao.length() > 0)
        {
            try
            {
                Custo custo = new Custo(identificacao, valor, periodicidade);
                custo.cadastrarCusto(custo);
                return true;
            }
            catch(ExceptionDAO e)
            {
                e.printStackTrace();
            }   
        }
        return false;
    }
    
    public ArrayList<Custo> listarCustos() throws ExceptionDAO
    {
        return new Custo().listarCustos();
    }
}
