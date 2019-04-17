import { Moment } from 'moment';
import { IProject } from 'app/shared/model//project.model';

export interface IPeriod {
    id?: string;
    startDate?: Moment;
    endDate?: Moment;
    name?: string;
    projects?: IProject[];
}

export class Period implements IPeriod {
    constructor(
        public id?: string,
        public startDate?: Moment,
        public endDate?: Moment,
        public name?: string,
        public projects?: IProject[]
    ) {}
}
