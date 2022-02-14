/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ExceptionDAO;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author Gabriel
 */
public class UsuarioController {
    
    public boolean cadastrarUsuario(String nome, String email, String senha, ArrayList<String> dias_trabalhados, int carga_horaria_diaria, int dias_ferias, float pretensao_salarial)
    {
        if(nome != null && nome.length() > 0 && email != null && email.length() > 0 && dias_trabalhados.size() > 0)
        {
            try
            {
                Usuario usuario = new Usuario(nome, email, senha, dias_trabalhados, carga_horaria_diaria, dias_ferias, pretensao_salarial);
                usuario.cadastrarUsuario(usuario);
                return true;
            }
            catch(ExceptionDAO e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean atualizarUsuario(ArrayList<String> dias_trabalhados, int carga_horaria_diaria, int dias_ferias, float pretensao_salarial)
    {
        if(dias_trabalhados.size() > 0)
        {
            try
            {
                Usuario usuario = new Usuario();
                usuario.setCarga_horaria_diaria(carga_horaria_diaria);
                usuario.setDias_ferias(dias_ferias);
                usuario.setDias_trabalhados(dias_trabalhados);
                usuario.setPretensao_salarial(pretensao_salarial);
                usuario.setValor_hora(usuario.calculaValor());
                usuario.atualizarUsuario(usuario);
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
