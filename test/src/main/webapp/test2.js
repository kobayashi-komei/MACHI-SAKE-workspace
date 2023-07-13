$(function() {
	$('#ajax_show').on('click', function() {
		$.ajax({
			url: "ajaxselect",
			type: "GET",
			data: {
				"id": $("#id_number").val()
			},
			async: true,
		}).done(function(data) {
			$('#add_result').html("<p>ID番号" + data.id + "は「" + data.name + "」です");

			console.log("通信成功");
			console.log(data);
		}).fail(function(data) {
			console.log("通信失敗");
			console.log(data);
		});

		return false;

	});
});