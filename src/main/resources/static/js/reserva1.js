$(document).ready(function() {
           // Configuración inicial
           const availableSlots = {
               '2025-02-10': ['09:00', '10:30', '14:00', '15:30', '17:00'],
               '2025-02-11': ['09:00', '11:00', '14:00', '16:00'],
               '2025-02-12': ['10:00', '12:00', '15:00', '17:30'],
           };

           // Establecer fecha mínima (hoy)
           const today = new Date().toISOString().split('T')[0];
           $('#fecha').attr('min', today);

           // ============================================
           // VALIDACIONES EN TIEMPO REAL CON JQUERY
           // ============================================

           // Validación DNI
           $('#dni').on('input', function() {
               let value = $(this).val().replace(/\D/g, '');
               $(this).val(value);

               if (value.length === 8) {
                   $(this).removeClass('invalid').addClass('valid');
                   $('#dniError').hide();
               } else if (value.length > 0) {
                   $(this).removeClass('valid').addClass('invalid');
                   $('#dniError').show();
               } else {
                   $(this).removeClass('valid invalid');
                   $('#dniError').hide();
               }
           });

           // Validación Nombre
           $('#nombre').on('blur', function() {
               if ($(this).val().trim().length > 0) {
                   $(this).addClass('valid').removeClass('invalid');
                   $('#nombreError').hide();
               } else {
                   $(this).addClass('invalid').removeClass('valid');
                   $('#nombreError').show();
               }
           });

           // Validación Apellido
           $('#apellido').on('blur', function() {
               if ($(this).val().trim().length > 0) {
                   $(this).addClass('valid').removeClass('invalid');
                   $('#apellidoError').hide();
               } else {
                   $(this).addClass('invalid').removeClass('valid');
                   $('#apellidoError').show();
               }
           });

           // Validación Teléfono
           $('#telefono').on('input', function() {
               let value = $(this).val().replace(/\D/g, '');
               $(this).val(value);

               if (value.length >= 10) {
                   $(this).removeClass('invalid').addClass('valid');
                   $('#telefonoError').hide();
               } else if (value.length > 0) {
                   $(this).removeClass('valid').addClass('invalid');
                   $('#telefonoError').show();
               } else {
                   $(this).removeClass('valid invalid');
                   $('#telefonoError').hide();
               }
           });

           // Validación Email
           $('#email').on('blur', function() {
               const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
               if (emailPattern.test($(this).val())) {
                   $(this).addClass('valid').removeClass('invalid');
                   $('#emailError').hide();
               } else if ($(this).val().length > 0) {
                   $(this).addClass('invalid').removeClass('valid');
                   $('#emailError').show();
               }
           });

           // ============================================
           // MANEJO DE SELECCIÓN DE SERVICIO
           // ============================================
           $('#servicio').on('change', function() {
               const selectedOption = $(this).find('option:selected');
               const duration = selectedOption.data('duration');
               const price = selectedOption.data('price');

               if (duration && price) {
                   $('#serviceDuration').text(duration + ' minutos');
                   $('#servicePrice').text('$' + price);
                   $('#serviceInfo').fadeIn().addClass('fade-in');
                   $(this).removeClass('invalid').addClass('valid');
                   $('#servicioError').hide();
               } else {
                   $('#serviceInfo').fadeOut();
                   $(this).removeClass('valid');
               }
           });

           // ============================================
           // MANEJO DE FECHA Y CARGA DE HORARIOS
           // ============================================
           $('#fecha').on('change', function() {
               const selectedDate = $(this).val();
               const $horaSelect = $('#hora');

               // Habilitar el selector de hora
               $horaSelect.prop('disabled', false);
               $horaSelect.empty();
               $horaSelect.append('<option value="">Seleccione hora</option>');

               // Simular carga de horarios desde el servidor
               // En producción, harías: $.get('/api/horarios?fecha=' + selectedDate)
               const slots = availableSlots[selectedDate] || 
                            ['09:00', '10:00', '11:00', '14:00', '15:00', '16:00', '17:00'];

               if (slots.length > 0) {
                   $.each(slots, function(index, slot) {
                       $horaSelect.append($('<option>', {
                           value: slot,
                           text: slot
                       }));
                   });
                   $(this).removeClass('invalid').addClass('valid');
                   $('#fechaError').hide();
               } else {
                   $horaSelect.append('<option value="">No hay horarios disponibles</option>');
               }

               // Efecto de entrada
               $horaSelect.addClass('fade-in');
           });

           // Validación de hora
           $('#hora').on('change', function() {
               if ($(this).val()) {
                   $(this).removeClass('invalid').addClass('valid');
                   $('#horaError').hide();
               }
           });

           // Validación de profesional
           $('#profesional').on('change', function() {
               if ($(this).val()) {
                   $(this).removeClass('invalid').addClass('valid');
                   $('#profesionalError').hide();
               }
           });

           // ============================================
           // FUNCIÓN DE VALIDACIÓN COMPLETA
           // ============================================
           function validateForm() {
               let isValid = true;
               const errors = [];

               // Validar DNI
               if ($('#dni').val().length !== 8) {
                   $('#dni').addClass('invalid');
                   $('#dniError').show();
                   errors.push('DNI inválido');
                   isValid = false;
               }

               // Validar Nombre
               if ($('#nombre').val().trim().length === 0) {
                   $('#nombre').addClass('invalid');
                   $('#nombreError').show();
                   errors.push('Nombre requerido');
                   isValid = false;
               }

               // Validar Apellido
               if ($('#apellido').val().trim().length === 0) {
                   $('#apellido').addClass('invalid');
                   $('#apellidoError').show();
                   errors.push('Apellido requerido');
                   isValid = false;
               }

               // Validar Teléfono
               if ($('#telefono').val().length < 10) {
                   $('#telefono').addClass('invalid');
                   $('#telefonoError').show();
                   errors.push('Teléfono inválido');
                   isValid = false;
               }

               // Validar Email
               const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
               if (!emailPattern.test($('#email').val())) {
                   $('#email').addClass('invalid');
                   $('#emailError').show();
                   errors.push('Email inválido');
                   isValid = false;
               }

               // Validar Servicio
               if (!$('#servicio').val()) {
                   $('#servicio').addClass('invalid');
                   $('#servicioError').show();
                   errors.push('Servicio requerido');
                   isValid = false;
               }

               // Validar Profesional
               if (!$('#profesional').val()) {
                   $('#profesional').addClass('invalid');
                   $('#profesionalError').show();
                   errors.push('Profesional requerido');
                   isValid = false;
               }

               // Validar Fecha
               if (!$('#fecha').val()) {
                   $('#fecha').addClass('invalid');
                   $('#fechaError').show();
                   errors.push('Fecha requerida');
                   isValid = false;
               }

               // Validar Hora
               if (!$('#hora').val()) {
                   $('#hora').addClass('invalid');
                   $('#horaError').show();
                   errors.push('Hora requerida');
                   isValid = false;
               }

               return { isValid, errors };
           }

           // ============================================
           // MANEJO DEL ENVÍO DEL FORMULARIO CON JQUERY
           // ============================================
           $('#bookingForm').on('submit', function(e) {
               e.preventDefault();

               // Ocultar mensajes anteriores
               $('#alertError').hide();
               $('#successMessage').hide();

               // Validar formulario
               const validation = validateForm();

               if (!validation.isValid) {
                   $('#errorText').text('Por favor complete todos los campos correctamente');
                   $('#alertError').fadeIn().addClass('fade-in');
                   $('html, body').animate({
                       scrollTop: $('#alertError').offset().top - 100
                   }, 500);
                   return;
               }

               // Recopilar datos del formulario usando jQuery
               const formData = {
                   dni: $('#dni').val(),
                   nombre: $('#nombre').val(),
                   apellido: $('#apellido').val(),
                   telefono: $('#telefono').val(),
                   email: $('#email').val(),
                   servicio: $('#servicio').val(),
                   servicioNombre: $('#servicio option:selected').text(),
                   profesional: $('#profesional').val(),
                   profesionalNombre: $('#profesional option:selected').text(),
                   fecha: $('#fecha').val(),
                   hora: $('#hora').val(),
                   duracion: $('#servicio option:selected').data('duration'),
                   precio: $('#servicio option:selected').data('price')
               };

               console.log('Datos del turno:', formData);

               // Mostrar loading
               $('#submitBtn').prop('disabled', true);
               $('#submitIcon').hide();
               $('#submitText').text('Procesando...');
               $('#loadingSpinner').show();

               // Simular llamada AJAX al backend
               // En producción usarías:
               /*
               $.ajax({
                   url: 'http://localhost:8080/api/turnos',
                   type: 'POST',
                   contentType: 'application/json',
                   data: JSON.stringify(formData),
                   success: function(response) {
                       // Manejar éxito
                   },
                   error: function(xhr, status, error) {
                       // Manejar error
                   }
               });
               */

               // Simulación de envío exitoso
               setTimeout(function() {
                   // Generar número de confirmación
                   const confirmNumber = Math.floor(Math.random() * 90000) + 10000;
                   $('#confirmNumber').text(confirmNumber);

                   // Mostrar mensaje de éxito
                   $('#successMessage').fadeIn().addClass('fade-in');

                   // Scroll suave al mensaje
                   $('html, body').animate({
                       scrollTop: $('#successMessage').offset().top - 100
                   }, 500);

                   // Restaurar botón
                   $('#submitBtn').prop('disabled', false);
                   $('#submitIcon').show();
                   $('#submitText').text('AGENDAR');
                   $('#loadingSpinner').hide();

                   // Resetear formulario después de 3 segundos
                   setTimeout(function() {
                       $('#bookingForm')[0].reset();
                       $('#serviceInfo').hide();
                       $('#hora').prop('disabled', true).empty().append('<option value="">Seleccione fecha</option>');
                       $('input, select').removeClass('valid invalid');
                       $('.error-message').hide();
                       $('#successMessage').fadeOut();
                   }, 3000);

               }, 1500); // Simula 1.5s de procesamiento
           });

           // ============================================
           // EFECTOS ADICIONALES CON JQUERY
           // ============================================

           // Efecto al hacer focus en inputs
           $('input, select').on('focus', function() {
               $(this).parent().addClass('active');
           }).on('blur', function() {
               $(this).parent().removeClass('active');
           });

           // Mostrar tooltip al pasar mouse sobre campos requeridos
           $('label .required').attr('title', 'Campo obligatorio');

       });