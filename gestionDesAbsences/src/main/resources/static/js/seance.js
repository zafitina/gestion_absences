var titre;
var current_date = new Date();

$(document).ready(function() {

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
				text : 'Ajouter séance',
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
