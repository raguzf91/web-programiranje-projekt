

///////////////////////////////////////////////////////////
// Make mobile navigation work

const btnNavEl = document.querySelector(".btn-mobile-nav");
const headerEl = document.querySelector(".header");

btnNavEl.addEventListener("click", function () {
  headerEl.classList.toggle("nav-open");
});

///////////////////////////////////////////////////////////
// Smooth scrolling animation

const allLinks = document.querySelectorAll("a:link");

allLinks.forEach(function (link) {
  link.addEventListener("click", function (e) {
    
    const href = link.getAttribute("href");

    // Scroll back to top
    if (href === "#")
      window.scrollTo({
        top: 0,
        behavior: "smooth",
      });

    // Scroll to other links
    if (href !== "#" && href.startsWith("#")) {
      const sectionEl = document.querySelector(href);
      sectionEl.scrollIntoView({ behavior: "smooth" });
    }

    // Close mobile naviagtion
    if (link.classList.contains("main-nav-link"))
      headerEl.classList.toggle("nav-open");
  });
});

///////////////////////////////////////////////////////////
// Sticky navigation

const sectionHeroEl = document.querySelector(".section-hero");

const obs = new IntersectionObserver(
  function (entries) {
    const ent = entries[0];
    console.log(ent);

    if (ent.isIntersecting === false) {
      document.body.classList.add("sticky");
    }

    if (ent.isIntersecting === true) {
      document.body.classList.remove("sticky");
    }
  },
  {
    // In the viewport
    root: null,
    threshold: 0,
    rootMargin: "-80px",
  }
);
obs.observe(sectionHeroEl);

let timeOut = function (element) {
  setTimeout(() => {
    element.textContent = '';
    element.classList.add('hidden');
  }, 2000);
}


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
      const successMessageElement = document.getElementById('success-message');
      successMessageElement.textContent = 'Uspješno ste se registrirali! Prijavite se na svoj račun.';
      successMessageElement.classList.remove('hidden');
      timeOut(successMessageElement);
  })
  .catch((greska) => {
      console.error('greska:', greska);
      const errorMessageElement = document.getElementById('error-message');
      errorMessageElement.textContent = greska.message;
      errorMessageElement.classList.remove('hidden');
      
      
  });
}




document.getElementById('registerForm').addEventListener('submit', submitRegisterForm);

///////////////////////////////////////////////////////////


// https://unpkg.com/smoothscroll-polyfill@0.4.4/dist/smoothscroll.min.js

/*
.no-flexbox-gap .main-nav-list li:not(:last-child) {
  margin-right: 4.8rem;
}

.no-flexbox-gap .list-item:not(:last-child) {
  margin-bottom: 1.6rem;
}

.no-flexbox-gap .list-icon:not(:last-child) {
  margin-right: 1.6rem;
}

.no-flexbox-gap .delivered-faces {
  margin-right: 1.6rem;
}

.no-flexbox-gap .meal-attribute:not(:last-child) {
  margin-bottom: 2rem;
}

.no-flexbox-gap .meal-icon {
  margin-right: 1.6rem;
}

.no-flexbox-gap .footer-row div:not(:last-child) {
  margin-right: 6.4rem;
}

.no-flexbox-gap .social-links li:not(:last-child) {
  margin-right: 2.4rem;
}

.no-flexbox-gap .footer-nav li:not(:last-child) {
  margin-bottom: 2.4rem;
}

@media (max-width: 75em) {
  .no-flexbox-gap .main-nav-list li:not(:last-child) {
    margin-right: 3.2rem;
  }
}

@media (max-width: 59em) {
  .no-flexbox-gap .main-nav-list li:not(:last-child) {
    margin-right: 0;
    margin-bottom: 4.8rem;
  }
}
*/
