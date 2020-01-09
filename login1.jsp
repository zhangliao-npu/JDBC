<%@ page language="java"import="java.util.*,cn.hpu.gu.*" pageEncoding="utf-8"%>

<%

String path =request.getContextPath();

String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

Login1.jsp

<!DOCTYPE HTML PUBLIC "-//W3C//DTDHTML 4.01 Transitional//EN">

<html>

  <head>

    <base href="<%=basePath%>">
   
    <title>My JSP 'login1.jsp' starting page</title>
   
    <meta http-equiv="pragma" content="no-cache">

    <meta http-equiv="cache-control" content="no-cache">

    <meta http-equiv="expires" content="0">   

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

    <meta http-equiv="description" content="This is my page">

    <!--

    <link rel="stylesheet"type="text/css" href="styles.css">

    -->
  </head>

  <body>

 <!--  修改成功！ <a href="login.jsp">返回主界面</a>  -->  

 

   <h3>增加或者修改后的信息   | <a href="login.jsp">返回主界面</a>  </h3>

  

   <table border="1"cellpadding="0" cellspacing="0"width="80%" align="center">

  <tr>

       <!--   <th>序号</th>-->

         <th>题目</th>

         <th>主讲</th>

         <th>地址</th>

         <th>主讲人单位</th>

         <th>时间</th>

         <th>内容</th>

         <th>发布时间</th>

         <th>操作</th>

  </tr>

    <%
           
                             //   XinxManager xm= new XinxManagerImp(); 

   

                          // List<Xinx> list = xm.getXinxs();

       

                         //  if(list!=null)

                       // {

                      //    for(int i=0; i<list.size(); i++)

                         // {

                                //   Xinx xin =list.get(i);
           
         Xinx xin =(Xinx)request.getAttribute("xin1");

          if(xin!=null)

    

    {
       
   %>

 <tr>

       <!--  <td><%=xin.getId()%></td>-->

        <td><%=xin.getTitle() %></td>

        <td><%=xin.getSpeaker() %></td>

        <td><%=xin.getAddress()%></td>

        <td><%=xin.getUnit() %></td>

        <td><%=xin.getTime() %></td>

        <td><%=xin.getContent() %></td>

        <td><%=xin.getDateposted()%></td>

       

        <td>

        <a href="DelServlet?id=<%=xin.getId() %>">删除</a>

        <a href="UpdateServlet1?id=<%=xin.getId() %>">修改</a> 

         <!-- 点击修改，执行UpdateServlet1，通过id获取要修改的信息，，，转到-->

        </td>  

  </tr> 

  <%

  //    }

   }

   %>

  </table> 

  </body>

</html>
