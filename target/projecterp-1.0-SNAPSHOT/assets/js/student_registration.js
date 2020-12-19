$(".student-form").on("submit", async function (e){
    e.preventDefault();

    let roll_number = "CS_005";
    let first_name = document.getElementById("firstName").value;
    let last_name = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let total_credit = document.getElementById("credit").value;
    let graduation_year = document.getElementById("graduationYear").value;

    let response = await fetch('/api/students/register',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            roll_number: roll_number,
            first_name: first_name,
            last_name: last_name,
            email: email,
            total_credit: total_credit,
            graduation_year: graduation_year
        })
    });
    this.submit();
});