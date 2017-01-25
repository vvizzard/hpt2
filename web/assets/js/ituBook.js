$(".cnn").click(
	function()
	{     
		$.ajax
		(
			{
			   url : 'testLog',
			   type : 'POST',
			   data : 'et=' + document.getElementById("et").value,
			   dataType : 'html',
			   success : function(code_html, statut)
			   {
					if(code_html!=1)
					{
						document.getElementById("err").innerHTML = '<div class="form-group has-error " id="err"><label class="control-label col-sm-3" for="email">e-mail/tel:</label><div class="col-sm-9"><input type="email" class="form-control" id="et" placeholder="entrer votre e-mail"></div></div>';						
					}
					else
					{
						window.location.assign("../templates/accueil");
					}
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
);