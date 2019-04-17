import { IPeriod } from 'app/shared/model//period.model';
import { ITeam } from 'app/shared/model//team.model';

export interface IProject {
    id?: string;
    name?: string;
    numStudent?: number;
    schedule?: string;
    status?: string;
    period?: IPeriod;
    teams?: ITeam[];
}

export class Project implements IProject {
    constructor(
        public id?: string,
        public name?: string,
        public numStudent?: number,
        public schedule?: string,
        public status?: string,
        public period?: IPeriod,
        public teams?: ITeam[]
    ) {}
}
