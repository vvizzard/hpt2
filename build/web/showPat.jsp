<jsp:include page="templates/header.jsp" />

<div class = "container login lg">
    <form class="form-horizontal" action="goShowPat.jsp" method="GET">
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="id">id:</label>
		<div class="col-sm-9">
                    <input type="text" class="form-control" name="id" placeholder="entrer le id" >
		</div>
	  </div>
	  <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="nom">nom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="nom" placeholder="entrer le nom du medecin ici" >
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="prenom">prenom:</label>
		<div class="col-sm-9">
		  <input type="text" class="form-control" name="prenom" placeholder="entrer le prenom du medecin ici" >
		</div>
	  </div>
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="dateNaissance1">date de naissance:</label>
		<div class="col-sm-9">
                    <input type="date" class="form-control" name="dateNaissance1" value="1800-01-01">
		</div>
	  </div>
        
          <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="dateNaissance2">date de naissance:</label>
		<div class="col-sm-9">
		  <input type="date" class="form-control" name="dateNaissance2" value="3000-01-01">
		</div>
	  </div>
          
	  <div class="form-group"> 
		<div class="col-sm-offset-3 col-sm-9">
		  <button type="submit" class="btn btn-default cnn" >Rechercher</button>
		</div>
	  </div>
	</form>
</div>
<jsp:include page="templates/footer.jsp" />