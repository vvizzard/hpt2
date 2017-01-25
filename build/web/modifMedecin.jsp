<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    Login temp = new Login();
    String[] specialite = temp.getSpecialite();
    
    String nom = "";//request.getParameter("nom");
    String prenom = "";//request.getParameter("prenom");
    String dateNaissance = "";//request.getParameter("dateNaissance");
    String dn = "";//dateNaissance.substring(8)+dateNaissance.substring(4,7)+'-'+dateNaissance.substring(0,4);
    String salaire = "";//request.getParameter("salaire");
    
    
    
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        dateNaissance = request.getParameter("dateNaissance");
        dn = dateNaissance.substring(8)+dateNaissance.substring(4,7)+'-'+dateNaissance.substring(0,4);
        salaire = request.getParameter("salaire");
        String id = request.getParameter("id");
    
%>

<div class = "container login lg">
    <form class="form-horizontal" action="goModifMedecin.jsp" method="GET">
	  <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="nom">nom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="nom" value="<%out.print(nom);%>">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="prenom">prenom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="prenom" value="<%out.print(prenom);%>">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="dateNaissance">date de naissance:</label>
		<div class="col-sm-9">
		  <input type="date" class="form-control" name="dateNaissance" value="<%out.print(dateNaissance);%>">
		</div>
	  </div>                
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="salaire">salaire:</label>
		<div class="col-sm-9">
		  <input type="number" class="form-control" name="salaire" value="<%out.print(salaire);%>" >
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="specialité">spécialité:</label>
		<div class="col-sm-9">
                    <select class="form-control" name="specialite">
                        <% for(int i = 0; i<specialite.length; i++)out.println("<option>"+specialite[i]+"</option>"); %>
                    </select>
		</div>
	  </div>
                    
                    <input type="hidden" name = "id" value="<%out.print(id);%>"
                    
	  <div class="form-group"> 
		<div class="col-sm-offset-3 col-sm-9">
		  <button type="submit" class="btn btn-default cnn" >modifier</button>
		</div>
	  </div>
	</form>
</div>
<jsp:include page="templates/footer.jsp" />