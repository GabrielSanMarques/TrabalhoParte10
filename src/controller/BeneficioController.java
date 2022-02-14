/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ExceptionDAO;
import java.util.ArrayList;
import model.Beneficio;

/**
 *
 * @author Gabriel
 */
public class BeneficioController {
    
    public boolean cadastrarBeneficio(String identificacao, float valor, char periodicidade)
    {
        if(identificacao != null && identificacao.length() > 0)
        {
            try
            {
                Beneficio beneficio = new Beneficio(identificacao, valor, periodicidade);
                beneficio.cadastrarBeneficio(beneficio);
                return true;
            }
            catch(ExceptionDAO e)
            {
                e.printStackTrace();
            }   
        }
        return false;
    }
    
    
    public ArrayList<Beneficio> listarBeneficios() throws ExceptionDAO
    {
        return new Beneficio().listarBeneficios();
    }
}
