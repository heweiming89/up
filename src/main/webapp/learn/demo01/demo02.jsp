<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
<form id="form01" method="post">
    <input id="inp01" type="text" name="content" title=""/> <br/> <input id="btn01" type="button"
                                                                         value="提交表单"/>
</form>
<img src="" id="img01"/>
</body>
<script src="${pageContext.request.contextPath }/webjars/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#btn01").on("click", function () {
            var param = $("#form01").serialize();
            var content = $("#inp01").val();
            console.info(content);
            console.info(Boolean(content));
            console.info(param);
            if (!content) {
                $("#img01")[0].src = '';
            } else {
                $("#img01")[0].src = '${pageContext.request.contextPath}/demo01/qrcode?' + param;
            }
        });
    });
</script>
</html>