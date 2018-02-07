/**
 * Created by admin on 6/24/2017.
 */

function filter() {

    var price;
    var alcoValue;



    document.getElementById('rangeValue').innerHTML = $('#rangePrice').val();
    price = $('#rangePrice').val();

    var alco = document.getElementsByName('alco');

    for(var i in alco){
        if(alco[i].checked){
            alcoValue = alco[i].value;
        }
    }

    console.log('price = '+price);
    console.log('alco = '+alcoValue);


    if(price == 0){

        $.ajax({
            url : '/filterAlcohol?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method : 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data : alcoValue,
            success : function (res) {
                var drinks = '';

                for (var i in res) {

                    var ingredints = '';

                    for(var j in res[i].ingredients){
                        ingredints += res[i].ingredients[j].ingredientName+'<br>';
                    }

                    drinks += '<tr><td>' + res[i].drinkName + '</td><td><img src="'+res[i].pathImage+'" alt="'+res[i].pathImage+'" height="192px" width="150px"></td><td>'+ingredints+'</td><td><a href="recipe/"'+ res[i].id+'>recipe</a></td></tr>';
                }
                document.getElementById('indexResult').innerHTML = drinks;
            },
            error : function () {

            }
        })

    }



}
