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
   if(isNull(form1.Sname.value)){  
   alert("请输入员工姓名！"); 
   return false;
   }
   if(isNull(form1.Sgrade.value)){
   alert("请输入员工年级！");
   return false;
   }
   if(isNull(form1.Sjob.value)){
   alert("请选择员工职位！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改进货信息</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ReplenishUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Ino" type="text" class="noshow" id="Ino" value="<s:property value='cnbean.Ino'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>供应商名称：</td>
                    <td><input name="Proname" type="text" class="text2" id="Proname" value="<s:property value='cnbean.Proname'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>商品名称：</td>
                    <td><input name="Pname" type="text" class="text2" id="Pname" value="<s:property value='cnbean.Pname'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>商品大类：</td>
                    <td><input name="Vname" type="text" class="text2" id="Vname" value="<s:property value='cnbean.Vname'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>商品小类：</td>
                    <td><input name="Lname" type="text" class="text2" id="Lname" value="<s:property value='cnbean.Lname'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>进货价：</td>
                    <td><input name="Grossprice" type="text" class="text2" id="Grossprice" value="<s:property value='cnbean.Grossprice'/>"></td>
                  </tr>
                  <tr>
                      <td height="30" align="right"><span style="color:red;">*</span>进货数量：</td>
                      <td><input name="Inum" type="text" class="text2" id="Inum" value="<s:property value='cnbean.Inum'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>负责员工：</td>
                    <td><input name="Sno" type="text" class="text2" id="Sno" value="<s:property value='cnbean.Sno'/>"></td>
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