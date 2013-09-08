<html>
<head>
<script>
	var fCount = 3;
	function addFileElement() {
 		fCount++;
 		var fObject = document.getElementById('fileSection');
		var text = 'File:';   
 		var tag='<input type="file" name="fileup'+fCount+'" />';   
 		var brk='<br>'
 		var o1 = document.createTextNode(text);
 		var o2 = document.createElement(tag);
 		var o3 = document.createElement(brk);
 		fObject.appendChild(o3);
 		fObject.appendChild(o1);
 		fObject.appendChild(o2);
 		fObject.appendChild(o3); 
	}
</script>
<title>Multiple file upload using JAX-RS</title>
</head>
<body>
<form  action="sampservice/filehandler/uploadfile" method="POST" enctype="multipart/form-data">
	<div id="fileSection" >
		File:<input type="file" name="fileup0" /><br>
	</div>
	<hr>
		<input type="submit" value="Upload All files" />
		<input type="button" onclick="addFileElement()" value="Add File"/>
</form>
</body>
</html>
