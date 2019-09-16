let apiUrl = "http://localhost:8090/api/v1/";
$(document).ready(function(){
    //define functions
    function loadData(parentContainer) {
        let endPoint = "todo/"
        console.log(apiUrl+endPoint);
       $.ajax({
           type:"GET",
           url : apiUrl+endPoint,
           dataType:"json",
           crossDomain:true,
           success: function(data){
               let todoList = "";
               data.forEach(element => {
                   let checked = element.completed == "Y" ? "checked":"";
                   let strikeStyle = element.completed == "Y" ? "completed-title":""
                   todoList +='<li class="todo-item">'+
                   '<div class="todo-title-container" >'+
                       '<h1 class="todo-title '+strikeStyle+'" data-desc-id="desc-'+element.id+'">'+element.title+'</h1>'+
                       '<input type="checkbox" data-todo-id ="'+element.id+'" id="checkbox-'+element.id+'" name="checkbox-'+element.id+'" class="completed-checkbox" '+checked+'/>'+
                   '</div>'+
                   '<div class="todo-description" id="desc-'+element.id+'"><i>'+element.description+'</i></div>'+
               '</li>'
               });
               $(parentContainer).html(todoList);
           },
           error: function(error){
               console.log("error"+JSON.stringify(error));
           }
       })
    }
    //add new todo
    function addTodo(todo){
        console.log(apiUrl+"todo/add/");
        console.log(todo);
        $.ajax({
            type:"POST",
            url : apiUrl+"todo/add/",
            data:JSON.stringify(todo),
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            crossDomain:true,
            success: function(data){
                loadData("#todo-list");
            },
            error:function(error){
                console.log(error);
            }
        });
        hideDialog("addDialog");
    }
    //update completed
    function updateCompleted(todo){
        console.log(apiUrl+"todo/completed/");
        console.log(todo);
        $.ajax({
            type:"POST",
            url : apiUrl+"todo/completed/",
            data:JSON.stringify(todo),
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            crossDomain:true,
            success: function(data){
                loadData("#todo-list");
            },
            error:function(error){
                console.log(error);
            }
        });
    }
    //show add dialog
    function showDialog(dialogId){
        $("#"+dialogId).show(200);
        
    }
    function hideDialog(dialogId){
        $("#"+dialogId).hide(200);
    }
    //call on load functions
    loadData("#todo-list");


    //listeners
    $(document).on ('click','.todo-title',function(e){
        let descid = "#"+$(this).attr("data-desc-id");
        $(descid).toggle(280);
    });

    $(document).on('click','#addNewTodoBtn',function(e){
        let todoTitle = $('#todoTitleTxt').val();
        let todoDescription = $('#todoDescriptionTxt').val();
        let reqObj = {
            title:todoTitle,
            description:todoDescription
        }
        addTodo(reqObj);
    });
    $(document).on ('click','#addDialogBtn',function(e){
        let dialogId = $(this).attr("data-dialog-id");
        showDialog(dialogId);
    });

    $(document).on ('click','#dialogCloseBtn',function(e){
        let dialogId = $(this).attr("data-dialog-id");
        hideDialog(dialogId);
    });
    $(document).on ('click','.completed-checkbox',function(e){
        let todoId = $(this).attr("data-todo-id");
        updateCompleted({
            id:todoId
        })
    });
    
})