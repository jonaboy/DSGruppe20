/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package api_call_soap;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 *
 * @author jonathan
 */
@WebService
public interface Api_Call_Interface {
    @WebMethod
    ArrayList<String> getApiLovNummer();
    @WebMethod
    ArrayList<String> getApiLovTitel();
    @WebMethod
    ArrayList<String> getApiLovTitelKort();
    @WebMethod
    ArrayList<String> getApiLovResume();
    @WebMethod
    ArrayList<String> getApiLovHeader();
    @WebMethod
    void fetchData(final Runnable runnable);
   
    
    
    
    
}
