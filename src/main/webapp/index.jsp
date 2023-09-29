<html>
<body>
<script>
    // 获取当前页面的URL
    var currentURL = window.location.href;

    // 如果当前URL是根路径或以"/SmartBlog_war"结尾
    if (currentURL === "http://localhost:15555/SmartBlog_war/" || currentURL.endsWith("/SmartBlog_war")) {
        // 执行重定向到 "/SmartBlog_war/home"
        window.location.href = "http://localhost:15555/SmartBlog_war/showlogin";
    }
</script>
</body>
</html>
