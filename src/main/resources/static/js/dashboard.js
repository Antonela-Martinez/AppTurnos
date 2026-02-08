// ========== DATOS DE EJEMPLO ==========
const appointments = [
    {
        id: 1,
        time: '09:00',
        client: 'María González',
        service: 'Capping + Semi',
        professional: 'Estefí',
        duration: 90,
        status: 'confirmed'
    },
    {
        id: 2,
        time: '10:30',
        client: 'Laura Rodríguez',
        service: 'Esmaltado semi manos+pies',
        professional: 'Aldana',
        duration: 120,
        status: 'confirmed'
    },
    {
        id: 3,
        time: '11:00',
        client: 'Ana Martínez',
        service: 'Soft gel',
        professional: 'Estefí',
        duration: 60,
        status: 'pending'
    },
    {
        id: 4,
        time: '14:00',
        client: 'Sofía López',
        service: 'Retirado + Capping',
        professional: 'Evelyn M.',
        duration: 90,
        status: 'confirmed'
    },
    {
        id: 5,
        time: '15:30',
        client: 'Valentina Torres',
        service: 'Semi pies',
        professional: 'Jaquelin',
        duration: 45,
        status: 'pending'
    }
];

// ========== FUNCIONES PRINCIPALES ==========

// Mostrar fecha actual
function updateCurrentDate() {
    const options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    const today = new Date();
    const dateString = today.toLocaleDateString('es-ES', options);
    document.getElementById('currentDate').textContent = dateString.charAt(0).toUpperCase() + dateString.slice(1);
}

// Renderizar tabla de turnos
function renderAppointments() {
    const tbody = document.getElementById('appointmentsBody');
    tbody.innerHTML = '';

    appointments.forEach((appointment, index) => {
        const row = document.createElement('tr');
        row.style.animationDelay = `${index * 0.05}s`;
        row.classList.add('fade-in');

        row.innerHTML = `
            <td>
                <div class="time-cell">
                    <span>⏰</span>
                    <span>${appointment.time}</span>
                </div>
            </td>
            <td><strong>${appointment.client}</strong></td>
            <td>${appointment.service}</td>
            <td>
                <div class="professional-cell">
                    <div class="professional-avatar">${appointment.professional.charAt(0)}</div>
                    <span>${appointment.professional}</span>
                </div>
            </td>
            <td>${appointment.duration} min</td>
            <td>${getStatusBadge(appointment.status)}</td>
            <td>
                <div class="actions-cell">
                    <button class="action-btn view" onclick="viewAppointment(${appointment.id})">Ver</button>
                    <button class="action-btn edit" onclick="editAppointment(${appointment.id})">Editar</button>
                    <button class="action-btn cancel" onclick="cancelAppointment(${appointment.id})">Cancelar</button>
                </div>
            </td>
        `;

        tbody.appendChild(row);
    });

    document.getElementById('appointmentCount').textContent = appointments.length;
}

// Obtener badge de estado
function getStatusBadge(status) {
    const statusConfig = {
        'confirmed': { icon: '✓', text: 'Confirmado', class: 'confirmed' },
        'pending': { icon: '⏳', text: 'Pendiente', class: 'pending' },
        'completed': { icon: '✓', text: 'Completado', class: 'completed' },
        'cancelled': { icon: '✗', text: 'Cancelado', class: 'cancelled' }
    };

    const config = statusConfig[status] || statusConfig.pending;
    return `<span class="status-badge ${config.class}">
                <span>${config.icon}</span>
                <span>${config.text}</span>
            </span>`;
}

// Toggle sidebar
function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('collapsed');
}

// ========== ACCIONES DE TURNOS ==========
function viewAppointment(id) {
    const appointment = appointments.find(a => a.id === id);
    alert(`📋 Detalles del Turno #${id}:\n\nCliente: ${appointment.client}\nServicio: ${appointment.service}\nHora: ${appointment.time}\nProfesional: ${appointment.professional}\nEstado: ${appointment.status}`);
}

function editAppointment(id) {
    alert(`✏️ Editar turno #${id}\n\nEsta funcionalidad abrirá un modal de edición.`);
}

function cancelAppointment(id) {
    if (confirm('¿Está seguro que desea cancelar este turno?')) {
        const appointment = appointments.find(a => a.id === id);
        appointment.status = 'cancelled';
        renderAppointments();
        alert(`✅ Turno #${id} cancelado exitosamente`);
    }
}

function newAppointment() {
    alert('➕ Nuevo Turno\n\nEsta funcionalidad abrirá un formulario para crear un nuevo turno.');
}

function logout() {
    if (confirm('¿Desea cerrar sesión?')) {
        alert('👋 Sesión cerrada');
        window.location.href = 'login.html';
    }
}

// ========== NAVEGACIÓN DE MENÚ ==========
document.querySelectorAll('.menu-item').forEach(item => {
    item.addEventListener('click', function(e) {
        e.preventDefault();
        
        // Remover clase active de todos
        document.querySelectorAll('.menu-item').forEach(i => i.classList.remove('active'));
        
        // Agregar clase active al clickeado
        this.classList.add('active');
        
        const section = this.getAttribute('data-section');
        alert(`Navegando a: ${section}\n\nEn la versión completa, aquí se cargaría la sección correspondiente.`);
    });
});

// ========== INICIALIZACIÓN ==========
document.addEventListener('DOMContentLoaded', function() {
    updateCurrentDate();
    renderAppointments();
});