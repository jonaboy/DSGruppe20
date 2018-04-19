/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

/**
 *
 * @author jespe
 */
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.DALException;
import database.SQLUserDAO;
import database.UserDAO;
import database.UserDTO;

@Path("/service")
public class UserService {
	
	UserDAO users = new SQLUserDAO();
	
	@Path("/student/{id}")
	@GET
	@Produces("application/json")
	public UserDTO findStudentOnId(@PathParam("id") String id) {
		
		UserDTO user = null;
		try {
			user = users.getStudent(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
        
	@Path("/score")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> ShowScores() {
//		String Users = "all users";
		List<UserDTO> allScores = null;
		try {
			allScores = users.getStudentList();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(allScores.toString());
		return allScores;
	}
        
}