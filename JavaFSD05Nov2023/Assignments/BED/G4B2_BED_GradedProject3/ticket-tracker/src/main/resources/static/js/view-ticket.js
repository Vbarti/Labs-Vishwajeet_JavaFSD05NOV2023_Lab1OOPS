// JavaScript for view-ticket.html

// Function to fetch and display ticket details
function viewTicket(ticketId) {
    fetch(`/api/tickets/${ticketId}`)
        .then(response => response.json())
        .then(ticket => {
            const ticketDetails = document.getElementById('ticket-details');
            ticketDetails.innerHTML = `
                <h2>${ticket.title}</h2>
                <p>${ticket.description}</p>
            `;
        });
}

// Fetch ticket details when the page loads
const urlParams = new URLSearchParams(window.location.search);
const ticketId = urlParams.get('id');
viewTicket(ticketId);
