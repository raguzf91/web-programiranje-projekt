document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the default form submission

    
    const email = document.getElementById('email').value;
    const lozinka = document.getElementById('lozinka').value;
  
    const korisnik = {
        email: email,
        lozinka: lozinka
    };

    fetch('/korisnik/prijava', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(korisnik)
    })
    .then(response => {
        if (!response.ok) {
            return response.json().then(error => {
                throw new Error(error.greska || 'Došlo je do greške prilikom registracije. Molimo pokušajte ponovno.');
            });
        } else {
            window.location.href = "/korisnik/pocetna";
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        // Handle success, e.g., redirect to another page or show a success message
    })
    .catch((greska) => {
        console.error('greska:', greska);
        const errorMessageElement = document.getElementById('error-message');
        errorMessageElement.textContent = greska.message;
        errorMessageElement.classList.remove('hidden');
        // Handle error, e.g., show an error message
    });
});