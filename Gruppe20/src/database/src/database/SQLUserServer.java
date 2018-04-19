/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.xml.ws.Endpoint;

/**
 *
 * @author jonathan
 */
public class SQLUserServer {
    
    public static void main(String[] args) throws DALException{
    SOAPImpl soap = new SOAPImpl();
    
    
    
    System.out.print("ssss");
    Endpoint.publish("http://[::]:9911/SQL_Soap", soap);
    }
}
