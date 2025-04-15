<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h2>Login</h2>
    <form id="loginForm">
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" required /><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br><br>

        <button type="submit">Login</button>
    </form>

    <div id="result" style="margin-top:20px; color:red;"></div>

    <script>
        $(document).ready(function() {
            $('#loginForm').submit(function(event) {
                event.preventDefault(); // 폼 기본 제출 막기

                const formData = {
                    username: $('#email').val(),
                    password: $('#password').val()
                };

                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/login',
                    contentType: 'application/json',
                    data: JSON.stringify(formData),
                    success: function(response) {
                        $('#result').css('color', 'green').text('로그인 성공!');

                        location.href = '/main'; // ajax로 요청보내면 JSON으로 응답받기 때문에 직접 성공페이지로 이동해줘야함
                    },
                    error: function(xhr) {
                        $('#result').css('color', 'red').text('로그인 실패: ' + xhr.responseText);
                    }
                });
            });
        });
    </script>
</body>
</html>