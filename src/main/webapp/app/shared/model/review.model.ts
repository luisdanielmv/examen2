import { Moment } from 'moment';
import { IStory } from 'app/shared/model//story.model';

export interface IReview {
    id?: string;
    timestamp?: Moment;
    comment?: string;
    status?: string;
    story?: IStory;
}

export class Review implements IReview {
    constructor(public id?: string, public timestamp?: Moment, public comment?: string, public status?: string, public story?: IStory) {}
}
