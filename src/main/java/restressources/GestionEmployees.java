package restressources;


import entity.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("employees")
public class GestionEmployees {
    public static List<Employee> employees = new ArrayList();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> displayEmployeesList(){
        return employees;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addEmployee (Employee e){
        if(employees.add(e))
            return "Add successful";
        else return "Add failed";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateEmployee (Employee e){
        Employee emp = searchEmployee(e.getCin());
        if(emp != null){
            emp.setNom(e.getNom());
            emp.setPrenom(e.getPrenom());
            return "Update successful";
        }
        else return "Update failed";
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search/{CIN}")
    public Employee searchEmployee(@PathParam(value = "CIN") String cin){
        Employee e =null;
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).getCin().equals(cin)){
                e= employees.get(i);
            }
        }
        return e;
    }
    @DELETE
    @Path("{CIN}")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean deleteEmployee(@PathParam(value = "CIN") String cin){
        return employees.remove(searchEmployee(cin));
    }


}

