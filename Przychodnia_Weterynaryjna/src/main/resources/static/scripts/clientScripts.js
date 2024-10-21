function showClientOption(option) {
    let tmp = document.getElementById(option + '-sec');
    let sections = tmp.getElementsByClassName('info-block');

    for (let i = 0; i < sections.length; i++) {
        sections[i].style.display = 'none';
    }
    tmp.style.display = 'inline-block';

}