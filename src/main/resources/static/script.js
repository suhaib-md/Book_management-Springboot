document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Request JWT token
    const response = await fetch('/token', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Basic ' + btoa(username + ':' + password)
        }
    });

    if (response.ok) {
        const token = await response.text();
        localStorage.setItem('jwtToken', token);
        alert('Login successful!');
    } else {
        alert('Login failed');
    }
});

document.getElementById('accessResource').addEventListener('click', async function() {
    const token = localStorage.getItem('jwtToken');

    if (!token) {
        alert('Please login first');
        return;
    }

    // Access protected resource
    const response = await fetch('/', {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        }
    });

    if (response.ok) {
        const data = await response.text();
        document.getElementById('resourceResponse').textContent = data;
    } else {
        document.getElementById('resourceResponse').textContent = 'Failed to access resource';
    }
});
