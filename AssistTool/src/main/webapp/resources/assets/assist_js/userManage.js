function changeUserType(id) {
	var userType = $('#user'+id).attr('class');
	var selectUserType = $('#userType'+ id +' option:selected').val();
	var selectTypeName = $('#userType'+ id +' option:selected').text();
	if( userType == selectUserType) {
		alert("기존의 유형과 동일합니다. 변경할 사용자 유형을 선택하세요!");
		return;
	}
	
	$.ajax({
		url : "changeUserType.action",
		data : { mId : id, mUserType : selectUserType},
		method : "get",
		success : function(data, stratus, xhr) {
			$('#user'+id).html(selectTypeName);
			$('#user'+id).attr('class', selectUserType);
			alert("변경되었습니다!");
		},
		fail : function(data, status, xhr) {
			alert("다시 시도하세요.");
		}
	});
};
function deleteMember(id) {
	if(confirm(" 정말 삭제하시겠습니까? ")) {
		$.ajax({
			url : "deleteMember.action",
			data : { mId : id },
			method : "get",
			success : function(data, stratus, xhr) {
				$('#low'+id).remove();
				alert("삭제되었습니다!");
			},
			fail : function(data, status, xhr) {
				alert("다시 시도하세요.");
			}
		});
	} else {
		return;
	}
};
