$('#weeks').change(function() {
	$('.cont').remove();
	$.ajax({
		url : "fileList.action",
		data : { folderName : this.value},
		method : "get",
		dataType : "json",
		success : function(data, status, xhr) {
			for(var i=0; i<data.length; i++) {
				$('#fileList').append('<tr  class="cont"><td><input name="filename" type="checkbox" value="'+ data[i] +'"></td><td>'+data[i]+'</td><td class="1"></td><td class="2"></td><td class="3"></td></tr>');
			}
		},
		fail : function(data, status, xhr) {
			alert("다시 시도하세요.");
		}
	});
});

$('#assign').click(function() {
	var checked = false;
	$('input[name=filename]:checked').each(function() {
		checked = true;
		var filename = $(this).val();
		
		$.ajax({
			url : "assignWork.action",
			data : { worker : $('input[name=memberName]:checked').val(), week : $('#weeks').val(), fileName : filename, step : $('input[name=step]:checked').val() },
			method : "get",
			dataType : "json",
			success : function(data, status, xhr) {
				var worker = $('input[name=memberName]:checked').val();
				var step = $('input[name=step]:checked').val();
				var row = $('input[name=filename]:checked').attr('class');
				if(step.includes('1')) {
				
				} else if (step.includes('2')) {
					
				} else {
					
				}
			},
			fail : function(data, status, xhr) {
				alert("다시 시도하세요.");
			}
		});
		
		//alert($('#weeks').val()); //작업 주차 
		//alert($(this).val());	//선택 파일명
		//alert($('input[name=step]:checked').val()); //작업 단계 
		//alert($('input[name=memberName]:checked').val()); //작업자
	});
	
	if(!checked) {
		alert('파일을 선택해주세요.');
	}
});

$('#cancel').click(function() {
	var checked = false;
	$('input[name=filename]:checked').each(function() {
		checked = true;
		alert($('#weeks').val()); //작업 주차 
		alert($(this).val());	//선택 파일명
		alert($('input[name=step]:checked').val()); //작업 단계 
		alert($('input[name=memberName]:checked').val()); //작업자
	});
	
	if(!checked) {
		alert('파일을 선택해주세요.');
	}
});