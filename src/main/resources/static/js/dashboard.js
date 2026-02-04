// ========== DATOS DE EJEMPLO ==========
       const appointments = [
           { id: 1, time: '09:00', client: 'María González', dni: '12345678', phone: '1123456789', email: 'maria@email.com', service: 'Capping + Semi', professional: 'Estefí', status: 'confirmed', duration: 90 },
           { id: 2, time: '10:30', client: 'Laura Rodríguez', dni: '23456789', phone: '1134567890', email: 'laura@email.com', service: 'Esmaltado semi manos+pies', professional: 'Aldana', status: 'confirmed', duration: 120 },
           { id: 3, time: '11:00', client: 'Ana Martínez', dni: '34567890', phone: '1145678901', email: 'ana@email.com', service: 'Soft gel', professional: 'Estefí', status: 'pending', duration: 60 },
           { id: 4, time: '14:00', client: 'Sofía López', dni: '45678901', phone: '1156789012', email: 'sofia@email.com', service: 'Retirado + Capping', professional: 'Evelyn M.', status: 'confirmed', duration: 90 },
           { id: 5, time: '15:30', client: 'Valentina Torres', dni: '56789012', phone: '1167890123', email: 'vale@email.com', service: 'Semi pies', professional: 'Jaquelin', status: 'pending', duration: 45 },
       ];

       // ========== TOGGLE SIDEBAR ==========
       const sidebar = document.getElementById('sidebar');
       const toggleBtn = document.getElementById('toggleSidebar');
       const toggleIcon = document.getElementById('toggleIcon');

       toggleBtn.addEventListener('click', () => {
           sidebar.classList.toggle('collapsed');
           toggleIcon.textContent = sidebar.classList.contains('collapsed') ? '☰' : '✕';
       });

       // ========== NAVEGACIÓN ==========
       const navItems = document.querySelectorAll('.nav-item');
       navItems.forEach(item => {
           item.addEventListener('click', (e) => {
               e.preventDefault();
               navItems.forEach(nav => nav.classList.remove('active'));
               item.classList.add('active');
               const section = item.dataset.section;
               console.log('Navegando a:', section);
               // Aquí podrías cargar contenido dinámico según la sección
           });
       });

       // ========== RENDERIZAR TABLA DE TURNOS ==========
       function renderAppointments() {
           const tbody = document.getElementById('appointmentsBody');
           tbody.innerHTML = '';

           appointments.forEach(appointment => {
               const row = document.createElement('tr');
               
               const statusIcons = {
                   confirmed: '✓',
                   pending: '⏱',
                   completed: '✓',
                   cancelled: '✕'
               };

               const statusTexts = {
                   confirmed: 'Confirmado',
                   pending: 'Pendiente',
                   completed: 'Completado',
                   cancelled: 'Cancelado'
               };

               row.innerHTML = `
                   <td>
                       <div class="time-cell">
                           <span>🕐</span>
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
                   <td>
                       <span class="status-badge ${appointment.status}">
                           <span>${statusIcons[appointment.status]}</span>
                           <span>${statusTexts[appointment.status]}</span>
                       </span>
                   </td>
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

       // ========== VER DETALLE DE TURNO ==========
       function viewAppointment(id) {
           const appointment = appointments.find(a => a.id === id);
           if (!appointment) return;

           const modalBody = document.getElementById('modalBody');
           modalBody.innerHTML = `
               <div class="detail-row">
                   <div class="detail-label">Hora:</div>
                   <div class="detail-value">${appointment.time}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Cliente:</div>
                   <div class="detail-value">${appointment.client}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">DNI:</div>
                   <div class="detail-value">${appointment.dni}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Teléfono:</div>
                   <div class="detail-value">${appointment.phone}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Email:</div>
                   <div class="detail-value">${appointment.email}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Servicio:</div>
                   <div class="detail-value">${appointment.service}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Profesional:</div>
                   <div class="detail-value">${appointment.professional}</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Duración:</div>
                   <div class="detail-value">${appointment.duration} minutos</div>
               </div>
               <div class="detail-row">
                   <div class="detail-label">Estado:</div>
                   <div class="detail-value">
                       <span class="status-badge ${appointment.status}">
                           ${appointment.status === 'confirmed' ? 'Confirmado' : 'Pendiente'}
                       </span>
                   </div>
               </div>
           `;

           document.getElementById('detailModal').classList.add('show');
       }

       // ========== EDITAR TURNO ==========
       function editAppointment(id) {
           console.log('Editar turno:', id);
           alert(`Editar turno #${id} - Esta funcionalidad se implementará con un formulario`);
       }

       // ========== CANCELAR TURNO ==========
       function cancelAppointment(id) {
           if (confirm('¿Está seguro que desea cancelar este turno?')) {
               const appointment = appointments.find(a => a.id === id);
               if (appointment) {
                   appointment.status = 'cancelled';
                   renderAppointments();
                   alert('Turno cancelado exitosamente');
               }
           }
       }

       // ========== CERRAR MODAL ==========
       document.getElementById('closeModal').addEventListener('click', () => {
           document.getElementById('detailModal').classList.remove('show');
       });

       document.getElementById('detailModal').addEventListener('click', (e) => {
           if (e.target.id === 'detailModal') {
               document.getElementById('detailModal').classList.remove('show');
           } 
   });

            // ========== NUEVO TURNO ==========
               document.getElementById('newAppointmentBtn').addEventListener('click', () => {
                   alert('Aquí se abriría un formulario para crear un nuevo turno');
               });

               // ========== LOGOUT ==========
               document.getElementById('logoutBtn').addEventListener('click', () => {
                   if (confirm('¿Está seguro que desea cerrar sesión?')) {
                       alert('Cerrando sesión...');
                       // window.location.href = '/login';
                   }
               });

               // ========== INICIALIZAR ==========
               renderAppointments();