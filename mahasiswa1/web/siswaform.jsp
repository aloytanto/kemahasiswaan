<%-- 
    Document   : siswaform
    Created on : May 28, 2018, 1:08:50 AM
    Author     : intel
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>mANAGEMEN SISWA</h1>
        <h2>
            <a href="/new">TAMBAH SISWA</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">LIHAT SISWA</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${siswa != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${siswa == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${siswa != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${siswa == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${siswa != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${book.title}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${book.author}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${book.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html
