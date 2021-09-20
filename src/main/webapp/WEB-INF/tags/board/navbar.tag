<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 
1. BoardController @Getmapping ("/list") 파라미터에 pageMaker를 대신하는 @모델어트리뷰트 ("cri") 값 입력 후
2. 네브바에서 c:if 태그를 제거한 후 사용
  -->
	<c:url value="/board/list" var="listUrl">
			<c:param name="pageNum" value="${cri.pageNum }"></c:param>
			<c:param name="amount" value="${cri.amount }"></c:param>
			<c:param name="keyword" value="${cri.keyword }"></c:param>
			<c:param name="type" value="${cri.type }"></c:param>			
	</c:url>
	
	<c:url value="/board/register" var="registerUrl">	
			<c:param name="pageNum" value="${cri.pageNum }"></c:param>
			<c:param name="amount" value="${cri.amount }"></c:param>
			<c:param name="keyword" value="${cri.keyword }"></c:param>
			<c:param name="type" value="${cri.type }"></c:param>					
	</c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${appRoot }/board/list">스프링 게시판</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
  
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
 
 <!--  c:url 설정한 값으로 href 링크 설정 -->    
        <a class="nav-link" href="${listUrl }"><i class="fas fa-list"></i> 목록보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${registerUrl }"><i class="fas fa-pen"></i> 글쓰기</a>
      </li>
    </ul>
  </div>


 
  <form action="${listUrl }" method="get" class="form-inline">
  	<select name="type" class="form-control mr-sm-2">
  		<option value="T" ${cri.type == "T" ? 'selected' : '' }>제목</option>
  		<option value="C" ${cri.type == "C" ? 'selected' : '' }>내용</option>
  		<option value="W" ${cri.type == "W" ? 'selected' : '' }>작성자</option>
  		<option value="TC" ${cri.type == "TC" ? 'selected' : '' }>제목 or 내용</option>
  		<option value="TW" ${cri.type == "TW" ? 'selected' : '' }>제목 or 작성자</option>
  		<option value="TWC" ${cri.type == "TWC" ? 'selected' : '' }>제목 or 내용 or 작성자</option>
  	</select>
<!-- 
<select>
1. 검색 이후, 검색 옵션 및 검색어를 유지시키고 싶은 경우
	일반적으로 option 태그 안에 selected란 어트리뷰트를 추가해주면 됨
1-1. <option value="T" selected > : 이 경우, 제목옵션이 선택되어 유지됨

2. 특정 경우에만 selected를 활성화 시키고 싶은 경우 3항을 사용함
2-1. <option value="T" ${cri.type == "T" ? 'selected' : '' }>제목</option>
	: cri.type이 T인 경우, selected로 설정해주고, 아닐 경우 빈 스트링('')으로 유지한다는 뜻
 -->
     <input name="keyword" value="${cri.keyword }" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    

    <input type="hidden" name="pageNum" value="1"> 
    <input type="hidden" name="amount" value="${cri.amount }">
<!-- 
<input >
1. 검색 이후에도 페이지를 유지하기 위해 hidden 타입의 input태그(pageNum & amount) 추가 
2. 검색시, 해당 첫페이지를 보여주기 위해 pageNume 프로퍼티의 value 값을 "1" 페이지로 설정해둠 
 -->
        
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>  
<!--
<form 41~>
1. type, keyword, pageNum, pageNum 총 4개의 파라미터가 넘어가는 것이고,  
2. 컨트롤러에서 이 4개의 값을 넘겨줘야 함 (Criteria에 내용 추가)

--> 
 
  
</nav>

<%--
[c:if 태그]

1. 뒤로가기 혹은 버튼 클릭 후 기존 목록으로 돌아가기 URL 
<c:url value="/board/list" var="listUrl">
	<c:if test="${not empty pageMaker }" >
		<c:param name="pageNum" value="${pageMaker.cri.pageNum }"></c:param>
		<c:param name="amount" value="${pageMaker.cri.amount }"></c:param>
	</c:if>
	<c:if test="${not empty cri }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
</c:url>

2. 뒤로가기 혹은 버튼 클릭 후 기존 글쓰기로 돌아가기 URL
<c:url value="/board/register" var="registerUrl">
	<c:if test="${not empty pageMaker }" >
		<c:param name="pageNum" value="${pageMaker.cri.pageNum }"></c:param>
		<c:param name="amount" value="${pageMaker.cri.amount }"></c:param>
	</c:if>
	<c:if test="${not empty cri }">
		<c:param name="pageNum" value="${cri.pageNum }"></c:param>
		<c:param name="amount" value="${cri.amount }"></c:param>
	</c:if>
</c:url> 
--%>