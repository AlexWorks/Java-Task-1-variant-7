'use strict';
document.addEventListener('DOMContentLoaded', (e) => {
    const containerElem = document.querySelector(".item-container");
    containerElem.addEventListener('click', clickHandler, false);
    const form = document.getElementById('filter');
    form.addEventListener('submit', (e) => {
        const field = document.createElement('input');
        field.setAttribute('name', 'SERVLET_COMMAND_NAME');
        field.setAttribute('value', 'filter');
        field.setAttribute('hidden', '');
        form.appendChild(field);
        return true;
    }, false);
    function clickHandler(e) {
        let element = e.target;
        while (!element.classList.contains('item') && element !== containerElem) {
            element = element.parentElement;
        }
        if (!element.classList.contains('item')) return;
        console.log(element);
        sendItem(element);
    }
    function sendItem(element) {
        const data = {
            'type': element.dataset.type,
            'name': element.dataset.name,
            'weight': element.dataset.weight,
            'price': element.dataset.price,
            'SERVLET_COMMAND_NAME': 'equip'
        };

        post('/app', data, 'POST');
    }

    function post(path, params, method) {
        method = method || "post";
        let form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);

        for(let key in params) {
            if(params.hasOwnProperty(key)) {
                let hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", key);
                hiddenField.setAttribute("value", params[key]);
                form.appendChild(hiddenField);
            }
        }
        document.body.appendChild(form);
        form.submit();
    }
}, false);