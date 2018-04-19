/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.jws.WebService;


/**
 *
 * @author jonathan
 */
@WebService(endpointInterface = "database.UserDAOSOAPI")
public class SOAPImpl {
     SQLUserDAO sql = new SQLUserDAO();
    public UserDTO getStudent(String student_id) throws DALException{
       
        return sql.getStudent(student_id);
    }
    
    public List<UserDTO> getStudentList() throws DALException{
        return sql.getStudentList();
    }
    
    public  void createScore(UserDTO user){
        sql.createScore(user);
    }
    
}
