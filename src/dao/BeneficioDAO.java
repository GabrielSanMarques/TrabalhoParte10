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
import model.Beneficio;
import model.EmailLogado;

/**
 *
 * @author Gabriel
 */
public class BeneficioDAO {
    
    public void cadastrarBeneficio(Beneficio beneficio) throws ExceptionDAO
    {
        String sql = "insert into beneficio set usuario_cod_usuario = (SELECT cod_usuario FROM usuario WHERE email = ?),"
                + "identificacao = ?, periodicidade = ?, valor = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try
        {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, EmailLogado.getInstance().getEmail());
            pStatement.setString(2, beneficio.getIdentificacao());
            pStatement.setString(3, String.valueOf(beneficio.getPeriodicidade()));
            pStatement.setFloat(4, beneficio.getValor());
            pStatement.execute();
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao cadastrar benefício: " + e);
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
    
    public ArrayList<Beneficio> listarBeneficios() throws ExceptionDAO
    {
        String sql = "select * from beneficio where usuario_cod_usuario in (select cod_usuario from usuario where "
                + "email = ?) order by cod_beneficio";
        Connection connection = null;
        PreparedStatement pStatement = null;
        
        ArrayList<Beneficio> beneficios = new ArrayList<Beneficio>();
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
                    Beneficio beneficio = new Beneficio(rs.getString("identificacao"), rs.getFloat("valor"), rs.getString("periodicidade").charAt(0));
                    beneficios.add(beneficio);
                }
            }
        }
        catch(SQLException e)
        {
            throw new ExceptionDAO("Erro ao consultar benefícios: " + e);
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
        
        return beneficios;
    }
    
}
