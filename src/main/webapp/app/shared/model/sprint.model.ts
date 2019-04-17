import { Moment } from 'moment';
import { ITeam } from 'app/shared/model//team.model';
import { IStory } from 'app/shared/model//story.model';

export interface ISprint {
    id?: string;
    name?: string;
    startDate?: Moment;
    endDate?: Moment;
    status?: string;
    team?: ITeam;
    stories?: IStory[];
}

export class Sprint implements ISprint {
    constructor(
        public id?: string,
        public name?: string,
        public startDate?: Moment,
        public endDate?: Moment,
        public status?: string,
        public team?: ITeam,
        public stories?: IStory[]
    ) {}
}
