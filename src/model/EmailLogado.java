/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gabriel
 */
public class EmailLogado {
    
    private static final long serialVersionUID = 1L;
    private static EmailLogado me;
    private String email;
 
    private EmailLogado(){
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public static EmailLogado getInstance() {
        if (me== null){
            me = new EmailLogado();
        }
        return me;
    }
}
