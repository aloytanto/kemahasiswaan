<%-- 
    Document   : siswalist
    Created on : May 28, 2018, 12:59:28 AM
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
        <h1>MANAJEMEN SISWA</h1>
        <h2>
            <a href="/">TAMBAH SISWA</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/listsiswa">LIHAT SEMUA SISWA</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>LIHAT DATA SISWA</h2></caption>
            <tr>
                <th>Nim</th>
                <th>Nama</th>
                <th>IPK</th>
              
                <th>Actions</th>
            </tr>
            <c:forEach var="siswa" items="${listsiswa}">
                <tr>
                    <td><c:out value="${Siswa.nim}" /></td>
                    <td><c:out value="${Siswa.nama}" /></td>
                    <td><c:out value="${Siswa.ipk}" /></td>
                   
                    <td>
                        <a href="/edit?id=<c:out value='${siswa.nim}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${siswa.nim}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>