import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { Examen2SharedModule } from 'app/shared';
import {
    SprintComponent,
    SprintDetailComponent,
    SprintUpdateComponent,
    SprintDeletePopupComponent,
    SprintDeleteDialogComponent,
    sprintRoute,
    sprintPopupRoute
} from './';

const ENTITY_STATES = [...sprintRoute, ...sprintPopupRoute];

@NgModule({
    imports: [Examen2SharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [SprintComponent, SprintDetailComponent, SprintUpdateComponent, SprintDeleteDialogComponent, SprintDeletePopupComponent],
    entryComponents: [SprintComponent, SprintUpdateComponent, SprintDeleteDialogComponent, SprintDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class Examen2SprintModule {}
