<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

<div  class="div-read0">
	
	<div class="container" style="padding: 0 4vw;">
		<div>
			<span class="title" id="title"></span>
		</div>
 		<div style="margin: 50px 0; float:left;">
			<span class="span-read0" id="regUserId"></span>
		</div>
		<div style="margin: 50px 0; float:right; display: none;" id="readDiv">
			<input type="button" class="btn-read0" id="" value="통계"/>
			<input type="button" class="btn-read0" onclick="boardUpdate()" value="수정"/>
			<input type="button" class="btn-read0" onclick="boardDel()" value="삭제"/>
		</div>
		<div class="contents" id="contents"></div>

	<form id="frm">
		<input type="hidden" id="boardSeq" name="boardSeq"/>
		<input type="hidden" name="status" value="R"/>
	</form>
	
	<div class="comment_div1" style="border-bottom: none; margin-top: 16rem;">
		<div class="comment_div2">
		<img class="card-img-custom3" alt="" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=">
			<div style="padding-left: 1rem">
				<span id="regUserNm" class="comment_span3">안민현</span>
				<span id="regUserNm" class="comment_span4">진행중</span>
			</div>
		</div>
	</div>
				
	<hr style="margin: 80px 0;">
				
	<div>
		<p style="font-weight: bold; font-size: 1.125rem;"><span id="commentCnt"></span>개의 댓글</p>
		<textarea class="textarea-comment" placeholder="댓글을 작성하세요." id="commentTxt"></textarea>
		<button class="btn-write3" style="float: right; margin-top: 20px;" data-depth="1" onclick="commentWrite()">댓글 작성</button>
	</div>
	
	<div id="comment"></div>
	
	<input type="hidden" id="loginUserId" value="${loginUserId}" name="loginUserId"/>
	</div>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$.ajax({
	    	type : "POST",
	        url : "/read",
	        data : {
	        	boardSeq : "${boardSeq}"
	        },
	        success : function(res){
	        	if(res.resultCode == "success"){
	        		
	        		const viewer = toastui.Editor.factory({
	        		    el : document.querySelector("#contents"),
	        		    viewer : true,
	        		    initialValue : res.data.content
	        		});
	        		
	        		$('#title').html(res.data.title);
	        		$('#regUserId').html(res.data.regUserId);
	        		$('#boardSeq').val(res.data.boardSeq);
	        		if(res.data.regUserId == '${loginUserId}') {
	        			$('#readDiv').css('display', 'block');
	        		}
	        		
	        		// 댓글
	        		var comment = res.data2;
	        		
	        		$('#commentCnt').html(comment.length);
	        		
	        		for(var i=0; i<comment.length; i++) {
	        			$('#comment').append("<div class=\"comment_div1\"> "
		        					 	+ "<div class=\"comment_div2\">"
			        						+ "<img alt=\"\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=\" class=\"card-img-custom2\">"
			        						+ "<div style=\"padding-left: 1rem\">"
				        						+ "<span class=\"comment_span\">" + res.data2[i].regUserId + "</span>"
				        						+ "<span class=\"comment_span2\">2일 전</span>"
			        						+ "</div>"	
				        				+ "</div>"
		        						+ "<p class=\"comment_p\">"
		        						+ res.data2[i].commentTxt
		        						+ "</p>"	
	        						+ "</div>"
	        						);
	        		}
	        		
	        		
	        		
	        	}
	        	else {
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
		
	});
	
	function boardUpdate() {
		const form = $('#frm');
		var formData = form.serialize();
		form.attr("action", "/write");
		form.submit();
	}
	
	function boardDel() {
		
		if(confirm("삭제하시겠습니까 ?")) {
			$.ajax({
		    	type : "POST",
		        url : "/board/delete",
		        data : {
		        	boardSeq : $('#boardSeq').val()
		        },
		        success : function(res){
		        	if(res.resultCode == "success"){
		        		alert("삭제되었습니다.");
		        		window.location.href = "/";
		        	}
		        	else {
		        		alert("삭제 중 오류가 발생하였습니다.");
		        	}
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown){
		            alert("통신 실패.")
		        }
		    });
		}
	}

	
	function commentWrite() {
		
		if($('#loginUserId').val() == null || $('#loginUserId').val() == '') {
			alert("로그인 후 작성 가능합니다.");
			return false;
		} 
		
		var params = {
				regUserId : $('#loginUserId').val(),
				boardSeq : $('#boardSeq').val(),
// 				groupNum : ,
				depth : 1,
				delYn : 'N',
				dept : $('#boardSeq').val(),
				commentTxt : $('#commentTxt').val()
		}
		
		$.ajax({
	    	type : "POST",
	        url : "/comment/write",
	        data : params,
	        success : function(res){
	        	if(res.resultCode == "success"){
	        		alert("등록되었습니다.");
	        		location.reload();
	        	}
	        	else {
	        		alert("등록 중 오류가 발생하였습니다.");
	        	}
	        },
	        error : function(XMLHttpRequest, textStatus, errorThrown){
	            alert("통신 실패.")
	        }
	    });
	}
	</script>
</div>