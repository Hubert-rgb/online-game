function test(){
    // WARNING: For POST requests, body is set to null by browsers.
    var data = new FormData();
    data.append("name", "Hubert");
    data.append("password", "tymonJestSuper");

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4) {
        console.log(this.responseText);
      }
    });

    xhr.open("POST", "http://localhost:8080/loginUser");

    xhr.send(data);
    xhr.r
}