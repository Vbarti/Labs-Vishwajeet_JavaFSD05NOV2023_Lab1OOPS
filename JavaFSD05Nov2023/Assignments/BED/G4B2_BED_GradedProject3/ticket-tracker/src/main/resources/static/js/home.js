// Function to fetch all tickets and display them on the home page
function fetchTickets() {
    fetch('/api/tickets')
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch tickets');
            }
            return response.json();
        })
        .then(tickets => {
            const ticketList = document.getElementById('ticket-list');
            ticketList.innerHTML = '';
            tickets.forEach(ticket => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${ticket.title}</td>
                    <td>${ticket.description}</td>
                    <td>${new Date(ticket.createdOn).toLocaleDateString()}</td>
                    <td>
                        <button class="edit-btn" onclick="editTicket(${ticket.id})">Edit</button>
                        <button class="view-btn" onclick="viewTicket(${ticket.id})">View</button>
                        <button class="delete-btn" onclick="deleteTicket(${ticket.id})">Delete</button>
                    </td>
                `;
                ticketList.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching tickets:', error.message);
        });
}

// Function to search tickets based on title or description
function searchTickets() {
    const searchInput = document.getElementById('search-box').value.toLowerCase();
    const rows = document.getElementById('ticket-list').getElementsByTagName('tr');
    for (let i = 0; i < rows.length; i++) {
        const title = rows[i].getElementsByTagName('td')[0].textContent.toLowerCase();
        const description = rows[i].getElementsByTagName('td')[1].textContent.toLowerCase();
        if (title.includes(searchInput) || description.includes(searchInput)) {
            rows[i].style.display = '';
        } else {
            rows[i].style.display = 'none';
        }
    }
}

// Function to redirect to edit ticket page
function editTicket(ticketId) {
    window.location.href = `/edit-ticket.html?id=${ticketId}`;
}

// Function to redirect to view ticket page
function viewTicket(ticketId) {
    window.location.href = `/view-ticket.html?id=${ticketId}`;
}

// Function to delete a ticket
function deleteTicket(ticketId) {
    if (confirm('Are you sure you want to delete this ticket?')) {
        fetch(`/api/tickets/${ticketId}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                // Ticket deleted successfully, fetch tickets to refresh the list
                fetchTickets();
            } else {
                throw new Error('Failed to delete ticket');
            }
        })
        .catch(error => {
            console.error('Error deleting ticket:', error.message);
        });
    }
}

// Fetch tickets when the page loads
document.addEventListener('DOMContentLoaded', fetchTickets);
