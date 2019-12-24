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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">销量信息</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="SaleManager.action">
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="22%" height="30" style="padding-left:20px;"> 功能导航： </td>
                      <td width="45%">查询：
                        <select name="SearchRow1" id="SearchRow1">
                          <option value="">--</option>
                          <option value="Pname">商品名称</option>
                          <option value="Vname">商品大类名称</option>
                          <option value="Lname">商品小类名称</option>
                          <option value="Ttime">销售时间</option>
                        </select>
                        <input name="SearchKey1" type="text" class="text1" id="SearchKey1">
                        
                        <td width="33%">
                          <select name="SearchRow2" id="SearchRow2">
                            <option value="">--</option>
                            <option value="Pname">商品名称</option>
                            <option value="Vname">商品大类名称</option>
                            <option value="Lname">商品小类名称</option>
                            <option value="Ttime">销售时间</option>
                          </select>
                          <input name="SearchKey2" type="text" class="text1" id="SearchKey2">
                          <input type="submit" name="button" id="button" value="点击查询"></td>
                    </tr>
                  </table>
                </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>销售时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>购物单号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品大类</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品小类</strong></td>
                    <td bgcolor="#D5E4F4"><strong>消费者学号</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Ttime}</td>
                      <td align="center">${Gno}</td>
                      <td align="center">${Pname}</td>
                      <td align="center">${Vname}</td>
                      <td align="center">${Lname}</td>
                      <td align="center">${Cno}</td>
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
