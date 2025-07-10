window.onload = function () {
  fetch('http://localhost:8080/vote/results')
    .then(response => response.json())
    .then(data => {
      const tbody = document.querySelector('#resultsTable tbody');
      const names = [];
      const votes = [];

      data.forEach(candidate => {
        // Fill the table
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${candidate.name}</td>
          <td>${candidate.voteCount}</td>
        `;
        tbody.appendChild(row);

        // Fill data for chart
        names.push(candidate.name);
        votes.push(candidate.voteCount);
      });

      // Draw the bar chart
      const ctx = document.getElementById('resultsChart').getContext('2d');
      new Chart(ctx, {
        type: 'bar',
        data: {
          labels: names,
          datasets: [{
            label: 'Vote Count',
            data: votes,
            backgroundColor: ['#3498db', '#2ecc71', '#e74c3c', '#f1c40f'],
            borderRadius: 6
          }]
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
              ticks: {
                precision: 0
              }
            }
          }
        }
      });
    })
    .catch(error => {
      document.getElementById('message').textContent = "Error loading results.";
    });
};
