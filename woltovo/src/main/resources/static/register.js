
function submitRegisterForm(event) {
    event.preventDefault(); // Prevent the default form submission

    const ime = document.getElementById('ime').value;
    const prezime = document.getElementById('prezime').value;
    const email = document.getElementById('email').value;
    const lozinka = document.getElementById('lozinka').value;
    const preferenca = document.getElementById('preferenca').value.toUpperCase();
    const kratica = document.getElementById('kratica').value.toUpperCase();
    const korisnik = {
        ime: ime,
        prezime: prezime,
        email: email,
        lozinka: lozinka,
        preferenca: preferenca,
        kratica: kratica
    };

    fetch('/korisnik/registracija', {
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
}

document.getElementById('registerForm').addEventListener('submit', submitRegisterForm);




