<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="sideLeft_div1">
	<div class="sideLeft_div2">
		<div data-testid="like" active="false" class="sideLeft_div3" id="likeBtn" onclick="boardLike(${boardSeq})"
			style="transform: scale(1);">
			<svg width="24" height="24" viewBox="0 0 24 24">
				<path fill="currentColor" d="M18 1l-6 4-6-4-6 5v7l12 10 12-10v-7z"></path></svg>
		</div>
		<div class="sideLeft_div4"></div>
		<div>
			<div class="sideLeft_div3" style="position: relative;" id="">
				<svg width="24" height="24" viewBox="0 0 24 24" class="share">
					<path fill="currentColor"
						d="M5 7c2.761 0 5 2.239 5 5s-2.239 5-5 5-5-2.239-5-5 2.239-5 5-5zm11.122 12.065c-.073.301-.122.611-.122.935 0 2.209 1.791 4 4 4s4-1.791 4-4-1.791-4-4-4c-1.165 0-2.204.506-2.935 1.301l-5.488-2.927c-.23.636-.549 1.229-.943 1.764l5.488 2.927zm7.878-15.065c0-2.209-1.791-4-4-4s-4 1.791-4 4c0 .324.049.634.122.935l-5.488 2.927c.395.535.713 1.127.943 1.764l5.488-2.927c.731.795 1.77 1.301 2.935 1.301 2.209 0 4-1.791 4-4z"></path></svg>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	const content = document.querySelector('.content');
	const wing = document.querySelector('.sideLeft_div1');
	//컨텐츠 영역부터 브라우저 최상단까지의 길이 구하기
	const contentTop = '100';
	
	window.addEventListener('scroll', function(){
	  if(window.scrollY >= contentTop){
	    wing.classList.add('fixed');
	  }else{
	    wing.classList.remove('fixed');
	  }
	});
	
</script>