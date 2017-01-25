<%@page import="fonctions.DetailPayement"%>
<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    Login temp = new Login();                           
    String id = request.getParameter("idFact");
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    
    //DetailPayement detail = temp.getDetailPayementById(id);
%>

<jsp:include page="templates/header.jsp" />
   <div class = "container login lg">
    <form class="form-horizontal" action="goPayeff.jsp" method="GET">
        <input type="hidden" name ="idFact" value = "<% out.print(id);%>">
        <input type="hidden" name ="nom" value = "<% out.print(nom);%>">
        <input type="hidden" name ="prenom" value = "<% out.print(prenom);%>">
        Montant à payer :<input type="number" name="montant" placeholder="veuiller inserer le montant">
        <button type="submit" value="payer">
    </form>
</div>
<jsp:include page="templates/footer.jsp" />