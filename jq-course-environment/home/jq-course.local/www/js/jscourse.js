<!-- login\register dialog-->
var dialogContent =  "cdn.tutsplus.com/net/uploads/legacy/412_ajaxCalls/DEMO/ajax/load.php?_=1401360582565";
var test = "/templates/login/login-register-overlay.html"
$.ajaxSetup ({
	cache: false
});
$(function() {
	
	$("#hlogin").click(function() {
		$("#dialog").dialog().load(test);
	});
	
	function regexp(o, n, regexp) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			<!--updateTips(n);-->
			return false;
		} else {
			return true;
		}
	}
	
	$('body').on('click', "#logbtn", function() {
		var bValid = true;
		bValid = bValid && (
			regexp(
				$("#flogin"), 
				"Login should a valid emal or contain numbers and chars", 
				/^[_\.0-9a-zA-Z-]+$/)
			||
			regexp(
				$("#flogin"), 
				"Login should a valid emal or contain numbers and chars", 
				/^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i)
			);
		bValid = bValid && regexp(
			$("#fpass"),
			"Password must contain only numbers and chars", 
			/^[a-zA-Z]{3,16}$/);
		if (bValid) {
			$("#hlogin").html(function() {
				var name = $("#flogin").val();
				return "<p>You are logged in as <a id=\"loginLink\" href=\"#\">" + name + "</a></p>";
			});
			$("#dialog").closest('.ui-dialog-content').dialog('close');
		}
	});
	
	$("#regbutton").click(function() {
		var bValid = true;
		bValid = bValid && regexp("#femail", 
			"Email should a valid emal", 
			/^[_\.0-9a-zA-Z-]+@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,6}$/i);
		bValid = bValid && regexp("#floginnew",
			"Login contain numbers and chars", 
			/^[a-zA-Z]{3,16}$/);
	});
	
	
});