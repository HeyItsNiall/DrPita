/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validate() {
    var firstname = document.form.firstname.value;
    var lastname = document.form.lastname.value;
    var address = document.form.address.value;
    var email = document.form.email.value;
    var phone = document.form.phone.value;
    var username = document.form.username.value;
    var password = document.form.password.value;
    var conpassword = document.form.conpassword.value;

    if (firstname == null || firstname == "") {

        alert("First Name can't be blank");
        event.preventDefault();
        return false;
    } else if (lastname == null || lastname == "") {

        alert("Last Name can't be blank");
        event.preventDefault();
        return false;
    } else if (address == null || address == "") {

        alert("Address can't be blank");
        event.preventDefault();
        return false;
    } else if (email == null || email == "") {

        alert("Email can't be blank");
        event.preventDefault();
        return false;
    } else if (phone == null || phone == "") {

        alert("Phone can't be blank");
        event.preventDefault();
        return false;
    } else if (username == null || username == "") {

        alert("Username can't be blank");
        event.preventDefault();
        return false;
    } else if (password.length < 6) {

        alert("Password must be at least 6 characters long");
        event.preventDefault();
        return false;
    } else if (password != conpassword) {

        alert("Confirm Password should be match with the Password");
        event.preventDefault();
        return false;
    }
}