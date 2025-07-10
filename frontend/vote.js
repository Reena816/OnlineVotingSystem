window.onload = function () {
    fetch("http://localhost:8080/vote/results")
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById("candidateList");

            data.forEach(candidate => {
                const div = document.createElement("div");
                div.className = "candidate-item";

                div.innerHTML = `
                    <input type="radio" name="candidate" value="${candidate.id}" required>
                    <img class="symbol-img" src="symbols/${candidate.name.toLowerCase()}.png" alt="${candidate.name}">
                    <label>${candidate.name}</label>
                `;
                list.appendChild(div);
            });
        })
        .catch(error => {
            document.getElementById("message").textContent = "Error loading candidates.";
        });

    document.getElementById('voteForm').addEventListener('submit', function(e) {
        e.preventDefault();
        const voterId = document.getElementById('voterId').value;
        const selected = document.querySelector('input[name="candidate"]:checked');

        if (!selected) {
            document.getElementById('message').textContent = "Please select a candidate.";
            return;
        }

        const candidateId = selected.value;

        fetch(`http://localhost:8080/vote/cast?voterId=${voterId}&candidateId=${candidateId}`, {
            method: 'POST'
        })
        .then(response => response.text())
        .then(data => {
            document.getElementById('message').textContent = data;

            // Show modal if vote is successful
            if (data.toLowerCase().includes("success")) {
                document.getElementById('voteSuccessModal').style.display = 'flex';
            }
        })
        .catch(error => {
            document.getElementById('message').textContent = "Error submitting vote.";
        });
    });
};
