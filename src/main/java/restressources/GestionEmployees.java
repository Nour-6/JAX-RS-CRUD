package restressources;


import entity.Employee;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("employees")
@Api
public class GestionEmployees {
    public static List<Employee> employees = new ArrayList<Employee>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get All Employees")
    @ApiResponses({
            @ApiResponse(code=200,message = "Success")
    })

    public List<Employee> displayEmployeesList(){
     return employees;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Adding an employee")
    @ApiResponses({
            @ApiResponse(code=200,message = "Success")
    })

    public void addEmployee (@ApiParam(required = true) Employee e){
        employees.add(e);
    }

    @PUT
    @Path("{cin}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Updating an employee")
    @ApiResponses({
            @ApiResponse(code=204, message="Success"),
            @ApiResponse(code=404, message="Not Found")
    })
    public void updateEmployee (	@ApiParam(required = true) @PathParam("cin") String cin,
                                      @ApiParam(required = true) Employee e){
        Employee emp = searchEmployee(cin);
            emp.setNom(e.getNom());
            emp.setPrenom(e.getPrenom());
    }
    @GET
    @Path("{CIN}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get All Employees")
    @ApiResponses({
            @ApiResponse(code=200,message = "Success")
    })
    public Employee searchEmployee(@ApiParam(required = true)@PathParam(value = "CIN") String cin){
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
    @ApiOperation(value="Removes an employee")
    @ApiResponses({
            @ApiResponse(code=204, message="Success"),
            @ApiResponse(code=404, message="Not Found")
    })
    public void deleteEmployee(@ApiParam(required = true)@PathParam(value = "CIN") String cin){
         employees.remove(searchEmployee(cin));
    }


}

