// Datos de ejemplo para horarios disponibles
const availableSlots = {
    '2025-02-10': ['09:00', '10:30', '14:00', '15:30', '17:00'],
    '2025-02-11': ['09:00', '11:00', '14:00', '16:00'],
    '2025-02-12': ['10:00', '12:00', '15:00', '17:30'],
};

// Establecer fecha mínima (hoy)
const today = new Date().toISOString().split('T')[0];
document.getElementById('fecha').setAttribute('min', today);

// Validación de DNI en tiempo real
const dniInput = document.getElementById('dni');
dniInput.addEventListener('input', function(e) {
    this.value = this.value.replace(/\D/g, '');
    if (this.value.length === 8) {
        this.classList.add('valid');
        this.classList.remove('invalid');
    } else {
        this.classList.remove('valid');
        this.classList.add('invalid');
    }
});

// Validación de teléfono
const telefonoInput = document.getElementById('telefono');
telefonoInput.addEventListener('input', function(e) {
    this.value = this.value.replace(/\D/g, '');
});

// Mostrar información del servicio
const servicioSelect = document.getElementById('servicio');
servicioSelect.addEventListener('change', function() {
    const selectedOption = this.options[this.selectedIndex];
    const duration = selectedOption.getAttribute('data-duration');
    const price = selectedOption.getAttribute('data-price');
    
    if (duration && price) {
        document.getElementById('serviceDuration').textContent = duration + ' minutos';
        document.getElementById('servicePrice').textContent = '$' + price;
        document.getElementById('serviceInfo').classList.add('show');
    } else {
        document.getElementById('serviceInfo').classList.remove('show');
    }
});

// Cargar horarios disponibles según fecha
const fechaInput = document.getElementById('fecha');
const horaSelect = document.getElementById('hora');

fechaInput.addEventListener('change', function() {
    const selectedDate = this.value;
    horaSelect.disabled = false;
    horaSelect.innerHTML = '<option value="">Seleccione hora</option>';
    
    // Simular carga de horarios disponibles
    const slots = availableSlots[selectedDate] || ['09:00', '10:00', '14:00', '15:00', '16:00', '17:00'];
    
    slots.forEach(slot => {
        const option = document.createElement('option');
        option.value = slot;
        option.textContent = slot;
        horaSelect.appendChild(option);
    });

    if (slots.length === 0) {
        const option = document.createElement('option');
        option.value = '';
        option.textContent = 'No hay horarios disponibles';
        horaSelect.appendChild(option);
    }
});

// Manejo del formulario
const form = document.getElementById('bookingForm');
form.addEventListener('submit', function(e) {
    e.preventDefault();
    
    // Validación básica
    if (!form.checkValidity()) {
        alert('Por favor complete todos los campos obligatorios');
        return;
    }

    // Recopilar datos del formulario
    const formData = {
        dni: document.getElementById('dni').value,
        nombre: document.getElementById('nombre').value,
        apellido: document.getElementById('apellido').value,
        telefono: document.getElementById('telefono').value,
        email: document.getElementById('email').value,
        servicio: document.getElementById('servicio').value,
        profesional: document.getElementById('profesional').value,
        fecha: document.getElementById('fecha').value,
        hora: document.getElementById('hora').value
    };

    console.log('Datos del turno:', formData);

    // Simular envío al backend
    // Aquí harías: fetch('/api/turnos', { method: 'POST', body: JSON.stringify(formData) })
    
    // Mostrar mensaje de éxito
    const confirmNumber = Math.floor(Math.random() * 90000) + 10000;
    document.getElementById('confirmNumber').textContent = confirmNumber;
    document.getElementById('successMessage').classList.add('show');

    // Scroll al mensaje
    document.getElementById('successMessage').scrollIntoView({ behavior: 'smooth' });

    // Opcional: resetear formulario después de 3 segundos
    setTimeout(() => {
        form.reset();
        document.getElementById('serviceInfo').classList.remove('show');
        horaSelect.disabled = true;
    }, 3000);
});