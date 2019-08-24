<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类型管理</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery.easyui.min.js"></script><!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/type.js"></script>
</head>

<body style="width: 100%;height: 100%">
<!--显示所有区域-->
<table id="dg"></table>
<!--工具栏-->
<div id="ToolBar">
    <div style="height: 25px;">
        <a href="javascript:dialogs('insertType','添加类型')" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:dialogs('updateType','修改类型')" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:dialogs('deleteType','删除类型')" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">多项删除</a>
    </div>
</div>
<!--添加区域信息的对话框-->
<div id="insertType" class="easyui-dialog" buttons="#insertbuttons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="insertfrom" method="post"><!--新增表单-->
        <table>
            <tr>
                <td>类型名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name"  /></td>
            </tr>
        </table>
    </form>
</div>
<div id="insertbuttons">  <!--绑定按钮-->
    <a href="javascript:save('insertfrom','insertType')" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:cancel('insertType')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>



<!--修改区域信息的对话框-->
<div id="updateType" class="easyui-dialog" buttons="#updatebuttons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="updatefrom" method="post"><!--修改表单-->
        <table>
            <tr>
                <td>类型编号:</td>
                <td><input type="text" style="border: none" readonly class="easyui-validatebox" required
                           name="id" /></td>
            </tr>
            <tr>
                <td>类型名称:</td>
                <td><input type="text" class="easyui-validatebox" required
                           name="name" /></td>
            </tr>
        </table>
    </form>
</div>
<div id="updatebuttons">  <!--绑定按钮-->
    <a href="javascript:save('updatefrom','updateType')" class="easyui-linkbutton" iconCls="icon-ok">更新</a>
    <a href="javascript:cancel('updateType')" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>

</body>

</html>
