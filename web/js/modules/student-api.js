import { FetchAPI } from './fetch-api.js';
import { Config } from './config.js';

export class StudentAPI {

    static PRODUCT_URL = Config.SERVER_URL + '/students';

    static getAll() {
        return FetchAPI.get(StudentAPI.PRODUCT_URL);
    }

    static getById() {
        return FetchAPI.get(StudentAPI.PRODUCT_URL);
    }
}
