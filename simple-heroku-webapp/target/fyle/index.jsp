<html>
<body>

<form action="webapi/myresource" method="get">
    <h2><b>SEARCH BANK USING IFSC</b></h2>
    ENTER IFSC CODE<input type="text" name=ifsc>
    <br>
    <input type="submit" value="SEARCH">
</form>


<form action="webapi/myresource/bank" method="get">
    <h2><b>SEARCH ALL BANKS IN CITY</b></h2>
    ENTER bank name<input type="text" name=bname>
    <br>
    ENTER bank city<input type="text" name=bcity>
    <br>
    <input type="submit" value="SEARCH">
</form>

</body>
</html>
