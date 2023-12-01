window.addEventListener('load', function () {
    (function(){

      const url = '/pacientes/listar';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {

         for(pacientes of data){
          
            var table = document.getElementById("pacientesTable");
            var peliculaRow =table.insertRow();
            let tr_id = 'tr_' + pacientes.id;
            pacientesRow.id = tr_id;

          
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + pacientes.id + '\"' +
                                      ' type="button" onclick="deleteBy('+pacientes.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + pacientes.id + '\"' +
                                      ' type="button" onclick="findBy('+pacientes.id+')" class="btn btn-info btn_id">' +
                                      pacientes.id +
                                      '</button>';

         
            peliculaRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_nombre\">' + pacientes.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + pacientes.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_dni\">' + pacientes.dni.toUpperCase() + '</td>'
                    '<td class=\"td_fechaingreso\">' + pacientes.fechaingreso.toUpperCase() + '</td>'
            
                    '<td>' + deleteButton + '</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/listarpaciente.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })