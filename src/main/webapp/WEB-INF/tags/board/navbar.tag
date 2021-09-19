<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- 
<!-- 뒤로가기 혹은 버튼 클릭 후 기존 목록으로 돌아가기 URL  -->
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

<!-- 뒤로가기 혹은 버튼 클릭 후 기존 글쓰기로 돌아가기 URL  -->
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

<!-- 
1. BoardController @Getmapping ("/list") 파라미터에 pageMaker를 대신하는 @모델어트리뷰트 ("cri") 값 입력 후
2. 네브바에서 c:if 태그를 제거한 후 사용
  -->
	<c:url value="/board/list" var="listUrl">
			<c:param name="pageNum" value="${cri.pageNum }"></c:param>
			<c:param name="amount" value="${cri.amount }"></c:param>
	</c:url>
	
	<c:url value="/board/register" var="registerUrl">	
			<c:param name="pageNum" value="${cri.pageNum }"></c:param>
			<c:param name="amount" value="${cri.amount }"></c:param>
	</c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">스프링 게시판</a>
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
  
  <form class="form-inline">
  	<select name="type" class="form-control mr-sm-2">
  		<option value="">--</option>
  		<option value="T">제목</option>
  		<option value="C">내용</option>
  		<option value="W">작성자</option>
  		<option value="TC">제목 or 내용</option>
  		<option value="TW">제목 or 작성자</option>
  		<option value="TWC">제목 or 내용 or 작성자</option>
  	</select>

    <input name="keyword" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>  
  
</nav>