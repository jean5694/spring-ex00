<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
</nav>