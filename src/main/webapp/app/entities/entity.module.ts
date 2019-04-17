import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { Examen2PeriodModule } from './period/period.module';
import { Examen2ProjectModule } from './project/project.module';
import { Examen2TeamModule } from './team/team.module';
import { Examen2SprintModule } from './sprint/sprint.module';
import { Examen2StudentModule } from './student/student.module';
import { Examen2StoryModule } from './story/story.module';
import { Examen2ReviewModule } from './review/review.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        Examen2PeriodModule,
        Examen2ProjectModule,
        Examen2TeamModule,
        Examen2SprintModule,
        Examen2StudentModule,
        Examen2StoryModule,
        Examen2ReviewModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Examen2EntityModule {}
