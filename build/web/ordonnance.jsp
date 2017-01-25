<%@page import="java.util.ArrayList"%>
<%@page import="fonctions.Article"%>
<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    Login temp = new Login();
    String[] specialite = temp.getSpecialite();                 
    Article[] medoc = temp.getListeMedicament();
%>

<div class = "container login lg">
    <h3><% out.print(request.getParameter("nom")); %>  <small><% out.print(request.getParameter("prenom")); %></small></h3> 
    <form class="form-horizontal" action="goFact.jsp" method="GET">           
        <input type="hidden" value ="<% out.print(request.getParameter("nom")); %>" name="nom">
        <input type="hidden" value ="<% out.print(request.getParameter("prenom")); %>" name="prenom">
        <div class="form-group" id="err">		
            <div class="col-sm-12">
                <input type="date" class="form-control" name="date">
            </div>
        </div>
        <div class="form-group" id="err">		
            <div class="col-sm-12">
              <input type="text" class="form-control" name="notif" placeholder="notification" >
            </div>
        </div>        
        <table class="table table-hover" id="tabfarany">
            <tr>
                <td>
                    <select class="form-control" name="medoc" id="med">
                        <% for(int i = 0; i<medoc.length; i++)out.println("<option>"+medoc[i].getNom()+"</option>"); %>
                    </select>
                </td>
                <td>
                    <input type="number" class="form-control" name="qt" id="qte" placeholder="quantite" >
                </td>
                <td>
                    <input type="text" class="form-control" name="pose" id="posologie" placeholder="posologie" >
                </td> 
                <td>
                    <input type="button" class="form-control" value="ajouter" onclick="ajouterMedicament()">
                </td>
            </tr>
            <tr>
                <th>medicament</th>
                <th>quantite</th>
                <th>posologie</th>                                
            </tr>                           
        </table>
        <script>
            function ajouterMedicament()
            {                                     
                $.ajax
                (
                    {
                       url : 'goMedocSession.jsp',
                       type : 'POST',
                       data : 'med=' +document.getElementById("med").value+'&qt='+document.getElementById("qte").value+'&pos='+document.getElementById("posologie").value,
                       dataType : 'html',
                       success : function(code_html, statut)
                       {                                                      
                            document.getElementById("tabfarany").innerHTML += "<tr><td>"+document.getElementById("med").value+"</td><td>"+document.getElementById("qte").value+"</td><td>"+document.getElementById("posologie").value+"</td></tr>";
                        },

                        error : function(resultat, statut, erreur)
                        {

                        },

                        complete : function(resultat, statut)
                        {

                        }
                    }
                );   
            }
        </script>
        
        <div class="col-sm-offset-9 col-sm-3">
          <button type="submit" class="btn btn-default cnn" >Facture</button>
        </div>            
        
    </form>
</div>
<jsp:include page="templates/footer.jsp" />