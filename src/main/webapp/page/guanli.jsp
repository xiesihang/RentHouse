<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  Object user=session.getAttribute("user");
  if(user==null){
    out.print("<script>location.href='login.jsp'</script>");
  }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0050)http://localhost:8080/HouseRent/manage!list.action -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD>
<TITLE>青鸟租房 - 用户管理</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type><LINK 
rel=stylesheet type=text/css href="../admin/css/style.css">
  <script src="../admin/js/jquery-1.8.3.js"></script>
<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../admin/images/logo.gif"></DIV>
<DIV class=search><span style="font-size: 15px">欢迎 ${sessionScope.user.name}</span>&nbsp;<LABEL class="ui-green searchs"><a href="fabu.jsp" title="">发布房屋信息</a></LABEL>
<LABEL class=ui-green><INPUT onclick='document.location="index.jsp"' value="退       出" type=button name=search></LABEL> 
</DIV></DIV>
<DIV class="main wrap">
<DIV id=houseArea>
<TABLE class=house-list>
  <TBODY>
<c:forEach var="info" items="${info.list}">
  <TR>
    <TD class=house-thumb><SPAN><A href="details.jsp" target="_blank"><img src="http://localhost:80/${info.path}" width="100" height="75" alt=""></A></SPAN></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">${info.title}</A></DT>
        <DD>${info.district}区${info.street},${info.floorage}平米,类型:${info.type}<BR>联系方式：${info.contact} </DD>
      </DL>
    </TD>
    <TD>
      <c:choose>
        <c:when test="${info.ispass==1}">已审核</c:when>
        <c:otherwise>未审核</c:otherwise>
      </c:choose>
    </TD>
    <TD class=house-type><LABEL class=ui-green><INPUT onclick="location.href='/page/selectOne?id=${info.id}'" value="修    改" type=button name=search></LABEL></TD>
    <TD class=house-price><LABEL class=ui-green><INPUT type=button value="删    除" onclick="javascript:del(${info.id})"></LABEL></TD></TR>
</c:forEach>
  </TBODY>
</TABLE>
</DIV>
<DIV class=pager>
<UL>
  <c:forEach begin="1" end="${info.pages}" step="1" var="i">
    <LI class=current><A id=widget_338868862
    href="/page/selectInfo?currPage=${i}"
    parseContent="true" showError="true" targets="houseArea"
    ajaxAfterValidation="false" validate="false"
  dojoType="struts:BindAnchor">${i}</A>
     </LI>
  </c:forEach>
</UL><SPAN class=total>${info.pageNum}/${info.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>

<script>
  function del(id) {
      if(confirm("确定删除吗?")){
          $.post("/page/deleteHouse",{"id":id},function (data) {
              if(data>=1){
                  alert("删除成功!")
                  location.href='/page/selectInfo'
              }
          },"json")
      }
  }
</script>