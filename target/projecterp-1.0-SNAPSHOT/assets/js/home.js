$("#refresh").on("click", async function (e){
    $.get("/api/students/viewAll", function (data, status){

        st = '<a title="view this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-eye-open text-primary"></i> </a>  <a title="edit this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-edit text-primary"></i> </a> <a title="delete this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-trash text-danger"></i> </a>';

        var obj = JSON.parse(data);
        var tableBody = document.getElementById("form-list-client-body");
        for( var person of obj) {

            var row = document.createElement("tr");
            var nameColumn = document.createElement("td");
            var ageColumn = document.createElement("td");
            var actionelements = document.createElement("td");
            nameColumn.innerText = person["roll_number"];
            ageColumn.innerText = person["first_name"];

            actionelements.innerHTML = st;

            row.appendChild(nameColumn);
            row.appendChild(ageColumn);
            row.appendChild(actionelements);
            tableBody.appendChild(row);
        }

        // alert("Data: " + data + "\nStatus: " + status);
    });
});