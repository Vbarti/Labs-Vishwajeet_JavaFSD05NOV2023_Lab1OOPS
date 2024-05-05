// JavaScript for new-ticket.html

// Function to create a new ticket
function createTicket() {
    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;

    fetch('/api/tickets', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            title: title,
            description: description,
        }),
    })
    .then(response => {
        if (response.ok) {
            window.location.href = '/'; // Redirect to home page after creating ticket
        } else {
            alert('Failed to create ticket');
        }
    });
}
