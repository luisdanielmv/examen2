import { IProject } from 'app/shared/model//project.model';
import { ISprint } from 'app/shared/model//sprint.model';
import { IStudent } from 'app/shared/model//student.model';

export interface ITeam {
    id?: string;
    name?: string;
    status?: string;
    project?: IProject;
    sprints?: ISprint[];
    students?: IStudent[];
}

export class Team implements ITeam {
    constructor(
        public id?: string,
        public name?: string,
        public status?: string,
        public project?: IProject,
        public sprints?: ISprint[],
        public students?: IStudent[]
    ) {}
}
