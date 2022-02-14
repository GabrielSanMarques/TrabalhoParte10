/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
     
     public void atualizarProjeto(Projeto projeto) throws ExceptionDAO
    {
        String sql = "update projeto set identificacao = ?, descricao = ?, cliente = ?, data_entrega = ?, horas_conclusao = ?, valor = ? where (cod_projeto = ? and "
                + "usuario_cod_usuario in (select cod_usuario from usuario where email = ?))";
        PreparedStatement pStatement = null;
        Connection connection = null;
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, projeto.getIdentificacao());
            pStatement.setString(2, projeto.getDescricao());
            pStatement.setString(3, projeto.getCliente());
            pStatement.setDate(4, new java.sql.Date(projeto.getData_entrega().getTime()));
            pStatement.setInt(5, projeto.getHoras_conclusao());
            pStatement.setFloat(6, projeto.getValor());
            pStatement.setInt(7, projeto.getCodigo());
            pStatement.setString(8, EmailLogado.getInstance().getEmail());
            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao atualizar projeto: " + e);
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
    
    public void excluirProjeto(Projeto projeto) throws ExceptionDAO
    {
        String sql = "delete from projeto where cod_projeto = ? and usuario_cod_usuario in "
                + "(select cod_usuario from usuario where email = ?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, projeto.getCodigo());
            pStatement.setString(2, EmailLogado.getInstance().getEmail());
            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao excluir projeto: " + e);
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
     
    public ArrayList<Projeto> listarProjetos() throws ExceptionDAO
    {
        String sql = "select * from projeto where usuario_cod_usuario in (select cod_usuario from usuario where "
                + "email = ?) order by cod_projeto";
        Connection connection = null;
        PreparedStatement pStatement = null;
        
        ArrayList<Projeto> projetos = new ArrayList<Projeto>();
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, EmailLogado.getInstance().getEmail());
            ResultSet rs = pStatement.executeQuery();
            if(rs != null)
            {
                while(rs.next())
                {
                    Projeto projeto = new Projeto(rs.getString("identificacao"), rs.getString("descricao"), rs.getString("cliente"), rs.getDate("data_entrega"), rs.getInt("horas_conclusao"), rs.getFloat("valor"));
                    projeto.setCodigo(rs.getInt("cod_projeto"));
                    projetos.add(projeto);
                }
            }
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao consultar projetos: " + e);
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
        
        return projetos;
    }
}
