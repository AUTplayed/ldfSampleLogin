function logout() {
	fetch("/api/logout", {method:"POST"}).then(()=> {
		ldf.load("#header", "/header");
	});
}