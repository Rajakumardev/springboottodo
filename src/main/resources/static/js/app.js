let apiUrl = "http://localhost:8090/api/v1/";
$(document).ready(function(){
    //define functions
    function loadData() {
        let endPoint = "todo/"
        console.log(apiUrl+endPoint);
       $.ajax({
           type:"GET",
           url : apiUrl+endPoint,
           dataType:"json",
           success: function(data){
               console.log(JSON.stringify(data));
           },
           error: function(error){
               console.log("error"+JSON.stringify(error));
           }
       })
    }
    //call on load functions
    loadData();

    $(".todo-title").click(function(e){
        let descid = "#"+$(this).attr("data-desc-id");
        $(descid).toggle(280);
    });
})