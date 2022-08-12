const nav = document.querySelector('.modal')
fetch('../HTMLincludes/modals.html')
.then(res=>res.text())
.then(data=>{
    nav.innerHTML = data;
})