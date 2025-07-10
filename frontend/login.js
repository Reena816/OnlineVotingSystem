document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const loginData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById('message').textContent = data;
        if (data === 'Login successful!') {
            // Redirect to vote page after successful login
            setTimeout(() => {
                window.location.href = "vote.html"; // or any page you want
            }, 1000);
        }
    })
    .catch(error => {
        document.getElementById('message').textContent = "Error: " + error;
    });
});
