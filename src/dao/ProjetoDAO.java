/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.EmailLogado;
import model.Projeto;

/**
 *
 * @author Gabriel
 */
public class ProjetoDAO {
    
     public void cadastrarProjeto(Projeto projeto) throws ExceptionDAO
    {
        String sql = "insert into projeto set usuario_cod_usuario = (SELECT cod_usuario FROM usuario WHERE email = ?)"
                + ", identificacao = ?, descricao = ?, cliente = ?, data_entrega = ?, horas_conclusao = ?, valor = ?";

        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, EmailLogado.getInstance().getEmail());
            pStatement.setString(2, projeto.getIdentificacao());
            pStatement.setString(3, projeto.getDescricao());
            pStatement.setString(4, projeto.getCliente());
            pStatement.setDate(5, new java.sql.Date(projeto.getData_entrega().getTime()));
            pStatement.setInt(6, projeto.getHoras_conclusao());
            pStatement.setFloat(7, projeto.getValor());

            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao cadastrar projeto: " + e);
        }
        finally
        {
            try
            {
                if(pStatement != null)
                    pStatement.close();
            }
            catch(SQLException e)
            {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
}
