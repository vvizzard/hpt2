<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    Login temp = new Login();
    String[] specialite = temp.getSpecialite();  
    String[] cat = temp.getCategorie();
%>

<div class = "container login lg">
    <table class="table table-hover">
        
        <% for(int i = 0; i<specialite.length; i++){%>
            <tr>
                <td><%out.println(specialite[i]);%></td>
                <td><a href = "deleteCategorie.jsp?id=<%out.println(cat[i]); %>">delete</td>
                <td><a href = "modifCategorie.jsp?id=<%out.println(cat[i]); %>&&nom=<%out.println(specialite[i]); %>">modifier</td>
            </tr> 
        <%}%>
    </table>
</div>
<jsp:include page="templates/footer.jsp" />