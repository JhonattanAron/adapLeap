document.addEventListener("DOMContentLoaded" , ()=>{
    let linkHtml = document.getElementById("linksCont")
    fecthArticles(linkHtml)
})

function fecthArticles(html) {
    let htmlInner = ``;

    fetch("/api/articles")
        .then(response => response.json())
        .then(data =>{
            data.map(art =>{
                const articleUrl = `${window.location.origin}/articles/${art.tittle}`;
                htmlInner += `
                    <li class=" d-flex align-items-center list-group-item linkItem">
                    <img class="imgCard"
                        src="${art.imgUrl}" alt="img">
                    <a href="${articleUrl}">${art.tittle}</a>
                </li>
                `
                html.innerHTML = htmlInner;
            })
        })
}

