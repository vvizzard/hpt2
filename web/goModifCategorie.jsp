<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    String bla = "";
    Login temp = new Login();                
    try{
        temp.modifCategorie(request.getParameter("id"),request.getParameter("nom"));        
    }
    catch(Exception s){
        bla = s.toString();
    }               
    if(bla.compareTo("")==0||bla.compareTo("org.postgresql.util.PSQLException: Aucun résultat retourné par la requête.")==0)request.getRequestDispatcher("listeCategorie.jsp").forward(request, response);
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