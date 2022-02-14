/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.EmailLogado;
import model.Usuario;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO {
    
    public void cadastrarUsuario(Usuario usuario) throws ExceptionDAO
    {
        String sql = "insert into usuario (nome, email, senha, valor_hora, carga_horaria_diaria, dias_ferias, pretensao_salarial) "
                + "value (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, usuario.getNome());
            pStatement.setString(2, usuario.getEmail());
            pStatement.setString(3, usuario.getSenha());
            pStatement.setFloat(4, usuario.getValor_hora());
            pStatement.setInt(5, usuario.getCarga_horaria_diaria());
            pStatement.setInt(6, usuario.getDias_ferias());
            pStatement.setFloat(7, usuario.getPretensao_salarial());
            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao cadastrar usuário: " + e);
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
    
    public void atualizarUsuario(Usuario usuario) throws ExceptionDAO
    {
        String sql = "update usuario set valor_hora = ?, carga_horaria_diaria = ?, dias_ferias = ?, pretensao_salarial = ? "
                + "where email = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setFloat(1, usuario.getValor_hora());
            pStatement.setInt(2, usuario.getCarga_horaria_diaria());
            pStatement.setInt(3, usuario.getDias_ferias());
            pStatement.setFloat(4, usuario.getPretensao_salarial());
            pStatement.setString(5, EmailLogado.getInstance().getEmail());
            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao atualizar usuário: " + e);
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
    
    public ResultSet autenticaUsuario(String email, String senha) throws ExceptionDAO
    {
        String sql = "select * from usuario where email = ? and senha = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, email);
            pStatement.setString(2, senha);
            ResultSet rs = pStatement.executeQuery();
            return rs;
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao logar: " + e);
        }
    }
    
    public float getValorHora()
    {
        float valor_hora = 0;
        String sql = "select valor_hora from usuario where email = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, EmailLogado.getInstance().getEmail());
            ResultSet rs = pStatement.executeQuery();
            while(rs.next())
            {
                valor_hora = rs.getFloat(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return valor_hora;
    }
    
}
