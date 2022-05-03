<%-- 
    Document   : index
    Created on : 2/05/2022, 08:07:15 AM
    Author     : por_s
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <script type="text/javascript">
            function  submitForm(id) {
                document.getElementById(id).submit();
            }

        </script>
        
        
        <jsp:forward page="/home.do" /> 
    </body>
</html>
