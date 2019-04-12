var loginuser = document.getElementById("loginuser");
loginuser.onkeydown = (event) => {
	if(event.keyCode == 13) {
		fetch("/api/login", {
			method: "POST",
			body: JSON.stringify({username:loginuser.value})
		}).then(()=>{ldf.nav("/");ldf.load("#header", "/header")});
	}
};