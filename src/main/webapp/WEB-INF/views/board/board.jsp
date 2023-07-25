<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<div class="album py-5 bg-body-tertiary" style="min-height: 1150px;">

      <div class="row g-4" style="margin: 0 70px;">
      <c:forEach var="boardList" items="${boardList}">
        <div style="width: 300px; margin-left: 15px; margin-right: 15px;">
          <div class="card-custom">
            <c:if test="${boardList.thumbnail == null || boardList.thumbnail == ''}">
            	<svg class="bd-placeholder-img card-img-top" style="width:320px;height:170px;cursor: pointer;" xmlns="http://www.w3.org/2000/svg" onclick="viewPageMove(${boardList.boardSeq});" role="img" focusable="false"><rect width="320px" height="100%" fill="#55595c"></rect></svg>
            </c:if>
            <c:if test="${boardList.thumbnail != null && boardList.thumbnail != ''}">
            	<img alt="" src="${boardList.thumbnail}" style="width:320px;height:170px;cursor: pointer;"  onclick="viewPageMove(${boardList.boardSeq});"/>
            </c:if>
            <div class="" style="height: 120px; cursor: pointer; padding: 16px;" onclick="viewPageMove(${boardList.boardSeq});">
              <h4 class="h4-board">${boardList.title}</h4>
              <span class="p-board">${boardList.thumbnailTxt}</span>
            </div>
            <div class="card-body" style="height: 40px; padding-left: 15px;">
            	<small class="text-small">${boardList.regDate} &nbsp;&nbsp;·11개의 댓글</small>
            </div>
            <div class="card-body-custom">
           	 	<a class="card-a-custom" onclick="userSpaceMove();">
            		<img alt="" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAASbSURBVHgB7Z0tTytBFIYP914BDiQ4cIADB0EhwYFE8ifq7g/hJ2CRSCQ4kOCobF3ruHk3maS5aSnbdnfPOe/7JE0oCTvTnmc+dvbMsNbr9b5M0PLLBDUSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAOX+MhPX1dTs+Prbt7W3b3d21jY2N6ndgPB7bYDCw4XBor6+v9vHxUb1nIL0Ae3t7dn5+XgV9FhABYuC1v79f/Q4SPD8/28vLi2UmrQA/Cfx34O/wwjXu7u7S9gi/z87O/loyELTr62vb2tqyZcFQcXp6Wv2MXiEb6SaBCDwEWDVFqmykEgABOjo6sqbAtbNJkEaAi4uLRoNfQBmXl5eWhRQCIChlnG6Dk5OTVstrkvACYKLXxJg/D5RZ1hEiE14ABGIVs/26IPgZeoHQAiDwbYz7s4AA0XuB0AIsusizKsrycmRCC+Dhyz84OLDIhBUAra/rHgCgDpGHgbAC7OzsmBc81aUuYQXY3Nw0L3iqS13CCtDFrd8sPNWlLsoIIkcCkBNWAE8JGpGTRcIKgPw9L3iqS13CCvD5+Wle8FSXuoQVAJm8HlK0UAfUJSqhJ4Fvb2/WNcgcjkxoAfDld936oieKhhYAwX96erKuwJ6B6Oni4dcBIEAXvQAC//j4aNEJLwCC30UgUGaGzSIpVgLRC7Q5FKCsLFvG0iwFPzw8tBIUlIGyspDqWcD9/X2jEuDaKCMT6R4GIUBNzAlwzWzBByl3ByNYaK23t7dLP6vHfT6u9/7+bhlZ6/V6X5YYpI0jebRu/mD2wBfSHxCBngAv9ASQ4PDwsErhwvvJE0JGo1EV9H6/72KFsS1SCDAZyFngnh2vVUwSUV4WQUILULZnlR06aMGYqDW1QDN56khZho6+Ghh2DoBgXF1dTZ3koZWvcqWubECdtg0NZUQ+QiakAGjxOA9gHhABj4wXeWyMHgX5/j85Zwi9AXoeD4+n6xJOAASk7nbwkjyCGT0meXg/mcWDYOMsIJwShtaO3mWRHT/odaINCaHmAIsEHyCQOP6tHAHXFKVukSQIsxK4aPDbBnWMdG5ACAHwhUYIfgHzEwwjEXAvQFdHwCzLzc1NiC1jrgXA2I31/Ijbr1HnCEfKuRagq/N/VgXuJLzPB9wKgMBnOITJu8RuBUDXnwHvQ4FLAbDkGrnr/x8MBV7vClwKEHHWPw+vn8mdANlaf8FrL+BOgIytv+Dxs7kSAC0kY+sveOwFXAnQ5bGvbdH0A6m6uBLAw8GPTePtaFk3AmTv/gtYF/A0DLgRgKH1Fzx9VjcCIBuHBU89nRsBkKrFgqfNJm5SwpBGVc7fz/CvWKZRUsk9bS1PvzVMfI+OiiVHApAjAciRAORIAHIkADkSgBwJQI4EIEcCkCMByJEA5EgAciQAORKAHAlAjgQgRwKQIwHIkQDkSAByJAA5EoAcCUCOBCBHApAjAciRAORIAHIkADkSgBwJQI4EIOcfGjV2tEfztqEAAAAASUVORK5CYII=" class="card-img-custom">
            		<span>by <b>${boardList.userId}</b></span>
            	</a>
            	<div class="card-like-custom">
            		<svg width="24" height="24" viewBox="0 0 24 24" class="like-svg">
            			<path fill="currentColor" d="M18 1l-6 4-6-4-6 5v7l12 10 12-10v-7z"></path>
            		</svg>
            		0
            	</div>
            </div>
          </div>
        </div>
        </c:forEach>
      </div>
    
    <script type="text/javascript">
    	
    // 조회 페이지로 이동
    function viewPageMove(seq) {
    	window.location.href="/read?boardSeq=" + seq;
    }
    
    // 개인 사용자 공간으로 이동
    function userSpaceMove() {
//     	window.location.href="/read";
    }
   	</script>
  </div>