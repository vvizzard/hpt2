<%@page import="fonctions.DetailPayement"%>
<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    Login temp = new Login();        
    String nom = "";//request.getParameter("nom");
    String prenom = "";//request.getParameter("prenom");   
            
    nom = request.getParameter("nom");
    prenom = request.getParameter("prenom");        
    //String id = request.getParameter("id");
    
    DetailPayement[] liste = temp.getListDetailPayement(temp.getPatient(nom, prenom));
    
%>

<div class = "container login lg">
    <form class="form-horizontal" action="goPaye.jsp" method="GET">
        <h3><%out.print(nom);%> <small> <%out.print(prenom);%> </small></h3>                
        <table class="table table-hover" id="tabfarany">            
            <tr>
                <th>id_facture</th>
                <th>date limite</th>
                <th>montant totale</th>
                <th>montant paye</th>
                <th>reste a payer</th>
            </tr>
            <% for(int i = 0; i < liste.length; i++){ %>
            <tr>
                <td><% out.print(liste[i].getIdFacture()); %></td>
                <td><% out.print(liste[i].getDeadlineString()); %></td>
                <td><% out.print(Double.toString(liste[i].getMontant())); %></td>
                <td><% out.print(Double.toString(liste[i].getPaye())); %></td>
                <td><% out.print(Double.toString(liste[i].getReste())); %></td>
                <td><a href="goPaye.jsp?idFact=<% out.print(liste[i].getIdFacture()); %>&nom=<%out.print(nom);%>&prenom=<%out.print(prenom);%>">payer</a></td>
            </tr>
            <% } %>           
        </table>          
    </form>
</div>
<jsp:include page="templates/footer.jsp" />