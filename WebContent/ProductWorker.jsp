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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">产品信息管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
                <form name="form1" method="post" action="DomitoryManager.action">
                  <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="22%" height="30" style="padding-left:20px;"> 功能导航： </td>
                      <td width="78%">查询：
                        <select name="SearchRow" id="SearchRow">
                          <option value="Pname">商品名称</option>
                          <option value="Vname">商品大类</option>
                          <option value="Lname">商品小类</option>
                          
                        </select>
                        <input name="SearchKey" type="text" class="text1" id="SearchKey">
                        <input type="submit" name="button" id="button" value="点击查询"></td>
                    </tr>
                  </table>
                </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>商品编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>售价</strong></td>
                    <td bgcolor="#D5E4F4"><strong>大类编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>大类名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>小类编号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>小类名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>商品最低库存量</strong></td>
                    <td bgcolor="#D5E4F4"><strong>货架编号</strong></td>
                    

                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Pno}</td>
                      <td align="center">${Pname}</td>
                      <td align="center">${Sellprice}</td>
                      <td align="center">${Vno}</td>
                      <td align="center">${Vname}</td>
                      <td align="center">${Lno}</td>
                      <td align="center">${Lname}</td>
                      <td align="center">${Stockout_n}</td>
                      <td align="center">${Shelfno}</td>
                      
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
