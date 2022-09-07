import { FetchAPI } from './fetch-api.js';
import { Config } from './config.js';

export class CourseAPI {

    static COURSE_URL = Config.SERVER_URL + '/courses';

    static getAll() {
        return FetchAPI.get(CourseAPI.COURSE_URL);
    }

}