
		function preview() {
			var file = document.getElementById("file").files[0];
			//			var imageurl=document.getElementById("file").pathname;
			//			alert(imageurl);
			var fileType = file.type.split("/")[0];
			if(fileType != "image") {
				alert("请上传图片");
				return;
			}
			var fileSize = Math.round(file.size / 1024 / 1024);
			if(fileSize >= 3) {
				alert("图片不得超过3M");
				return;
			}
			var img = document.getElementById("imgs");
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(e) {
				var url = reader.result;
				img.src = url;
			};

		}

		function call() {
			document.getElementById("imgs").src = "";
			document.getElementById("file").value = "";
		}

