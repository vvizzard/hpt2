<%@page import="java.util.Calendar"%>
<%@page import="fonctions.FactureFille"%>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="fonctions.FactureMere"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fonctions.Article"%>
<%@page import="javax.mail.Session"%>
<%@page import="fonctions.Login" %>
<%@page import="fonctions.Medecin" %>
<jsp:include page="templates/header.jsp" />
<%     
    Login temp = new Login();  
    Article[] listeArticle = temp.getListeArticle();
    FactureMere fm = new FactureMere(temp.getTva(),temp.getPatient(request.getParameter("nom"), request.getParameter("prenom")),request.getParameter("date"));
    ArrayList<FactureFille> ff = new ArrayList<FactureFille>();
    ff.add(new FactureFille(listeArticle[0],fm,"1","1"));
    ArrayList<String[]> listeAchat = (ArrayList<String[]>)session.getAttribute("liste");
    double somme = 0;
    for(int i = 0; i < listeAchat.size(); i++){
        for(int j = 0; j < listeArticle.length; j++){
            if(listeAchat.get(i)[0].compareTo(listeArticle[j].getNom())==0){
                ff.add(new FactureFille(listeArticle[j],fm,"1",listeAchat.get(i)[1]));
                somme+=ff.get(ff.size()-1).getMontant();
                break;
            }
        }
    }
    fm.setMontant(somme);
    temp.insertFactureMere(fm);
    fm.setId(temp.getFMId(fm));
    temp.insertPayement(fm.getId(), 0);
    for(int i = 0; i < ff.size(); i++)temp.insertFactureFille(ff.get(i));   
    session.invalidate();
%>
<div class = "container login lg">
    <h3><% out.print(request.getParameter("nom")); %>  <small><% out.print(request.getParameter("prenom")); %></small></h3> 
    <p><% out.print(fm.getDate()); %></p>
    <form class="form-horizontal" action="goFact.jsp" method="GET">        
        <input type="hidden" value ="<% out.print(request.getParameter("nom")); %>" name="nom">
        <input type="hidden" value ="<% out.print(request.getParameter("prenom")); %>" name="prenom">              
        <table class="table table-hover" id="tabfarany">            
            <tr>
                <th>medicament</th>
                <th>quantite</th>
                <th>montant</th>                                
            </tr>
            <% for(int i = 0; i < ff.size(); i++){ %>
            <tr>
                <td><% out.print(ff.get(i).getArticle().getNom()); %></td>
                <td><% out.print(ff.get(i).getQuantiteString()); %></td>
                <td><% out.print(Double.toString(ff.get(i).getMontant())); %></td>
            </tr>
            <% } %>
            <tr>
                <td>tva</td>
                <td> </td>
                <td><% out.print(Double.toString(fm.getTva()));%></td>
            </tr>
            <tr>
                <td>Montant total</td>
                <td> </td>
                <td><% out.print(Double.toString(fm.getMontantTTC()));%></td>
            </tr>
            <tr>
                <td>Date limite de payement</td>
                <td> </td>
                <td><% out.print(fm.getDate());%></td>
            </tr>
        </table>                            
        <div class="col-sm-offset-9 col-sm-3">
          <button type="submit" class="btn btn-default cnn" >Payer</button>
        </div>                    
    </form>
</div>
<jsp:include page="templates/footer.jsp" />