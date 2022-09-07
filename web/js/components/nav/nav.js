export class Nav {

    render(component, data = {}) {
        let nav = `
            <div class="container">
                <a class="navbar-brand" href="#!"><img class="logo" src="assets/logo.png" alt="Logo"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <div class="navbar-nav ms-auto mb-2 mb-lg-0" id="login">
                       
                    </div>
                </div>

            </div>
        `;

        document.getElementById('nav').innerHTML = nav;
        component.render(data);
    }
}