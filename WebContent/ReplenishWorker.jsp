<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生超市管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">学生超市管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">进货管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="ReplenishManager.action">
                  <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="22%" height="30" style="padding-left:20px;"> 功能导航：  <a href="ReplenishAdd.action">新增进货</a></td>
                      <td width="78%">查询：
                        <select name="SearchRow" id="SearchRow">
                    
                          <option value="Proname">供应商名称</option>
                          <option value="Pname">商品名称</option>
                          <option value="Vname">商品大类名称</option>
                          <option value="Lname">商品小类名称</option>
                          <option value="Idate">进货日期</option>
                         
                        </select>
                        <input name="SearchKey" type="text" class="text1" id="SearchKey">
                        <input type="submit" name="button" id="button" value="点击查询"></td>
                    </tr>
                  </table>
                </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>进货编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>供应商名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>进货日期</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品大类</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品小类</strong></td>
                    <td bgcolor="#D5E4F4"><strong>进货价</strong></td>
                    <td bgcolor="#D5E4F4"><strong>进货数量</strong></td>
                    <td bgcolor="#D5E4F4"><strong>负责员工编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Ino}</td>
                      <td align="center">${Proname}</td>
                      <td align="center">${Pname}</td>
                      <td align="center">${Idate}</td>
                      <td align="center">${Vname}</td>
                      <td align="center">${Lname}</td>
                      <td align="center">${Grossprice}</td>
                      <td align="center">${Inum}</td>
                      <td align="center">${Sno}</td>
                      <td align="center"><a href="ReplenishUpdate.action?Ino=${Ino}">修改</a><a href="ReplenishDel.action?Ino=${Ino}" onClick="return confirm('确定要删除该产品吗？')">删除</a></td>
                     
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
