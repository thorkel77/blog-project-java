<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<c:forEach items="${article}" var="article">

<table border = 2>
    <thead>
        <tr>
            <th >Titre</th>
            <th >Description</th>
           	<th>texte</th>
            <th >Date</th>
           
           
           
            
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><p> <c:out value="${ article.getTitre() }" /></p></td>
            <td><p> <c:out value="${ article.getDescription() }" /></p></td>
            <td><p> <c:out value="${ article.getTexte() }" /></p></td>
            <td><p> <c:out value="${ article.getDate() }" /></p></td>
        </tr>
    </tbody>
</table>
	

</table>








	</c:forEach>
	




</body>
</html>