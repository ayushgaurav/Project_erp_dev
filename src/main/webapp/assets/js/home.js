$("#refresh").on("click", async function (e){
    $.get("/api/students/viewAll", function (data, status){
        alert("Data: " + data + "\nStatus: " + status);
    });
});