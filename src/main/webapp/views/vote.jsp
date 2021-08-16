<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Главная страница голосования</title>
</head>
<body>
<form action="vote" method="POST">
<label for="artist">Группа</label>
<select name="artist">
<option value="1">Ирина Олегрова</option>
<option value="2">Каста</option>
<option value="3">Луна</option>
<option value="4">Иванушки</option>
</select><br/>
<label for="genre">Жанр</label><br/>
<input type="checkbox" name="genre" value="1"> Рок <br/>
<input type="checkbox" name="genre" value="2"> Поп <br/>
<input type="checkbox" name="genre" value="3"> Фолк <br/>
<input type="checkbox" name="genre" value="4"> Альт <br/>
<input type="checkbox" name="genre" value="5"> Классика <br/>
<input type="checkbox" name="genre" value="6"> Джаз <br/>
<input type="checkbox" name="genre" value="7"> Тик-тоник <br/>
<label for="about">О себе<label><br/>
<textarea name="about"></textarea>
<input type="submit" name="Отправить">
</form>
</body>
</html>