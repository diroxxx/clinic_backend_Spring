function showArticle(data) {
    var title = data.getAttribute('data-title');


    var divs = document.getElementsByClassName('article-block');
    for (var i = 0; i < divs.length; i++) {
        divs[i].style.display = 'none';
    }

    document.getElementById(title).style.display = 'block';
}

function changeColorTitle(data) {
    var title = data.getAttribute('data-title');
    var titles = document.getElementsByClassName('title-block');

    for (var i = 0; i < titles.length; i++) {
        titles[i].style.color = '#33372C';
    }

    var titleToChange = document.getElementById('article ' + title);

    titleToChange.style.color = '#46a14a';
    // titleToChange.style.color = '#557C56';

}