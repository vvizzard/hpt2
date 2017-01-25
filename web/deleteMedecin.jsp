<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    String bla = "";
    Login temp = new Login();                
    try{
        temp.deleteMedecin(request.getParameter("id"));        
    }
    catch(Exception s){
        bla = s.toString();
    }               
    if(bla.compareTo("")==0||bla.compareTo("org.postgresql.util.PSQLException: Aucun résultat retourné par la requête.")==0)request.getRequestDispatcher("goShow.jsp?id=&nom=&prenom=&dateNaissance1=1800-01-01&dateNaissance2=3000-01-01").forward(request, response);
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