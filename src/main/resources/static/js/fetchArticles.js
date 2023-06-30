document.addEventListener("DOMContentLoaded", () => {
    fetch("/articles/api")
        .then(response => response.json())
        .then(data => {
            console.log(data);
            let html = document.getElementById("articles");
            let innerHtml = '';

            data.map((data, index) => {
                const activeClass = index === 0 ? 'active' : '';
                const articleUrl = `${window.location.origin}/articles/${data.tittle}`;
                const limitedContent = limitarParrafo(data.paragraphOne, 100); // Límite de 100 palabras

                innerHtml +=
                    `
                    <div class="carousel-item ${activeClass}">
                        <div class="card background-trans center">
                            <img src="${data.imgUrl}" class="card-img-top img-article" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${data.tittle}</h5>
                                <p>${limitedContent}</p>
                                <a href="${articleUrl}" target="_blank" class="btn btn-primary">Visitar Blog</a>
                            </div>
                        </div>
                    </div>
                    `;
            });

            html.innerHTML = innerHtml;

        });
});

function limitarParrafo(parrafo, limitePalabras) {
    if (parrafo) {
        var palabras = parrafo.split(" ");
        if (palabras.length > limitePalabras) {
            var parrafoLimitado = palabras.slice(0, limitePalabras).join(" ") + "...";
            return parrafoLimitado;
        }
    }
    return parrafo;
}


