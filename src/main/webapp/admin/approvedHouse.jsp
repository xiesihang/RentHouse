<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>房屋管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
    <script src="js/approvedHouse.js"></script>
</head>
<body style="width: 100%;height: 100%">
<!--显示已审核房屋信息-->
<table id="dg"></table>

<!--制作工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        标题:<input id ="title" name ="title" type ="text" class="textbox" style ="width:130px;" />
        区域:<select name="district" id="district">
                <option value="">请选择</option>
            </select>
        街道:<select name="street" id="street">
                <option value="">请选择</option>
            </select>
        类型:<select name="type" id="type">
                <option value="">请选择</option>
            </select>
        <a id ="search" href ="javascript:search()" class="easyui-linkbutton" data-options="iconCls:'icon-search'," style ="margin-left:20px; padding:0 10px 0 10px;">查询</a>
    </div>
</div>

</div>
</body>


</html>
