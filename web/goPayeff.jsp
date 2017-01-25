<%@page import="fonctions.Payement"%>
<%@page import="fonctions.DetailPayement"%>
<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<% 
    Login temp = new Login();                           
    String id = request.getParameter("idFact");
    String mt = request.getParameter("montant");
    
    DetailPayement detail = temp.getDetailPayementById(id);            
    String bla = "";
    Medecin[] tst = null;
    try{
        Payement pay = new Payement(mt,detail);
        temp.insertPayement(pay.getFacture().getIdFacture(), pay.getMontant());
        request.getRequestDispatcher("payement.jsp?nom="+request.getParameter("nom")+"&prenom="+request.getParameter("prenom")).forward(request, response);
    }
    catch(Exception e){
        bla = e.getMessage();
    }               
%>

<div class="container login lg">
    <div >
        <% if(bla.compareTo("")==0){ %>
        <table class="table table-hover">
            <tr>
                <th>id</th>
                <th>nom</th>
                <th>prenom</th>
                <th>date de naissance</th>
                <th>spécialité</th>
                <th>salaire</th>
            </tr>
            <% for(int i = 0; i<tst.length;i++){%>
            <tr>
                <td> <% out.print(tst[i].id); %> </td>
                <td> <% out.print(tst[i].nom); %> </td>
                <td> <% out.print(tst[i].prenom); %> </td>
                <td> <% out.print(tst[i].dateNaissance); %> </td>
                <td> <% out.print(tst[i].specialite);%></td>
                <td> <% out.print(tst[i].salaire.substring(0,tst[i].salaire.length()-1 ));%></td>
                <td><a href = "deleteMedecin.jsp?id=<%out.println(tst[i].id); %>">delete</td>
                <td><a href = "modifMedecin.jsp?id=<%out.println(tst[i].id); %>&&nom=<%out.println(tst[i].nom);%>&&prenom=<%out.println(tst[i].prenom);%>&&dateNaissance=<%out.println(tst[i].dateNaissance);%>&&salaire=<%out.println(tst[i].salaire);%>">modifier</td>
            </tr>
            <%}%>
        </table>
            <%} else{%>
            <p><%out.print(bla);%></p>
            <%}%>
    </div>
</div>  

<jsp:include page="templates/footer.jsp" />