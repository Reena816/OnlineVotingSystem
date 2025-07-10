document.getElementById('registerForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const voter = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };

    fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(voter)
    })
    .then(response => response.text())
    .then(data => {
        if (data.includes("success")) {
            document.getElementById('successModal').style.display = 'flex';
        } else if (data.includes("Username already exists")) {
            document.getElementById('existsModal').style.display = 'flex';
        } else {
            document.getElementById('message').textContent = data;
        }

        document.getElementById('registerForm').reset();
    })
    .catch(error => {
        document.getElementById('message').textContent = "Error: " + error;
    });
});

// Redirect to login
function goToLogin() {
    window.location.href = "login.html";
}
