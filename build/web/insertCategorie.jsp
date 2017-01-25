<jsp:include page="templates/header.jsp" />
<%@page import="fonctions.Login" %>
<% 
    Login temp = new Login();
    String[] specialite = temp.getSpecialite();                    
%>

<div class = "container login lg">
    <form class="form-horizontal" action="goIns.jsp" method="POST">
	  <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="nom">nom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="nom" placeholder="entrer le nom du medecin ici">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="prenom">prenom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="prenom" placeholder="entrer le prenom du medecin ici">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="dateNaissance">date de naissance:</label>
		<div class="col-sm-9">
		  <input type="date" class="form-control" name="dateNaissance">
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="salaire">salaire:</label>
		<div class="col-sm-9">
		  <input type="number" class="form-control" name="salaire" placeholder="entrer le salaire du medecin ici" >
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
	  <div class="form-group"> 
		<div class="col-sm-offset-3 col-sm-9">
		  <button type="submit" class="btn btn-default cnn" >inscrire</button>
		</div>
	  </div>
	</form>
</div>
<jsp:include page="templates/footer.jsp" />