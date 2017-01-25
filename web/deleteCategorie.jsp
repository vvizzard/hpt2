<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    String bla = "";
    Login temp = new Login();                
    try{
        temp.deleteCategorie(request.getParameter("id"));        
    }
    catch(Exception s){
        if(s.toString().compareToIgnoreCase("org.postgresql.util.PSQLException: Aucun résultat retourné par la requête.")!=0)bla = "Vous ne pouvez pas supprimer cette catégorie car elle est utilisée";
        else bla = "";
    }               
    if(bla.compareTo("")==0)request.getRequestDispatcher("listeCategorie.jsp").forward(request, response);
    else{    
%>

<jsp:include page="templates/header.jsp" />
        <div class="container login lg">
            <p> <% out.println(bla); %> </p>
        </div>
    </body>
</html>
<%}%>
<jsp:include page="templates/footer.jsp" />