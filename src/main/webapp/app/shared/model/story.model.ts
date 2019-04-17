import { ISprint } from 'app/shared/model//sprint.model';
import { IStudent } from 'app/shared/model//student.model';
import { IReview } from 'app/shared/model//review.model';

export interface IStory {
    id?: string;
    code?: string;
    name?: string;
    description?: string;
    status?: string;
    sprint?: ISprint;
    students?: IStudent[];
    reviews?: IReview[];
}

export class Story implements IStory {
    constructor(
        public id?: string,
        public code?: string,
        public name?: string,
        public description?: string,
        public status?: string,
        public sprint?: ISprint,
        public students?: IStudent[],
        public reviews?: IReview[]
    ) {}
}
