//recupérer la liste id des étudiants dans un tableau
function getCheckboxes() {
	var checkboxes = [];
	$("input:checkbox[name=student]:checked").each(function() {
		checkboxes.push($(this).val());
	});
	return checkboxes;
}

$(document).ready(
		function() {
			// enregistrer les presences
			$('#savePresence').on(
					'click',
					function() {
						var checkboxes = getCheckboxes();
						var idsession = $('#showProf').val();
						for (var i = 0; i < checkboxes.length; i++) {
							$
									.ajax({
										url : 'http://localhost:8080/'
												+ idsession + '/'
												+ checkboxes[i]
												+ '/editPresence',
										type : 'POST',
										success : function() {
										}
									});
						}
					});
		});