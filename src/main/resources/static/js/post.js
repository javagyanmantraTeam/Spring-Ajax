$(document).ready(
		function() {

			var url = window.location;

			// SUBMIT FORM
			$("#userForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					name : $("#name").val(),
					email : $("#email").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : url + "save",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == true) {
							$("#postResultDiv").html(
									"<strong>" + result.data.message
											+ "</strong>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

				// Reset FormData after Posting
				resetData();

			}

			function resetData() {
				$("#name").val("");
				$("#email").val("");
			}
		})