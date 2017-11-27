$('#newsCountingTab').click(function() {
	$.ajax({
		url : "newsCounting.action",
		method : "get",
		dataType : "json",
		success : function(data, status, xhr) {
			if(data.length != 0) {
				$('#newsDocNum').html(setFormatComma(data[0]));
				$('#newsNoDocNo').html(setFormatComma(data[1]) + "( " + setFormatComma(data[2]) + " )");
				$('#newsEventNo').html(setFormatComma(data[3]) + "( " + setFormatComma(data[4]) + " )");
				$('#newsEntityNo').html(setFormatComma(data[5]));
			} else {
				alert("결과가 없습니다.");
			}
		},
		fail : function(data, status, xhr) {
			alert("다시 시도하세요.");
		}
	});
});

$('#promedCountingTab').click(function() {
	$.ajax({
		url : "promedCounting.action",
		method : "get",
		dataType : "json",
		success : function(data, status, xhr) {
			if(data.length != 0) {
				for(var i=0; i<data.length; i++) {
					$('#promedDocNo').html(setFormatComma(data[0]));
					$('#noPromedDocNo').html(setFormatComma(data[1]) + "( " + setFormatComma(data[2]) + " )");
					$('#promedEventNo').html(setFormatComma(data[3]) + "( " + setFormatComma(data[4]) + " )");
					$('#promedEntityNo').html(setFormatComma(data[5]));
				}
			} else {
				alert("결과가 없습니다.");
			}
		},
		fail : function(data, status, xhr) {
			alert("다시 시도하세요.");
		}
	});
});


function setFormatComma(x) {
	return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}