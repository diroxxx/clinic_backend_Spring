function showArticle(data) {
    let title = data.getAttribute('data-title');


    let divs = document.getElementsByClassName('article-block');
    for (let i = 0; i < divs.length; i++) {
        divs[i].style.display = 'none';
    }

    document.getElementById(title).style.display = 'block';
}

function changeColorTitle(data) {
    let title = data.getAttribute('data-title');
    let titles = document.getElementsByClassName('title-block');

    for (let i = 0; i < titles.length; i++) {
        titles[i].style.color = '#33372C';
    }

    let titleToChange = document.getElementById('article ' + title);

    titleToChange.style.color = '#46a14a';
    // titleToChange.style.color = '#557C56';

}

    document.addEventListener("DOMContentLoaded", function() {
        let toast = document.getElementById("toast");

        // Sprawdzenie, czy dymek istnieje (czyli czy wiadomość jest dostępna)
        if (toast && toast.textContent.trim() !== "") {
            toast.classList.add("show"); // Wyświetl dymek

            // Schowaj dymek po 5 sekundach
            setTimeout(function() {
                toast.style.animation = "fadeOut 1s forwards"; // Uruchom animację wygaszania
            }, 3000); // 5000 ms = 5 sekund
        }
    });


