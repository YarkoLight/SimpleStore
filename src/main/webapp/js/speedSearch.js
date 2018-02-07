/**
 * Created by admin on 6/21/2017.
 */
function search() {

    $.ajax({
        url: '/searchDrink?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchIn').val(),
        success: function (res) {

            // console.log(res);

            var drinks = '';

            for (var i in res) {

                var ingredints = '';

                for(var j in res[i].ingredients){
                    ingredints += res[i].ingredients[j].ingredientName+'<br>';
                }

                drinks += '<tr><td>' + res[i].drinkName + '</td><td><img src="'+res[i].pathImage+'" alt="'+res[i].pathImage+'" height="192px" width="150px"></td><td>'+ingredints+'</td><td><a href="recipe/"'+ res[i].id+'>recipe</a></td></tr>';
            }
            document.getElementById('indexResult').innerHTML = drinks;
        }

    })

}