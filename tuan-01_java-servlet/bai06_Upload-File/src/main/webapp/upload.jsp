<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Upload multi-files</h1>
    <form action="/upload" method="post">
        <span>File #1:</span>
        <input type="file" name="files" multiple>
        <br> <br>

        <span>File #2:</span>
        <input type="file" name="files" multiple>
        <br> <br>

        <span>File #3:</span>
        <input type="file" name="files" multiple>
        <br> <br>

        <span>File #4:</span>
        <input type="file" name="files" multiple>
        <br> <br>

        <span>File #5:</span>
        <input type="file" name="files" multiple>
        <br> <br>

        <button type="submit">Upload</button>
        <button type="reset"> Reset </button>
    </form>
</body>
</html>