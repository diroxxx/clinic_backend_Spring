// function showClientOption(option) {
//     let tmp = document.getElementById(option + '-sec');
//     let sections = tmp.getElementsByClassName('info-block');
//
//     for (let i = 0; i < sections.length; i++) {
//         sections[i].style.display = 'none';
//     }
//     tmp.style.display = 'block';
//
// }


function showClientOption(option) {
    // Ukrycie wszystkich sekcji (wszystkie elementy, które mogą być widoczne)
    let allSections = document.querySelectorAll('.info-block'); // Zakładam, że sekcje mają klasę 'info-block'
    for (let i = 0; i < allSections.length; i++) {
        allSections[i].style.display = 'none'; // Ukrywanie wszystkich
    }

    // Wyświetlenie wybranej sekcji
    let selectedSection = document.getElementById(option + '-sec');
    if (selectedSection) {
        selectedSection.style.display = 'block'; // Wyświetl wybraną sekcję
    } else {
        console.error("Sekcja " + option + "-sec nie istnieje.");
    }
}
