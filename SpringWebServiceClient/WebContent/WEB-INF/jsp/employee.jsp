<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Employee</title>
	  
  <link href="<c:url value="/resources/css/employee-css.css"/>" rel="stylesheet" type="text/css">
	  
  <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-3.1.0.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/employee-validation.js"/>"></script>
  
 </head>
 <body>
 
<span style="float: right">
	<a href="<c:url value ="?lang=en"/>">en</a>
	| 
	<a href="<c:url value ="?lang=de"/>">de</a>
</span>
 
 
 <div class="employeeForm">
 <c:if test="${empty employee.id}">
 	<h2>Add Employee</h2>
 </c:if>
 <c:if test="${!empty employee.id}">
 	<h2>Update Employee</h2>
 </c:if>
  
  <div class="errorAndSuccessMessage">
	<label class="errorMessage" id="firstNameMissing">Please enter first name.</label>
	<label class="errorMessage" id="firstNameInvalid">Please enter valid first name.</label>
	<label class="errorMessage" id="lastNameInvalid">Please enter valid last name.</label>
	<label class="errorMessage" id="designationMissing">Please enter designation.</label>
	<label class="errorMessage" id="designationInvalid">Please enter valid designation.</label>
	<label class="errorMessage" id="companyNameMissing">Please enter company name.</label>
	<label class="errorMessage" id="companyNameInvalid">Please enter valid company name.</label>
  </div>
  
  <div>
  	<c:url var="employeeAction" value ="/saveOrUpdateEmployee"/>
  <form:form method="POST" action="${employeeAction}" commandName="employee">
      <table align="center">
      <c:if test="${!empty employee.id}">
       <tr>
           <td><form:label path="id">Employee ID:</form:label></td>
           <td><form:input path="id" readonly="true" id="employeeId"/></td>
       </tr>
       </c:if>
       <tr>
           <%-- <td><form:label path="firstName"><em>*</em>First Name:</form:label></td> --%>
           <td><form:label path="firstName"><em>*</em><spring:message code="label.firstname"/>:</form:label></td>
           <td><form:input path="firstName" id="firstName"/></td>
       </tr>
       <tr>
           <td><form:label path="lastName">Last Name:</form:label></td>
           <td><form:input path="lastName" id="lastName"/></td>
       </tr>
       <tr>
           <td><form:label path="designation"><em>*</em>Designation:</form:label></td>
           <td><form:input path="designation" id="designation"/></td>
       </tr>
       
       <tr>
           <td><form:label path="companyName"><em>*</em>Company Name:</form:label></td>
           <td><form:input path="companyName" id="companyName"/></td>
       </tr>
          <tr>
          	<td colspan="2">	
          	<c:if test="${empty employee.id}">
          		<input type="submit" value="Submit" id="addEmployee"/>
          	</c:if>
          	<c:if test="${!empty employee.id}">
          		<input type="submit" value="Update" id="updateEmployee"/>
          	</c:if>
          	<input type="button" value="Clear" id="clearEmployee"/>
          </td>
        </tr>
   </table> 
  </form:form>
  
  <c:if test="${!empty employeeList}">
  <h2>Employees List</h2>
 <table border="1" align="center" >
  <tr>
   <th>Employee ID</th>
   <th>First Name</th>
   <th>Last Name</th>
   <th>Designation</th>
   <th>Company</th>
   <th>Actions</th>
  </tr>

  <c:forEach items="${employeeList}" var="employee">
   <tr>
    <td><c:out value="${employee.id}"/></td>
    <td><c:out value="${employee.firstName}"/></td>
    <td><c:out value="${employee.lastName}"/></td>
    <td><c:out value="${employee.designation}"/></td>
    <td><c:out value="${employee.companyName}"/></td>
    <td align="center"><a href="updateEmployee/${employee.id}">Edit</a> | <a href="deleteEmployee/${employee.id}">Delete</a></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
 </div>
  
</div>

<script type="text/javascript">
$(document).ready(function(){
	/* Employee.validateEmployee();
	$('#clearEmployee').click(function(){
		Employee.clearEmployeeForm();
		Employee.hideAllMessage();
	}); */
});

</script>
<!-- 

// Datatable ajax call sample

<script> 
$(document).ready(function() {
	preventBack(); 
    $('#example').DataTable();
    
   var table = $('#example2').DataTable({
	   scrollY:        '50vh',
       scrollCollapse: true,
       paging:         false,
	   "ajax": {
            "url": "getRepTypMasters",
            "type": "POST",
            "dataSrc": ""
        },
        "columns": [
                    { "data": "rn" },
                    { "data": "cn" },
                    { "data": "rd" },
                    { 
                    	"data": null,
                    	//"defaultContent":'<a class="repEdit" href="#" style="color:#000;text-decoration:none;"><img src="<c:url value="/resources/images/edit.png" />" height="12px" width="12px" title="Edit"/> <spring:message code="label.edit"/></a>'
                    	"defaultContent":"<button>Edit</button>"
                    },
                    { 
	                   	"data": "rs",
                        render: function (data, type, row) {
                            var ddl = "<select>";
                            for (var i = 0; i < data.length; i++) {
                            	if(data == 1){
                            		ddl = ddl + "<option value='"+data+"'>Active</option>";
                            		ddl = ddl + "<option value='"+data+"'>In-Active</option>";
                            	}else{
                            		ddl = ddl + "<option value='"+data+"'>In-Active</option>";
                            		ddl = ddl + "<option value='"+data+"'>Active</option>";
                            	}
                                
                            }
                            ddl += "</select>";
                            return ddl;
                        }
                    },
                ],
    	language: {
            paginate: {
                previous	: "<spring:message code='datatable.previous'/>",
                next		: "<spring:message code='datatable.next'/>",
            },
        }
    });
    
    // Reading table Row data
    //$('#example2 tbody').on( 'click', 'button', function () {
    $(document).on( 'click', '#example2 tbody button', function () {
        console.log( table.row( this ).data() );
    } );
    
    
});


</script>
 -->
 </body>
</html>