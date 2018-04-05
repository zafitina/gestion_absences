var titre;
var current_date = new Date();

$(document).ready(

		function() {

			// valider session
			$('#valider').on(
					'click',
					function() {
						var id = $('#seance').val();
						var test = $('#groupe').val();
						test.forEach(function(element) {
							$.ajax({
								url : 'http://localhost:8080/session/update/'
										+ element + '/' + id,
								type : 'POST',
								success : function() {
									alert('ok');
								}
							});
						});
					});

			// changement liste salle
			$('#batiment').on(
					'change',
					function() {
						$('#salle').find('option').remove();
						$.ajax({
							url : 'http://localhost:8080/salle/byBuilding/'
									+ this.value,
							type : 'GET',
							dataType : 'json',
							success : function(json) {
								$('#salle').append(
										$('<option selected>').text(
												'Choisissez...').attr('value',
												0));
								$.each(json, function(i, value) {
									$('#salle').append(
											$('<option>').text(value.numero)
													.attr('value', value.id));
								});
							}
						});
					});
			// changement liste groupe
			$('#formation').on(
					'change',
					function() {
						$('#groupe').find('option').remove();
						$.ajax({
							url : 'http://localhost:8080/groupe/byFormation/'
									+ this.value,
							type : 'GET',
							dataType : 'json',
							success : function(json) {
								$.each(json, function(i, value) {
									$('#groupe').append(
											$('<option>').text(value.nom).attr(
													'value', value.id));
								});
							}
						});
					});

			// le calendrier
			$('#calendar').fullCalendar({
				defaultView : 'agendaWeek',
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'agendaWeek,agendaDay,month, addSession'
				},
				eventClick : function(eventObj) {
					if (eventObj.url) {
						return true;
					}
				},
				customButtons : {
					addSession : {
						text : 'Ajouter une séance',
						click : function() {
							window.open('createSession', '_self');
						}
					}
				},
				minTime : '08:00:00',
				maxTime : '21:30:00',
				// date actuelle
				defaultDate : current_date,
				locale : 'fr',
				navLinks : true,
				// navigate views
				selectable : true,
				selectHelper : true,
				editable : true,
				eventLimit : true,
				// affichage des données
				events : 'http://localhost:8080/session/events'
			});

		});
