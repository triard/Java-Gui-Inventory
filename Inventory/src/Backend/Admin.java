/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;

/**
 *
 * @author Asus
 */
public class Admin extends Akun{

    @Override
    public String username() {
        String username ="admin";
        return username;
    }

    @Override
    public String password() {
        String password = "admin";
        return password;
    }

  
   
    
}
