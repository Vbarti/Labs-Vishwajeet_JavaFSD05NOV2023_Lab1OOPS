// JavaScript for edit-ticket.html

// Function to fetch ticket details and populate the form for editing
function fetchTicketDetails(ticketId) {
    fetch(`/api/tickets/${ticketId}`)
        .then(response => response.json())
        .then(ticket => {
            document.getElementById('title').value = ticket.title;
            document.getElementById('description').value = ticket.description;
            // Initialize Quill editor
            
            // Set content in the editor
            quill.root.innerHTML = ticket.content;
        });
}

// Function to update an existing ticket
function updateTicket(ticketId) {
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;
    const content = document.querySelector('.ql-editor').innerHTML; // Get content from Quill editor

    fetch(`/api/tickets/${ticketId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            description: description,
            content: content, // Include content in the request body
        }),
    })
    .then(response => {
        if (response.ok) {
            window.location.href = '/'; // Redirect to home page after updating ticket
        } else {
            alert('Failed to update ticket');
        }
    });
}

// Fetch ticket details when the page loads
const urlParams = new URLSearchParams(window.location.search);
const ticketId = urlParams.get('id');
fetchTicketDetails(ticketId);

// Add event listener to submit button
document.getElementById('edit-ticket-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent default form submission
    updateTicket(ticketId); // Call updateTicket function
});