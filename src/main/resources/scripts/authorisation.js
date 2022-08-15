class Authorisation{
    constructor(){
        const authorisation = localStorage.getItem("authorisation");
        this.validateAuthorisation(authorisation);
    };

    validateAuthorisation(authorisation){
        if(authorisation != 1){
            window.location.replace("login.html");
        }
    };

    logOut(){
        localStorage.clear();
        window.location.replace("login.html");        
    };
};