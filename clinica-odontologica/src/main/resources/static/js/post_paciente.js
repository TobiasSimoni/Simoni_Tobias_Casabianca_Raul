window.addEventListener('load', function () {

    
    const formulario = document.querySelector('#add_new_paciente');

    formulario.addEventListener('submit', function (event) {

   
        const formData = {
          "nombre": "TobiaSss",
              "apellido": "Simoni",
              "dni": 45740199,
              "fechaIngreso": "2023-11-30",
              "domicilioEntradaDto": {
                  "calle": "dsdsds",
                  "numero": 5426,
                  "localidad": "fsldlsad",
                  "provincia": "fsdjasd"

        };
        
        const url = '/pacientes/registrar';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Paciente Agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();

            })
            .catch(error => {
                    
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                    
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
         document.querySelector('#dni').value = "";
         document.querySelector('#FechaIngreso').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/listarpaciente.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});