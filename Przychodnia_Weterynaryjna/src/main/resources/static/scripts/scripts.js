
// function loadArticle(data) {
//     var title = data.getAttribute('data-title');
//     console.log("Loading article with title: " + title);
//
//     fetch(`home/article/${title}`)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Article not found');
//             }
//             return response.json();
//         })
//         .then(article => {
//             // Wyświetlenie treści artykułu w divie
//             document.getElementById('article-block').style.display = 'block';
//             document.getElementById('article-block').textContent = article.content;
//         })
//         .catch(error => {
//             console.error('Error:', error);
//             document.getElementById('article-block').textContent = 'Error loading article.';
//         });
// }

function showArticle(data) {
    var title = data.getAttribute('data-title');


    var divs = document.getElementsByClassName('article-block');
    for (var i = 0; i < divs.length; i++) {
        divs[i].style.display = 'none';
    }

    // Pokaż wybrany div
    document.getElementById(title).style.display = 'block';
}

function changeColorTitle(data) {}