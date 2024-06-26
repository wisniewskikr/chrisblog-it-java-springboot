function submit() {
    
    const username = document.getElementsByName("username")[0].value;
    const password = document.getElementsByName("password")[0].value;
    const redirect = document.getElementsByName("redirect")[0].value;

    const url = `http://localhost:8080/login-submit?username=${username}&password=${password}&redirect=${redirect}`;  

    location.href = url;

}