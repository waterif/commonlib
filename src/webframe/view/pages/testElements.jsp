<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>test page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script language="javascript" src="<%=basePath%>/view/js/test.js" ></script>
</head>

<body>
	<form:form modelAttribute="test" method="post" action="test/hello.do">
	<table>
	    <tr><td>input标签：</td>
	        <td> <form:input path="username" /></td></<tr>
	        
        <tr><td>password标签：</td>
	        <td><form:password path="password"  onblur="checkPass(this);"/></td></<tr>
                           
        <tr><td>绑定boolean的checkbox标签：</td>
	        <td><form:checkbox path="testBoolean" /></td></<tr>
                           
        <tr><td>绑定Array的checkbox 标签：</td>
	        <td>
				<form:checkbox path="testArray" value="arrayItem 路人甲" />arrayItem 路人甲
        		<form:checkbox path="testArray" value="arrayItem 路人乙" />arrayItem 路人乙
        		<form:checkbox path="testArray" value="arrayItem 路人丙" />arrayItem 路人丙
        		<form:checkbox path="testArray" value="arrayItem 路人丁" />arrayItem 路人丁</td></<tr>
                            
        <tr><td>绑定Array的checkboxs 标签：</td>
	        <td><form:checkboxes path="selectArray" items="${test.testArray}" /></td></<tr>
                           
        <tr><td>绑定Map的checkboxs  标签：</td>
		    <td><form:checkboxes path="selectIds" items="${test.testMap}" /> </td></<tr>
                          
        <tr><td>绑定Integer的radiobutton 标签：</td>
		    <td>
			<form:radiobutton path="radiobuttonId" value="0" />0
        	<form:radiobutton path="radiobuttonId" value="1" />1
        	<form:radiobutton path="radiobuttonId" value="2" />2 </td></<tr>
        
        <tr><td>绑定Map的radiobuttons 标签：</td>
		    <td>
		    <form:radiobuttons path="selectId" items="${test.testMap}" /></td></<tr>
                           
        <tr><td>绑定Map的select 标签：</td>
		    <td>
		    <form:select path="selectId" items="${test.testMap}" /></td></<tr>
                            
        <tr><td>不绑定items数据直接在form:option添加的select 标签：</td>
            <td>
		    <form:select path="selectId">
			    <option>请选择人员</option>
			    <form:option value="1">路人甲</form:option>
			    <form:option value="2">路人乙</form:option>
			    <form:option value="3">路人丙</form:option>
		    </form:select></td></<tr>
		
        <tr><td>不绑定items数据直接在html的option添加的select 标签：</td>
            <td>
		    <form:select path="selectId">
				<option>请选择人员</option>
				<option value="1">路人甲</option>
				<option value="2">路人乙</option>
				<option value="3">路人丙</option>
			</form:select> </td></<tr>
		
        <tr><td>用form:option绑定items的select 标签：</td>
            <td>
		    <form:select path="selectId">
			    <option />请选择人员
                <form:options items="${test.testMap}" />
		    </form:select></td></<tr>
        
         <tr><td>时间格式化标签 标签：</td>
            <td> <form:input path="testTime" /></td></<tr>	            
            
         <tr><td>money格式化 标签：</td>
            <td> <form:input path="money" /></td></<tr>		  	    
		   
		 <tr><td>国际化展示 标签：</td>
            <td> <spring:message code="i18n.show"/></td></<tr>	
            	
        <tr><td>textarea 标签：</td>
            <td>
            <form:textarea path="remark" /></td></<tr>

		<tr> <td colspan="2"> <input type="submit" value="Submit" /> </td></tr>
	</table>
	</form:form>
</body>
</html>