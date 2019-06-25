<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${ctx}/resources/css/reset.css" />
<link rel="stylesheet" href="${ctx}/resources/css/font-awesome.min.css" />
<link rel="stylesheet" href="${ctx}/resources/css/noto.sans.korea.css" />
<script src="${ctx}/resources/js/jquery-1.11.2.min.js"></script>
<script src="${ctx}/resources/js/bootstrap.min.js"></script>
<c:set var="submenu" >
    <decorator:getProperty property='meta.submenu' />
</c:set>
<decorator:head />
	<div class="container">
      <!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="${ctx}">TicToc Crocodile</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <%-- <li class="dropdown <c:if test="${submenu eq 'user'}">active</c:if>">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">사용자<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ctx}/user/list">사용자목록</a></li>
                  <li><a href="${ctx}/user/new">사용자등록</a></li>
                </ul>
              </li>
              <li class="dropdown <c:if test="${submenu eq 'quiz'}">active</c:if>">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">문제<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ctx}/quiz/list">문제목록</a></li>
                  <li><a href="${ctx}/quiz/new">문제등록</a></li>
                </ul>
              </li>
              <li class="dropdown <c:if test="${submenu eq 'notice'}">active</c:if>">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">공지사항<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ctx}/notice/list">공지사항목록</a></li>
                  <li><a href="${ctx}/notice/new">공지사항등록</a></li>
                </ul>
              </li>
              <li class="dropdown <c:if test="${submenu eq 'news'}">active</c:if>">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">뉴스<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ctx}/news/list">뉴스목록</a></li>
                  <li><a href="${ctx}/news/new">뉴스등록</a></li>
                </ul>
              </li>
              <li class="dropdown <c:if test="${submenu eq 'wrong'}">active</c:if>">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">오답노트<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ctx}/wrong/list">오답노트목록</a></li>
                  <li><a href="${ctx}/wrong/new">오답노트등록</a></li>
                </ul>
              </li>
              <li class="dropdown <c:if test="${submenu eq 'question'}">active</c:if>">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Q&A<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ctx}/question/list">Q&A목록</a></li>
                  <li><a href="${ctx}/question/new">Q&A등록</a></li>
                </ul>
              </li> --%>
              <li>
              	<a href="<c:url value="/logout" />" > Logout</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
</head>
<body>
<%-- body S --%>
		<decorator:body/>
<%-- body E --%>
</body>
</html>