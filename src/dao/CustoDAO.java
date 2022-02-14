/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Custo;
import model.EmailLogado;

/**
 *
 * @author Gabriel
 */
public class CustoDAO {
    
    public void cadastrarCusto(Custo custo) throws ExceptionDAO
    {
        String sql = "insert into custo set usuario_cod_usuario = (SELECT cod_usuario FROM usuario WHERE email = ?),"
                + "identificacao = ?, periodicidade = ?, valor = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, EmailLogado.getInstance().getEmail());
            pStatement.setString(2, custo.getIdentificacao());
            pStatement.setString(3, String.valueOf(custo.getPeriodicidade()));
            pStatement.setFloat(4, custo.getValor());
            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao cadastrar custo: " + e);
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
    
    public ArrayList<Custo> listarCustos() throws ExceptionDAO
    {
        String sql = "select * from custo where usuario_cod_usuario in (select cod_usuario from usuario where "
                + "email = ?) order by cod_custo";
        Connection connection = null;
        PreparedStatement pStatement = null;
        
        ArrayList<Custo> custos = new ArrayList<Custo>();
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
                    Custo custo = new Custo(rs.getString("identificacao"), rs.getFloat("valor"), rs.getString("periodicidade").charAt(0));
                    custos.add(custo);
                }
            }
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao consultar custos: " + e);
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
        
        return custos;
    }
    
}
