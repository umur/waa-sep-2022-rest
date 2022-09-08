export class FetchAPI {

    static async post(url = '', data = {}) {
        const response = await fetch(url, {
            method: 'POST',
            body: JSON.stringify(data)
        });
        return response.json();
    }

    static async get(url = '') {
        const response = await fetch(url, {
            method: 'GET',
        });
        return response.json();
    }

    static async delete(url = '', data = {}) {
        const response = await fetch(url, {
            method: 'DELETE',
            body: JSON.stringify(data)
        });
        return response.json();
    }

    static async put(url = '', data = {}) {
        const response = await fetch(url, {
            method: 'PUT',
            mode: 'cors',
            body: JSON.stringify(data)
        });
        return response.json();
    }
}