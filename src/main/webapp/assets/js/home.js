$("#refresh").on("click", async function (e){
    $.get("/api/students/viewAll", function (data, status){

        // st = '<a title="view this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-eye-open text-primary"></i> </a>  <a title="edit this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-edit text-primary"></i> </a> <a title="delete this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-trash text-danger"></i> </a>';

        var obj = JSON.parse(data);
        var tableBody = document.getElementById("form-list-client-body");


        while (tableBody.hasChildNodes()) {
            tableBody.removeChild(tableBody.firstChild);
        }


        for( var person of obj) {


            var row = document.createElement("tr");
            var nameColumn = document.createElement("td");
            var ageColumn = document.createElement("td");
            var actionelements = document.createElement("td");
            nameColumn.innerText = person["roll_number"];
            ageColumn.innerText = person["first_name"];

            var X = person["roll_number"];
            st = '<a id ="view_'+ X + '" title="view this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-eye-open text-primary"></i> </a>  <a id ="edit_'+ X + '" title="edit this user" class="btn btn-default btn-sm "> <i class="glyphicon glyphicon-edit text-primary"></i> </a> <a id ="delete_'+ X + '" title="delete this user" class=" delete_but btn btn-default btn-sm "> <i class="glyphicon glyphicon-trash text-danger"></i> </a>';
            actionelements.innerHTML = st;

            row.appendChild(nameColumn);
            row.appendChild(ageColumn);
            row.appendChild(actionelements);

            row.setAttribute("id",person["roll_number"]);
            tableBody.appendChild(row);



            // $(".text-danger").on("click", function (e)
            // {
            //     alert("del");
            // });


        }

        // alert("Data: " + data + "\nStatus: " + status);
    });
});

//
//

$("#tablebody").on("click", ".text-danger", function (e)
{
   alert($(this).closest('tr').attr("id"));
});
//
// $(".glyphicon-edit").on("click", function (e)
// {
//     alert("view");
// });
// $(".glyphicon-eye-open").on("click", function (e)
// {
//     alert("open");
// });
//
// $(".text-danger").addEventListener("click", function (e)
// {
//    alert(e.target.value);
// });
//
// var element = document.getElementById('id');
// element.onclick = function() {
//     // onclick stuff
// }