<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学校超市管理系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">学校超市管理系统</td>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改用户信息</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="UserUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Uno" type="text" class="noshow" id="Uno" value="<s:property value='cnbean.Uno'/>"></td>
                  </tr>

                  <tr>
                    <td height="30" align="right">：学号</td>
                    <td><input name="Cno" type="text" class="text2" id="Cno" disabled='disabled' value="<s:property value='cnbean.Cno'/>"></td>
                    
                  </tr>

                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>用户名：</td>
                    <td><input name="Username" type="text" class="text2" id="Username" value="<s:property value='cnbean.Username'/>"></td>
                    
                  </tr>

                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>密码：</td>
                    <td><input name="Password" type="text" class="text2" id="Password" value="<s:property value='cnbean.Password'/>"></td>
                    
                  </tr>

                  <tr>
                    <td height="30" align="right">：用户类型</td>
                    <td><input name="Type" type="text" class="text2" id="Type" disabled='disabled' value="<s:property value='cnbean.Type'/>"></td>
                    
                  </tr>
                 
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="确认修改">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
