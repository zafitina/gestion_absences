$(document).ready(function() {
	$('#tableEtu').DataTable({
		"processing" : true,
		"ajax" : {
			"url" : "http://localhost:8080/student/all",
			"dataType" : "json",
			"type" : "GET",
			"contentType" : "application/json",
			"dataSrc" : ""
		},
		"columns" : [ {
			"data" : "id"
		}, {
			"data" : "nom"
		}, {
			"data" : "prenom"
		}, {
			"data" : "mail"
		} ],
		"language" : {
			"decimal" : "",
			"emptyTable" : "No data available in table",
			"info" : "Showing _START_ to _END_ of _TOTAL_ entries",
			"infoEmpty" : "Showing 0 to 0 of 0 entries",
			"infoFiltered" : "(filtered from _MAX_ total entries)",
			"infoPostFix" : "",
			"thousands" : ",",
			"lengthMenu" : "Show _MENU_ entries",
			"loadingRecords" : "Loading...",
			"processing" : "Processing...",
			"search" : "Search:",
			"zeroRecords" : "No matching records found",
			"paginate" : {
				"first" : "First",
				"last" : "Last",
				"next" : "Next",
				"previous" : "Previous"
			},
			"aria" : {
				"sortAscending" : ": activate to sort column ascending",
				"sortDescending" : ": activate to sort column descending"
			}
		}
	});

	$('#tableEtu').DataTable({
		"processing" : true,
		"ajax" : {
			"url" : "http://localhost:8080/student/bySession/"+,
			"dataType" : "json",
			"type" : "GET",
			"contentType" : "application/json",
			"dataSrc" : ""
		},
		"columns" : [ {
			"data" : "id",
			"visible" : false
		}, {
			"data" : "nom"
		}, {
			"data" : "prenom"
		}, {
			"data" : "mail"
		} ],
		"language" : {
			"decimal" : "",
			"emptyTable" : "No data available in table",
			"info" : "Showing _START_ to _END_ of _TOTAL_ entries",
			"infoEmpty" : "Showing 0 to 0 of 0 entries",
			"infoFiltered" : "(filtered from _MAX_ total entries)",
			"infoPostFix" : "",
			"thousands" : ",",
			"lengthMenu" : "Show _MENU_ entries",
			"loadingRecords" : "Loading...",
			"processing" : "Processing...",
			"search" : "Search:",
			"zeroRecords" : "No matching records found",
			"paginate" : {
				"first" : "First",
				"last" : "Last",
				"next" : "Next",
				"previous" : "Previous"
			},
			"aria" : {
				"sortAscending" : ": activate to sort column ascending",
				"sortDescending" : ": activate to sort column descending"
			}
		}
	});

});
