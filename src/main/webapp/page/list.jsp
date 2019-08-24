<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0030)http://localhost:8080/House-2/ -->
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>青鸟租房 - 首页</TITLE>
<META content="text/html; charset=utf-8" http-equiv=Content-Type>
<LINK rel=stylesheet type=text/css href="../admin/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<script src="../admin/js/jquery-1.8.3.js"></script>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../admin/images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id=sform method=post action="/page/search">
    <input type="hidden" name="page" id="page" value="1">
    <h3 class=bold>房屋信息</h3>
    标题：<input id="title" type=text name=title value="${conditions.title}">&emsp;&emsp;
    类型: <select name="type" id="type">
            <option value="">请选择</option>
          </select>&emsp;&emsp;
    区域: <select name="district" id="district">
            <option value="">请选择</option>
          </select>&emsp;&emsp;
    街道: <select name="street" id="street">
            <option value="">请选择</option>
          </select>&emsp;&emsp;
    价格: <input type="text" size="8" name="start" value="${conditions.start}">&emsp;-&emsp;<input type="text" size="8" name="end" value="${conditions.end}">&emsp;&emsp;
    <LABEL class=ui-blue><INPUT type=submit value=搜索房屋></LABEL>
  </FORM>
</DL>
</DIV>



<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>
  <c:forEach var="info" items="${info.list}">
  <TR>
    <TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="http://localhost:80/${info.path}" width="100" height="75" alt=""></a></span></TD>
    <TD>
      <DL>
        <DT><A href="details.jsp" target="_blank">${info.title}</A></DT>
        <DD>${info.district}${info.street},${info.floorage}平米<BR>联系方式：${info.contact} </DD></DL></TD>
    <TD class=house-type>${info.type}</TD>
    <TD class=house-price><SPAN>${info.price}</SPAN>元/月</TD></TR>
  </c:forEach>
  <TR>无租房信息</TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:go(1)">首页</A></LI>
  <LI><A href="javascript:go(${info.prePage==0?1:info.prePage})">上一页</A></LI>
  <LI><A href="javascript:go(${info.nextPage==0?info.pages:info.nextPage})">下一页</A></LI>
  <LI><A href="javascript:go(${info.pages})">末页</A></LI></UL><SPAN
class=total>${info.pageNum}/${info.pages}页</SPAN> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
<script>
//加载所有类型
$(function(){  //加载事件
    //发送异步请求获取类型，进行显示
    $.post("selectTypeAll",null,function (data) {
        for(var i=0;i<data.length;i++){
            //创建节点
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            //追加节点
            $("#type").append(node);
        }
        //设置选中项
        $("#type").val(${conditions.type})
    },"json");
});



//加载所有区域
$(function(){  //加载事件
    //发送异步请求获取类型，进行显示
    $.post("selectDistrictAll",null,function (data) {
        for(var i=0;i<data.length;i++){
            //创建节点
            var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
            //追加节点
            $("#district").append(node);
        }
        //设置选中项
        $("#district").val(${conditions.district})
        loadStreet();
    },"json");
    //给区域添加改变事件
    $("#district").change(function () {
        loadStreet()
    });

    //加载街道
    function loadStreet() {
        //获取区域编号
        var id=$("#district").val();
        if(id!=""){
        //清空原有数据项
          $("#street>option:gt(0)").remove();
          $.post("selectStreetByDistrictId",{"id":id},function (data) {
              for(var i=0;i<data.length;i++){
                  //创建节点
                  var node=$("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
                  //追加节点
                  $("#street").append(node);
              }
              //设置选中项
              $("#street").val(${conditions.street})
          },"json")
      }
    }
});

//带条件分页(提交表单将当前页携带过去)
function go(p) {
  $("#page").val(p)
  $("#sform").submit()
}

</script>