<jsp:include page="templates/header.jsp" />
<div class = "container login lg">
	<form class="form-horizontal" >
	  <div class="form-group" id="err">
		<label class="control-label col-sm-3" for="email">e-mail/tel:</label>
		<div class="col-sm-9">
		  <input type="email" class="form-control" id="et" placeholder="entrer votre e-mail">
		</div>
	  </div>
	  <div class="form-group">
		<label class="control-label col-sm-3" for="pwd">Mot de passe:</label>
		<div class="col-sm-9"> 
		  <input type="password" class="form-control" id="pw" placeholder="entrer le mot de passe ici">
		</div>
	  </div>	  
	  <div class="form-group"> 
		<div class="col-sm-offset-3 col-sm-9">
		  <button type="button" class="btn btn-default cnn">connexion</button>
		</div>
	  </div>
	</form>
</div>
<jsp:include page="templates/footer.jsp" />